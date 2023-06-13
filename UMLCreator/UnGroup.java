package UMLCreator;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import UMLObject.Shape;

public class UnGroup extends Mode{
	@Override
	public void mousePressed(MouseEvent e) {
		if(canvas.clickSelectedShape != null && canvas.clickSelectedShape.getGroupSelectedObj()!= null) {
			ArrayList<Shape> shapes = canvas.getShapes();
			for(Shape groupingObj : canvas.clickSelectedShape.getGroupSelectedObj()) {
				shapes.add(groupingObj);
			}
			shapes.remove(canvas.clickSelectedShape);
		}
		
		this.canvas.repaint();
	}
}
