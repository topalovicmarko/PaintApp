package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DimensionOfDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textX;
	protected JTextField textY;
	protected JTextField textOuterRadius;
	protected Color donutColor = Color.WHITE;
	protected Color borderColor = Color.BLACK;
	protected int outerRadius;
	protected JTextField textInnerRadius;
	protected int innerRadius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DimensionOfDonut dialog = new DimensionOfDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DimensionOfDonut() {
		setTitle("Dimension of donut");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{70, 160, 120, 82, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 25, 25, 25, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("Donut center: X coordinate");
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
			JLabel lblY = new JLabel("Donut center: Y coordinate");
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
			JLabel lblOuterRadius = new JLabel("Outer radius");
			GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
			gbc_lblOuterRadius.fill = GridBagConstraints.VERTICAL;
			gbc_lblOuterRadius.anchor = GridBagConstraints.EAST;
			gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterRadius.gridx = 1;
			gbc_lblOuterRadius.gridy = 3;
			contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);
		}
		{
			textOuterRadius = new JTextField();
			GridBagConstraints gbc_textOuterRadius = new GridBagConstraints();
			gbc_textOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textOuterRadius.fill = GridBagConstraints.BOTH;
			gbc_textOuterRadius.gridx = 2;
			gbc_textOuterRadius.gridy = 3;
			contentPanel.add(textOuterRadius, gbc_textOuterRadius);
			textOuterRadius.setColumns(10);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner radius");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.fill = GridBagConstraints.VERTICAL;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 1;
			gbc_lblInnerRadius.gridy = 4;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			textInnerRadius = new JTextField();
			GridBagConstraints gbc_textInnerRadius = new GridBagConstraints();
			gbc_textInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textInnerRadius.fill = GridBagConstraints.BOTH;
			gbc_textInnerRadius.gridx = 2;
			gbc_textInnerRadius.gridy = 4;
			contentPanel.add(textInnerRadius, gbc_textInnerRadius);
			textInnerRadius.setColumns(10);
		}
		{
			JLabel lblDonutColor = new JLabel("Donut color");
			GridBagConstraints gbc_lblDonutColor = new GridBagConstraints();
			gbc_lblDonutColor.anchor = GridBagConstraints.EAST;
			gbc_lblDonutColor.fill = GridBagConstraints.VERTICAL;
			gbc_lblDonutColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblDonutColor.gridx = 1;
			gbc_lblDonutColor.gridy = 5;
			contentPanel.add(lblDonutColor, gbc_lblDonutColor);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					donutColor = JColorChooser.showDialog(null, "Choose color of donut", Color.BLACK);
				}}
			);
			
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.fill = GridBagConstraints.BOTH;
			gbc_btnColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnColor.gridx = 2;
			gbc_btnColor.gridy = 5;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JLabel lblBorderColor = new JLabel("Border color");
			GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
			gbc_lblBorderColor.anchor = GridBagConstraints.EAST;
			gbc_lblBorderColor.fill = GridBagConstraints.VERTICAL;
			gbc_lblBorderColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblBorderColor.gridx = 1;
			gbc_lblBorderColor.gridy = 6;
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
			gbc_btnBorderColor.gridy = 6;
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
							if((Integer.parseInt(textX.getText())) < 0 && (Integer.parseInt(textY.getText())) < 0 ){
								JOptionPane.showMessageDialog (null, "X and Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textX.getText())) < 0){
								JOptionPane.showMessageDialog (null, "X coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
								}
							else if((Integer.parseInt(textY.getText())) < 0){
								JOptionPane.showMessageDialog (null, "Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
								}
							else if(Integer.parseInt(textOuterRadius.getText()) < 0){
								JOptionPane.showMessageDialog(null, "Outer radius can't be negative!","ERROR!!!", JOptionPane.ERROR_MESSAGE);
							}
							else if(Integer.parseInt(textOuterRadius.getText()) == 0) {
								JOptionPane.showMessageDialog (null, "Outer radius can't be 0!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textInnerRadius.getText())) < 0){
								JOptionPane.showMessageDialog(null, "Inner radius can't be negative!", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textInnerRadius.getText())) == 0) {
								JOptionPane.showMessageDialog (null, "Inner radius can't be 0!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textInnerRadius.getText())) > (Integer.parseInt(textOuterRadius.getText()))) {
								JOptionPane.showMessageDialog (null, "Inner radius can't be bigger than the outer radius!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textOuterRadius.getText())) == (Integer.parseInt(textInnerRadius.getText()))) {
								JOptionPane.showMessageDialog (null, "Inner radius can't be same as the outer radius!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else{
								outerRadius = Integer.parseInt(textOuterRadius.getText());
								innerRadius = Integer.parseInt(textInnerRadius.getText());
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