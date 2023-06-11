package UMLObject;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import UMLFrame.Canvas;

public class Shape {
	Canvas canvas = Canvas.getCanvas();
	protected int x1 = -1 ,y1 = -1,x2 = -1 ,y2 = -1,height = -1,width = -1;
	protected boolean selected = false;
	protected String name = "Object name";
	protected Port[] ports = new Port[4];
	
	public Shape(int x1,int y1,int height,int width) {
		this.x1 = x1;
		this.y1 = y1;
		this.height = height;
		this.width = width;
		this.x2 = x1 + width;
		this.y2 = y1 + height;
		this.selected = false;
		this.setPorts(x1,y1);
	}
	
	private void setPorts(int x,int y) {
		int width_mid = (width/2);
		int height_mid = (height/2);
		System.out.println(x+" "+y);
		//上
		Port port = new Port();
		port.setPoint(x + width_mid,y - 5);
		ports[0] = port;
		//右
		port = new Port();
		port.setPoint(x + width,y + height_mid);
		ports[1] = port;
		//下
		port = new Port();
		port.setPoint(x + width_mid,y + height);
		ports[2] = port;
		//左
		port = new Port();
		port.setPoint(x - 5,y + height_mid);
		ports[3] = port;
	}
	
	public int getX1() {
		return x1;
	}
	
	public int getX2() {
		return x2;
	}
	
	public int getY1() {
		return y1;
	}
	
	public int getY2() {
		return y2;
	}
	
	public void draw(Graphics g) {
		System.out.print("Shape沒多型到");
	}
	
	public void setNewName(String newName) {
		this.name = newName;
		canvas.repaint();
	}
	

	public Port getPorts(int pos) {
		return ports[pos];
	}
	
	//for select clicked or region
	public Shape checkClicked(Point p) {
		//點下去的地方要比左上角x右邊，而且要比左上角的y低，比右下角的x左邊，比右下角的y上面
		if(p.x - this.x1 > 0 && p.y - this.y1 > 0 && p.x - this.x2 < 0 && p.y - this.y2 < 0) {
			return this;
		}
		return null;
	}
	
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
	
	//for class or useCase
	public void setNewObjLocation(int moveX,int moveY) {
		this.x1 = this.x1 + moveX;
		this.y1 = this.y1 + moveY;
		this.x2 = this.x1 + width;
		this.y2 = this.y1 + height;
		
		int width_mid = (width/2);
		int height_mid = (height/2);
		//上
		ports[0].setNewPortLocation(this.x1 + width_mid,this.y1 - 5);
		//右
		ports[1].setNewPortLocation(this.x1 + width,this.y1 + height_mid);
		//下
		ports[2].setNewPortLocation(this.x1 + width_mid,this.y1 + height);
		//左
		ports[3].setNewPortLocation(this.x1 - 5,this.y1 + height_mid);
	}
	
	//for Obj selected
	public void setSelectedState(boolean state) {
		//把狀態相反
		this.selected = state;
	}
	
	public boolean getSelectedState() {
		return this.selected;
	}
	
	public void resetSelectedState() {
		this.selected = false;
	}
	
	public ArrayList<Shape> getSelectedObj(){
		return null;
	}
	
	protected void drawSelectedPorts(Graphics g) {
		
	}
	
	
}
