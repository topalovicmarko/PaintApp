package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DimensionOfPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textX;
	protected JTextField textY;
	protected Color pointColor = Color.BLACK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DimensionOfPoint dialog = new DimensionOfPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DimensionOfPoint() {
		setTitle("Dimension of point");
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{100, 100, 0, 100, 0};
		gbl_contentPanel.rowHeights = new int[]{30, 30, 30, 30, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X coordinate");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			textX = new JTextField();
			GridBagConstraints gbc_textX = new GridBagConstraints();
			gbc_textX.insets = new Insets(0, 0, 5, 5);
			gbc_textX.fill = GridBagConstraints.BOTH;
			gbc_textX.gridx = 2;
			gbc_textX.gridy = 1;
			contentPanel.add(textX, gbc_textX);
			textX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textY = new JTextField();
			GridBagConstraints gbc_textY = new GridBagConstraints();
			gbc_textY.insets = new Insets(0, 0, 5, 5);
			gbc_textY.fill = GridBagConstraints.BOTH;
			gbc_textY.gridx = 2;
			gbc_textY.gridy = 2;
			contentPanel.add(textY, gbc_textY);
			textY.setColumns(10);
		}
		{
			JLabel lblPointColor = new JLabel("Point color:");
			GridBagConstraints gbc_lblPointColor = new GridBagConstraints();
			gbc_lblPointColor.anchor = GridBagConstraints.EAST;
			gbc_lblPointColor.fill = GridBagConstraints.VERTICAL;
			gbc_lblPointColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblPointColor.gridx = 1;
			gbc_lblPointColor.gridy = 3;
			contentPanel.add(lblPointColor, gbc_lblPointColor);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pointColor = JColorChooser.showDialog(null, "Choose point color", Color.BLACK);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.fill = GridBagConstraints.BOTH;
			gbc_btnColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnColor.gridx = 2;
			gbc_btnColor.gridy = 3;
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
							if(Integer.parseInt(textX.getText()) < 0 && Integer.parseInt(textY.getText()) < 0){
								JOptionPane.showMessageDialog (null, "X and Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else if((Integer.parseInt(textX.getText())) < 0){
								JOptionPane.showMessageDialog (null, "X coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}else if((Integer.parseInt(textY.getText())) < 0){
								JOptionPane.showMessageDialog (null, "Y coordinate can't be negative!", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else
								setVisible(false);
						}catch(Exception ex) {
							ex.printStackTrace();
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
	}
}