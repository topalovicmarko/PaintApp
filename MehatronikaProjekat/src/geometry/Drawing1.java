package geometry;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing1 extends JPanel {
	
	public static void main(String [] args) {
		JFrame frame = new JFrame();
		frame.setSize(1066, 768);
		Drawing1 drawing = new Drawing1();
		frame.add(drawing);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		Point p1 = new Point(533,384);
		Point p2 = new Point(480,300);
		Line l1 = new Line(p1,p2);
		//l1.moveBy(50, 50);
		//l1.draw(g);
		Rectangle r1 = new Rectangle(p2, 53, 84);
		//r1.draw(g);
		Circle c1 = new Circle(new Point(300,300), 30);
		c1.moveTo(200, 200);
		//c1.draw(g);
		//p1.draw(g);
		//p2.draw(g);
		
		//Domaci
		/*Donut d1 = new Donut(new Point(r2.getUpperLeft().getX()+(r2.getWidth()/2), 
			r2.getUpperLeft().getY()+(r2.getHeight()/2)),(int)(r2.getWidth()*Math.sqrt(2)/2),80);
		d1.draw(g); */
		
		Donut d1 = new Donut(p1, 50, 20);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p1);
		shapes.add(l1);
		shapes.add(c1);
		shapes.add(d1);
		shapes.add(r1);
		
		//Iterator koji pomera elemente niza 
		/*Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			it.next().moveBy(10, 0);
		}*/
		
		//Ispis informacija o elementima niza
		/*for(Shape s : shapes) {
			System.out.println(s.toString());
		}*/
	
		//shapes.get(2).draw(g); //Iscrtati 3 clan niza
		//shapes.get(shapes.size() -1).draw(g); //Iscrtavanje poslednjeg clana niza
		shapes.remove(1); //Izbacivanje drugog elementa liste
		//shapes.get(1).draw(g); //Iscrtati drugi element liste
		//shapes.get(3).draw(g); //Iscrtati element sa indeksom 3
		shapes.add(4, l1); //Dodati liniju u listu tako da ona bude cetvrti element liste
		
		//Iscrtavanje samo krugova
		/*for(Shape s : shapes) {
			if(s instanceof Circle) {
				s.draw(g);
			}
		}*/
		
		//Iscrtavaanje samo povrsinskih oblika(Krug, Krug sa rupom, Pravougaonik)
		/*for(Shape s : shapes) {
			if(s instanceof Circle) {
				s.draw(g);
			}
			else if(s instanceof Rectangle){
				s.draw(g);
			}
					
		}*/
		
		//Testiranje iscrtavanja i selektovanja svih objekata iz liste shapes
		/*for(Shape s : shapes){
			if(s instanceof Point) {
				s.setSelected(true);
				s.draw(g);
			}
			else if(s instanceof Line) {
				s.setSelected(true);
				s.draw(g);
			}
			else if(s instanceof Circle) {
				s.setSelected(true);
				s.draw(g);
			}
			else if(s instanceof Donut) {
				s.setSelected(true);
				s.draw(g);
			}
			else if(s instanceof Rectangle) {
				s.setSelected(true);
				s.draw(g);
			}
		}*/
		
		
		//Primer HashMap
		HashMap<String, Shape> hmShapes = new HashMap<String, Shape>();
		hmShapes.put("Point", p1);
		hmShapes.put("Line", l1);
		hmShapes.put("Circle", c1);
		
		/*for(Shape s : hmShapes.values()) {
		s.draw(g);	
		}*/
		
		/*for(String s : hmShapes.keySet()) {
			System.out.println(s);
		}*/
		
		for(Map.Entry<String, Shape> me : hmShapes.entrySet()) {
			me.getValue().draw(g);
		}
		
	
	}
}