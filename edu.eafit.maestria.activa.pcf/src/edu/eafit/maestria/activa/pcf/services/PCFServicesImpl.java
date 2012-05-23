package edu.eafit.maestria.activa.pcf.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.dvb.pcf.pcf.ActionLanguage;
import org.dvb.pcf.pcf.Audio;
import org.dvb.pcf.pcf.BooleanVar;
import org.dvb.pcf.pcf.Collection;
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

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.model.ShapeKind;
import edu.eafit.maestria.activa.pcf.PCFActivator;
import edu.eafit.maestria.activa.pcf.utils.Messages;
import edu.eafit.maestria.activa.services.IEntityServices;
import edu.eafit.maestria.activa.services.IInteroperableFormatServices;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class PCFServicesImpl implements IInteroperableFormatServices {


	private static final LogUtil logger = LogUtil.getInstance(PCFActivator.getDefault().getBundle().getSymbolicName());

	private static final String ENTITY_DETAIL_TEMPLATE_FILE = "resources/entityDetail.xml";
	private static final String NEXT_ESCENE_FIELD_VALUE = "#../entityDetail";
	private static final String TEXT_XML_MIME_TYPE = "text/xml";
	private static final String NEXT_SCENE_FIELD_NAME = "next_scene";
	private static final String MAIN_SCENE_NAME = "main";
	private static final String ACTION_LANGUAGE_NAME = "show";
	private static final String KEY_FIELD_NAME = "key";
	private static final String KEY_EVENT_TYPE = "KeyEvent";
	private static final String EVENT_NAME = "select";
	private static final String BORDERCOLOR_FIELD_NAME = "bordercolor";
	private static final String CONTEXT_ORIGINAL = "original";
	private static final String VERTEX_FIELD_NAME = "vertex_";
	private static final String SIZE_FIELD_NAME = "size";
	private static final String ENTITY_FIELD_NAME = "entity_";
	private static final String ANIMATION_FIELD_NAME = "animation_";
	private static final String ANIMATION_PATH = "#../../../" + ANIMATION_FIELD_NAME;
	private static final String ORIGIN_POSITION_FIELD_NAME = "origin";
	private static final String ORIGIN_POSITION_PATH = "#../" + ORIGIN_POSITION_FIELD_NAME;
	private static final String FRAMES_FIELD_NAME = "frames";
	private static final String FPS_FIELD_NAME = "fps";
	private static final String COLLECTION_NAME = "timestamp_";
	private static final String FIRST_SCENE_FIELD_NAME = "firstScene";
	private static final String DEFAULT_AUDIO_FIELD_NAME = "default_audio";
	private static final String DEFAULT_FULLSCREEN_VIDEO_FIELD_NAME = "default_fullscreen_video";
	private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
	private static final String CONTENT = "content";
	private static final String STREAM_NAME = "video";
	private static final String REFERENCE_SCREEN_MAPPING_FIELD_VALUE = "display-anamorphic";
	private static final String REFERENCE_SCREEN_MAPPING_FIELD_NAME = "referenceScreenMapping";
	private static final String REFERENCE_SCREEN_FIELD_NAME = "referenceScreen";
	private static final String PCF_SPEC_VERSION_FIELD_VALUE = "1.0";
	private static final String PCF_SPEC_VERSION_FIELD_NAME = "pcfSpecVersion";
	private static final String ENTITY_DETAIL_TEMPLATE = "-entityDetailTemplate";
	private static final String PCF_EXTENSION = ".pcf.xml";
	private static final String DIR_NAME ="pcf";
	
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
		
		addTimestamps(project, service);
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
		pcfSpecVersion.setName(PCF_SPEC_VERSION_FIELD_NAME);
		pcfSpecVersion.setValue(PCF_SPEC_VERSION_FIELD_VALUE);
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createString(pcfSpecVersion));

		Size referenceScreen = pcfFactory.createSize();
		referenceScreen.setName(REFERENCE_SCREEN_FIELD_NAME);
		referenceScreen.getValue().add(Constants.Player.WIDTH);
		referenceScreen.getValue().add(Constants.Player.HEIGHT);
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createSize(referenceScreen));
		
		org.dvb.pcf.pcf.String referenceScreenMapping = pcfFactory.createString();
		referenceScreenMapping.setName(REFERENCE_SCREEN_MAPPING_FIELD_NAME);
		referenceScreenMapping.setValue(REFERENCE_SCREEN_MAPPING_FIELD_VALUE);
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createString(referenceScreenMapping));
		
		org.dvb.pcf.pcf.Integer fps = pcfFactory.createInteger();
		fps.setName(FPS_FIELD_NAME);
		
		fps.setValue(Float.valueOf(project.getVideo().getFps()).intValue());
		
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createInteger(fps));
		
		Stream stream = pcfFactory.createStream();
		stream.setName(STREAM_NAME);
		StreamData streamData = pcfFactory.createStreamData();
		streamData.setName(CONTENT);
		ExternalBodyType ebt = new org.dvb.pcf.pcf_types.ObjectFactory().createExternalBodyType();
		ebt.setContentType(APPLICATION_OCTET_STREAM);
		ebt.setUri(project.getVideo().getVideo().getName());
		stream.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createExternalBody(ebt));
		
		Video video = pcfFactory.createVideo();
		video.setName(DEFAULT_FULLSCREEN_VIDEO_FIELD_NAME);
		stream.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createVideo(video));

		Audio audio = pcfFactory.createAudio();
		audio.setName(DEFAULT_AUDIO_FIELD_NAME);
		stream.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createAudio(audio));
		
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createStream(stream));
		
		URI firstSceneURI = pcfFactory.createURI();
		firstSceneURI.setName(FIRST_SCENE_FIELD_NAME);
		firstSceneURI.setValue("#" + MAIN_SCENE_NAME);
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createURI(firstSceneURI));
		
		return service;
	}

	private void addTimestamps(Project project, Service service) {
		Collection timestamps = pcfFactory.createCollection();
		
		for (Entry<Integer, List<Animation>> entry : project.getVideo().getAnimations().entrySet()) {
			Collection timestamp = pcfFactory.createCollection();
			timestamp.setName(COLLECTION_NAME + entry.getKey());
			
			org.dvb.pcf.pcf.Integer frame = pcfFactory.createInteger();
			frame.setName(FRAMES_FIELD_NAME);
//			millis.setValue(framesToMillis(project.getVideo().getFps(), entry.getKey()));
			frame.setValue(entry.getKey());
			
			timestamp.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createInteger(frame));
			boolean animationCreated = false;
			for (Animation animation : entry.getValue()){
				
				if (animation.getEntityId() == 0)
					continue;
				
				animationCreated = true;
				Collection shapePCF = pcfFactory.createCollection();
				Position origin = pcfFactory.createPosition();
				origin.setName(ORIGIN_POSITION_FIELD_NAME);
				java.awt.Shape shape = animation.getShape(entry.getKey());
				origin.getValue().add(shape.getBounds().x);
				origin.getValue().add(shape.getBounds().y);
				shapePCF.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createPosition(origin));
				
				if (animation.getKind() == ShapeKind.RECTANGLE) { 
					Rectangle r = pcfFactory.createRectangle();
					r.setHref(ANIMATION_PATH + animation.getId());
					shapePCF.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createRectangle(r));
				} else if (animation.getKind() == ShapeKind.POLYGON) { 
					Polygon p = pcfFactory.createPolygon();
					p.setHref(ANIMATION_PATH + animation.getId());
					shapePCF.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createPolygon(p));
				}
				
				timestamp.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createCollection(shapePCF));
			}
			
			if (animationCreated)
				timestamps.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createCollection(timestamp));
		}
		service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createCollection(timestamps));
	}
	
