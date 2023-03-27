package UMLObject;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Shape implements ObjectFactory {
	protected int x1,y1,x2,y2,height,width;
	protected boolean selected;
	
	//Port 
		
	/*Shape(int x,int y){
		this.width = 100;
		this.height = 150;
		this.x1 = x;
		this.y1 = y;
		this.x2 = x1 + width;
		this.y2 = y1 + height;
	}*/
	
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
	public void setSelectedState() {
		
	}
	
	public boolean getSelectedState() {
		return false;
	}
	
	public void resetSelectedState() {

	}
}
