package UMLCreator;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import UMLObject.Shape;

public class ToGroup extends Mode{
	@Override
	public void mousePressed(MouseEvent e) {
		if(canvas.group.getGroupSelectedObj().size() > 1) {
			ArrayList<Shape> shapes = canvas.getShapes();
			ArrayList<Shape> rmShapeList = new ArrayList<Shape>();
			
			canvas.group.setGroupCoordinate();
			canvas.addShape(canvas.group);

			for(int i = 0;i < shapes.size();i++)
				if(canvas.group.getGroupSelectedObj().contains(shapes.get(i)))
					rmShapeList.add(shapes.get(i));
			
			for(Shape rmShape : rmShapeList)
				shapes.remove(rmShape);
			
			canvas.repaint();
		}
	}
}



