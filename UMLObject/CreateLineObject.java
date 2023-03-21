package UMLObject;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import UMLFrame.Canvas;

public class CreateLineObject extends Mode{
	Canvas canvas = Canvas.getCanvas();
	ArrayList<Shape> shapes = canvas.getShapes();
	
	Point startP = null,endP = null;
	Port firstP = null,secondP = null;
	
	public CreateLineObject() {
		System.out.println("Create line Obj");
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		//要先判斷才能建立line物件，所以判斷要寫在Create而不是Line
		//System.out.println(contain(e.getX(),e.getY())+" "+ e.getPoint());
		if(contain(e.getX(),e.getY(),"first")) {
			startP = e.getPoint();
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(startP != null) {
			endP = e.getPoint();
			//Line需要改一下，這邊不應該用AssciationLine，除非是Line物件
			Line line = new Line();
			line.setLinePoint(startP, endP);
			canvas.hintLine = line;
			canvas.repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		//這邊還要再判斷有沒有點到另一個點，不能是自己，然後要記得在port那邊存已經有的線 每次都要保存然後畫出來
		if(firstP != null && contain(e.getX(),e.getY(),"second") && secondP != null) {
			Line line = new Line();
			line.setLinePoint(startP, endP);
			canvas.addShape(line);
		}
		//然後再reset hintLine startP endP
		startP = null;
		endP = null;
		firstP = null;
		secondP = null;
		canvas.hintLine = null;
		canvas.repaint();
	}
	
	
	//在選擇線的模式下點擊是否有包含在Port的範圍
	public boolean contain(int x,int y,String s) {
		boolean check = false;
		for(int i = 0;i < shapes.size() && !check; i++) {
			for(int pos = 0;pos < 4 && !check;pos++) {
				if(shapes.get(i).getPorts(pos) != null) {
					check = shapes.get(i).getPorts(pos).isCantained(x, y);
					if(check) {
						if(s == "first")
							firstP = shapes.get(i).getPorts(pos);
						else if(s == "second" && shapes.get(i).getPorts(pos) != firstP)
							secondP = shapes.get(i).getPorts(pos);
					}
				}
			}	
		}
		System.out.println("Check:" + check);
		return check;
	}
}
