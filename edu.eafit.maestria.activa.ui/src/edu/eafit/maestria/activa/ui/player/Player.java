package edu.eafit.maestria.activa.ui.player;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class Player extends ViewPart {
	public Player() {
	}

	public static final String ID = "activa.ui.view.player";
	
	public void createPartControl(Composite parent) {
		RowLayout rowLayout = new RowLayout();
		rowLayout.fill = true;
		rowLayout.wrap = false;
		parent.setLayout(rowLayout);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new RowData(232, parent.getSize().y));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite player = new Composite(parent, SWT.NONE);
		RowLayout playerLayout = new RowLayout(SWT.VERTICAL);
		player.setLayout(playerLayout);
		//player.setLayoutData(new RowData(600,600));
		
		VlcjPlayer.getInstance().createUI(player);
		
	}
	
	public void setFocus() {
		//messageText.setFocus();
	}
}
