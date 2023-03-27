package UMLObject;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import UMLFrame.Canvas;

public class SelectMode extends Mode{
	private Point startP = null; 
	ArrayList<Shape> shapes = null;
	Canvas canvas = Canvas.getCanvas();

	
	public SelectMode() {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		//點下去的那一瞬間要去判斷現在是不是有點到物件
		startP = e.getPoint();
		shapes = canvas.getShapes();
		if(canvas.selectedShape != null) {
			canvas.selectedShape.resetSelectedState();
		}
		canvas.selectedShape = null;
		
		canvas.group = null;
		
		Shape selectedShape = null;
		
		for(int i = 0;i < shapes.size();i++) {
			selectedShape = shapes.get(i).checkClicked(startP);
			if(selectedShape != null) {
				canvas.selectedShape = selectedShape;
				canvas.selectedShape.setSelectedState();
				System.out.println(canvas.selectedShape.getSelectedState()+" "+canvas.selectedShape);
				break;
			}
		}
		
		canvas.group = new Group();
		
		canvas.repaint();
	}
	
	@Override 
	public void mouseDragged(MouseEvent e) {
		//startP
		if(canvas.selectedShape != null) {
			int moveX = e.getX() - startP.x;
			int moveY = e.getY() - startP.y;
			canvas.selectedShape.setNewObjLocation(moveX, moveY);
			canvas.repaint();
			
			startP = e.getPoint();
			
		} 
		else {
			//RegionSelect
			
			canvas.group.setPoint(startP,e.getPoint());
			ArrayList<Shape> shapes = canvas.getShapes(); 
			for(int i = 0;i < shapes.size();i++) {
				Shape inRegionObj = shapes.get(i).checkRegion(startP, e.getPoint());
				if(inRegionObj != null) {
					
				}
			}
			
			
		}
		
	}
	
	@Override 
	public void mouseReleased(MouseEvent e) {
		canvas.group = null;
	}
	
}
