package UMLObject;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.awt.Graphics2D;

import UMLCreator.CanvasSingleton;
import UMLFrame.Canvas;

public class Group extends Shape{
	private Point leftUpper,rightButtom;
	private ArrayList<Shape> selectedObjs;
	
	Canvas canvas =  CanvasSingleton.getCanvas();
	
	public Group() {
		super(-1,-1,-1,-1);
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
		//g.setColor(Color.red);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));

		
		int minX = Math.min(leftUpper.x,rightButtom.x);
		int maxX = Math.max(leftUpper.x,rightButtom.x);
		int minY = Math.min(leftUpper.y,rightButtom.y);
		int maxY = Math.max(leftUpper.y,rightButtom.y);
		
		g2d.fillRect(minX, minY, maxX - minX, maxY - minY);
		
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
