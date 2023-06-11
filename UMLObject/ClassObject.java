package UMLObject;

import javax.swing.*;

import UMLObject.Shape;
import UMLFrame.Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ClassObject extends Shape {
	private final static int HEIGHTNUM = 150;
	private final static int WIDTHNUM = 100;
	
	public ClassObject(int x,int y){
		super(x,y,HEIGHTNUM,WIDTHNUM);
		super.setPorts(x,y);
	}
	
	@Override
	public void draw(Graphics g) {
		int portion = super.height / 3;
		
		g.setColor(Color.black);
		g.drawRect(x1, y1, width, height);
		g.drawString(name, x1 + (width / 6), y1 + (height / 6));
		g.drawLine(x1, y1 + portion, x2, y1 + portion);
		g.drawLine(x1, y1 + portion * 2, x2, y1 + portion * 2);	
		
		for(int i = 0;i < 4;i++)
			if(ports[i].getLines())
				ports[i].drawPort(g);
	}
}
