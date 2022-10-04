package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DimensionOfRectangle extends JDialog {
	
	protected JTextField textX;
	protected JTextField textY;
	protected JTextField textWidth;
	protected JTextField textHeight;
	protected boolean isOk;
	protected Color borderColor = Color.BLACK;
	protected Color rectangleColor =  Color.WHITE;
	protected int width;
	protected int height;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DimensionOfRectangle dialog = new DimensionOfRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DimensionOfRectangle() {
		setTitle("Dimension of rectangle");
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(Integer.parseInt(textX.getText()) < 0 && Integer.parseInt(textY.getText()) < 0){
								JOptionPane.showMessageDialog (null, "X and Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textX.getText())) < 0){
								JOptionPane.showMessageDialog (null, "X coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}else if((Integer.parseInt(textY.getText())) < 0){
								JOptionPane.showMessageDialog (null, "Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textWidth.getText())) < 0 &&  (Integer.parseInt(textHeight.getText())) < 0) {
								JOptionPane.showMessageDialog(null, "Width and height can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}else if ((Integer.parseInt(textWidth.getText())) < 0 && (Integer.parseInt(textHeight.getText())) > 0){
								JOptionPane.showMessageDialog(null, "Width can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);	
							}else if ((Integer.parseInt(textWidth.getText())) > 0 && (Integer.parseInt(textHeight.getText())) < 0){
								JOptionPane.showMessageDialog(null, "Height can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}else if((Integer.parseInt(textWidth.getText())) == 0 && (Integer.parseInt(textHeight.getText())) != 0) {
								JOptionPane.showMessageDialog(null, "Width can't be 0!", "WARNING!", JOptionPane.WARNING_MESSAGE);
							}else if((Integer.parseInt(textWidth.getText())) != 0 && (Integer.parseInt(textHeight.getText()) == 0) ) {
								JOptionPane.showMessageDialog(null, "Height can't be 0!", "WARNING!", JOptionPane.WARNING_MESSAGE);
							}else if((Integer.parseInt(textWidth.getText())) == 0 && (Integer.parseInt(textHeight.getText()) == 0 )) {
								JOptionPane.showMessageDialog(null, "Width and height can't be 0!", "WARNING!", JOptionPane.WARNING_MESSAGE);
							}else{
								isOk = true;
								width = Integer.parseInt(textWidth.getText());
								height = Integer.parseInt(textHeight.getText());
								setVisible (false);
							}
						} catch (Exception e2) {
							e2.printStackTrace();
							JOptionPane.showMessageDialog(null,"You must enter numbers!","ERROR!",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panelCenter = new JPanel();
			getContentPane().add(panelCenter, BorderLayout.CENTER);
			GridBagLayout gbl_panelCenter = new GridBagLayout();
			gbl_panelCenter.columnWidths = new int[]{47, 215, 68, 90, 0};
			gbl_panelCenter.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 25, 0};
			gbl_panelCenter.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelCenter.setLayout(gbl_panelCenter);
			{
				JLabel lblX = new JLabel("Upper left point: X coordinate");
				GridBagConstraints gbc_lblX = new GridBagConstraints();
				gbc_lblX.insets = new Insets(0, 0, 5, 5);
				gbc_lblX.anchor = GridBagConstraints.EAST;
				gbc_lblX.gridx = 1;
				gbc_lblX.gridy = 1;
				panelCenter.add(lblX, gbc_lblX);
			}
			{
				textX = new JTextField();
				if(Drawing.getOperation() == 1)
					textX.setEditable(false);
				GridBagConstraints gbc_textX = new GridBagConstraints();
				gbc_textX.insets = new Insets(0, 0, 5, 5);
				gbc_textX.fill = GridBagConstraints.BOTH;
				gbc_textX.gridx = 2;
				gbc_textX.gridy = 1;
				panelCenter.add(textX, gbc_textX);
				textX.setColumns(10);
			}
			{
				JLabel lblY = new JLabel("Upper left point: Y coordinate");
				GridBagConstraints gbc_lblY = new GridBagConstraints();
				gbc_lblY.insets = new Insets(0, 0, 5, 5);
				gbc_lblY.anchor = GridBagConstraints.EAST;
				gbc_lblY.gridx = 1;
				gbc_lblY.gridy = 2;
				panelCenter.add(lblY, gbc_lblY);
			}
			{
				textY = new JTextField();
				if(Drawing.getOperation() == 1)
					textY.setEditable(false);
				GridBagConstraints gbc_textY = new GridBagConstraints();
				gbc_textY.insets = new Insets(0, 0, 5, 5);
				gbc_textY.fill = GridBagConstraints.BOTH;
				gbc_textY.gridx = 2;
				gbc_textY.gridy = 2;
				panelCenter.add(textY, gbc_textY);
				textY.setColumns(10);
			}
			{
				JLabel lblWidth = new JLabel("Width");
				GridBagConstraints gbc_lblWidth = new GridBagConstraints();
				gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
				gbc_lblWidth.anchor = GridBagConstraints.EAST;
				gbc_lblWidth.gridx = 1;
				gbc_lblWidth.gridy = 3;
				panelCenter.add(lblWidth, gbc_lblWidth);
			}
			{
				textWidth = new JTextField();
				GridBagConstraints gbc_textWidth = new GridBagConstraints();
				gbc_textWidth.insets = new Insets(0, 0, 5, 5);
				gbc_textWidth.fill = GridBagConstraints.BOTH;
				gbc_textWidth.gridx = 2;
				gbc_textWidth.gridy = 3;
				panelCenter.add(textWidth, gbc_textWidth);
				textWidth.setColumns(10);
			}
			{
				JLabel lblHeight = new JLabel("Height");
				GridBagConstraints gbc_lblHeight = new GridBagConstraints();
				gbc_lblHeight.anchor = GridBagConstraints.EAST;
				gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
				gbc_lblHeight.gridx = 1;
				gbc_lblHeight.gridy = 4;
				panelCenter.add(lblHeight, gbc_lblHeight);
			}
			{
				textHeight = new JTextField();
				GridBagConstraints gbc_textHeight = new GridBagConstraints();
				gbc_textHeight.insets = new Insets(0, 0, 5, 5);
				gbc_textHeight.fill = GridBagConstraints.BOTH;
				gbc_textHeight.gridx = 2;
				gbc_textHeight.gridy = 4;
				panelCenter.add(textHeight, gbc_textHeight);
				textHeight.setColumns(10);
			}
			{
				JLabel lblRectangleColor = new JLabel("Rectangle Color");
				if(Stack.isHideColor())
					lblRectangleColor.setVisible(false);
				else if(Sort.isHideColor())
					lblRectangleColor.setVisible(false);
				GridBagConstraints gbc_lblRectangleColor = new GridBagConstraints();
				gbc_lblRectangleColor.anchor = GridBagConstraints.EAST;
				gbc_lblRectangleColor.fill = GridBagConstraints.VERTICAL;
				gbc_lblRectangleColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblRectangleColor.gridx = 1;
				gbc_lblRectangleColor.gridy = 5;
				panelCenter.add(lblRectangleColor, gbc_lblRectangleColor);
			}
			{
				JButton btnRectangleColor = new JButton("Color");
				if(Stack.isHideColor())
					btnRectangleColor.setVisible(false);
				else if(Sort.isHideColor())
					btnRectangleColor.setVisible(false);
				btnRectangleColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rectangleColor = JColorChooser.showDialog(null, "Choose rectangle color", Color.WHITE);
					}
				});
				GridBagConstraints gbc_btnRectangleColor = new GridBagConstraints();
				gbc_btnRectangleColor.fill = GridBagConstraints.BOTH;
				gbc_btnRectangleColor.insets = new Insets(0, 0, 5, 5);
				gbc_btnRectangleColor.gridx = 2;
				gbc_btnRectangleColor.gridy = 5;
				panelCenter.add(btnRectangleColor, gbc_btnRectangleColor);
			}
			{
				JLabel lblBorderColor = new JLabel("Border Color");
				if(Stack.isHideColor())
					lblBorderColor.setVisible(false);
				else if(Sort.isHideColor())
					lblBorderColor.setVisible(false);
				GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
				gbc_lblBorderColor.anchor = GridBagConstraints.EAST;
				gbc_lblBorderColor.fill = GridBagConstraints.VERTICAL;
				gbc_lblBorderColor.insets = new Insets(0, 0, 0, 5);
				gbc_lblBorderColor.gridx = 1;
				gbc_lblBorderColor.gridy = 6;
				panelCenter.add(lblBorderColor, gbc_lblBorderColor);
			}
			{
				JButton btnBorderColor = new JButton("Color");
				if(Stack.isHideColor())
					btnBorderColor.setVisible(false);
				else if(Sort.isHideColor())
					btnBorderColor.setVisible(false);
				btnBorderColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						borderColor = JColorChooser.showDialog(null, "Choose border color", Color.BLACK);
					}
				});
				GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
				gbc_btnBorderColor.fill = GridBagConstraints.BOTH;
				gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
				gbc_btnBorderColor.gridx = 2;
				gbc_btnBorderColor.gridy = 6;
				panelCenter.add(btnBorderColor, gbc_btnBorderColor);
			}
		}
	}
}