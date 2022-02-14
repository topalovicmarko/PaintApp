package geometry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Drawing extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDonut;
	private static int operation; 			
	private static int shapes; 				

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing frame = new Drawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Drawing() {
		setTitle("Topalovi\u0107 Marko MH 75-2018");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{337, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCenter.rowHeights = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCenter.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JPanel pnl = new PnlDrawing();	
		pnl.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnl = new GridBagConstraints();
		gbc_pnl.fill = GridBagConstraints.BOTH;
		gbc_pnl.gridwidth = 12;
		gbc_pnl.gridheight = 11;
		gbc_pnl.gridx = 0;
		gbc_pnl.gridy = 0;
		panelCenter.add(pnl, gbc_pnl);
		GridBagLayout gbl_pnl = new GridBagLayout();
		gbl_pnl.columnWidths = new int[]{0};
		gbl_pnl.rowHeights = new int[]{0};
		gbl_pnl.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pnl.rowWeights = new double[]{Double.MIN_VALUE};
		pnl.setLayout(gbl_pnl);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.WHITE);
		contentPane.add(panelNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorth = new GridBagLayout();
		gbl_panelNorth.columnWidths = new int[]{60, 30, 42, 29, 12, 0, 40, 46, 32, 32, 60, 0};
		gbl_panelNorth.rowHeights = new int[]{-13, 0};
		gbl_panelNorth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNorth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelNorth.setLayout(gbl_panelNorth);
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operation != 1) {
					operation = 1;
				}
			}
		});
		GridBagConstraints gbc_btnDraw = new GridBagConstraints();
		gbc_btnDraw.fill = GridBagConstraints.BOTH;
		gbc_btnDraw.insets = new Insets(0, 0, 5, 5);
		gbc_btnDraw.gridx = 1;
		gbc_btnDraw.gridy = 0;
		panelNorth.add(btnDraw, gbc_btnDraw);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operation != 2)
					operation = 2;
			}
		});
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.BOTH;
		gbc_btnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelect.gridx = 2;
		gbc_btnSelect.gridy = 0;
		panelNorth.add(btnSelect, gbc_btnSelect);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operation != 3)
					operation = 3;
					modify();
			}
		});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.fill = GridBagConstraints.BOTH;
		gbc_btnModify.insets = new Insets(0, 0, 5, 5);
		gbc_btnModify.gridx = 3;
		gbc_btnModify.gridy = 0;
		panelNorth.add(btnModify, gbc_btnModify);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operation != 4)
					operation = 4;
					delete();
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.gridx = 4;
		gbc_btnDelete.gridy = 0;
		panelNorth.add(btnDelete, gbc_btnDelete);
		
		tglbtnPoint = new JToggleButton("Point");
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPoint.gridx = 5;
		gbc_tglbtnPoint.gridy = 0;
		panelNorth.add(tglbtnPoint, gbc_tglbtnPoint);
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shapes != 1) {
					shapes = 1;
					tglbtnPoint.setSelected(true);
					tglbtnLine.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnDonut.setSelected(false);
				}
			}
		});
		
		tglbtnLine = new JToggleButton("Line");
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.fill = GridBagConstraints.BOTH;
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLine.gridx = 6;
		gbc_tglbtnLine.gridy = 0;
		panelNorth.add(tglbtnLine, gbc_tglbtnLine);
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shapes != 2) {
					shapes = 2;
					tglbtnPoint.setSelected(false);
					tglbtnLine.setSelected(true);
					tglbtnRectangle.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnDonut.setSelected(false);
				}
			}
		});
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.fill = GridBagConstraints.BOTH;
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnRectangle.gridx = 7;
		gbc_tglbtnRectangle.gridy = 0;
		panelNorth.add(tglbtnRectangle, gbc_tglbtnRectangle);
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shapes != 3) {
					shapes = 3;
					tglbtnPoint.setSelected(false);
					tglbtnLine.setSelected(false);
					tglbtnRectangle.setSelected(true);
					tglbtnCircle.setSelected(false);
					tglbtnDonut.setSelected(false);
				}
			}
		});
		
		tglbtnCircle = new JToggleButton("Circle");
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.fill = GridBagConstraints.BOTH;
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCircle.gridx = 8;
		gbc_tglbtnCircle.gridy = 0;
		panelNorth.add(tglbtnCircle, gbc_tglbtnCircle);
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shapes != 4) {
					shapes = 4;
					tglbtnPoint.setSelected(false);
					tglbtnLine.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnCircle.setSelected(true);
					tglbtnDonut.setSelected(false);
				}
			}
		});
		
		tglbtnDonut = new JToggleButton("Donut");
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnDonut.fill = GridBagConstraints.BOTH;
		gbc_tglbtnDonut.gridx = 9;
		gbc_tglbtnDonut.gridy = 0;
		panelNorth.add(tglbtnDonut, gbc_tglbtnDonut);
		tglbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shapes != 5) {
					shapes = 5;
					tglbtnPoint.setSelected(false);
					tglbtnLine.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnDonut.setSelected(true);
			}
			}
		});
	}

	public void modify(){
		Shape selectedShape = PnlDrawing.getSelected();
		
		if(selectedShape != null) {
			if(selectedShape instanceof Point) {
				Point p = (Point) selectedShape;
				DimensionOfPoint dop = new DimensionOfPoint();
				dop.textX.setText("" + p.getX());
				dop.textY.setText("" + p.getY());
				dop.pointColor = p.getBorderColor();
				dop.setVisible(true);
				selectedShape.moveTo(Integer.parseInt(dop.textX.getText()), Integer.parseInt(dop.textY.getText()));
				selectedShape.setBorderColor(dop.pointColor);
			}
		else if(selectedShape instanceof Line) {
				DimensionOfLine dol = new DimensionOfLine();
				Line l = (Line) selectedShape;
				dol.textStartX.setText("" + l.getStartPoint().getX());
				dol.textStartY.setText("" + l.getStartPoint().getY());
				dol.textEndX.setText("" + l.getEndPoint().getX());
				dol.textEndY.setText("" + l.getEndPoint().getY());
				dol.lineColor = l.getBorderColor();
				dol.setVisible(true);
				((Line)selectedShape).setStartPoint(new Point(Integer.parseInt(dol.textStartX.getText()), Integer.parseInt(dol.textStartY.getText())));
				((Line)selectedShape).setEndPoint(new Point(Integer.parseInt(dol.textEndX.getText()), Integer.parseInt(dol.textEndY.getText())));
				selectedShape.setBorderColor(dol.lineColor);
				
			}else if(selectedShape instanceof Rectangle) {
				DimensionOfRectangle dor = new DimensionOfRectangle();
				Rectangle r = (Rectangle) selectedShape;
				dor.textX.setText("" + r.getUpperLeft().getX());
				dor.textY.setText("" + r.getUpperLeft().getY());
				dor.textWidth.setText("" + r.getWidth());
				dor.textHeight.setText("" + r.getHeight());
				dor.borderColor = r.getBorderColor();
				dor.rectangleColor = r.getRectangleColor();
				dor.setVisible(true);
				selectedShape.moveTo((Integer.parseInt(dor.textX.getText())), (Integer.parseInt(dor.textY.getText())));
				((Rectangle) selectedShape).setWidth(dor.width);
				((Rectangle) selectedShape).setHeight(dor.height);
				selectedShape.setBorderColor(dor.borderColor);
				((Rectangle) selectedShape).setRectangleColor(dor.rectangleColor);
			
			}
			else if(selectedShape instanceof Donut) {
				DimensionOfDonut dod = new DimensionOfDonut();
				Donut d = (Donut) selectedShape;
				dod.textX.setText("" + d.getCenter().getX());
				dod.textY.setText("" + d.getCenter().getY());
				dod.textOuterRadius.setText("" + d.getRadius());
				dod.textInnerRadius.setText("" + d.getInnerRadius());
				dod.borderColor = d.getBorderColor();
				dod.donutColor = d.getDonutColor();
				dod.setVisible(true);
				selectedShape.moveTo (Integer.parseInt(dod.textX.getText()), Integer.parseInt(dod.textY.getText()));
				((Donut) selectedShape).setRadius(dod.outerRadius);
				((Donut) selectedShape).setInnerRadius(dod.innerRadius);
				selectedShape.setBorderColor(dod.borderColor);
				((Donut) selectedShape).setDonutColor(dod.donutColor);
			}	
			else if(selectedShape instanceof Circle) {
				DimensionOfCircle doc = new DimensionOfCircle();
				Circle c = (Circle) selectedShape;
				doc.textX.setText("" + c.getCenter().getX());
				doc.textY.setText("" + c.getCenter().getY());
				doc.textRadius.setText("" + c.getRadius());
				doc.borderColor = c.getBorderColor();
				doc.circleColor = c.getCircleColor();
				doc.setVisible(true);
				selectedShape.moveTo (Integer.parseInt(doc.textX.getText()), Integer.parseInt(doc.textY.getText()));
				((Circle) selectedShape).setRadius(doc.radius);
				selectedShape.setBorderColor(doc.borderColor);
				((Circle) selectedShape).setCircleColor(doc.circleColor);
			}
			
	}
	else {
		JOptionPane.showMessageDialog(null, "You must select object!", "WARNING!", JOptionPane.WARNING_MESSAGE);
	}
}

	public void delete() {
		
		Shape selectedShape = PnlDrawing.getSelected();
		if(selectedShape != null) {
			int option = JOptionPane.showConfirmDialog(null, "Are you sure that you want to delete selected object?", "Delete", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION) {
				PnlDrawing.getShapes().remove(selectedShape);
			}
		}else
			JOptionPane.showMessageDialog(null, "You must select object!", "WARNING!", JOptionPane.WARNING_MESSAGE);
	}
		
	//Get i Set metode
	public static int getOperation() {
		return operation;
	}
	
	public static int getShapes() {
		return shapes;
	}
}
