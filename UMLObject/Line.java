package UMLObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import UMLFrame.Canvas;

public class Line extends Shape{
	
	private Point startP,endP;
	private int arrowW = 10, arrowH = 10;

	public void setLinePoint(Point startP,Point endP) {
		this.startP = startP;
		this.endP = endP;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(startP.x,startP.y,endP.x,endP.y);
		
		// 三角形的點, 考慮線條角度
		int dx = endP.x - startP.x, dy = endP.y - startP.y;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + startP.x;
        ym = xm*sin + ym*cos + startP.y;
        xm = x;

        x = xn*cos - yn*sin + startP.x;
        yn = xn*sin + yn*cos + startP.y;
        xn = x;

        int[] xpoints = {endP.x , (int) xm, (int) xn};
        int[] ypoints = {endP.y, (int) ym, (int) yn};
        g.setColor(Color.black);
        g.fillPolygon(xpoints, ypoints, 3);
		
	}
}
