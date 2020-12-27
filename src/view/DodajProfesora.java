package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.BazaProfesora;
import classes.Predmet;
import classes.Profesor;
import classes.Titula;
import classes.Zvanje;
import controllers.ProfesoriController;
import gui.MainFrame;
import net.miginfocom.swing.MigLayout;

public class DodajProfesora extends JDialog{
	
	private JPanel panelPolja;
	private JPanel panelDugmad;
	
	private JLabel lblPrezime;
	private JTextField tfPrezime;
	private JLabel lblIme; 
	private JTextField tfIme;
	private JLabel lblDatRodj;
	private JTextField tfDatRodj;
	private JLabel lblAdresa;
	private JTextField tfAdresa;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblBrLK;
	private JTextField tfBrLK;
	private JLabel lblTitula;
	private JComboBox cbTitula;
	private JLabel lblZvanje;
	private JComboBox cbZvanje;
	
	private JButton btnOK;
	private JButton btnCancel;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public DodajProfesora() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/3, d.height/1.5);
		setSize(d);
		
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(MainFrame.getInstance());
		getContentPane().setBackground(Color.WHITE);

		initComponents();
		
		pack();
		
	}
	
	private void initComponents() {
		panelPolja = new JPanel();
		panelDugmad = new JPanel();
		panelPolja.setLayout(new MigLayout(null, "[]50[]", "[]30[]30[]30[]30[]30[]30[]30[]30"));

		panelDugmad.setLayout(new MigLayout());
		
		panelPolja.setBackground(Color.WHITE);
		panelDugmad.setBackground(Color.WHITE);
		
		setLayout(new BorderLayout());
		
		lblPrezime = new JLabel("Prezime*");
		tfPrezime = new JTextField(30);

		lblIme = new JLabel("Ime*");
		tfIme = new JTextField(30);
		
		lblDatRodj = new JLabel("Datum rodjenja*");
		tfDatRodj = new JTextField(30);
		
		lblAdresa = new JLabel("Adresa*");
		tfAdresa = new JTextField(30);
		
		lblEmail = new JLabel("Email*");
		tfEmail = new JTextField(30);
		
		lblBrLK = new JLabel("Broj licne karte*");
		tfBrLK = new JTextField(30);
		
		lblTitula = new JLabel("Titula*");
		cbTitula = new JComboBox<Titula>(Titula.values());
		
		lblZvanje = new JLabel("Zvanje*");
		cbZvanje = new JComboBox<Zvanje>(Zvanje.values());
		
		btnOK = new JButton("Potvrdi");
		btnCancel = new JButton("Odustani");
		
		panelPolja.add(lblPrezime);
		panelPolja.add(tfPrezime,  "wrap");
		panelPolja.add(lblIme);
		panelPolja.add(tfIme, " wrap");
		panelPolja.add(lblDatRodj);
		panelPolja.add(tfDatRodj, " wrap");
		panelPolja.add(lblAdresa);
		panelPolja.add(tfAdresa, "wrap");
		panelPolja.add(lblEmail);
		panelPolja.add(tfEmail, "wrap");
		panelPolja.add(lblBrLK);
		panelPolja.add(tfBrLK, "wrap");
		panelPolja.add(lblTitula);
		panelPolja.add(cbTitula, "wrap");
		panelPolja.add(lblZvanje);
		panelPolja.add(cbZvanje, "wrap");
		panelDugmad.add(btnOK, "cell 0 3, span 2 1, align center, tag ok");
		panelDugmad.add(btnCancel, "cell 0 3, align center, tag cancel");
		
btnCancel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setBackground(Color.LIGHT_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		
btnOK.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnOK.setBackground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOK.setBackground(Color.LIGHT_GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(tfPrezime.getText().trim().isEmpty() || tfIme.getText().trim().isEmpty() || tfDatRodj.getText().trim().isEmpty() || tfAdresa.getText().trim().isEmpty() || tfEmail.getText().trim().isEmpty() || tfBrLK.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Sva polja su obavezna!", "Greška", JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				for(Profesor pr: BazaProfesora.getInstance().getProfesori()) {
					if(tfBrLK.getText().trim().equals(pr.getBrojLicneKarte())) {
						JOptionPane.showMessageDialog(null,"Već postoji profesor sa unesenim brojem lične karte!", "Greška", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				Date datumRodjenja = new Date();
				try {
					datumRodjenja = sdf.parse(tfDatRodj.getText());
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "Datum unesite u formatu (dd/mm/yyyy)", "Greška", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					return;
				}
				
				String titula_str = cbTitula.getSelectedItem().toString();
				Titula titula = Titula.valueOf(titula_str);
				String zvanje_str = cbZvanje.getSelectedItem().toString();
				Zvanje zvanje = Zvanje.valueOf(zvanje_str);
					
				ProfesoriController.getInstance().dodajProfesora(tfPrezime.getText(), tfIme.getText(), datumRodjenja, tfAdresa.getText(), tfEmail.getText(), tfBrLK.getText(), titula, zvanje, new ArrayList<Predmet>());
				
				/*for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
					System.out.println(p.toString());
				}*/
				
				dispose();
				
			}
		});
		
		panelPolja.setBorder(new EmptyBorder(30, 30, 10, 30));
		panelDugmad.setBorder(new EmptyBorder(10, 30, 10, 30));
		add(panelPolja, BorderLayout.NORTH);
		add(panelDugmad, BorderLayout.EAST);
		
		
	}
	
	
}
