package edit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Student;

import view.PolozeniJTable;
import controller.StudentiController;
import gui.MainFrame;
import model.Ocena;
import model.Polozeni;
import model.Predmet;
public class IzmeniStudenta extends JFrame {


	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

	 String ime = "";
		String prezime= "";
		String brojIndeksa= "";
		String datumRodjenja= "";
		String adresaStanovanja= "";
		String kontaktTelefon;
		String mailAdresa;
		String godinaUpisa= "";
		int godUpisa;
		int trenutnaGodinaStudija;
		String status = "";
		double prosek; 
		
		private static PolozeniJTable pol;
		private JTabbedPane tabs;
		private JTextField txtIme;
		private JTextField txtPrezime;
		private JTextField txtMail;
		private JTextField txtBrojTelefona;
		private JTextField txtAdresaStanovanja;
		private JTextField txtGodUpisa;
		private JTextField txtIndeks;
		private JTextField txtDatumRodjenja;
		private Date datumRodjenjaa = new Date();
	
public IzmeniStudenta(Student student) {		
	
	Toolkit tkit = Toolkit.getDefaultToolkit();	
	Dimension screenSize = tkit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setSize(1 * screenWidth / 5, 1 * screenHeight / 5);	
	setLocationRelativeTo(null);
	setPreferredSize(new Dimension(500,600));
	setTitle("Izmena studenta");
	setVisible(true);

	JPanel panCenter=new JPanel();
	BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
	panCenter.setLayout(boxCenter);
    
	JButton btnOk=new JButton("Potvrdi");
	//btnOk.setEnabled(false);
	btnOk.setPreferredSize(new Dimension(75,25));
	
	Dimension dim=new Dimension(220,20);
	Dimension dim2=new Dimension(150,70);
	
	JLabel losUnos = new JLabel("<html> Izmenite podatke o studentu <br>");
	losUnos.setPreferredSize(new Dimension(150,100));
	panCenter.add(losUnos);
	JLabel losUnos2 = new JLabel("          ");
	losUnos2.setPreferredSize(dim2);
	
	btnOk.setEnabled(false);
	
	FocusListener focus = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			if(!(txtIme.getText() == "" || txtPrezime.getText()== "" || mailAdresa == "" || kontaktTelefon == "" || txtAdresaStanovanja.getText().trim().isEmpty() || godinaUpisa == ""
				||	txtIndeks.getText().trim().isEmpty() )) {
				btnOk.setEnabled(true);
			} else {
				btnOk.setEnabled(false);
			}
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	
	JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblIme=new JLabel("Ime:");
    lblIme.setPreferredSize(dim);
    txtIme=new JTextField();
    lblIme.setPreferredSize(dim);
    txtIme.setPreferredSize(dim);
    txtIme.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			ime  = txtIme.getText();
			try {
    			txtIme.getText().matches("[A-Za-z]+");
				losUnos2.setText(" ");

    		}catch (Exception ex) {
    			losUnos2.setText("Pogresno uneto ime!");
    			
    			//ime = "";
    		}
			if (!txtIme.getText().matches("[A-Z a-z]+")) {
				losUnos2.setText("Pogresno uneto ime!");
    			losUnos2.setVisible(true);
    			panCenter.add(losUnos2);
    			ime = "";	
			}
    	}
    });
    	
    
    
    
    
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
    txtPrezime=new JTextField();
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
    txtPrezime.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			prezime  = txtPrezime.getText();
			// TODO Auto-generated method stub
			try {
    			txtIme.getText().matches("[A-Z a-z]+");
				losUnos2.setText(" ");
				
    		}catch (Exception ex) {
    			losUnos2.setText("Pogresno uneto prezime!");
    			
    			prezime = "";
    		}
			if (!txtPrezime.getText().matches("[A-Z a-z]+")) {
				losUnos2.setText("Pogresno uneto prezime!");
    			losUnos2.setVisible(true);
    			panCenter.add(losUnos2);
    			prezime = "";	
			}
    	}
    });
    
    JPanel panDatumRodjenja=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblDatumRodjenja=new JLabel("Datum rodjenja:");
    txtDatumRodjenja=new JTextField();
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
    txtDatumRodjenja.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			btnOk.setEnabled(true);

			datumRodjenja  = txtDatumRodjenja.getText();
			try {
				datumRodjenjaa = sdf.parse(datumRodjenja);
			} catch (ParseException ex) {
				losUnos2.setText("<html>Lose unet datum rodjenja!<br>"
						+ " Format je dd.mm.yyyy.");
				losUnos2.setVisible(true);
    			panCenter.add(losUnos2);
    			btnOk.setEnabled(false);
				datumRodjenja = "";
			}
			
			if (datumRodjenja == "") {
				losUnos2.setText("<html>Lose unet datum rodjenja!<br>"
						+ " Format je dd.mm.yyyy.");
				losUnos2.setVisible(true);
    			panCenter.add(losUnos2);
    			btnOk.setEnabled(false);
				datumRodjenja = "";	
			}
    	}
    });
    
    JPanel panAdresaStanovanja=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblAdresaStanovanja=new JLabel("Adresa stanovanja:");
    lblIme.setPreferredSize(dim);
    txtAdresaStanovanja=new JTextField();
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
    txtBrojTelefona=new JTextField();
    lblBrojTelefona.setPreferredSize(dim);
    txtBrojTelefona.setPreferredSize(dim);
    txtBrojTelefona.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent arg0) {
    		kontaktTelefon =arg0.getActionCommand();  
    		System.out.println(kontaktTelefon);
    	}
    });
    panBrojTelefona.add(lblBrojTelefona);
    panBrojTelefona.add(txtBrojTelefona);
    
    txtBrojTelefona.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			kontaktTelefon  = txtBrojTelefona.getText();
			try {
				txtBrojTelefona.getText().matches("[0-9]+");
				losUnos2.setText("    ");

    		}catch (Exception ex) {
    			losUnos2.setText("<html>Lose unet broj telefona!<br>");
    			losUnos2.setVisible(true);
    			kontaktTelefon = "";
    		}
			if (!txtBrojTelefona.getText().matches("[0-9]+")) {
				losUnos2.setText("<html>Lose unet broj telefona!<br>");
				losUnos2.setVisible(true);
    			panCenter.add(losUnos2);
				kontaktTelefon = "";	
			}
    	}
    });
    JPanel panMail=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblMail=new JLabel("E-mail adresa:");
    lblIme.setPreferredSize(dim);
    txtMail=new JTextField();
    lblMail.setPreferredSize(dim);
    txtMail.setPreferredSize(dim);
    txtMail.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent arg0) {
    		mailAdresa = arg0.getActionCommand();  
    		System.out.println(mailAdresa);
    	}
    });
    txtMail.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			mailAdresa  = txtMail.getText();
			try {
				txtMail.getText().matches("[a-z0-9]+\\@uns.ac.rs");
				losUnos2.setText("    ");

    		}catch (Exception ex) {
    			losUnos2.setText("<html>Lose unet mail!<br>"
    					+ "Mora se zavrsiti sa <br>"
    					+ "@uns.ac.rs");
    			
    			mailAdresa = "";
    		}
			if (!txtMail.getText().matches("[a-z0-9]+\\@uns.ac.rs")) {
				losUnos2.setText("<html>Lose unet mail!<br>"
						+  "Mora se zavrsiti sa <br>"
						+ "@uns.ac.rs");
				losUnos2.setVisible(true);
				btnOk.setEnabled(false);
    			panCenter.add(losUnos2);
				mailAdresa = "";	
			}
    	}
    });
    mailAdresa = txtMail.getText();
    panMail.add(lblMail);
    panMail.add(txtMail);
    
    
    JPanel panIndeks=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblIndeks=new JLabel("Broj indeksa:");
    lblIme.setPreferredSize(dim);
    txtIndeks=new JTextField();
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
    txtGodUpisa=new JTextField();
    txtGodUpisa.setPreferredSize(dim);
  
    txtGodUpisa.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			godinaUpisa  = txtGodUpisa.getText();
		
			if (!txtGodUpisa.getText().matches("\\d{4}")) {
				losUnos2.setVisible(true);
    			panCenter.add(losUnos2);
				godinaUpisa = "";	
			}
			
			
    	}
    });
    godinaUpisa= txtGodUpisa.getText();
    panGodUpisa.add(lblGodUpisa);
    panGodUpisa.add(txtGodUpisa);
    
    JPanel panTrenutnaGod = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblTrenutnaGod= new JLabel("Trenutna godina studija:");
    lblTrenutnaGod.setPreferredSize(dim);
    String[] godine = { " ","I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
	final JComboBox<String> combo = new JComboBox<String>(godine);
	combo.addActionListener(new ActionListener() {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String temp = (String) combo.getSelectedItem();
			if (temp == "I (prva)") {
				trenutnaGodinaStudija = 1 ;
				}else if (temp == "II (druga)") {
					trenutnaGodinaStudija = 2 ;
				}else if (temp == "III (treca)") {
					trenutnaGodinaStudija = 3 ;
				}else if (temp == "IV (cetvrta)") {
					trenutnaGodinaStudija = 4 ;
				} else {
					trenutnaGodinaStudija = 0 ;
				}
			try {
    			if (2021 - (Integer.parseInt(godinaUpisa)  ) <  trenutnaGodinaStudija ){
    				losUnos2.setText("<html>Proverite godinu upisa<br>"
    						+ " i trenutnu godinu studija!"
    						);
    					godinaUpisa = "";
    					txtGodUpisa.setText("");
    					losUnos2.setVisible(true);
            			panCenter.add(losUnos2);
    			}
    			} catch (Exception ex) {
    				godinaUpisa = "";
    			}
		}
		
		
	});
	
	panTrenutnaGod.add(lblTrenutnaGod);
	panTrenutnaGod.add(combo);
	combo.setSelectedIndex(0);
	
	
	JPanel panFinansiranje = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel lblFinansiranje = new JLabel("Nacin finansiranja:");
	lblFinansiranje.setPreferredSize(dim);
	String[] nacini = {" ", "Budzet", "Samofinansiranje" };
	final JComboBox<String> combo2 = new JComboBox<String>(nacini);
	combo2.addActionListener(new ActionListener() {

		
		@Override
		public void actionPerformed(ActionEvent e2) {
			// TODO Auto-generated method stub
			String temp2 = (String) combo2.getSelectedItem();
			if (temp2 == "Samofinansiranje") {
				status = "s";
				}else if (temp2 == "Budzet") {
					status = "b";
				
			
		} else {
			status = "";
		}
		}
		
	});
	panFinansiranje.add(lblFinansiranje); 
	panFinansiranje.add(combo2);
	
	
	
	
	

	
	txtMail.setText(student.getMailAdresa());
	txtIme.setText(student.getIme());
	txtPrezime.setText(student.getPrezime());
	txtDatumRodjenja.setText((sdf.format(student.getDatumRodjenja())));
	txtAdresaStanovanja.setText(student.getAdresaStanovanja());
	txtBrojTelefona.setText(student.getKontaktTelefon());
	status = student.getStatus();
	trenutnaGodinaStudija = student.getTrenutnaGodinaStudija();
	godinaUpisa = student.getGodinaUpisa();
	txtIndeks.setText(student.getBrojIndeksa());
	txtGodUpisa.setText(student.getGodinaUpisa());

	
	if(trenutnaGodinaStudija == 0) {
		combo.setSelectedIndex(0);
	} else if (trenutnaGodinaStudija == 1) {
		combo.setSelectedIndex(1);
	}else if (trenutnaGodinaStudija == 2) {
		combo.setSelectedIndex(2);
	}else if (trenutnaGodinaStudija == 3) {
		combo.setSelectedIndex(3);
	}else if (trenutnaGodinaStudija == 4) {
		combo.setSelectedIndex(4);
	}
	
	
	if (status == "") {
		combo2.setSelectedIndex(0);
	}else if (status == "b") {
		combo2.setSelectedIndex(1);
	}else if (status == "s") {
		combo2.setSelectedIndex(2);
	}
	
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
	
	
	
    txtIme.addFocusListener(focus);
	txtPrezime.addFocusListener(focus);
	txtMail.addFocusListener(focus);
	txtBrojTelefona.addFocusListener(focus);
	txtAdresaStanovanja.addFocusListener(focus);
	txtIndeks.addFocusListener(focus);
	txtGodUpisa.addFocusListener(focus);
	combo.addFocusListener(focus);
	combo2.addFocusListener(focus);
	
	JButton btnCancel=new JButton("Odustani");
	btnCancel.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		}
	});
	
	btnCancel.setPreferredSize(new Dimension(90,25));
	
	JPanel panBottom=new JPanel();
	BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
	panBottom.setLayout(box);	
	panBottom.add(Box.createGlue());
	panBottom.add(btnOk);
	panBottom.add(Box.createHorizontalStrut(10));
	panBottom.add(btnCancel);
	panBottom.add(Box.createHorizontalStrut(10));
	
	
	btnOk.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent arg0) {
			
    		if(txtIme.getText() == ""  | txtPrezime.getText() == "" | txtIndeks.getText().isEmpty() | 
    				txtAdresaStanovanja.getText().isEmpty() | txtBrojTelefona.getText()  == " " | mailAdresa == "" | txtGodUpisa.getText() == "" | trenutnaGodinaStudija == 0 | status == "" ){
    			losUnos.setText("<html>Niste popunili valjano sva polja!<br>");	
    			
    			
    		
    			
    			
    		}else {
    			
    			
				try {
					datumRodjenjaa = sdf.parse(txtDatumRodjenja.getText());
				} catch (ParseException ex1) {
					
					ex1.printStackTrace();
					return;
				}
    			
    	
		
			StudentiController.getInstance().izmeniStudenta(txtIme.getText(),txtPrezime.getText(),txtIndeks.getText(),datumRodjenjaa, 
					txtAdresaStanovanja.getText(), txtBrojTelefona.getText(),txtMail.getText(), godinaUpisa, trenutnaGodinaStudija, status,prosek, new ArrayList<Ocena>(), new ArrayList<Predmet>());
			
			dispose();
    		}
    	}
    });
	
	tabs = new JTabbedPane();
	JPanel izmena = new JPanel();
	JPanel polozeniBot = new JPanel();
	JPanel polozeni = new JPanel();
	polozeni.setLayout(new BoxLayout(polozeni, BoxLayout.Y_AXIS));
	JPanel polozeniTop = new JPanel();
	polozeniTop.setLayout(new BoxLayout(polozeniTop, BoxLayout.X_AXIS));

	polozeniBot.setLayout(new BoxLayout(polozeniBot, BoxLayout.X_AXIS));

	JLabel prosek = new JLabel("Prosek:\t" + String.valueOf(	student.getProsek()));
	polozeniBot.add(Box.createHorizontalGlue());

	polozeniBot.add(prosek);
	JPanel polozeniBot2 = new JPanel();
	polozeniBot2.setLayout(new BoxLayout(polozeniBot2, BoxLayout.X_AXIS));
	JLabel espb = new JLabel("ESPB:\t" + String.valueOf(student.getEspb()));
	polozeniBot2.add(Box.createHorizontalGlue());

	polozeniBot2.add(espb);
	


	JButton ponistiOcenu = new JButton("Ponisti ocenu");
	
	polozeniTop.add(ponistiOcenu);
	polozeniTop.add(Box.createHorizontalGlue());
	izmena.add(panCenter);
	izmena.add(panBottom,BorderLayout.SOUTH);
	JPanel center = new JPanel();
	center.add(showPolozeni(student));
	
	tabs.add("izmena", izmena);
	polozeni.add(polozeniTop);
	polozeni.add(center);
	polozeni.add(polozeniBot);
	polozeni.add(polozeniBot2);
	tabs.add("polozeni", polozeni);
	
	
	pack();

	add(tabs);
	
	
	
	ponistiOcenu.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JFrame frame1 = new JFrame();
			String[] options1 = new String[2];
			options1[0] = new String("Da");
			options1[1] = new String("Ne");
			int n1 = JOptionPane.showOptionDialog(frame1.getContentPane(),"Da li ste sigurni da zelite da ponistite ocenu?","Ponistavanje ocene", 0,JOptionPane.INFORMATION_MESSAGE,null,options1,null);				   
			if(n1 == JOptionPane.YES_OPTION) {
			//student.removePolozeni(Polozeni.getRow(IzmeniStudenta.pol.getSelectedRow()));
			azuriraj(null, -1);
		    espb.setText(("ESPB:\t" + String.valueOf(student.getEspb())));
			polozeniBot2.add(espb);
			prosek.setText(("Prosek:\t" + String.valueOf(	student.getProsek())));
			polozeniBot.add(prosek);
			}
			if(n1 == JOptionPane.NO_OPTION) {
		          return;
		    }

		}
		
	});
}

private JScrollPane showPolozeni(Student student) {
	
	pol = new PolozeniJTable(student);
	JScrollPane pol1 = new JScrollPane(pol);
	pol1.setBorder(new EmptyBorder(20, 20, 20, 20));
	this.azuriraj(null, -1);
	return pol1;
}

public void azuriraj(String akcija, int vrednost) {
	Polozeni model1 = (Polozeni) pol.getModel();
	model1.fireTableDataChanged();
	validate();
	
}

}
	
	