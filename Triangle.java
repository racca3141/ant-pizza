//Triangle Class
//Emerson Racca

import java.awt.*;

public class Triangle{

	private int x1, y1, x2, y2, x3, y3;
	private int xmin, yofxmin, ymin, xmid, yofxmid, ymid, xmax, yofxmax, ymax;
	private Color color;

	public Triangle(int xa, int ya, int xb, int yb, int xc, int yc, Color c){
		x1 = xa;
		y1 = ya;
		x2 = xb;
		y2 = yb;
		x3 = xc;
		y3 = yc;
		color = c;
	}

	public void draw(Graphics g){
		Color oldColor = g.getColor();
		g.setColor(color);
		int xPoly[] = {x1,x2,x3};
        	int yPoly[] = {y1,y2,y3};

        	Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);

		g.drawPolygon(poly);
		g.setColor(oldColor);
	}
	
	public void fill(Graphics g){
		Color oldColor = g.getColor();
		g.setColor(color);
		int xPoly[] = {x1,x2,x3};
        	int yPoly[] = {y1,y2,y3};

        	Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);

		g.fillPolygon(poly);
		g.setColor(oldColor);
	}
	
	public boolean containsPoint(int x, int y){
		

		//Find min, mid, max of x locations.
		if(x1 >= x2 && x1 >= x3){
			xmax = x1;
			yofxmax = y1;
			if(x2 >= x3){
				xmid = x2;
				yofxmid = y2;
				xmin = x3;
				yofxmin = y3;
			}
			else{
				xmid = x3;
				yofxmid = y3;
				xmin = x2;
				yofxmin = y2;
			}
		}
		if(x2 >= x1 && x2 >= x3){
			xmax = x2;
			yofxmax = y2;
			if(x1 >= x3){
				xmid = x1;
				yofxmid = y1;
				xmin = x3;
				yofxmin = y3;
			}
			else{
				xmid = x3;
				yofxmid = y3;
				xmin = x1;
				yofxmin = y1;
			}
		}
		else{
			xmax = x3;
			yofxmax = y3;
			if(x1 >= x2){
				xmid = x1;
				yofxmid = y1;
				xmin = x2;
				yofxmin = y2;
			}
			else{
				xmid = x2;
				yofxmid = y2;
				xmin = x1;
				yofxmin = y1;
			}
		}

		//Used for testing.
		System.out.println();
		System.out.println("" + xmin + "," + yofxmin + " " + xmid + "," + yofxmid + " " + xmax + "," + yofxmax);

		//To determine if our current (x,y) position is inside a triangle
		//we have to determine its location relative to the x positions (with the same y value) of the three
		//lines that make up the triangle.  If there is exactly one x (xCount == 1) that is greater
		//than the current mouse pointed x, then we know we are in the triangle.
		//Test for each line and keep track of the count.
		int xCount = 0;

		//Case 1 -- Line that passes through (xmin, yofxmin) and (xmid, yofxmid)
		//(xmin, yofxmin) is our designated origin, so x intercept is 0 for this case.
		//y = mx + b; solve for x --> x = y/m

		//Compute the slope in the translated cartesian
		double slope;
		slope = (double)(yofxmin - yofxmid) / (xmid - xmin);

		//Translate pointed x,y on the cartesian
		int yValue;
		//if(y <= yofxmin)
			yValue = yofxmin - y;
		//else
			//yValue = y - yofxmin;	
		int xValue;
		xValue = x - xmin;

		//Solve for x on the line
		int xLine;
		if(slope == 0.0)
			xLine = xValue;
		else
			xLine = (int)(yValue / slope);

		//Update count.  Don't count if slope is 0.
		if(xLine >= xValue && slope != 0.0){
			if(yofxmin >= yofxmid && y >= yofxmid && y <= yofxmin)
				xCount++;
			if(yofxmid >= yofxmin && y >= yofxmin && y <= yofxmid)
				xCount++;
		}

		//Used for testing.
		System.out.println("x on line = " + xLine + ", mouse x = " + xValue + " , Count = " + xCount + " ,slope 1 = " + slope);
		
		//----------------------------
		//Case 2 -- Line that passes through (xmin, yofxmin) and (xmax, yofxmax)
		//(xmin, yofxmin) is our designated origin, so x intercept is 0 for this case.

		//Get the slope.		
		slope = (double)(yofxmin - yofxmax) / (xmax - xmin);
		

		//Solve for x on the line
		if(slope == 0.0)
			xLine = xValue;
		else
			xLine = (int)(yValue / slope);

		
		//Update count.  Don't count when slope is 0.
		if(xLine >= xValue && slope != 0.0){
			if(yofxmin >= yofxmax && y >= yofxmax && y <= yofxmin)
				xCount++;
			if(yofxmax >= yofxmin && y >= yofxmin && y <= yofxmax)
				xCount++;
		}

		//Used for testing.
		System.out.println("x on line = " + xLine + ", mouse x = " + xValue + " , Count = " + xCount + " ,slope 1 = " + slope);

		//-----------------------------
		//Case 3 is involved since the x-intercept is needed.  The line
		//goes through (xmid, yofxmid) and (xmax, yofxmax).

		//Get the slope.		
		slope = (double)(yofxmid - yofxmax) / (xmax - xmid);

		//Translate the location of the two coordinates relative to our
		//original (xmin, yofxmin) which is our true cartesian origin.
		int xmaxTr, yofxmaxTr, xmidTr, yofxmidTr;
		xmaxTr = xmax - xmin;
		yofxmaxTr = yofxmin - yofxmax;
		
		xmidTr = xmid - xmin;
		yofxmidTr = yofxmin - yofxmid;

		//Compute x intercept
		//y=mx + b, where b is the intercept.
		int xIntercept;
		xIntercept = yofxmidTr - (int)(slope * xmidTr); 

		//We now have the line equation for the third side of the triangle!
		//y = mx + xIntercept;  Solve for x!
		//x = (y - xIntercept) / m;

		//Solve for x on the line
		if(slope == 0.0)
			xLine = xValue;
		else
			xLine = (int)((yValue - xIntercept) / slope);

		//Update count.  Don't count when slope is 0.
		if(xLine >= xValue && slope != 0.0){
			if(yofxmid >= yofxmax && y >= yofxmax && y <= yofxmid)
				xCount++;
			if(yofxmax >= yofxmid && y >= yofxmid && y <= yofxmax)
				xCount++;
		}
			
		//Used for testing.
		System.out.println("x on line = " + xLine + ", mouse x = " + xValue + " , Count = " + xCount + " ,slope 1 = " + slope);

		if(xCount == 1)
			return true;
		else
			return false;

		
	}


	public void move(int xAmount, int yAmount){
		x1 = x1 + xAmount;
		y1 = y1 + yAmount;
		x2 = x2 + xAmount;
		y2 = y2 + yAmount;
		x3 = x3 + xAmount;
		y3 = y3 + yAmount;
	}
	
}
	