//Rectangle Class

import java.awt.*;

public class Rectangle{

	private int leftX, topY, length, width;
	private Color color;

	public Rectangle(int x, int y, int w, int l, Color c){
		leftX = x;
		topY = y;
		length = l;
		width = w;
		color = c;
	}

	public void draw(Graphics g){
		Color oldColor = g.getColor();
		g.setColor(color);
		g.drawRect(leftX, topY, width, length);
		g.setColor(oldColor);
	}

	public void fill(Graphics g){
		Color oldColor = g.getColor();
		g.setColor(color);
		g.fillRect(leftX, topY, width, length);
		g.setColor(oldColor);
	}

	public boolean containsPoint(int x, int y){
		if(x >= leftX && x <= leftX + width && y >= topY && y <=topY + length)
			return true;
		else
			return false;
	}

	public void move(int xAmount, int yAmount){
		leftX = leftX + xAmount;
		topY = topY + yAmount;
	}
}
	