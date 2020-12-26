package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import classes.BazaStudenata;
import controllers.StudentiController;
import dialog.Dialog;
import listeners.FocusList;

import studenti.view.AbstractTableModelStudenti;


public class DodajStudenta extends JFrame{
	// TXT.GETtEXT()
	
	 String ime = "";
	String prezime= "";
	String brojIndeksa= "";
	String datumRodjenja= "";
	String adresaStanovanja= "";
	String kontaktTelefon= "";
	String mailAdresa= "";
	String godinaUpisa= "";
	int godUpisa;
	int trenutnaGodinaStudija;
	char status;
	double prosek; 
	
	
	
	public DodajStudenta() {
		super();
		
		Toolkit tkit = Toolkit.getDefaultToolkit();	
		Dimension screenSize = tkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(1 * screenWidth / 5, 1 * screenHeight / 5);	
		setLocationRelativeTo(null);
		
		setTitle("Dodavanje Studenta");
		setVisible(true);
	
		JPanel panCenter=new JPanel();
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
	    
		FocusList focusListener = new FocusList();
		FocusList focusListener1 = new FocusList();
		
		Dimension dim=new Dimension(150,20);

		
		JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIme=new JLabel("Ime:");
        lblIme.setPreferredSize(dim);
        JTextField txtIme=new JTextField();
        lblIme.setPreferredSize(dim);
        txtIme.setPreferredSize(dim);
        
        txtIme.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		ime = arg0.getActionCommand();  
        		System.out.println(ime);
        	}
        });
        panIme.add(lblIme);
        panIme.add(txtIme); 


        JPanel panPrezime=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblPrezime=new JLabel("Prezime:");
        lblIme.setPreferredSize(dim);
        JTextField txtPrezime=new JTextField();
        lblPrezime.setPreferredSize(dim);
        txtPrezime.setPreferredSize(dim);       
        txtPrezime.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		prezime = arg0.getActionCommand();  
        		System.out.println(prezime);
        	}
        });
        panPrezime.add(lblPrezime);
        panPrezime.add(txtPrezime);
        
        
        JPanel panDatumRodjenja=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblDatumRodjenja=new JLabel("Datum rodjenja:");
        JTextField txtDatumRodjenja=new JTextField();
        lblDatumRodjenja.setPreferredSize(dim);
        txtDatumRodjenja.setPreferredSize(dim);
        txtDatumRodjenja.setPreferredSize(dim);
        txtDatumRodjenja.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		datumRodjenja = arg0.getActionCommand();  
        		System.out.println(datumRodjenja);
        	}
        });
        panDatumRodjenja.add(lblDatumRodjenja);
        panDatumRodjenja.add(txtDatumRodjenja);
        
        
        JPanel panAdresaStanovanja=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblAdresaStanovanja=new JLabel("Adresa stanovanja:");
        lblIme.setPreferredSize(dim);
        JTextField txtAdresaStanovanja=new JTextField();
        lblAdresaStanovanja.setPreferredSize(dim);
        txtAdresaStanovanja.setPreferredSize(dim);
        txtAdresaStanovanja.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		adresaStanovanja = arg0.getActionCommand();  
        		System.out.println(adresaStanovanja);
        	}
        });
        panAdresaStanovanja.add(lblAdresaStanovanja);
        panAdresaStanovanja.add(txtAdresaStanovanja);
        
        
        JPanel panBrojTelefona=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblBrojTelefona=new JLabel("Broj telefona:");
        lblIme.setPreferredSize(dim);
        JTextField txtBrojTelefona=new JTextField();
        lblBrojTelefona.setPreferredSize(dim);
        txtBrojTelefona.setPreferredSize(dim);
        txtDatumRodjenja.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		kontaktTelefon =arg0.getActionCommand();  
        		System.out.println(kontaktTelefon);
        	}
        });
        panBrojTelefona.add(lblBrojTelefona);
        panBrojTelefona.add(txtBrojTelefona);
        
        
        JPanel panMail=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblMail=new JLabel("E-mail adresa:");
        lblIme.setPreferredSize(dim);
        JTextField txtMail=new JTextField();
        lblMail.setPreferredSize(dim);
        txtMail.setPreferredSize(dim);
        txtMail.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		mailAdresa = arg0.getActionCommand();  
        		System.out.println(mailAdresa);
        	}
        });
        mailAdresa = txtMail.getText();
        panMail.add(lblMail);
        panMail.add(txtMail);
        
        
        JPanel panIndeks=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIndeks=new JLabel("Broj indeksa:");
        lblIme.setPreferredSize(dim);
        JTextField txtIndeks=new JTextField();
        lblIndeks.setPreferredSize(dim);
        txtIndeks.setPreferredSize(dim);
        txtIndeks.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		brojIndeksa = arg0.getActionCommand();  
        		System.out.println(brojIndeksa);
        	}
        });
        panIndeks.add(lblIndeks);
        panIndeks.add(txtIndeks);
        
        
        JPanel panGodUpisa=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblGodUpisa=new JLabel("Godina upisa:");
        lblGodUpisa.setPreferredSize(dim);
        JTextField txtGodUpisa=new JTextField();
        txtGodUpisa.setPreferredSize(dim);
        txtGodUpisa.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		godinaUpisa = arg0.getActionCommand();  
  
        		System.out.println(godinaUpisa);
        	}
        });
        godinaUpisa= txtGodUpisa.getText();
        panGodUpisa.add(lblGodUpisa);
        panGodUpisa.add(txtGodUpisa);
        
        JPanel panTrenutnaGod = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTrenutnaGod= new JLabel("Trenutna godina studija:");
        lblTrenutnaGod.setPreferredSize(dim);
        String[] godine = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
		final JComboBox<String> combo = new JComboBox<String>(godine);
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		panTrenutnaGod.add(lblTrenutnaGod);
		panTrenutnaGod.add(combo);
		combo.setSelectedIndex(0);
		
		
		JPanel panFinansiranje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblFinansiranje = new JLabel("Nacin finansiranja:");
		lblFinansiranje.setPreferredSize(dim);
		String[] nacini = {"Budzet", "Samofinansiranje" };
		final JComboBox<String> combo2 = new JComboBox<String>(nacini);
		panFinansiranje.add(lblFinansiranje);
		panFinansiranje.add(combo2);
		combo.setSelectedIndex(0);
        
        
        panCenter.add(panIme);
        panCenter.add(panPrezime);
        panCenter.add(panDatumRodjenja);
        panCenter.add(panAdresaStanovanja);
        panCenter.add(panBrojTelefona);
        panCenter.add(panMail);
        panCenter.add(panIndeks);
        panCenter.add(panGodUpisa);
        panCenter.add(panTrenutnaGod);
        panCenter.add(panFinansiranje);
        panCenter.add(Box.createVerticalStrut(25));  
        add(panCenter,BorderLayout.CENTER);
       
      
		
		JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		
		JLabel losUnos = new JLabel("");
		panCenter.add(losUnos);
		
		
		JButton btnOk=new JButton("Potvrdi");
		btnOk.setPreferredSize(new Dimension(75,25));
		btnOk.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		try {
        			int a = Integer.valueOf(godinaUpisa);
        		}catch (Exception e) {
        			losUnos.setText("Pogresno uneta godina upisa!");
        			losUnos.setVisible(true);
        			panCenter.add(losUnos);
        			godinaUpisa = "";
        		}
        		if(ime == ""  | prezime == " " | brojIndeksa == "" | datumRodjenja == "" |
        				 adresaStanovanja == "" | kontaktTelefon  == " " | mailAdresa == "" | godinaUpisa == ""){
        			losUnos.setText("Popunite sva polja!");
        			losUnos.setVisible(true);
        			panCenter.add(losUnos);
        			
        		}else {
        	StudentiController.getInstance().dodajStudenta(ime,prezime,brojIndeksa,datumRodjenja, 
    				adresaStanovanja, kontaktTelefon,mailAdresa, godinaUpisa, trenutnaGodinaStudija, status,prosek);
        		
        	}
        	}
        });
		
		
		
		
		
		/* String ime;
			String prezime;
			String brojIndeksa;
			String datumRodjenja;
			String adresaStanovanja;
			String kontaktTelefon;
			String mailAdresa;
			String godinaUpisa;
			int trenutnaGodinaStudija;
			char status;
			double prosek; 
			
		*/
		JButton btnCancel=new JButton("Odustani");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		btnCancel.setPreferredSize(new Dimension(90,25));
		panBottom.add(Box.createGlue());
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		
		
		
		add(panBottom,BorderLayout.SOUTH);
		pack();
		
	}}