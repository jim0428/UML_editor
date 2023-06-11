package UMLCreator;

import java.awt.event.MouseEvent;

import UMLObject.Shape;

public class CreateShape extends Mode{
	private String shapeType;
	public CreateShape(String shapeType) {
		this.shapeType = shapeType;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Shape classObject = ObjectFactory.createShapeObj(e.getX(),e.getY(),shapeType);
		
		canvas.addShape(classObject);
		canvas.repaint();
	}
}
