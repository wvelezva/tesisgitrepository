package edu.eafit.maestria.activa.pcf.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.dvb.pcf.pcf.ActionLanguage;
import org.dvb.pcf.pcf.Audio;
import org.dvb.pcf.pcf.BooleanVar;
import org.dvb.pcf.pcf.Color;
import org.dvb.pcf.pcf.MarkedUpText;
import org.dvb.pcf.pcf.ObjectFactory;
import org.dvb.pcf.pcf.OnEventType;
import org.dvb.pcf.pcf.PCF;
import org.dvb.pcf.pcf.Polygon;
import org.dvb.pcf.pcf.Position;
import org.dvb.pcf.pcf.PositionArray;
import org.dvb.pcf.pcf.Rectangle;
import org.dvb.pcf.pcf.Scene;
import org.dvb.pcf.pcf.Service;
import org.dvb.pcf.pcf.Size;
import org.dvb.pcf.pcf.Stream;
import org.dvb.pcf.pcf.StreamData;
import org.dvb.pcf.pcf.Trigger;
import org.dvb.pcf.pcf.URI;
import org.dvb.pcf.pcf.UserKey;
import org.dvb.pcf.pcf.Video;
import org.dvb.pcf.pcf_types.ComponentType;
import org.dvb.pcf.pcf_types.ExternalBodyType;
import org.dvb.pcf.x_dvb_pcf.A;
import org.dvb.pcf.x_dvb_pcf.Body;
import org.dvb.pcf.x_dvb_pcf.Em;
import org.dvb.pcf.x_dvb_pcf.Img;
import org.dvb.pcf.x_dvb_pcf.P;
import org.dvb.pcf.x_dvb_pcf.Table;
import org.dvb.pcf.x_dvb_pcf.Td;
import org.dvb.pcf.x_dvb_pcf.Tr;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IProperty;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.ITaggedResource;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.model.ShapeKind;
import edu.eafit.maestria.activa.pcf.PCFActivator;
import edu.eafit.maestria.activa.pcf.utils.Messages;
import edu.eafit.maestria.activa.services.IEntityServices;
import edu.eafit.maestria.activa.services.IInteroperableFormatServices;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class PCFServicesImpl implements IInteroperableFormatServices {

	private static final String ENTITY_DETAIL_TEMPLATE = "-entityDetailTemplate";
	private final LogUtil logger = LogUtil.getInstance(PCFActivator.getDefault().getBundle().getSymbolicName(), PCFServicesImpl.class);
	private final String PCF_EXTENSION = ".pcf.xml";
	private final String DIR_NAME ="pcf";
	private ObjectFactory pcfFactory;
	private org.dvb.pcf.x_dvb_pcf.ObjectFactory xdvbpcfFactory;
	private IEntityServices entityServices;
	
	public PCFServicesImpl(IEntityServices entityServices) {
		pcfFactory = new ObjectFactory();
		xdvbpcfFactory = new org.dvb.pcf.x_dvb_pcf.ObjectFactory();
		this.entityServices = entityServices;
	}

	@Override
	public boolean export(Project project) {
		if (project == null)
			return false;
		
		PCF pcf = pcfFactory.createPCF();
		Service service = createService(project);
		
		addShapes(project, service);
		addEntities(project, service);
		
		Scene scene = createScene();
		
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createScene(scene));		
		pcf.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createService(service));
		
		return writeModel(project, pcf);
	}

	private Service createService(Project project) {
		Service service = pcfFactory.createService();
		String projectName = StringUtils.substringBeforeLast(project.getSource().getName(), Constants.File.PROJECT_FILE_EXTENSION);
		service.setName(projectName);

		org.dvb.pcf.pcf.String pcfSpecVersion = pcfFactory.createString();
		pcfSpecVersion.setName("pcfSpecVersion");
		pcfSpecVersion.setValue("1.0");
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createString(pcfSpecVersion));

		Size referenceScreen = pcfFactory.createSize();
		referenceScreen.setName("referenceScreen");
		referenceScreen.getValue().add(Constants.Player.WIDTH);
		referenceScreen.getValue().add(Constants.Player.HEIGHT);
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createSize(referenceScreen));
		
		org.dvb.pcf.pcf.String referenceScreenMapping = pcfFactory.createString();
		referenceScreenMapping.setName("referenceScreenMapping");
		referenceScreenMapping.setValue("display-anamorphic");
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createString(referenceScreenMapping));
		
		//FIXME 
		//hay que probar esto =
		//new org.dvb.pcf.pcf_types.ObjectFactory().createEnumerationType(value);
		
		Stream stream = pcfFactory.createStream();
		stream.setName("video");
		StreamData streamData = pcfFactory.createStreamData();
		streamData.setName("content");
		ExternalBodyType ebt = new org.dvb.pcf.pcf_types.ObjectFactory().createExternalBodyType();
		ebt.setContentType("application/octet-stream");
		ebt.setUri(project.getVideo().getVideo().getName());
		stream.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createExternalBody(ebt));
		
		Video video = pcfFactory.createVideo();
		video.setName("default_fullscreen_video");
		stream.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createVideo(video));

		Audio audio = pcfFactory.createAudio();
		audio.setName("default_audio");
		stream.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createAudio(audio));
		
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createStream(stream));
		
		URI firstSceneURI = pcfFactory.createURI();
		firstSceneURI.setName("firstScene");
		firstSceneURI.setValue("#main");
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createURI(firstSceneURI));
		
		return service;
	}

	private void addShapes(Project project, Service service) {
		for (int i = 0; i < project.getVideo().getAllAnimations().size(); i++) {
			Animation animation = project.getVideo().getAllAnimations().get(i);
			
			if (animation.getEntityId() == 0)
				continue;
			
			IEntity entity = ((IEntityServices)Container.get(IEntityServices.class)).getByAnimation(animation);
			if (entity == null)
				continue;
			
			if (animation.getKind() == ShapeKind.RECTANGLE) { 
				Rectangle r = createRectangle(animation, i);
				service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createRectangle(r));
			} else if (animation.getKind() == ShapeKind.POLYGON) { 
				Polygon p = createPolygon(animation, i);
				service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createPolygon(p));
			}
		}
	}

	private void addEntities(Project project, Service service) {
		Map<Long, Long> addedEntities = new HashMap<Long, Long>();
		List<Animation> animations = project.getVideo().getAllAnimations();
		for (int i = 0; i < animations.size(); i++) {
			Animation animation = animations.get(i);
			if (animation.getEntityId() == 0)
				continue;
			
			IEntity entity = ((IEntityServices)Container.get(IEntityServices.class)).getByAnimation(animation);
			if (entity == null || addedEntities.containsKey(Long.valueOf(entity.getEntityId())))
				continue;
			
			addedEntities.put(Long.valueOf(entity.getEntityId()), Long.valueOf(entity.getEntityId()));
			
			MarkedUpText entityRepresentation = pcfFactory.createMarkedUpText();
			entityRepresentation.setName("entity_" + entity.getEntityId());
			Body body = xdvbpcfFactory.createBody();
			Table table = xdvbpcfFactory.createTable();
			Tr tr = xdvbpcfFactory.createTr();
			//image
			Td td = xdvbpcfFactory.createTd();
			td.setRowspan(new BigInteger("2"));
			IResource image = entityServices.getEntityImage(entity);
			if (image != null && image.getFile() != null) {
				Img img = xdvbpcfFactory.createImg();
				img.setSrc(image.getFile().getName());
				img.setAlt(image.getName());
				td.getContent().add(img);
			}
			tr.getThOrTd().add(td);
			//name
			td = xdvbpcfFactory.createTd();
			td.setColspan(new BigInteger("2"));
			P p = xdvbpcfFactory.createP();
			p.getContent().add(entity.getName());
			td.getContent().add(p);
			tr.getThOrTd().add(td);
			table.getTr().add(tr);
			
			//properties
			if (entity.getProperties().size() > 0) {
				tr = xdvbpcfFactory.createTr();
				td = xdvbpcfFactory.createTd();
				Table properties = xdvbpcfFactory.createTable();
				Tr trProperties = xdvbpcfFactory.createTr();
				Td tdProperties = xdvbpcfFactory.createTd();
				tdProperties.setColspan(new BigInteger("2"));
				Em em = xdvbpcfFactory.createEm();
				em.getContent().add(Messages.PROPERTIES);
				tdProperties.getContent().add(em);
				trProperties.getThOrTd().add(tdProperties);
				properties.getTr().add(trProperties);
				for (IProperty property : entity.getProperties()) {
					trProperties = xdvbpcfFactory.createTr();
					//key
					tdProperties = xdvbpcfFactory.createTd();
					em = xdvbpcfFactory.createEm();
					em.getContent().add(property.getKey());
					tdProperties.getContent().add(em);
					trProperties.getThOrTd().add(tdProperties);
					//value
					tdProperties = xdvbpcfFactory.createTd();
					tdProperties.getContent().add(property.getValue());
					trProperties.getThOrTd().add(tdProperties);
					
					properties.getTr().add(trProperties);
				}
				
				td.getContent().add(properties);
				tr.getThOrTd().add(td);
			}
			
			//resources
			if (entity.getTaggedResources().size() > 0) {
				td = xdvbpcfFactory.createTd();
				Em em = xdvbpcfFactory.createEm();
				em.getContent().add(Messages.RESOURCES);
				td.getContent().add(em);
				for (ITaggedResource taggedResource : entity.getTaggedResources()){
					td.getContent().add(xdvbpcfFactory.createBr());
					A a = xdvbpcfFactory.createA();
					a.setHref(taggedResource.getResource().getFile().getName());
					a.getContent().add(taggedResource.getResource().getName());
					td.getContent().add(a);
				}
				tr.getThOrTd().add(td);
				table.getTr().add(tr);
			}
			
			//description
			tr = xdvbpcfFactory.createTr();
			td = xdvbpcfFactory.createTd();
			td.setColspan(new BigInteger("3"));
			p = xdvbpcfFactory.createP();
			p.getContent().add(entity.getDescription());
			td.getContent().add(p);
			tr.getThOrTd().add(td);
			table.getTr().add(tr);
			
			body.getPOrHrOrTable().add(table);
			entityRepresentation.setBody(body);
			service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createMarkedUpText(entityRepresentation));		
		}
	}
	
	private Rectangle createRectangle(Animation animation, int index) {
		java.awt.Rectangle shape = (java.awt.Rectangle) animation.getShape(0);
		Rectangle r = pcfFactory.createRectangle();
		
		createCommonProperties(animation, index, shape.x, shape.y, r);
		
		Size size = pcfFactory.createSize();
		size.setName("size");
		size.getValue().add(shape.width);
		size.getValue().add(shape.height);
		r.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createSize(size));
		
		return r;
	}

	private Polygon createPolygon(Animation animation, int index) {
		java.awt.Polygon shape = (java.awt.Polygon) animation.getShape(0);
		Polygon p = pcfFactory.createPolygon();
		
		createCommonProperties(animation, index, shape.xpoints[0], shape.ypoints[0], p);
		
		PositionArray vertexArray = pcfFactory.createPositionArray();
		for (int i=1;i<shape.npoints;i++){
			Position vertex = pcfFactory.createPosition();
			vertex.setName("vertex_" + 1);
			vertex.getValue().add(shape.xpoints[i]);
			vertex.getValue().add(shape.ypoints[i]);
			vertexArray.getPosition().add(vertex);
		}
		p.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createPositionArray(vertexArray));
		
		return p;
	}

	private void createCommonProperties(Animation animation, int index, int x, int y, ComponentType r) {
		r.setName("animation_" + index);
		
		Position origin = pcfFactory.createPosition();
		origin.setName("origin");
		origin.getValue().add(x);
		origin.getValue().add(y);
		r.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createPosition(origin));
		
		Color borderColor = pcfFactory.createColor();
		borderColor.setName("bordercolor");
		borderColor.setValue("#" + Integer.toHexString(animation.getColor().getRGB()));
		r.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createColor(borderColor));
		
		OnEventType oet = createEvent("select", animation);
		r.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createOnEvent(oet));
	}
	
	private OnEventType createEvent(String name, Animation animation) {
		OnEventType oet = pcfFactory.createOnEventType();
		oet.setName(name);
		Trigger trigger = pcfFactory.createTrigger();
		trigger.setEventtype("KeyEvent");
		UserKey key = pcfFactory.createUserKey();
		key.setName("key");
		key.setValue(getUserKey(animation.getColor()));
		trigger.getPrimitiveTypeValueOrConstructedTypeValueOrCompoundTypeValue().add(pcfFactory.createUserKey(key));
		oet.setTrigger(trigger);
		ActionLanguage show = pcfFactory.createActionLanguage();
		show.setName("show");
		//show.setHref("#../showEntity");
		StringBuffer content = new StringBuffer();
		content.append("entitySelected.content = entity_" + animation.getEntityId() + ".content;");
		content.append("\nSceneNavigate(<uri>entityDetail</uri>,<enum>forget</enum>,nil);");
		show.setContent(content.toString());
		oet.setActionLanguage(show);
		return oet;
	}

	private org.dvb.pcf.pcf_types.Userkey getUserKey(java.awt.Color color){
		if (color.equals(java.awt.Color.red))
			return org.dvb.pcf.pcf_types.Userkey.VK_COLORED_KEY_0;
		if (color.equals(java.awt.Color.green))
			return org.dvb.pcf.pcf_types.Userkey.VK_COLORED_KEY_1;
		if (color.equals(java.awt.Color.yellow))
			return org.dvb.pcf.pcf_types.Userkey.VK_COLORED_KEY_2;
		if (color.equals(java.awt.Color.blue))
			return org.dvb.pcf.pcf_types.Userkey.VK_COLORED_KEY_3;
		return null;
	}
	
	private Scene createScene() {
		Scene scene = pcfFactory.createScene();
		scene.setName("main");
		
		URI nextSceneURI = pcfFactory.createURI();
		nextSceneURI.setName("next_scene");
		nextSceneURI.setValue("#../entityDetail");
		scene.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createURI(nextSceneURI));
		
		BooleanVar running = pcfFactory.createBooleanVar();
		running.setName("running");
		org.dvb.pcf.pcf.Boolean runningValue = pcfFactory.createBoolean();
		runningValue.setName("value");
		runningValue.setValue(Boolean.TRUE);
		running.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createBoolean(runningValue));
		scene.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createBooleanVar(running));
		
		return scene;
	}

	private boolean writeModel(Project project, PCF pcf) {
		
		File directory = new File(project.getSource().getParent() + File.separatorChar + DIR_NAME);
		directory.mkdirs();
		String projectName = StringUtils.substringBeforeLast(project.getSource().getName(), Constants.File.PROJECT_FILE_EXTENSION);
		String pcfFileName = projectName + PCF_EXTENSION;
		File out = new File(directory, pcfFileName);
		
		try {
			JAXBContext context = JAXBContext.newInstance(pcf.getClass().getPackage().getName());
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(pcf, out);
		} catch (JAXBException e) {
			logger.logError("Error exporting to PCF", e);
			return false;
		}
		
		try {
			InputStream src = PCFServicesImpl.class.getClassLoader().getResourceAsStream("resources/entityDetail.xml");
			File dst = new File(directory, projectName + ENTITY_DETAIL_TEMPLATE + PCF_EXTENSION);
			FileUtils.copyInputStreamToFile(src, dst);
		} catch (IOException e) {
			logger.logError("Error exporting to PCF entity detail template", e);
			return false;
		}
		
		return true;
	}
}
