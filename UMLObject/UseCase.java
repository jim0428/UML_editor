package UMLObject;

import java.awt.Color;
import java.awt.Graphics;

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
	}
	
	@Override
	public Port getPorts(int pos) {
		return ports[pos];
	}
	
	
	
}
