package UMLObject;

import java.awt.event.MouseEvent;

public class CreateUseCaseObject extends Mode{
	
	public CreateUseCaseObject() {
		System.out.println("123");
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// 這裡可以做多型，之後可以改，初步想法是用if來判斷
		Shape classObject = new UseCase(e.getX(),e.getY());
		
		System.out.print(e.getX()+" "+e.getY()+" ");
		canvas.addShape(classObject);
		canvas.repaint();
	}
}
