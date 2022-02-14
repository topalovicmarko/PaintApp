package geometry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	private int position;
	private static boolean hideColor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
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
		gbl_pnlCenter.columnWidths = new int[]{56, 290, 0};
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
		
		JButton tglbtnAddRectangle = new JButton("Add rectangle");
		tglbtnAddRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideColor = true;
				DimensionOfRectangle dor = new DimensionOfRectangle();
				dor.setVisible(true);
				if(dor.isOk) {
					dlm.add(0, new Rectangle(new Point(Integer.parseInt(dor.textX.getText()), Integer.parseInt(dor.textY.getText())),
							Integer.parseInt(dor.textWidth.getText()), Integer.parseInt(dor.textHeight.getText())));
				}
			}
		});
		GridBagConstraints gbc_tglbtnAddRectangle = new GridBagConstraints();
		gbc_tglbtnAddRectangle.fill = GridBagConstraints.BOTH;
		gbc_tglbtnAddRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnAddRectangle.gridx = 0;
		gbc_tglbtnAddRectangle.gridy = 0;
		pnlCenter.add(tglbtnAddRectangle, gbc_tglbtnAddRectangle);
		
		
		JButton tglbtnDeleteRectangle = new JButton("Delete rectangle");
		tglbtnDeleteRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideColor = true;
				position = list.getSelectedIndex();
				DimensionOfRectangle dor = new DimensionOfRectangle();
				//Ispis vrednosti objekta koji se briše
				dor.textX.setText("" + dlm.getElementAt(position).getUpperLeft().getX());
				dor.textX.setEditable(false);
				dor.textY.setText("" + dlm.getElementAt(position).getUpperLeft().getY());
				dor.textY.setEditable(false);
				dor.textWidth.setText("" + dlm.getElementAt(position).getWidth());
				dor.textWidth.setEditable(false);
				dor.textHeight.setText("" + dlm.getElementAt(position).getHeight());
				dor.textHeight.setEditable(false);
				dor.setVisible(true);
				dlm.remove(position);
			}
		});
		GridBagConstraints gbc_tglbtnDeleteRectangle = new GridBagConstraints();
		gbc_tglbtnDeleteRectangle.fill = GridBagConstraints.BOTH;
		gbc_tglbtnDeleteRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnDeleteRectangle.gridx = 0;
		gbc_tglbtnDeleteRectangle.gridy = 1;
		pnlCenter.add(tglbtnDeleteRectangle, gbc_tglbtnDeleteRectangle);
	}

	//Get i Set metode
	public static boolean isHideColor() {
		return hideColor;
	}
}