package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel {
	
	static ArrayList<Shape>  shapes = new ArrayList<Shape>();	//lista u kojoj smeštamo nacrtane oblike
	private boolean firstPoint = false;							//promenjljiva koja nam govori da li je postavljena prva taèka linije
	private int x, y, newX, newY;
	private Point upperLeft; 									//gornja leva taèka pravougaonika
	ArrayList<Shape> selected = new ArrayList<Shape>();			//lista u koju smeštamo selektovane oblike
	ArrayList<Shape> lastSelected = new ArrayList<Shape>();		//lista u koju smeštamo zadnji selektovan objekat
	private static Shape selectedShape; 						//promenljiva koja nam pokazuje koji je oblik selektovan
	
	public PnlDrawing() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Drow
				if(Drawing.getOperation() == 1) {
					switch(Drawing.getShapes()) {
						case 1:{
							Point p1 = new Point(e.getX(), e.getY(), Color.BLACK);
							shapes.add(p1);
							break;
						}
						case 2:{
							if(!firstPoint) {
								x = e.getX();
								y = e.getY();
								firstPoint = true;
							}
							else if(firstPoint) {
								newX = e.getX();
								newY = e.getY();
								Line l1 = new Line(new Point(x, y), new Point(newX, newY), Color.BLACK);
								firstPoint = false;
								shapes.add(l1);
							}
							break;
						}
						case 3:{
							upperLeft = new Point(e.getX(), e.getY());
							DimensionOfRectangle dor = new DimensionOfRectangle();
							dor.textX.setText("" + e.getX());
							dor.textY.setText("" + e.getY());
							dor.setVisible(true);
							Rectangle r1 = new Rectangle(upperLeft, dor.width, dor.height, dor.rectangleColor, dor.borderColor);
							shapes.add(r1);
							break;
					}
						case 4:{
							DimensionOfCircle doc = new DimensionOfCircle();
							doc.textX.setText("" + e.getX());
							doc.textY.setText("" + e.getY());
							doc.setVisible(true);
							Circle c1 = new Circle(new Point(e.getX(), e.getY()), doc.radius, doc.borderColor, doc.circleColor);
							shapes.add(c1);
							break;
					}	
						case 5:{
						DimensionOfDonut dod = new DimensionOfDonut();
						dod.textX.setText("" + e.getX());
						dod.textY.setText("" + e.getY());
						dod.setVisible(true);
						Donut d1 = new Donut(new Point(e.getX(), e.getY()), dod.outerRadius, dod.innerRadius, dod.borderColor, dod.donutColor);
						shapes.add(d1);
						break;
					}
					}
				}
				//Select
				if(Drawing.getOperation() == 2){
					selection(e.getX(), e.getY());	
			}
			}
		});

	}

	@Override
	public void paint(Graphics g){
		
		super.paint(g);
		Iterator<Shape> it = shapes.iterator(); 

		while (it.hasNext()) { 
			Shape s = (Shape) it.next();  
			
			if(s instanceof Rectangle){
				((Rectangle) s).fill(g);
			}								
			if(s instanceof Circle){
				((Circle) s).fill(g);
			}
			if(s instanceof Donut){
				((Donut) s).fill(g);
			}
			s.draw(g); 
		}
		repaint();
	}
	
	public void selection(int x,int y) {
		
		Iterator<Shape> it = shapes.iterator();
		selected.clear();
		selectedShape = null;
		
		while(it.hasNext()) {
			Shape shape = it.next();
			shape.setSelected(false);
			if(shape.contains(x, y))
				selected.add(shape);
		}
			if(selected.size() == 1) {
				((Shape) selected.get(0)).setSelected(true); 
				selectedShape = selected.get(0);
				
			}else if(selected.size() > 1){ 		
				((Shape) selected.get(selected.size()-1)).setSelected(true);  //selektovace se poslednji objekat
				selectedShape = selected.get(selected.size()-1);
			}	
	}

	//Get i Set metode
	public static ArrayList<Shape> getShapes(){
		return shapes;
	}

	public static Shape getSelected() {
		return selectedShape;
	}
}