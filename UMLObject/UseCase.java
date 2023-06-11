package UMLObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import UMLFrame.Canvas;

public class UseCase extends Shape{
	private final static int HEIGHTNUM = 100;
	private final static int WIDTHNUM = 150;
	
	public UseCase(int x, int y) {
		super(x,y,HEIGHTNUM,WIDTHNUM);
	}
	
	@Override
	public void draw(Graphics g) {	
		g.setColor(Color.black);
		g.drawOval(x1,y1,width,height);
		g.drawString(this.name, x1 + (width / 3), y1 + (height / 2));
		
		for(int i = 0;i < 4;i++)
			if(ports[i].getLines())
				ports[i].drawPort(g);
	}
}
