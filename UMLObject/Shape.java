package UMLObject;

import java.awt.Graphics;

public class Shape implements ObjectFactory {
	protected int x1,y1,x2,y2,height,width;
	//Port 
		
	Shape(int x,int y){
		this.width = 100;
		this.height = 150;
		this.x1 = x;
		this.y1 = y;
		this.x2 = x1 + width;
		this.y2 = y1 + height;
	}
	
	@Override
	public void draw(Graphics g) {
		System.out.print("Shape沒多型到");
	}
	
}
