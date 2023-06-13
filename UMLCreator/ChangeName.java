package UMLCreator;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import UMLObject.Shape;

public class ChangeName extends Mode{
	@Override
	public void mousePressed(MouseEvent e) {
		Shape selectedObj = super.canvas.clickSelectedShape;
		if(selectedObj != null) {
			JFrame jFrame = new JFrame();
			 String getMessage = JOptionPane.showInputDialog(jFrame, "Enter your message");
			 if(getMessage != null)
				 selectedObj.setNewName(getMessage);
		}
	}
}
