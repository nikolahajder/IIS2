package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JTextField txtUnesiIgraca;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
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
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		JButton btnIspisi = new JButton("Ispi\u0161i");
		btnIspisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)");
			}
		});
		pnlJug.add(btnIspisi);
		
		JPanel pnlCentar = new JPanel();
		pnlCentar.setBackground(new Color(204, 255, 204));
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		pnlCentar.setLayout(null);
		
		JLabel lblAleksandarKolarov = new JLabel("Aleksandar Kolarov");
		lblAleksandarKolarov.setBounds(117, 11, 121, 19);
		pnlCentar.add(lblAleksandarKolarov);
		
		JLabel lblNemanjaMatic = new JLabel("Nemanja Mati\u0107");
		lblNemanjaMatic.setBounds(117, 41, 88, 19);
		pnlCentar.add(lblNemanjaMatic);
		
		JLabel lblAleksandarMitrovic = new JLabel("Aleksandar Mitrovi\u0107");
		lblAleksandarMitrovic.setBounds(117, 71, 121, 19);
		pnlCentar.add(lblAleksandarMitrovic);
		
		JToggleButton tglbtnKolarov = new JToggleButton("Kolarov");
		tglbtnKolarov.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnKolarov.isSelected()) {
					lblAleksandarKolarov.setForeground(Color.BLUE);
					lblAleksandarMitrovic.setForeground(Color.BLACK);
					lblNemanjaMatic.setForeground(Color.BLACK);
					dlm.addElement(lblAleksandarKolarov.getText());
				}
			}
		});
		buttonGroup.add(tglbtnKolarov);
		tglbtnKolarov.setBounds(10, 9, 97, 23);
		pnlCentar.add(tglbtnKolarov);
		
		JToggleButton tglbtnMatic = new JToggleButton("Mati\u0107");
		tglbtnMatic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnMatic.isSelected()) {
					lblAleksandarKolarov.setForeground(Color.BLACK);
					lblAleksandarMitrovic.setForeground(Color.BLACK);
					lblNemanjaMatic.setForeground(Color.BLUE);
					dlm.addElement(lblNemanjaMatic.getText());
				}
			}
		});
		buttonGroup.add(tglbtnMatic);
		tglbtnMatic.setBounds(10, 39, 97, 23);
		pnlCentar.add(tglbtnMatic);
		
		JToggleButton tglbtnMitrovic = new JToggleButton("Mitrovi\u0107");
		tglbtnMitrovic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnMitrovic.isSelected()) {
					lblAleksandarKolarov.setForeground(Color.BLACK);
					lblAleksandarMitrovic.setForeground(Color.BLUE);
					lblNemanjaMatic.setForeground(Color.BLACK);
					dlm.addElement(lblAleksandarMitrovic.getText());
				}
			}
		});
		buttonGroup.add(tglbtnMitrovic);
		tglbtnMitrovic.setBounds(10, 69, 97, 23);
		pnlCentar.add(tglbtnMitrovic);
		
		JScrollPane scrlPnIgraci = new JScrollPane();
		scrlPnIgraci.setBounds(233, 11, 168, 74);
		pnlCentar.add(scrlPnIgraci);
		
		JList lstIgraci = new JList();
		lstIgraci.setModel(dlm);
		scrlPnIgraci.setViewportView(lstIgraci);
		
		JButton btnIzbrisi = new JButton("Izbri\u0161i");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(!lstIgraci.isSelectionEmpty()) {
					dlm.removeElement(lstIgraci.getSelectedValue());
				}
			}
		});
		btnIzbrisi.setBounds(319, 91, 82, 23);
		pnlCentar.add(btnIzbrisi);
		
		JCheckBox chckbxUnesiIgraca = new JCheckBox("Unesi igra\u010Da");
		chckbxUnesiIgraca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxUnesiIgraca.isSelected()) {
					txtUnesiIgraca.setEnabled(true);
				} else {
					txtUnesiIgraca.setEnabled(false);
				}
			}
		});
		chckbxUnesiIgraca.setBounds(10, 123, 97, 23);
		pnlCentar.add(chckbxUnesiIgraca);
		
		txtUnesiIgraca = new JTextField();
		txtUnesiIgraca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtUnesiIgraca.getText());
				}
			}
		});
		txtUnesiIgraca.setEnabled(false);
		txtUnesiIgraca.setBounds(117, 124, 109, 22);
		pnlCentar.add(txtUnesiIgraca);
		txtUnesiIgraca.setColumns(10);
		
		JLabel lblOdaberiIgraca = new JLabel("Odaberi igra\u010Da");
		lblOdaberiIgraca.setBounds(10, 164, 97, 14);
		pnlCentar.add(lblOdaberiIgraca);
		
		JComboBox cbxOdaberiIgraca = new JComboBox();
		cbxOdaberiIgraca.addItem("Dušan Tadić");
		cbxOdaberiIgraca.addItem("Luka Milivojević");
		cbxOdaberiIgraca.addItem("Luka Jović");
		cbxOdaberiIgraca.setBounds(117, 161, 121, 20);
		pnlCentar.add(cbxOdaberiIgraca);
		
		JButton btnDodajIgraca = new JButton("Dodaj igrača");
		btnDodajIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement((String) cbxOdaberiIgraca.getSelectedItem());
			}
		});
		btnDodajIgraca.setBounds(248, 160, 121, 23);
		pnlCentar.add(btnDodajIgraca);
		
		JLabel lblNaslov = new JLabel("Naslov");
		lblNaslov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNaslov, BorderLayout.NORTH);
	}
}
