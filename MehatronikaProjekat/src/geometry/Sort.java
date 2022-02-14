package geometry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Sort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	private DefaultListModel<Rectangle> sortedModel = new DefaultListModel<Rectangle>();
	private static boolean hideColor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort frame = new Sort();
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
	public Sort() {
		setTitle("Topalovi\u0107 Marko MH 75-2018");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{130, 295, 0};
		gbl_pnlCenter.rowHeights = new int[]{30, 30, 190, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		pnlCenter.add(scrollPane, gbc_scrollPane);
		
		JList<Rectangle> list = new JList<Rectangle>();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
		
		JButton btnAddRectangle = new JButton("Add Rectangle");
		btnAddRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideColor = true;
				DimensionOfRectangle dor = new DimensionOfRectangle();
				dor.setVisible(true);
				if(dor.isOk) {
					dlm.add(0, new Rectangle(new Point(Integer.parseInt(dor.textX.getText()), Integer.parseInt(dor.textY.getText())),
							Integer.parseInt(dor.textWidth.getText()), Integer.parseInt(dor.textHeight.getText())));
					scrollPane.setViewportView(list);
				}
			}
		});
		GridBagConstraints gbc_btnAddRectangle = new GridBagConstraints();
		gbc_btnAddRectangle.fill = GridBagConstraints.BOTH;
		gbc_btnAddRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddRectangle.gridx = 0;
		gbc_btnAddRectangle.gridy = 0;
		pnlCenter.add(btnAddRectangle, gbc_btnAddRectangle);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] rectangles = dlm.toArray();
				
				sortedModel.removeAllElements();
				
				for(int j = 0; j < rectangles.length; j++) {
					Arrays.sort(rectangles);
					sortedModel.addElement((Rectangle) rectangles[j]);
				}
				
				JList<Rectangle> sortedList = new JList<Rectangle>(sortedModel);
				scrollPane.setViewportView(sortedList);
			}
		});
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.fill = GridBagConstraints.BOTH;
		gbc_btnSort.insets = new Insets(0, 0, 5, 5);
		gbc_btnSort.gridx = 0;
		gbc_btnSort.gridy = 1;
		pnlCenter.add(btnSort, gbc_btnSort);
	}

	//Get i Set metode
	public static boolean isHideColor() {
		return hideColor;
	}
}