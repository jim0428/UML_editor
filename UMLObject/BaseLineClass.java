package UMLObject;

import java.awt.Color;
import java.awt.Graphics;

public class BaseLineClass{
	protected Port[] ports = new Port[2];
	protected int startX;
	protected int startY;
	protected int endX;
	protected int endY;
	
	public BaseLineClass(Port firstP,Port secondP) {
		this.ports[0] = firstP;
		this.ports[1] = secondP;
	}
	
	public void draw(Graphics g) {
		this.startX = ports[0].getX();
		this.startY = ports[0].getY();
		this.endX   = ports[1].getX();
		this.endY   = ports[1].getY();
		
		g.setColor(Color.black);
		g.drawLine(startX,startY,endX,endY);
		
	}
}
