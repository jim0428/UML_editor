package UMLObject;

import java.awt.Color;
import java.awt.Graphics;

public class GeneralLine extends BaseLineClass{
	private int arrowW = 10, arrowH = 10;

	public GeneralLine(Port firstP,Port secondP) {
		super(firstP,secondP);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		this.drawArrow(g);
	}
	
	private void drawArrow(Graphics g) {
		// TODO Auto-generated method stub
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
