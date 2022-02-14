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

public class DimensionOfLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textStartX;
	protected JTextField textStartY;
	protected JTextField textEndX;
	protected JTextField textEndY;
	protected Color lineColor = Color.BLACK;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DimensionOfLine dialog = new DimensionOfLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DimensionOfLine() {
		setTitle("Dimension of line");
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{100, 145, 80, 100, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 30, 30, 30, 30, 30, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartX = new JLabel("Start point: X coordinate");
			GridBagConstraints gbc_lblStartX = new GridBagConstraints();
			gbc_lblStartX.anchor = GridBagConstraints.EAST;
			gbc_lblStartX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartX.gridx = 1;
			gbc_lblStartX.gridy = 1;
			contentPanel.add(lblStartX, gbc_lblStartX);
		}
		{
			textStartX = new JTextField();
			GridBagConstraints gbc_textStartX = new GridBagConstraints();
			gbc_textStartX.insets = new Insets(0, 0, 5, 5);
			gbc_textStartX.fill = GridBagConstraints.BOTH;
			gbc_textStartX.gridx = 2;
			gbc_textStartX.gridy = 1;
			contentPanel.add(textStartX, gbc_textStartX);
			textStartX.setColumns(10);
		}
		{
			JLabel lblStartY = new JLabel("Start point: Y coordinate");
			GridBagConstraints gbc_lblStartY = new GridBagConstraints();
			gbc_lblStartY.anchor = GridBagConstraints.EAST;
			gbc_lblStartY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartY.gridx = 1;
			gbc_lblStartY.gridy = 2;
			contentPanel.add(lblStartY, gbc_lblStartY);
		}
		{
			textStartY = new JTextField();
			GridBagConstraints gbc_textStartY = new GridBagConstraints();
			gbc_textStartY.insets = new Insets(0, 0, 5, 5);
			gbc_textStartY.fill = GridBagConstraints.BOTH;
			gbc_textStartY.gridx = 2;
			gbc_textStartY.gridy = 2;
			contentPanel.add(textStartY, gbc_textStartY);
			textStartY.setColumns(10);
		}
		{
			JLabel lblEndX = new JLabel("End point: X coordinate");
			GridBagConstraints gbc_lblEndX = new GridBagConstraints();
			gbc_lblEndX.anchor = GridBagConstraints.EAST;
			gbc_lblEndX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndX.gridx = 1;
			gbc_lblEndX.gridy = 3;
			contentPanel.add(lblEndX, gbc_lblEndX);
		}
		{
			textEndX = new JTextField();
			GridBagConstraints gbc_textEndX = new GridBagConstraints();
			gbc_textEndX.insets = new Insets(0, 0, 5, 5);
			gbc_textEndX.fill = GridBagConstraints.BOTH;
			gbc_textEndX.gridx = 2;
			gbc_textEndX.gridy = 3;
			contentPanel.add(textEndX, gbc_textEndX);
			textEndX.setColumns(10);
		}
		{
			JLabel lblEndY = new JLabel("End point: Y coordinate");
			GridBagConstraints gbc_lblEndY = new GridBagConstraints();
			gbc_lblEndY.anchor = GridBagConstraints.EAST;
			gbc_lblEndY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndY.gridx = 1;
			gbc_lblEndY.gridy = 4;
			contentPanel.add(lblEndY, gbc_lblEndY);
		}
		{
			textEndY = new JTextField();
			GridBagConstraints gbc_textEndY = new GridBagConstraints();
			gbc_textEndY.insets = new Insets(0, 0, 5, 5);
			gbc_textEndY.fill = GridBagConstraints.BOTH;
			gbc_textEndY.gridx = 2;
			gbc_textEndY.gridy = 4;
			contentPanel.add(textEndY, gbc_textEndY);
			textEndY.setColumns(10);
		}
		{
			JLabel lblLineColor = new JLabel("Line Color");
			GridBagConstraints gbc_lblLineColor = new GridBagConstraints();
			gbc_lblLineColor.anchor = GridBagConstraints.EAST;
			gbc_lblLineColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblLineColor.gridx = 1;
			gbc_lblLineColor.gridy = 5;
			contentPanel.add(lblLineColor, gbc_lblLineColor);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lineColor = JColorChooser.showDialog(null, "Choose line color", Color.BLACK);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.fill = GridBagConstraints.BOTH;
			gbc_btnColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnColor.gridx = 2;
			gbc_btnColor.gridy = 5;
			contentPanel.add(btnColor, gbc_btnColor);
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
							if(Integer.parseInt(textStartX.getText()) < 0 && Integer.parseInt(textStartY.getText()) < 0){
								JOptionPane.showMessageDialog (null, "X and Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textStartX.getText())) < 0){
								JOptionPane.showMessageDialog (null, "X coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}else if((Integer.parseInt(textStartY.getText())) < 0){
								JOptionPane.showMessageDialog (null, "Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if(Integer.parseInt(textEndX.getText()) < 0 && Integer.parseInt(textEndY.getText()) < 0){
								JOptionPane.showMessageDialog (null, "X and Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textEndX.getText())) < 0){
								JOptionPane.showMessageDialog (null, "X coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}else if((Integer.parseInt(textEndY.getText())) < 0){
								JOptionPane.showMessageDialog (null, "Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else
								setVisible(false);
						}catch(Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null,"You must enter numbers!","ERROR!", JOptionPane.ERROR_MESSAGE);
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