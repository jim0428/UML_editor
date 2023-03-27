package UMLObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import UMLFrame.Canvas;

public class Line extends Shape{
	private Port[] ports = new Port[2];
	private int arrowW = 10, arrowH = 10;

	public void setLinePort(Port firstP,Port secondP) {
		this.ports[0] = firstP;
		this.ports[1] = secondP;
	}
	
	@Override
	public void draw(Graphics g) {
		int startX = ports[0].getX();
		int startY = ports[0].getY();
		int endX   = ports[1].getX();
		int endY   = ports[1].getY();
		
		g.setColor(Color.black);
		g.drawLine(startX,startY,endX,endY);
		
		// 三角形的點, 考慮線條角度
		int dx = endX - startX, dy = endY - startY;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + startX;
        ym = xm*sin + ym*cos + startY;
        xm = x;

        x = xn*cos - yn*sin + startX;
        yn = xn*sin + yn*cos + startY;
        xn = x;

        int[] xpoints = {endX , (int) xm, (int) xn};
        int[] ypoints = {endY, (int) ym, (int) yn};
        g.setColor(Color.black);
        g.fillPolygon(xpoints, ypoints, 3);
		
	}
}
