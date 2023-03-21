package UMLObject;

import java.awt.Graphics;

public interface ObjectFactory {
	public abstract void draw(Graphics g);
	public abstract Port getPorts(int pos);
}
