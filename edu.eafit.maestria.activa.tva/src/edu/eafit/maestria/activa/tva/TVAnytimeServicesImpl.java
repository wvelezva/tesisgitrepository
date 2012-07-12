package edu.eafit.maestria.activa.tva;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import tva.metadata._2011.ObjectFactory;
import tva.metadata._2011.ProgramInformationTableType;
import tva.metadata._2011.SegmentInformationTableType;
import tva.metadata._2011.SegmentListType;
import tva.metadata._2011.TVAMainType;
import tva.mpeg7._2008.TextualType;
import edu.eafit.maestria.activa.metadata.EntityInformationTableType;
import edu.eafit.maestria.activa.metadata.EntityRegionType;
import edu.eafit.maestria.activa.metadata.EntityType;
import edu.eafit.maestria.activa.metadata.ExtendedProgramDescriptionType;
import edu.eafit.maestria.activa.metadata.ExtendedSegmentInformationType;
import edu.eafit.maestria.activa.metadata.PropertiesType;
import edu.eafit.maestria.activa.metadata.PropertiesType.Property;
import edu.eafit.maestria.activa.metadata.ResourcesType;
import edu.eafit.maestria.activa.metadata.ResourcesType.Resource;
import edu.eafit.maestria.activa.metadata.mpeg7.IntegerMatrixType;
import edu.eafit.maestria.activa.metadata.mpeg7.RegionLocatorType;
import edu.eafit.maestria.activa.metadata.mpeg7.RegionLocatorType.Box;
import edu.eafit.maestria.activa.metadata.mpeg7.RegionLocatorType.Polygon;
import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IProperty;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.ITaggedResource;
import edu.eafit.maestria.activa.model.Metadata;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.model.ShapeKind;
import edu.eafit.maestria.activa.services.IEntityServices;
import edu.eafit.maestria.activa.services.IMetadataServices;
import edu.eafit.maestria.activa.tva.utils.Messages;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class TVAnytimeServicesImpl implements IMetadataServices {

	private ObjectFactory tvaFactory;
	private edu.eafit.maestria.activa.metadata.ObjectFactory activaFactory;
	private edu.eafit.maestria.activa.metadata.mpeg7.ObjectFactory activaMpeg7Factory;
	private tva.mpeg7._2008.ObjectFactory mpeg7Factory;
	private IEntityServices entityServices;
	private Map<Long, EntityType> addedEntities;
	
	public TVAnytimeServicesImpl(IEntityServices entityServices){
		tvaFactory = new ObjectFactory();
		activaFactory = new edu.eafit.maestria.activa.metadata.ObjectFactory();
		activaMpeg7Factory = new edu.eafit.maestria.activa.metadata.mpeg7.ObjectFactory();
		mpeg7Factory = new tva.mpeg7._2008.ObjectFactory();
		
		this.entityServices = entityServices;
	}
	
	private static final LogUtil logger = LogUtil.getInstance(TVAActivator.getDefault().getBundle().getSymbolicName());
	@Override
	public Object loadMetadata(String tvaFileName) {
		try {
			JAXBContext context = JAXBContext.newInstance(TVAMainType.class);
			Unmarshaller u = context.createUnmarshaller();
			JAXBElement<TVAMainType> element = (JAXBElement<TVAMainType>)u.unmarshal(new File(tvaFileName));
			return element.getValue();
			
		} catch (JAXBException e) {
			logger.error(e, Messages.ERROR_IMPORTING_TVA);
		}
		return new TVAMainType();
	}

	@Override
	public boolean saveMetadata(Project project) {
		if (project == null || project.getMetadata() == null)
			return false;
		
		Metadata metadata = project.getMetadata();
		
		TVAMainType tva = null;
		if (metadata.getContent() == null) {
			tva = tvaFactory.createTVAMainType();
		} else {
			tva = (TVAMainType)metadata.getContent();
		}
		if (tva.getProgramDescription() == null)
			tva.setProgramDescription(activaFactory.createExtendedProgramDescriptionType());
		
		createProgramInformation(project,  tva);
		createEntityInformation(project, tva);
		createSegmentInformation(project, tva);
		
		return writeModel(metadata, tva);
	}

	
	private void createProgramInformation(Project project, TVAMainType tva) {
		ProgramInformationTableType programInformationTable = tvaFactory.createProgramInformationTableType();
		
		tva.getProgramDescription().setProgramInformationTable(programInformationTable);
	}

	private void createEntityInformation(Project project, TVAMainType tva) {
		List<Animation> animations = project.getVideo().getAllAnimations();
		if (animations.size() <=0)
			return;
		
		ExtendedProgramDescriptionType programDescription = (ExtendedProgramDescriptionType)tva.getProgramDescription();
		EntityInformationTableType entityInformation = activaFactory.createEntityInformationTableType();
		
		addedEntities = new HashMap<Long, EntityType>();
		for (int i = 0; i < animations.size(); i++) {
			Animation animation = animations.get(i);
			if (animation.getEntityId() == 0)
				continue;
			
			IEntity entity = entityServices.getByAnimation(animation);
			if (entity == null || addedEntities.containsKey(Long.valueOf(entity.getEntityId())))
				continue;
			
			EntityType tvaEntity = activaFactory.createEntityType();
			tvaEntity.setEntityId("entity_" + entity.getEntityId());
			tvaEntity.setType(entity.getType().getLabel());
			
			addedEntities.put(Long.valueOf(entity.getEntityId()), tvaEntity);

			tvaEntity.setName(entity.getName());
			TextualType description = mpeg7Factory.createTextualType();
			description.setValue(entity.getDescription());
			tvaEntity.setDescription(description);
			
			IResource image = entityServices.getEntityImage(entity);
			if (image != null && image.getFile() != null) {
				tvaEntity.setImage(image.getFile().getName());
			}
			
			//properties
			if (entity.getProperties().size() > 0) {
				PropertiesType properties = activaFactory.createPropertiesType();
				for (IProperty property : entity.getProperties()) {
					Property tvaProperty = activaFactory.createPropertiesTypeProperty(); 
					tvaProperty.setKey(property.getKey());
					tvaProperty.setValue(property.getValue());
					
					properties.getProperty().add(tvaProperty);
				}
				tvaEntity.setProperties(properties);
			}
			
			//resources
			if (entity.getTaggedResources().size() > 0) {
				ResourcesType resources = activaFactory.createResourcesType();
				for (ITaggedResource taggedResource : entity.getTaggedResources()){
					Resource tvaResource = activaFactory.createResourcesTypeResource();
					tvaResource.setHREF(taggedResource.getResource().getFile().getName());
					tvaResource.setName(taggedResource.getResource().getName());
					resources.getResource().add(tvaResource);
				}
				tvaEntity.setResources(resources);
			}
			
			entityInformation.getEntity().add(tvaEntity);
		}
		
		programDescription.setEntityInformationTable(entityInformation);
	}

	private void createSegmentInformation(Project project, TVAMainType tva) {
		if (project.getVideo().getAnimations() == null)
			return;
		
		SegmentInformationTableType segmentInformationTable = tvaFactory.createSegmentInformationTableType();
		SegmentListType segmentList = tvaFactory.createSegmentListType();

		for (Integer frame : project.getVideo().getAnimations().keySet()) {
			ExtendedSegmentInformationType segmentInformation = activaFactory.createExtendedSegmentInformationType();
			segmentInformation.setSegmentId(frame.toString());
			
			boolean hasContent = false;
			for (Animation animation : project.getVideo().getAnimations().get(frame)){
			
				if (animation.getEntityId() == 0)
					continue;
				
				IEntity entity = entityServices.getByAnimation(animation);
				if (entity == null)
					continue;
				
				EntityRegionType entityRegion = activaFactory.createEntityRegionType();
				//entityRegion.setEntityRef("entity_" + animation.getEntityId());
				entityRegion.setEntityRef(addedEntities.get(Long.valueOf(animation.getEntityId())));
				
				RegionLocatorType regionLocator = activaMpeg7Factory.createRegionLocatorType();
	
				if (animation.getKind() == ShapeKind.RECTANGLE) { 
					regionLocator.getBox().add(createBox(project, animation));
					
				} else if (animation.getKind() == ShapeKind.POLYGON) { 
					regionLocator.getPolygon().add(createPolygon(project, animation));
					
				}
				entityRegion.setRegion(regionLocator);
				segmentInformation.getEntityRegion().add(entityRegion);
				hasContent=true;
			}
			if (hasContent)
				segmentList.getSegmentInformation().add(segmentInformation);
		}
		
		segmentInformationTable.setSegmentList(segmentList);
		tva.getProgramDescription().setSegmentInformationTable(segmentInformationTable);
		
	}
	
	private Box createBox(Project project, Animation animation) {
		java.awt.Rectangle shape = (java.awt.Rectangle) animation.getShape(0);
		Box b = activaMpeg7Factory.createRegionLocatorTypeBox();
		
		b.getDim().add(BigInteger.valueOf(2));
		b.getDim().add(BigInteger.valueOf(4));
		
		b.getValue().add(BigInteger.valueOf(shape.x));
		b.getValue().add(BigInteger.valueOf(shape.y));
		
		b.getValue().add(BigInteger.valueOf(shape.x + shape.width));
		b.getValue().add(BigInteger.valueOf(shape.y));
		
		b.getValue().add(BigInteger.valueOf(shape.x));
		b.getValue().add(BigInteger.valueOf(shape.y + shape.height));
		
		b.getValue().add(BigInteger.valueOf(shape.x + shape.width));
		b.getValue().add(BigInteger.valueOf(shape.y + shape.height));
		
		return b;
	}

	private Polygon createPolygon(Project project, Animation animation) {
		java.awt.Polygon shape = (java.awt.Polygon) animation.getShape(0);
		Polygon p = activaMpeg7Factory.createRegionLocatorTypePolygon();
		
		IntegerMatrixType value = activaMpeg7Factory.createIntegerMatrixType();
		value.getDim().add(BigInteger.valueOf(2));
		value.getDim().add(BigInteger.valueOf(shape.npoints));
		
		for (int i=1;i<shape.npoints;i++){
			value.getValue().add(BigInteger.valueOf(shape.xpoints[i]));
			value.getValue().add(BigInteger.valueOf(shape.ypoints[i]));
		}
		p.setCoords(value);
		
		return p;
	}
	private boolean writeModel(Metadata metadata, TVAMainType tva) {
		
		try {
			JAXBContext context = JAXBContext.newInstance("tva.metadata._2011");
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			metadata.getSource().createNewFile();
			m.marshal(tvaFactory.createTVAMain(tva), metadata.getSource());
		} catch (JAXBException e) {
			logger.error(e, Messages.ERROR_EXPORTING_TVA);
			return false;
		} catch (IOException e) {
			logger.error(e, Messages.ERROR_EXPORTING_TVA);
			return false;
		}
		
		return true;
	}

}
	