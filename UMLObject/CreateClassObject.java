package UMLObject;

import java.awt.event.MouseEvent;

public class CreateClassObject extends Mode {
	public CreateClassObject() {
		System.out.println("123");
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Shape classObject = new ClassObject(e.getX(),e.getY());
		
		System.out.print(e.getX()+" "+e.getY()+" ");
		canvas.addShape(classObject);
		canvas.repaint();
	}

	

	
}
