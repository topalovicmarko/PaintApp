package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextField;

public class Rectangle extends Shape{
	
	private Point upperLeft;
	private int width;
	private int height;
	private Color rectangleColor = Color.WHITE;

	public double area() {
		return width * height;
	}
	
	public int circumference() {
		return 2*width + 2*height;
	}
	
	public void fill(Graphics g) {
		g.setColor(getRectangleColor());
		g.fillRect(upperLeft.getX(), upperLeft.getY(), width, height);
	}
	
	@Override
	public String toString(){
		return "Upper left point: (" + this.upperLeft.getX() + ", " + this.upperLeft.getY() + 
									"), width = " + this.width + ", height = " + this.height ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			if(this.upperLeft.equals(temp.upperLeft) && this.width == temp.width && this.height == temp.height) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return (this.upperLeft.getX() <= x && this.upperLeft.getX() + width >= x && 
				this.upperLeft.getY() <= y && this.upperLeft.getY() + height >= y); 
	}
	
	public boolean contains (Point p) {
		return (this.upperLeft.getX() <= p.getX() && this.upperLeft.getX() + width >= p.getX() && 
				this.upperLeft.getY() <= p.getY() && this.upperLeft.getY() + height >= p.getY()); 
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getBorderColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeft.getX()-3, upperLeft.getY()-3, 6, 6);
			g.drawRect(upperLeft.getX()+width-3, upperLeft.getY()-3, 6, 6);
			g.drawRect(upperLeft.getX()-3, upperLeft.getY()+height-3, 6, 6);
			g.drawRect(upperLeft.getX()+width-3, upperLeft.getY()+height-3, 6, 6);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Rectangle) {
			return (int)(area()- ((Rectangle)obj).area());
		}
		return 0;
	}
	
	//Konstruktori
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft,width,height);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeft, int width, int height, Color rectangleColor, Color borderColor) {
		this (upperLeft, width, height);
		setRectangleColor(rectangleColor);
		setBorderColor(borderColor);
	}
	
	//Get i Set metode

	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Color getRectangleColor() {
		return rectangleColor;
	}

	public void setRectangleColor(Color rectangleColor) {
		this.rectangleColor = rectangleColor;
	}
}
