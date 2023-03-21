package UMLObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Port{
	private int x1,y1,width,height;
	//要存line
	//private ArrayList<Line> Lines = new ArrayList<Line>();
	
	public void setPoint(int x1,int y1) {
		this.x1 = x1;
		this.y1 = y1;
		this.width = 5;
		this.height = 5;
	}
	
	//會在class或usecase中被調用
	public void drawPort(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x1, y1, width, height);
	}
	
	/*public addLine(Line) {
		
	}*/
	
	public boolean isCantained(int x,int y) {
		if (Math.abs(x - x1) <= 10 && Math.abs(y - y1) <= 10){
			return true;
		}
		return false;
	}
}
