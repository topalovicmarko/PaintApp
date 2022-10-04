package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	
	private int x;
	private int y;

	public double distance(Point p) {
	int dX = this.x - p.x; 							//Udaljenost x kordinata
	int dY =this.y - p.y; 							//Udaljenost y kordinata
	double distance = Math.sqrt(dX*dX + dY*dY);
	return distance;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + " , " + this.y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point temp = (Point) obj;
		if(this.x == temp.x && this.y == temp.y) {
			return true;
		}
	}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return distance(new Point(x, y)) <= 2; 		//Udaljenost manja od 2 pixela
	}
	
	@Override
	public void draw (Graphics g) {
		g.setColor(getBorderColor());
		g.drawLine(x+2,y,x-2,y);
		g.drawLine(x,y+2,x,y-2);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(x-3, y-3, 6, 6);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x += byX;
		this.y += byY;
		
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Point) {
			return (int)(distance(new Point(0,0)) - ((Point)obj).distance(new Point(0,0))); 
		}
		return 0;
	}
	
	//Konstruktori
	
	public Point() {
		
	}
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point (int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	
	public Point(int x, int y, Color pointColor) {
		this(x, y);
		this.setBorderColor(pointColor);
	}
	
	//Get i Set metode
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}