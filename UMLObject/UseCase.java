package UMLObject;

import java.awt.Color;
import java.awt.Graphics;

public class UseCase extends Shape{
	//這個應該要讓一個class去繼承Shape然後就直接用name
	protected String name;
	
	UseCase(int x, int y) {
		super(x, y);
		this.name = "Object name";
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.black);
		g.drawOval(x1,y1,height,width);
		g.drawString(this.name, x1 + (width / 3), y1 + (height / 3));
	}
}
