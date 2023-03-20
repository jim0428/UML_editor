package UMLFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import UMLFrame.Canvas;
import UMLObject.CreateClassObject;
import UMLObject.Mode;
import UMLObject.Shape;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EventListener;

import java.util.ArrayList; 

public class Canvas extends JPanel{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    
    private static Canvas canvas = null;
    private Mode currentMode = null;
    private EventListener listener = null;
    
    private ArrayList<Shape> shapes = new ArrayList<Shape>(); 
    
    //private Listener
    
    public static Canvas getCanvas(){
    	if(canvas == null){
    		canvas = new Canvas();
    	}
    	return canvas;
    }
    
    public void setCurrentMode(Mode currentMode) {
    	this.currentMode = currentMode;
    }
    
    public void setCurrentListener() {
		this.removeMouseMotionListener((MouseMotionListener) listener);
		this.removeMouseListener((MouseListener) listener);
		this.listener = currentMode;
		this.addMouseListener((MouseListener) listener);
		this.addMouseMotionListener((MouseMotionListener) listener);
    }
    
	public void addShape(Shape s) {
		shapes.add(s);
	}
    
	public Canvas(){
      //setPreferredSize(new Dimension(WIDTH, HEIGHT));
      //setBackground(Color.WHITE);
      
	}
	

    @Override
	public void paint(Graphics g) {
	    setPreferredSize(new Dimension(WIDTH, HEIGHT));
	    setBackground(Color.WHITE);
		/* set canvas area */ /* set painting color */
		Dimension dim = getSize();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, dim.width, dim.height);
		
		System.out.println(shapes);
		
//		for(int i = shapes.size() - 1; i >= 0;i++) {
//			shapes.get(i).draw(g);	
//		}
		
		for(Shape shape : shapes) {
			shape.draw(g);
		}
		
		
	}
    
}
