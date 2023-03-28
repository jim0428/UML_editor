package UMLObject;

import java.awt.Color;
import java.awt.Graphics;

public class CompositionLine extends Shape{
	private Port[] ports = new Port[2];
	private int diamondW = 10, diamondH = 10;

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
		double xm = D - diamondW, xn = xm, ym = diamondH, yn = -diamondH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + startX;
        ym = xm*sin + ym*cos + startY;
        xm = x;

        x = xn*cos - yn*sin + startX;
        yn = xn*sin + yn*cos + startY;
        xn = x;
        
        // 分點公式算出線上的點, 三角形的三個點與這個點連線即為一個菱形
        double xq = (diamondH*2/D)*startX + ((D-diamondH*2)/D)*endX;
        double yq = (diamondH*2/D)*startY + ((D-diamondH*2)/D)*endY;
   
        int[] xpoints = {endX, (int) xm, (int) xq, (int) xn};
        int[] ypoints = {endY, (int) ym, (int) yq, (int) yn};
        
        g.setColor(Color.black);
        g.fillPolygon(xpoints, ypoints, 4);
		
	}
}
