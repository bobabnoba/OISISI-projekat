package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Titula;
import model.Zvanje;
import controller.ProfesoriController;

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
	private JComboBox<Titula> cbTitula;
	private JLabel lblZvanje;
	private JComboBox<Zvanje> cbZvanje;
	private JLabel lblAdresaKanc;
	private JTextField tfAdresaKanc;
	private JLabel lblTelefon;
	private JTextField tfTelefon;
	
	private JButton btnOK;
	private JButton btnCancel;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	public DodajProfesora() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/2.2, d.height/1.2);
		setSize(d);
		
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(MainFrame.getInstance());
		getContentPane().setBackground(Color.WHITE);

		initComponents();
		
		pack();
		
	}
	
	
	FocusListener focus = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(!(tfPrezime.getText().trim().isEmpty() || tfIme.getText().trim().isEmpty() || tfDatRodj.getText().trim().isEmpty() || tfAdresa.getText().trim().isEmpty() || tfEmail.getText().trim().isEmpty() || tfBrLK.getText().trim().isEmpty())) {
					btnOK.setEnabled(true);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	
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
		tfPrezime.addFocusListener(focus);

		lblIme = new JLabel("Ime*");
		tfIme = new JTextField(30);
		tfIme.addFocusListener(focus);
		
		lblDatRodj = new JLabel("Datum rođenja*");
		tfDatRodj = new JTextField(30);
		tfDatRodj.addFocusListener(focus);
		
		lblAdresa = new JLabel("Adresa stanovanja*");
		tfAdresa = new JTextField(30);
		tfAdresa.addFocusListener(focus);
		
		lblTelefon = new JLabel("Kontakt telefon*");
		tfTelefon = new JTextField(30);
		tfTelefon.addFocusListener(focus);
		
		lblEmail = new JLabel("Email*");
		tfEmail = new JTextField(30);
		tfEmail.addFocusListener(focus);
		
		lblAdresaKanc = new JLabel("Adresa kancelarije*");
		tfAdresaKanc = new JTextField(30);
		tfAdresaKanc.addFocusListener(focus);
		
		lblBrLK = new JLabel("Broj lične karte*");
		tfBrLK = new JTextField(30);
		tfBrLK.addFocusListener(focus);
		
		lblTitula = new JLabel("Titula*");
		cbTitula = new JComboBox<Titula>(Titula.values());
		
		lblZvanje = new JLabel("Zvanje*");
		cbZvanje = new JComboBox<Zvanje>(Zvanje.values());
		
		btnOK = new JButton("Potvrdi");
		btnOK.setEnabled(false);
		btnCancel = new JButton("Odustani");
		
		panelPolja.add(lblPrezime);
		panelPolja.add(tfPrezime,  "wrap");
		panelPolja.add(lblIme);
		panelPolja.add(tfIme, " wrap");
		panelPolja.add(lblDatRodj);
		panelPolja.add(tfDatRodj, " wrap");
		panelPolja.add(lblAdresa);
		panelPolja.add(tfAdresa, "wrap");
		panelPolja.add(lblTelefon);
		panelPolja.add(tfTelefon, "wrap");
		panelPolja.add(lblEmail);
		panelPolja.add(tfEmail, "wrap");
		panelPolja.add(lblAdresaKanc);
		panelPolja.add(tfAdresaKanc, "wrap");
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
					JOptionPane.showMessageDialog(null, "Datum unesite u formatu (dd.mm.yyyy.)!", "Greška", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					return;
				}
				
				String titula_str = cbTitula.getSelectedItem().toString();
				Titula titula = Titula.valueOf(titula_str);
				String zvanje_str = cbZvanje.getSelectedItem().toString();
				Zvanje zvanje = Zvanje.valueOf(zvanje_str);
					
				ProfesoriController.getInstance().dodajProfesora(tfPrezime.getText(), tfIme.getText(), datumRodjenja, tfAdresa.getText(), tfTelefon.getText(), tfEmail.getText(), tfAdresaKanc.getText(), tfBrLK.getText(), titula, zvanje, new ArrayList<Predmet>());
				
				dispose();
				
			}
		});
		
		panelPolja.setBorder(new EmptyBorder(30, 30, 10, 30));
		panelDugmad.setBorder(new EmptyBorder(10, 30, 10, 30));
		add(panelPolja, BorderLayout.NORTH);
		add(panelDugmad, BorderLayout.EAST);
		
		
	}
	
	
}
