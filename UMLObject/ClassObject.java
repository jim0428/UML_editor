package UMLObject;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class ClassObject extends Shape {
	protected String name;
	
	
	ClassObject(int x,int y){
		super(x,y);
		this.name = "Object name";
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int portion = height / 3;
		g.setColor(Color.black);
		g.drawRect(x1, y1, width, height);
		g.drawString(this.name, x1 + (width / 6), y1 + (height / 6));
		g.drawLine(x1, y1 + portion, x2, y1 + portion);
		g.drawLine(x1, y1 + portion * 2, x2, y1 + portion * 2);
	}

}
