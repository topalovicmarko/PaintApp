package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable , Comparable<Object> {
	
	protected boolean selected;
	protected Color borderColor;
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
	
	//Konstruktori
		public Shape() {
			
		}
		
		public Shape(boolean selected) {
			this.selected = selected;
		}
	
	//Get i Set metode
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	public Color getBorderColor() {
		return borderColor;
	}
}