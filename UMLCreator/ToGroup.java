package UMLCreator;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import UMLObject.Shape;

public class ToGroup extends Mode{
	@Override
	public void mousePressed(MouseEvent e) {
		if(canvas.group.getSelectedObj().size() > 1) {
			canvas.group.setCoordinate();
			canvas.addShape(canvas.group);
			ArrayList<Shape> shapes = canvas.getShapes();
			for(int i = 0;i < shapes.size();i++)
				if(canvas.group.getSelectedObj().contains(shapes.get(i))) {
					shapes.remove(shapes.get(i));
					i--;
				}
			//System.out.println(shapes);
			this.canvas.repaint();			
		}
	}
}
