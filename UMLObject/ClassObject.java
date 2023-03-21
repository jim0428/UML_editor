package UMLObject;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
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
	


}
