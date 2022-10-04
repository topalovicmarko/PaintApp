package geometry;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) throws Exception {
		Point p1 = new Point();
		Point p2 = new Point();
		
		//System.out.println("x je: "+p1.getX()+", y je: "+p1.getY() + ", selected je: "+p1.isSelected());
		//System.out.println("x je: "+p2.getX()+", y je: "+p2.getY() + ", selected je: "+p2.isSelected());
		//System.out.println(p1);
		
		p1.setX(0);
		p1.setY(15);
		p2.setX(33);
		p2.setY(20);
		
		//System.out.println("x je: "+p1.getX()+", y je: "+p1.getY() + ", selected je: "+p1.isSelected());
		//System.out.println("x je: "+p2.getX()+", y je: "+p2.getY() + ", selected je: "+p2.isSelected());
		//System.out.println(p1 == p2);
		
		Point p3 = new Point();
		Point p4 = new Point();
		
		p3.setX(25);
		p3.setY(50);
		p4.setX(40);
		p4.setY(28);
		
		//System.out.println("Udaljenost tacke p1 od p2 je: " +p1.distance(p2));
		
		Line l1 = new Line();
		//System.out.println(l1); 
		Line l2 = new Line();
		
		l1.setStartPoint(p1);
		l1.setEndPoint(p2);
		l2.setStartPoint(p3);
		l2.setEndPoint(p4);
		
		//System.out.println("Duzina linije l1 je: " +l1.length());
		//System.out.println("Duzina linije l2 je: " +l2.length());
		
		Rectangle r1 = new Rectangle();		
		r1.setUpperLeft(p3);
		r1.setHeight(20);
		r1.setWidth(35);
		//System.out.println("Povrsina pravougaonika r1 je: " +r1.area());
		//System.out.println("Obim pravougaonika r1 je: " +r1.circumference());
		
		//Circle c1 = new Circle();
		//c1.setCenter(p2);
		//c1.setRadius(35);
		//System.out.println("Povrsina kruga c1 je: " +c1.area());
		//System.out.println("Obim kruga c1 je: " +c1.circumference());
		
		//l1.getEndPoint().setY((int)((c1.getCenter().getX()-c1.getCenter().getY()) - (r1.getUpperLeft().getX()+c1.area())));
		//System.out.println(l1.getEndPoint().getY());
		
		//Vezbe 4
		
		/*System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1 == p2); 
		System.out.println(p2.getX());
		p1 = p2;									//p1 je unisten jer nista vise ne pokazuje na njega
		System.out.println(p1.getX());
		p1.setX(150);
		System.out.println("X je: " +p1.getX());
		System.out.println("X je: " +p2.getX());
		System.out.println(p1 == p2);
		System.out.println(p1); 
		
		//Circle c2 = new Circle(p1, 30, true);
		//System.out.println(c2.getCenter()+ "," +c2.getRadius()+ "," +c2.isSelected());
		
		Line l3 = new Line(p3, p4, false);
		System.out.println(l3.getEndPoint()+ "," +l3.getStartPoint()+ "," +l3.isSelected());
		
		Point p5 = new Point(10, 15, false);
		System.out.println(p5.getX()+ "," +p5.getY()+ "," +p5.isSelected());
		
		Rectangle r2 = new Rectangle(p3, 20, 30, false);
		System.out.println(r2.getHeight()+ "," +r2.getWidth()+ "," +r2.getUpperLeft()+ "," +r2.isSelected());
		
		//System.out.println(c2.toString());
		
		System.out.println(p1.toString());
		System.out.println(l1.toString());
		System.out.println(r1.toString());
		System.out.println(p1.equals(p2));
		System.out.println(l1.equals(l2));
		
		Line l5 = new Line(new Point(30, 25),new Point(15,10));
		Line l6 = new Line(new Point(30, 25),new Point(15,10));
		System.out.println(l5.equals(l6));
		
		Rectangle r3 = new Rectangle(new Point(10,15),50,60);
		Rectangle r4 = new Rectangle(new Point(10,15),50,60);
		System.out.println(r3.equals(r4));
		
		//System.out.println(c1.toString());
		
		Circle c3 = new Circle(new Point(10,5),20);
		Circle c4 = new Circle(new Point(10,5),20);
		System.out.println(c3.equals(c4));*/
		
		//Vezba 5
		/*System.out.println(p1.contains(0, 18));
		System.out.println(l1.contains(0,15));
		System.out.println(r1.contains(60, 50));
		c1.getCenter().setY(20);
		System.out.println(c1.contains(0,0));
		
		Donut d1 = new Donut(new Point(5,15),50,20);
		Donut d2 = new Donut(new Point(5,15),50,20);
		System.out.println(d1.toString());
		System.out.println(d1.equals(d2));*/
		
		//Vezbe 6
		//System.out.println(c2.toString());
		Donut d1 = new Donut(p1,30,15);
		System.out.println(d1.toString());
		
		//Vezbe 7
		Circle c1 = new Donut(p1,40,20);
		Circle c2 = new Circle(p1,60);
		System.out.println(c1.compareTo(c2));
		
		//Vezbe 8
		
		//Dobra praksa
		/*
		 * try { c1.setRadius(-20); } catch (Exception e) {
		 * JOptionPane.showMessageDialog(null, "Radius mora biti veci od 0!", "Greska",
		 * JOptionPane.ERROR_MESSAGE); }
		 */
		//Losa praksa
		//c1.setRadius(0);
		
		//System.out.println(c1.getRadius());
	}
}