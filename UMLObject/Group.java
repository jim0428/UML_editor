package UMLObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import UMLFrame.Canvas;

public class Group extends Shape{
	private Point leftUpper,rightButtom;
	private ArrayList<Shape> selectedObj;
	Canvas canvas = Canvas.getCanvas();
	
	public Group() {
		leftUpper   = new Point();
		rightButtom = new Point();
	}
	
	@Override
	public void draw(Graphics g) {
		int offsetX = rightButtom.x - leftUpper.x;
		int offsetY = rightButtom.y - leftUpper.y;
		
		g.setColor(Color.red);
		if(offsetX > 0 && offsetY > 0) { //滑鼠到右下
			g.drawRect(leftUpper.x, leftUpper.y, Math.abs(offsetX), Math.abs(offsetY));	
		} 
		else if(offsetX < 0 && offsetY > 0) { //滑鼠到左下
			g.drawRect(rightButtom.x , leftUpper.y , Math.abs(offsetX), Math.abs(offsetY));
		}
		else if(offsetX > 0 && offsetY < 0) {
			g.drawRect(leftUpper.x , rightButtom.y , Math.abs(offsetX), Math.abs(offsetY));
		}
		else if(offsetX < 0 && offsetY < 0) {
			g.drawRect(rightButtom.x , rightButtom.y , Math.abs(offsetX), Math.abs(offsetY));
		}
		
		canvas.repaint();
	}
	
	public void setPoint(Point leftUpper,Point rightButtom) {
		this.leftUpper   = leftUpper;
		this.rightButtom = rightButtom;
	}
	
	
}
