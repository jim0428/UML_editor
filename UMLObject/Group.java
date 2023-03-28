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
		leftUpper   = new Point();
		rightButtom = new Point();
		selectedObjs = new ArrayList<Shape>();
		selected = false;
	}
	
	public void setCoordinate() {
		this.x1 = this.y1 = Integer.MAX_VALUE;
		this.x2 = this.y2 = Integer.MIN_VALUE;
		for(Shape s: this.selectedObjs) {
			if(this.x1 > s.getX1()) {
				this.x1 = s.getX1();
			}
			if(this.x2 < s.getX2()) {
				this.x2 = s.getX2();
			}
			if(this.y1 > s.getY1()) {
				
				this.y1 = s.getY1();
			}
			if(this.y2 < s.getY2()) {
				this.y2 = s.getY2();
			}
		}
		this.height = this.y2 - this.y1;
		this.width  = this.x2 - this.x1;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(x1, y1, width, height);

		for(Shape s: selectedObjs) {
			s.draw(g);

		}
		
		if(this.selected) {
			drawSelectedPorts(g);
		}
		
	}
	
	@Override
	protected void drawSelectedPorts(Graphics g) {
		for(Shape s: selectedObjs) {			
			if(s.getSelectedObj() != null)
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
	public ArrayList<Shape> getSelectedObj(){
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
	
	
	@Override
	public Shape checkClicked(Point p) {
		//點下去的地方要比左上角x右邊，而且要比左上角的y低，比右下角的x左邊，比右下角的y上面
		if(p.x - this.x1 > 0 && p.y - this.y1 > 0 && p.x - this.x2 < 0 && p.y - this.y2 < 0) {
			return this;
		}
		return null;
	}
	
	@Override
	public Shape checkRegion(Point startP,Point endP) {
		int offsetX = endP.x - startP.x;
		int offsetY = endP.y - startP.y;
		
		
		if(offsetX > 0 && offsetY > 0) { //滑鼠到右下
			if(startP.x < this.x1 && startP.y < this.y1 &&  endP.x > this.x2 && endP.y > this.y2)
				return this;
		} 
		else if(offsetX < 0 && offsetY > 0) { //滑鼠到左下
			if(startP.x > this.x2 && startP.y < this.y1 &&  endP.x < this.x1 && endP.y > this.y2)
				return this;
		}
		else if(offsetX > 0 && offsetY < 0) { //滑鼠到右上
			if(startP.x < this.x1 && startP.y > this.y2 &&  endP.x > this.x2 && endP.y < this.y1)
				return this;
		}
		else if(offsetX < 0 && offsetY < 0) { //滑鼠到左上
			if(startP.x > this.x2 && startP.y > this.y2 &&  endP.x < this.x1 && endP.y < this.y1)
				return this;
		}
		
		return null;
	}
	
	@Override
	public void setSelectedState(boolean state) {
		//把狀態相反
		this.selected = state;
	}
	
	@Override
	public boolean getSelectedState() {
		return this.selected;
	}
	
	@Override
	public void resetSelectedState() {
		this.selected = false;
	}
}
