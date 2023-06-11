package UMLCreator;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


import UMLFrame.Canvas;
import UMLObject.BaseLineClass;
import UMLObject.Port;
import UMLObject.Shape;

public class CreateLine extends Mode{
	protected Canvas canvas;
	protected ArrayList<Shape> shapes;
	
	protected Port firstP = null;
	protected Port secondP = null;
	
	private String lineType;
	
	public CreateLine(String lineType){
		this.canvas = Canvas.getCanvas();
		this.shapes = canvas.getShapes();
		this.lineType = lineType;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		//要先判斷才能建立line物件，所以判斷要寫在Create而不是Line
		firstP = contain(e.getPoint());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(firstP != null) {
			secondP = new Port(e.getX(), e.getY());
			//Line需要改一下，這邊不應該用AssciationLine，除非是Line物件
			BaseLineClass line = ObjectFactory.createLineObj(firstP, secondP,lineType);
			//線還沒畫上去的時候要有的線
			canvas.hintLine = line;
			canvas.repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		//這邊還要再判斷有沒有點到另一個點，不能是自己，然後要記得在port那邊存已經有的線 每次都要保存然後畫出來
		secondP = contain(e.getPoint());
		if(firstP != null && secondP != null && firstP != secondP) {
			BaseLineClass line = ObjectFactory.createLineObj(firstP, secondP,lineType);
			if(line != null) {
				firstP.setLine(line);
				secondP.setLine(line);
				canvas.addLines(line);	
			}
		}
		//然後再reset hintLine startP endP
		this.createLineReset();
		canvas.repaint();
	}
	
	private void createLineReset() {
		firstP = null;
		secondP = null;
		canvas.hintLine = null;
	}
	
	//在選擇線的模式下點擊是否有包含在Port的範圍
	public Port contain(Point p) {
		for(int i = 0;i < shapes.size(); i++) {
			Shape curShape = shapes.get(i);
			Port check = curShape.checkPort(p);
			if(check != null && check != firstP) {
				return check;
			}
		}

		return null;
	}
	
	
}
