package UMLFrame;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import UMLFrame.Canvas;
import UMLObject.CreateClassObject;
import UMLObject.Group;
import UMLObject.Mode;
import UMLObject.Shape;
import UMLObject.Line;

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
    public Line hintLine = null;
    public Shape clickSelectedShape = null;
    public Group group = null;
    public boolean dragging = false; 
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
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}

	public void toGroup() {
		group.setCoordinate();
		this.addShape(group);
		//System.out.println(shapes);
		this.canvas.repaint();
	}
	
    @Override
	public void paint(Graphics g) {
	    setPreferredSize(new Dimension(WIDTH, HEIGHT));
		/* set canvas area */ /* set painting color */
		Dimension dim = getSize();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, dim.width, dim.height);
		
		for(Shape shape : shapes) {
			shape.draw(g);
			if(shape.getSelectedState()) {
				for(int i = 0;i < 4;i++) {
					if(shape.getPorts(i) != null)
						shape.getPorts(i).drawPort(g);
				}
			}
		}
		
		if(hintLine != null) {
			hintLine.draw(g);
		}
		
		if(group != null && canvas.dragging) {
			group.drawHintRegion(g);
		}
	
	}
    
    
    
}
