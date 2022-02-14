package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class DimensionOfCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textX;
	protected JTextField textY;
	protected JTextField textRadius;
	protected Color circleColor = Color.WHITE;
	protected Color borderColor = Color.BLACK;
	protected int radius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DimensionOfCircle dialog = new DimensionOfCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DimensionOfCircle() {
		setTitle("Dimension of circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{70, 160, 120, 82, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 25, 25, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("Circle center: X coordinate");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.fill = GridBagConstraints.VERTICAL;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
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
			contentPanel.add(textX, gbc_textX);
			textX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Circle center: Y coordinate");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.fill = GridBagConstraints.VERTICAL;
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
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
			contentPanel.add(textY, gbc_textY);
			textY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.fill = GridBagConstraints.VERTICAL;
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textRadius = new JTextField();
			GridBagConstraints gbc_textRadius = new GridBagConstraints();
			gbc_textRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textRadius.fill = GridBagConstraints.BOTH;
			gbc_textRadius.gridx = 2;
			gbc_textRadius.gridy = 3;
			contentPanel.add(textRadius, gbc_textRadius);
			textRadius.setColumns(10);
		}
		{
			JLabel lblCircleColor = new JLabel("Circle color");
			GridBagConstraints gbc_lblCircleColor = new GridBagConstraints();
			gbc_lblCircleColor.anchor = GridBagConstraints.EAST;
			gbc_lblCircleColor.fill = GridBagConstraints.VERTICAL;
			gbc_lblCircleColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblCircleColor.gridx = 1;
			gbc_lblCircleColor.gridy = 4;
			contentPanel.add(lblCircleColor, gbc_lblCircleColor);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					circleColor = JColorChooser.showDialog(null, "Choose color of circle", Color.BLACK);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.fill = GridBagConstraints.BOTH;
			gbc_btnColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnColor.gridx = 2;
			gbc_btnColor.gridy = 4;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JLabel lblBorderColor = new JLabel("Border color");
			GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
			gbc_lblBorderColor.anchor = GridBagConstraints.EAST;
			gbc_lblBorderColor.fill = GridBagConstraints.VERTICAL;
			gbc_lblBorderColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblBorderColor.gridx = 1;
			gbc_lblBorderColor.gridy = 5;
			contentPanel.add(lblBorderColor, gbc_lblBorderColor);
		}
		{
			JButton btnBorderColor = new JButton("Color");
			btnBorderColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borderColor = JColorChooser.showDialog(null, "Choose border color ", Color.BLACK);
				}
			});
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.fill = GridBagConstraints.BOTH;
			gbc_btnBorderColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnBorderColor.gridx = 2;
			gbc_btnBorderColor.gridy = 5;
			contentPanel.add(btnBorderColor, gbc_btnBorderColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try { 
							radius = Integer.parseInt(textRadius.getText());
							if((Integer.parseInt(textX.getText())) < 0 && (Integer.parseInt(textY.getText())) < 0 ){
								JOptionPane.showMessageDialog (null, "X and Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textX.getText())) < 0){
								JOptionPane.showMessageDialog (null, "X coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
								}
							else if((Integer.parseInt(textY.getText())) < 0){
								JOptionPane.showMessageDialog (null, "Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
								}
							else if(radius < 0){
								JOptionPane.showMessageDialog(null, "Radius can't be negative!","ERROR!!!", JOptionPane.ERROR_MESSAGE);
							}else if(radius == 0) {
								JOptionPane.showMessageDialog (null, "Radius can't be 0!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}else{
								setVisible(false);
							}
						} catch (NumberFormatException e1) { 
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null,"You must enter numbers!", "ERROR!", JOptionPane.ERROR_MESSAGE);
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
	}
}