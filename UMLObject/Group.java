package UMLObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import UMLFrame.Canvas;

public class Group extends Shape{
	private Point leftUpper,rightButtom;
	private ArrayList<Shape> selectedObjs;
	
	Canvas canvas = Canvas.getCanvas();
	
	public Group() {
		super(10,10,10,10);
		leftUpper   = new Point();
		rightButtom = new Point();
		selectedObjs = new ArrayList<Shape>();
		selected = false;
	}
	
	public void setGroupCoordinate() {
		super.x1 = super.y1 = Integer.MAX_VALUE;
		super.x2 = super.y2 = Integer.MIN_VALUE;
		for(Shape s: this.selectedObjs) {
			if(super.x1 > s.getX1()) {
				super.x1 = s.getX1();
			}
			if(super.x2 < s.getX2()) {
				super.x2 = s.getX2();
			}
			if(super.y1 > s.getY1()) {
				super.y1 = s.getY1();
			}
			if(super.y2 < s.getY2()) {
				super.y2 = s.getY2();
			}
		}
		
		super.width  = super.x2 - super.x1;
		super.height = super.y2 - super.y1;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(super.x1, super.y1, super.width, super.height);

		for(Shape s: selectedObjs) {
			s.draw(g);
		}
		//If selecting, the ports in the group obj are needed to be draw
		if(this.selected) {
			drawSelectedPorts(g);
		}
		
	}
	
	@Override
	protected void drawSelectedPorts(Graphics g) {
		for(Shape s: selectedObjs) {			
			if(s.getGroupSelectedObj() != null)
				s.drawSelectedPorts(g);
			for(int i = 0;i < 4;i++) {
				if(s.getPorts(i) != null)
					s.getPorts(i).drawPort(g);
			}
		}
	}
	
	public void drawHintRegion(Graphics g) {
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
	
	public void setSelectedObj(Shape s){
		selectedObjs.add(s);
	}
	
	@Override
	public ArrayList<Shape> getGroupSelectedObj(){
		return selectedObjs;
	}
	
	@Override
	public void setNewObjLocation(int moveX,int moveY) {
		this.x1 = this.x1 + moveX;
		this.y1 = this.y1 + moveY;
		this.x2 = this.x1 + width;
		this.y2 = this.y1 + height;
		
		for(Shape s:selectedObjs)
			s.setNewObjLocation(moveX, moveY);
	}
}
