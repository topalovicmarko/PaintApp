package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	
	protected Point center;
	protected int radius;
	private Color circleColor; 	

	
	public double area() {
		return radius*radius*Math.PI;
	}
	
	public double circumference() {
		return 2*radius*Math.PI;
	}
	
	public void fill(Graphics g) {
		g.setColor(getCircleColor());
		g.fillOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
	}
	
	@Override
	public String toString() {
		return "Center: (" + this.center.getX() + ", " + this.center.getY() + ") , radius = " + this.radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle) obj;
			if(this.center.equals(temp.center) && this.radius == temp.radius);{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return center.distance(new Point(x,y)) <= radius;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(borderColor);
		g.drawOval(center.getX()-radius,center.getY()-radius,radius*2,radius*2);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX()-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()+radius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-radius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()+radius-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()-radius-3, 6, 6);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Circle) {
			return (int)(area() - ((Circle)obj).area());
		}
		return 0;
	}
	
	
	//Konstruktori
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center,radius);
		this.selected = selected;
	}
	
	public Circle(Point center, int radius, Color borderColor, Color circleColor){
		this(center, radius);
		setBorderColor(borderColor);
		setCircleColor(circleColor);
	}
	
	//Get i Set metode
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) throws NumberFormatException{
		if(radius > 0) {
		this.radius = radius;
	}
		else {
			throw new NumberFormatException("Radius moa biti veci od 0!");
		}
	}

	public Color getCircleColor() {
		return circleColor;
	}

	public void setCircleColor(Color circleColor) {
		this.circleColor = circleColor;
	}
	
}