//	private Integer framesToMillis(float fps, Integer key) {
//		float frameDuration = Constants.Player.MILLIS_IN_SECONDS/fps;
//		double result = Math.ceil(key.floatValue() * frameDuration);
//		
//		return Integer.valueOf(Double.valueOf(result).intValue()); 
//	}

	private void addShapes(Project project, Service service) {
		for (int i = 0; i < project.getVideo().getAllAnimations().size(); i++) {
			Animation animation = project.getVideo().getAllAnimations().get(i);
			
			if (animation.getEntityId() == 0)
				continue;
			
			IEntity entity = ((IEntityServices)Container.get(IEntityServices.class)).getByAnimation(animation);
			if (entity == null)
				continue;
			
			if (animation.getKind() == ShapeKind.RECTANGLE) { 
				Rectangle r = createRectangle(project, animation, i);
				service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createRectangle(r));
			} else if (animation.getKind() == ShapeKind.POLYGON) { 
				Polygon p = createPolygon(project, animation, i);
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
			entityRepresentation.setName(ENTITY_FIELD_NAME + entity.getEntityId());
			
			ExternalBodyType body = new ExternalBodyType();
			body.setContentType(TEXT_XML_MIME_TYPE);
			body.setUri(project.getTva().getSource().getName());
			entityRepresentation.setExternalBody(pcfFactory.createExternalBody(body));
			
			service.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createMarkedUpText(entityRepresentation));		
		}
	}
	
	private Rectangle createRectangle(Project project, Animation animation, int index) {
		java.awt.Rectangle shape = (java.awt.Rectangle) animation.getShape(0);
		Rectangle r = pcfFactory.createRectangle();
		
		createCommonProperties(project, animation, r);
		
		Size size = pcfFactory.createSize();
		size.setName(SIZE_FIELD_NAME);
		size.getValue().add(shape.width);
		size.getValue().add(shape.height);
		r.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createSize(size));
		
		return r;
	}

	private Polygon createPolygon(Project project, Animation animation, int index) {
		java.awt.Polygon shape = (java.awt.Polygon) animation.getShape(0);
		Polygon p = pcfFactory.createPolygon();
		
		createCommonProperties(project, animation, p);
		
		PositionArray vertexArray = pcfFactory.createPositionArray();
		for (int i=1;i<shape.npoints;i++){
			Position vertex = pcfFactory.createPosition();
			vertex.setName(VERTEX_FIELD_NAME + 1);
			vertex.getValue().add(shape.xpoints[i]);
			vertex.getValue().add(shape.ypoints[i]);
			vertexArray.getPosition().add(vertex);
		}
		p.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createPositionArray(vertexArray));
		
		return p;
	}

	private void createCommonProperties(Project project, Animation animation, ComponentType r) {
		r.setName(ANIMATION_FIELD_NAME + animation.getId());
		
		Position origin = pcfFactory.createPosition();
		origin.setHref(ORIGIN_POSITION_PATH);
		origin.setContext(CONTEXT_ORIGINAL);
		r.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createPosition(origin));
		
		Color borderColor = pcfFactory.createColor();
		borderColor.setName(BORDERCOLOR_FIELD_NAME);
		String hexColor = Integer.toHexString(animation.getColor().getRGB());
		borderColor.setValue("#" + hexColor.substring(2) + hexColor.substring(0,2));
		r.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createColor(borderColor));
		
		OnEventType oet = createEvent(project, EVENT_NAME, animation);
		r.getReferenceOrPrimitiveTypeValueOrConstructedTypeValue().add(pcfFactory.createOnEvent(oet));
	}
	
	private OnEventType createEvent(Project project, String name, Animation animation) {
		OnEventType oet = pcfFactory.createOnEventType();
		oet.setName(name);
		Trigger trigger = pcfFactory.createTrigger();
		trigger.setEventtype(KEY_EVENT_TYPE);
		
		UserKey key = pcfFactory.createUserKey();
		key.setName(KEY_FIELD_NAME);
		key.setValue(getUserKey(animation.getColor()));
		
		trigger.getPrimitiveTypeValueOrConstructedTypeValueOrCompoundTypeValue().add(pcfFactory.createUserKey(key));
		oet.setTrigger(trigger);
		
		ActionLanguage show = pcfFactory.createActionLanguage();
		show.setName(ACTION_LANGUAGE_NAME);
		StringBuffer content = new StringBuffer();
		content.append("entitySelected.content = entity_" + animation.getEntityId() + ".content;");
		
		String projectName = StringUtils.substringBeforeLast(project.getSource().getName(), Constants.File.PROJECT_FILE_EXTENSION);
		String entityDetailTemplate = projectName + ENTITY_DETAIL_TEMPLATE + PCF_EXTENSION;
		 
		content.append("\nSceneNavigate(<uri>" + entityDetailTemplate + "#entityDetail</uri>,<enum>forget</enum>,nil);");
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
		scene.setName(MAIN_SCENE_NAME);
		
		URI nextSceneURI = pcfFactory.createURI();
		nextSceneURI.setName(NEXT_SCENE_FIELD_NAME);
		nextSceneURI.setValue(NEXT_ESCENE_FIELD_VALUE);
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
			JAXBContext context = JAXBContext.newInstance(pcf.getClass());
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// to specify the URI->prefix mapping, you'll need to provide an
	        // implementation of NamespaecPrefixMapper, which determines the
	        // prefixes used for marshalling.
	        // 
	        // you specify this as a property of Marshaller to
	        // tell the marshaller to consult your mapper
	        // to assign a prefix for a namespace.
//	        try {
//	            m.setProperty("com.sun.xml.bind.namespacePrefixMapper",new NamespacePrefixMapperImpl());
//	        } catch(PropertyException e) {
//	            // if the JAXB provider doesn't recognize the prefix mapper,
//	            // it will throw this exception. Since being unable to specify
//	            // a human friendly prefix is not really a fatal problem,
//	            // you can just continue marshalling without failing
//	            logger.error(e);
//	        }
			m.marshal(pcf, out);
		} catch (JAXBException e) {
			logger.error(e, Messages.ERROR_EXPORTING_PCF);
			return false;
		}
		
		try {
			InputStream src = PCFServicesImpl.class.getClassLoader().getResourceAsStream(ENTITY_DETAIL_TEMPLATE_FILE);
			File dst = new File(directory, projectName + ENTITY_DETAIL_TEMPLATE + PCF_EXTENSION);
			FileUtils.copyInputStreamToFile(src, dst);
		} catch (IOException e) {
			logger.error(e, Messages.ERROR_EXPORTING_DETAIL_TEMPLATE);
			return false;
		}
		
		return true;
	}
	
	
	
}
