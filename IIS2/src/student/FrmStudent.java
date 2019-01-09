package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtBrojStudenata;
	DefaultListModel dlm = new DefaultListModel();
	JList lstStudent = new JList();
	int brojac = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStudent frame = new FrmStudent();
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
	public FrmStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlZapad = new JPanel();
		contentPane.add(pnlZapad, BorderLayout.WEST);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStudent dlgStudent = new DlgStudent();
				dlgStudent.setVisible(true);
				dlm.addElement("Broj indeksa: " + dlgStudent.getCbxSmer().getSelectedItem() +
						" " + dlgStudent.getTxtBrojIndeksa().getText() + " / " + 
						dlgStudent.getCbxGodina().getSelectedItem() + ", Prezime: " +
						dlgStudent.getTxtPrezime().getText() + " Ime: " + dlgStudent.getTxtIme().getText());
				brojac++;
				txtBrojStudenata.setText(Integer.toString(brojac));
				}
			});
		
		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lstStudent.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(pnlZapad,
							"Nijedan red nije selektovan!",
							"Greška",
							JOptionPane.ERROR_MESSAGE);
				} else {
					DlgStudent dlgModifikacija = new DlgStudent();
					String[] split = dlm.getElementAt(lstStudent.getSelectedIndex()).toString().split(" ");
					int index = lstStudent.getSelectedIndex();
					dlgModifikacija.getTxtIme().setText(split[9]);
					dlgModifikacija.getTxtPrezime().setText(split[7]);
					dlgModifikacija.getTxtBrojIndeksa().setText(split[3]);
					dlgModifikacija.getCbxSmer().setSelectedItem(split[2]);
					dlgModifikacija.getCbxGodina().setSelectedItem( split[4]);
					dlgModifikacija.setVisible(true);
					
					if (dlgModifikacija.isOk) {
						dlm.removeElementAt(lstStudent.getSelectedIndex());
						dlm.add(index, "Broj indeksa: " + dlgModifikacija.getCbxSmer().getSelectedItem() + " " + 
										dlgModifikacija.getTxtBrojIndeksa().getText() + " / " + 
										dlgModifikacija.getCbxGodina().getSelectedItem() + ", Prezime " + 
										dlgModifikacija.getTxtPrezime().getText() + " ,Ime " + dlgModifikacija.getTxtIme().getText());
					}
				}
				
			}
		});
		GroupLayout gl_pnlZapad = new GroupLayout(pnlZapad);
		gl_pnlZapad.setHorizontalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlZapad.createParallelGroup(Alignment.LEADING)
						.addComponent(btnModifikuj, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
						.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pnlZapad.setVerticalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDodaj)
					.addGap(18)
					.addComponent(btnModifikuj)
					.addContainerGap(146, Short.MAX_VALUE))
		);
		pnlZapad.setLayout(gl_pnlZapad);
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		
		JScrollPane scrlStudent = new JScrollPane();
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrlStudent, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
		);
		gl_pnlCentar.setVerticalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrlStudent, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
		);
		
		lstStudent.setModel(dlm);
		scrlStudent.setViewportView(lstStudent);
		pnlCentar.setLayout(gl_pnlCentar);
		
		JPanel pnlIstok = new JPanel();
		contentPane.add(pnlIstok, BorderLayout.EAST);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!dlm.isEmpty()) {
					dlm.remove(dlm.size() - 1);
					brojac--;
					txtBrojStudenata.setText(Integer.toString(brojac));
				} else {
					JOptionPane.showMessageDialog(null,
							"Lista je prazna!", 
							"Greška",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pnlIstok.add(btnUkloni);
		
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		JLabel lbl1 = new JLabel("Studenata u listi:");
		pnlJug.add(lbl1);
		
		txtBrojStudenata = new JTextField();
		txtBrojStudenata.setEditable(false);
		pnlJug.add(txtBrojStudenata);
		txtBrojStudenata.setColumns(2);
		
		JLabel lblEvidencijaStudenata = new JLabel("Evidencija studenata");
		lblEvidencijaStudenata.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvidencijaStudenata.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblEvidencijaStudenata, BorderLayout.NORTH);
	}
}

