package edu.eafit.maestria.activa.ui.handlers.player;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.model.Scene;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;

public class SaveSnapshotHandler extends AbstractHandler implements IHandler {

	public static final String commandId = "activa.ui.command.player.saveSnapshot";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Project project = Container.getProject();
		if (project != null) {
			int frame = ActivaPlayer.getInstance().getCurrentFrame();

			Video video = project.getVideo();
			List<Scene> scenes = video.getScenes();
			Scene scene = new Scene();
			video.addScene(scene);
			scene.setId(scenes.size());
			Scene currentScene = video.getSceneByFrame(frame);

			scene.setStart(frame);
			scene.setEnd(currentScene.getEnd());
			
			currentScene.setEnd(frame-1);
			
			ActivaPlayer.getInstance().saveSnapshot(scene);
		}
		return null;
	}

}
