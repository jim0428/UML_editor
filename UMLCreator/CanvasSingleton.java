package UMLCreator;

import UMLFrame.Canvas;

public class CanvasSingleton {
	
	private static Canvas canvas = new Canvas(); 
	
	private CanvasSingleton(){
		
	}
	
    public static Canvas getCanvas(){
    	return canvas;
    }
}
