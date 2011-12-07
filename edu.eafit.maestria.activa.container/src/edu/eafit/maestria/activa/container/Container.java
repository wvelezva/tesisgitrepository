package edu.eafit.maestria.activa.container;

import org.picocontainer.DefaultPicoContainer;

public class Container extends DefaultPicoContainer{
	private static Container container = new Container();
	
	private Container(){
		
	}
	
	public static Container getInstance(){
		return container;
	}
}
