package UMLFrame;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import UMLCreator.Mode;
import UMLFrame.Canvas;
import UMLObject.BaseLineClass;
import UMLObject.Group;
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
    private ArrayList<BaseLineClass> lines = new ArrayList<BaseLineClass>();
    public BaseLineClass hintLine = null;
    public Shape clickSelectedShape = null;
    public Group group = null;
    public boolean dragging = false; 
    //private Listener
    
	public Canvas(){
	      
	      
	}
    
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
    
	public void addLines(BaseLineClass line) {
		lines.add(line);
	}
	

	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
    @Override
	public void paint(Graphics g) {
	    setPreferredSize(new Dimension(WIDTH, HEIGHT));
		Dimension dim = getSize();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, dim.width, dim.height);
		
		//draw shape and ports
		for(Shape shape : shapes) {
			shape.draw(g);
			//draw the port when being clicked or having lines connection
			shape.drawSpecifcPort(g);
		}
		
		//draw lines
		for(BaseLineClass line : lines) {
			line.draw(g);
		}
		
		if(hintLine != null) {
			hintLine.draw(g);
		}
		
		if(group != null && canvas.dragging) {
			group.drawHintRegion(g);
		}
	
	}
}
