package UMLObject;

import javax.swing.*;

import UMLObject.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ClassObject extends Shape {
	protected String name = "Object name";
	private Port[] ports = new Port[4];
	
	ClassObject(int x,int y){
		this.width = 100;
		this.height = 150;
		this.x1 = x;
		this.y1 = y;
		this.x2 = x1 + width;
		this.y2 = y1 + height;
		this.selected = false;
		setPorts(x,y);
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
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int portion = height / 3;
		g.setColor(Color.black);
		g.drawRect(x1, y1, width, height);
		g.drawString(this.name, x1 + (width / 6), y1 + (height / 6));
		g.drawLine(x1, y1 + portion, x2, y1 + portion);
		g.drawLine(x1, y1 + portion * 2, x2, y1 + portion * 2);	
		
	}

	@Override
	public Port getPorts(int pos) {
		return ports[pos];
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
		int offsetY = endP.x - startP.x;
		
		
		
		return null;
	}
	
	@Override
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
	
	@Override
	public void setSelectedState() {
		//把狀態相反
		this.selected = !this.selected;
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
