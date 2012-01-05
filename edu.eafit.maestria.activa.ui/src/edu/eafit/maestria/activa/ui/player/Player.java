package edu.eafit.maestria.activa.ui.player;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.services.IEntityServices;

public class Player extends ViewPart {
	
	Properties properties;
	
	public Player() {
	}

	public static final String ID = "activa.ui.view.player";
	private Table table;
	
	public void createPartControl(Composite parent) {
		RowLayout rowLayout = new RowLayout();
		rowLayout.fill = true;
		rowLayout.wrap = false;
		parent.setLayout(rowLayout);
		
		properties = new Properties(parent, SWT.NONE);
		properties.setEntity(((IEntityServices)Container.getInstance().getComponent(IEntityServices.class)).newEntity());
		
		Composite player = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE);
		RowLayout playerLayout = new RowLayout(SWT.VERTICAL);
		player.setLayout(playerLayout);
		
		ActivaPlayer.getInstance().createUI(player);
		
	}
	
	public IEntity getEntity(){
		return properties.getEntity();
	}
	
	public void setFocus() {
		//messageText.setFocus();
	}
}
