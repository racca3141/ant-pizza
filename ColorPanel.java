import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel extends JPanel{
	private Circle c1;
	private Rectangle r1;
	private Triangle p1, p2, p3, p4, p5;
	

	private Circle selectedCircle;
	private Rectangle selectedRectangle;
	private Triangle selectedTriangle;
	private int x, y;

	public ColorPanel(Color backColor){
		setBackground(backColor);
	


        	p1 = new Triangle(100,100,200,50,300,100, Color.blue);
		p2 = new Triangle(200,200,100,10,150,215,Color.green);
		c1 = new Circle(200,75,20,Color.red);
		r1 = new Rectangle(100,100,200,150,Color.pink);


  		selectedCircle = null;
  		selectedRectangle = null;
		selectedTriangle = null;

  		addMouseListener(new PanelListener());
  		addMouseMotionListener(new PanelMotionListener());
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);



		p1.fill(g);
		p2.fill(g);
		c1.fill(g);
		r1.fill(g);
		
	}

	private class PanelListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			x = e.getX();
			y = e.getY();

			if(p1.containsPoint(x, y))
				selectedTriangle = p1;
			else if(p2.containsPoint(x,y))
				selectedTriangle = p2;

			else if(c1.containsPoint(x,y))
				selectedCircle = c1;

			else if(r1.containsPoint(x, y))
				selectedRectangle = r1;

			else {
				selectedCircle = null;
				selectedRectangle = null;
				selectedTriangle = null;
			}
		}
	
		public void mouseReleased(MouseEvent e){
			selectedCircle = null;
			selectedRectangle = null;
			selectedTriangle = null;
		}
	}

	private class PanelMotionListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e){
			if(selectedCircle != null){
				int newX = e.getX();
				int newY = e.getY();
				int dx = newX - x;
				int dy = newY - y;
				selectedCircle.move(dx, dy);
				x = newX;
				y = newY;
				repaint();
			}
			if(selectedRectangle != null){
				int newX = e.getX();
				int newY = e.getY();
				int dx = newX - x;
				int dy = newY - y;
				selectedRectangle.move(dx, dy);
				x = newX;
				y = newY;
				repaint();
			}
			if(selectedTriangle != null){
				int newX = e.getX();
				int newY = e.getY();
				int dx = newX - x;
				int dy = newY - y;
				selectedTriangle.move(dx, dy);
				x = newX;
				y = newY;
				repaint();
			}
			
		}
	}

}