package UMLObject;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Shape implements ObjectFactory {
	protected int x1 = -1 ,y1 = -1,x2 = -1 ,y2 = -1,height = -1,width = -1;
	protected boolean selected = false;
	
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
	
	@Override
	public void draw(Graphics g) {
		System.out.print("Shape沒多型到");
	}
	
	@Override
	public Port getPorts(int pos) {
		return null;
	}
	
	//for select clicked or region
	public Shape checkClicked(Point e) {
		return null;
	}
	
	public Shape checkRegion(Point startP,Point endP) {
		return null;
	}
	
	//for class or useCase
	public void setNewObjLocation(int moveX,int moveY) {
		System.out.println("In Shape: didn't do anything.");
	}
	
	//for Obj selected
	public void setSelectedState(boolean state) {
		
	}
	
	public boolean getSelectedState() {
		return false;
	}
	
	public void resetSelectedState() {

	}
}
