package UMLObject;

import java.awt.event.MouseEvent;

public class CreateShape extends Mode{
	private String shapeType;
	public CreateShape(String shapeType) {
		this.shapeType = shapeType;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// 這裡可以做多型，之後可以改，初步想法是用if來判斷
		Shape classObject = ObjectFactory.createShapeObj(e.getX(),e.getY(),shapeType);
		
		System.out.print(e.getX()+" "+e.getY()+" ");
		canvas.addShape(classObject);
		canvas.repaint();
	}
}
