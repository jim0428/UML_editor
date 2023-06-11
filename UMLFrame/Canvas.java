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
	
	public Canvas(){
      //setPreferredSize(new Dimension(WIDTH, HEIGHT));
      //setBackground(Color.WHITE);
      
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}

	public void chgName() {
		if(this.clickSelectedShape != null) {
			JFrame jFrame = new JFrame();
			 String getMessage = JOptionPane.showInputDialog(jFrame, "Enter your message");
			 if(getMessage != null)
				 clickSelectedShape.setNewName(getMessage);
		}
	}
	
	public void toGroup() {
		if(group.getSelectedObj().size() > 1) {
			group.setCoordinate();
			this.addShape(group);
			for(int i = 0;i < shapes.size();i++)
				if(group.getSelectedObj().contains(shapes.get(i))) {
					shapes.remove(shapes.get(i));
					i--;
				}
			//System.out.println(shapes);
			this.canvas.repaint();			
		}
	}
	
	public void unGroup() {
		if(clickSelectedShape != null && clickSelectedShape.getSelectedObj()!= null) {
			for(Shape groupingObj : clickSelectedShape.getSelectedObj()) {
				shapes.add(groupingObj);
			}
			shapes.remove(clickSelectedShape);
		}
		
		this.canvas.repaint();
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
