package UMLObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class UseCase extends Shape{
	//這個應該要讓一個class去繼承Shape然後就直接用name
	protected String name = "Object name";
	private Port[] ports = new Port[4];
	
	UseCase(int x, int y) {
		this.width = 150;
		this.height = 100;
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
		
		g.setColor(Color.black);
		g.drawOval(x1,y1,width,height);
		g.drawString(this.name, x1 + (width / 3), y1 + (height / 2));
		
		for(int i = 0;i < 4;i++)
			if(ports[i].getLines())
				ports[i].drawPort(g);
		
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
	public void setSelectedState(boolean state) {
		//把狀態相反
		this.selected = state;
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
