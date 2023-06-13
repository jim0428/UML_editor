package UMLCreator;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import UMLFrame.Canvas;
import UMLObject.Group;
import UMLObject.Shape;

public class SelectMode extends Mode{
	private Point startP = null; 
	ArrayList<Shape> shapes = null;
	Canvas canvas = CanvasSingleton.getCanvas();

	public SelectMode() {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		//點下去的那一瞬間要去判斷現在是不是有點到物件
		canvas.dragging = true;
		startP = e.getPoint();
		shapes = canvas.getShapes();
		
		/*reset狀態之後看怎麼改可以比較漂亮*/
		if(canvas.clickSelectedShape != null) {
			canvas.clickSelectedShape.resetSelectedState();
		}
		canvas.clickSelectedShape = null;
		
		if(canvas.group != null) {
			for(Shape s : canvas.group.getGroupSelectedObj()) {
				s.resetSelectedState();
			}
		}
		canvas.group = null;
		
		
		Shape selectedShape = null;
		
		for(int i = shapes.size() - 1;i >= 0;i--) {
			selectedShape = shapes.get(i).checkClicked(startP);
			if(selectedShape != null) {
				canvas.clickSelectedShape = selectedShape;
				canvas.clickSelectedShape.setSelectedState(true);
				canvas.getShapes().remove(selectedShape);
				canvas.getShapes().add(selectedShape);
				break;
			}
		}
		
		canvas.repaint();
		
		canvas.group = new Group();
	}
	
	@Override 
	public void mouseDragged(MouseEvent e) {
		//startP
		if(canvas.clickSelectedShape != null) {
			int moveX = e.getX() - startP.x;
			int moveY = e.getY() - startP.y;
			canvas.clickSelectedShape.setNewObjLocation(moveX, moveY);
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
					inRegionObj.setSelectedState(true);
				}
				else {
					shapes.get(i).setSelectedState(false);
				}
			}
		}
	}
	
	@Override 
	public void mouseReleased(MouseEvent e) {
		for(int i = 0;i < shapes.size();i++) {
			if(shapes.get(i).getSelectedState()) {
				canvas.group.setSelectedObj(shapes.get(i));
			}
		}
		
		//canvas.group.setPoint(new Point(0,0), new Point(0,0));
		
		//System.out.println(canvas.group.getSelectedObj());
		
		canvas.dragging = false;
	}
	
}
