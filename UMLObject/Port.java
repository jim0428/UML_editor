package UMLObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Port{
	private final static int PORTHEIGHT = 5;
	private final static int PORTWIDTH = 5;
	private int x1,y1,width,height;
	//要存line
	private ArrayList<BaseLineClass> Lines = new ArrayList<BaseLineClass>();
	
	public Port(int x1,int y1) {
		this.x1 = x1;
		this.y1 = y1;
		this.width = PORTHEIGHT;
		this.height = PORTWIDTH;
	}
	
	public int getX() {
		return x1;
	}
	
	public int getY() {
		return y1;
	}
	
	public void setNewPortLocation(int newX,int newY) {
		this.x1 = newX;
		this.y1 = newY;
	}
	
	public void setLine(BaseLineClass line) {
		Lines.add(line);
	}
	
	public boolean getLines() {
		if(Lines.size() != 0)
			return true;
		return false;
	}
	
	//會在class或usecase中被調用
	public void drawPort(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x1, y1, width, height);
	}
	
}
