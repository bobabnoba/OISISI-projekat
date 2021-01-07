package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ProfesoriController;
import gui.MainFrame;
import model.Predmet;
import model.Profesor;
import model.Titula;
import model.Zvanje;
import net.miginfocom.swing.MigLayout;

public class IzmjenaProfesora extends JDialog {
	
	private JTabbedPane tabbedPane;
	private ProfPredmetiTable predmetiTable;
	private JPanel panelInfo;
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
	
	private JButton btnOK;
	private JButton btnCancel;
	
	//private ProfesoriTable profesoriTable = new ProfesoriTable();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	
	public IzmjenaProfesora(Profesor profesor) {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/2.2, d.height/1.4);
		setSize(d);
		setTitle("Izmjena profesora");
		
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(MainFrame.getInstance());
		getContentPane().setBackground(Color.WHITE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		createTabbedPane(profesor);
		//initComponents(profesor);
	}
	
	private void createTabbedPane(Profesor profesor) {
		tabbedPane = new JTabbedPane();
		
		JPanel infoTab = showInfo(profesor);
		JPanel predmetiTab = showPredmeti(profesor);
		
		tabbedPane.add("Izmjena", infoTab);
		tabbedPane.add("Predmeti", predmetiTab);
		
		
		tabbedPane.setBorder(new EmptyBorder(10, 0, 10, 0));
		
		this.add(tabbedPane, BorderLayout.CENTER);
	}
	
	public JPanel showInfo(Profesor profesor) {
		return initComponents(profesor);
	}
	
	public JPanel showPredmeti(Profesor profesor) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		//predmetiTable = new ProfPredmetiTable(profesor.getPredmeti());
		//updatePred();
		//ProfPredmetiTable predmetiTable = new ProfPredmetiTable(profesor.getPredmeti());
		JScrollPane predmeti = showPredmetiTable(profesor);
		//predmeti.setBackground(Color.WHITE);
		//predmeti.setBorder(new EmptyBorder(20, 30, 30, 30));
		JPanel buttons = new JPanel();
		JButton btnDodaj = new  JButton("Dodaj predmet");
		JButton btnUkloni = new JButton("Ukloni predmet");
		
		btnDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DodajPredmetProfesoru dpp = new DodajPredmetProfesoru(profesor, predmetiTable);
				dpp.setVisible(true);
			}
		});
		
		btnUkloni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
			}
		});
		
		buttons.add(btnDodaj);
		buttons.add(btnUkloni);
		buttons.setBorder(new EmptyBorder(10, 20, 10, 20));
		buttons.setBackground(Color.WHITE);
		panel.add(buttons, BorderLayout.NORTH);
		panel.add(predmeti, BorderLayout.CENTER);
		return panel;
	}
	public JScrollPane showPredmetiTable(Profesor profesor) {
		predmetiTable = new ProfPredmetiTable(profesor);
		JScrollPane ret = new JScrollPane(predmetiTable);
		updatePred();
		return ret;
	}
	
	public void updatePred() {
		ATMProfPredmeti model = (ATMProfPredmeti) predmetiTable.getModel();
		model.fireTableDataChanged();
		validate();
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
	
	private JPanel initComponents(Profesor p) {
		
		panelPolja = new JPanel();
		panelDugmad = new JPanel();
		panelPolja.setLayout(new MigLayout(null, "[]30[]", "[]20[]20[]20[]20[]20[]20[]20[]20"));

		panelDugmad.setLayout(new MigLayout());
		
		panelPolja.setBackground(Color.WHITE);
		panelDugmad.setBackground(Color.WHITE);
		
		setLayout(new BorderLayout());
		
		lblPrezime = new JLabel("Prezime*");
		tfPrezime = new JTextField(30);
		tfPrezime.setText(p.getPrezime());
		tfPrezime.addFocusListener(focus);

		lblIme = new JLabel("Ime*");
		tfIme = new JTextField(30);
		tfIme.setText(p.getIme());
		tfIme.addFocusListener(focus);
		
		lblDatRodj = new JLabel("Datum rodjenja*");
		tfDatRodj = new JTextField(30);
		tfDatRodj.setText(sdf.format(p.getDatumRodjenja()));
		tfDatRodj.addFocusListener(focus);
		
		lblAdresa = new JLabel("Adresa*");
		tfAdresa = new JTextField(30);
		tfAdresa.setText(p.getAdresa());
		tfAdresa.addFocusListener(focus);
		
		lblEmail = new JLabel("Email*");
		tfEmail = new JTextField(30);
		tfEmail.setText(p.getEmail());
		tfEmail.addFocusListener(focus);
		
		lblBrLK = new JLabel("Broj licne karte*");
		tfBrLK = new JTextField(30);
		tfBrLK.setText(p.getBrojLicneKarte());
		tfBrLK.addFocusListener(focus);
		
		lblTitula = new JLabel("Titula*");
		cbTitula = new JComboBox<Titula>(Titula.values());
		cbTitula.setSelectedItem(p.getTitula());
		
		lblZvanje = new JLabel("Zvanje*");
		cbZvanje = new JComboBox<Zvanje>(Zvanje.values());
		cbZvanje.setSelectedItem(p.getZvanje().getNaziv());
		
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
				
				Date datumRodjenja = new Date();
				try {
					datumRodjenja = sdf.parse(tfDatRodj.getText());
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "Datum unesite u formatu (dd.MM.yyyy.)", "Greška", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					return;
				}
				
				String titula_str = cbTitula.getSelectedItem().toString();
				Titula titula = Titula.valueOf(titula_str);
				String zvanje_str = cbZvanje.getSelectedItem().toString();
				Zvanje zvanje = Zvanje.valueOf(zvanje_str);
					
				ProfesoriController.getInstance().izmijeniProfesora(tfPrezime.getText(), tfIme.getText(), datumRodjenja, tfAdresa.getText(), tfEmail.getText(), tfBrLK.getText(), titula, zvanje, new ArrayList<Predmet>());
				
				dispose();
				
			}
		});
					
			panelInfo = new JPanel();
			panelInfo.setBackground(Color.WHITE);
			
			panelPolja.setBorder(new EmptyBorder(20, 20, 10, 20));
			panelDugmad.setBorder(new EmptyBorder(10, 20, 10, 20));
			panelInfo.add(panelPolja, BorderLayout.NORTH);
			panelInfo.add(panelDugmad, BorderLayout.EAST);
			
			
			return panelInfo;
		
	}
	
}
