package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
=======
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
<<<<<<< HEAD
import java.sql.Date;
=======
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
<<<<<<< HEAD
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import classes.BazaStudenata;
import controllers.StudentiController;
import dialog.Dialog;
import listeners.FocusList;

import studenti.view.AbstractTableModelStudenti;
=======
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



import model.BazaStudenata;
import model.Student;
import controller.StudentiController;
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615


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
	String status = "";
	double prosek; 
	
<<<<<<< HEAD
	
=======
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtMail;
	private JTextField txtBrojTelefona;
	private JTextField txtAdresaStanovanja;
	private JTextField txtGodUpisa;
	private JTextField txtIndeks;
	private JTextField txtDatumRodjenja;
	private Date datumRodjenjaa;
	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
	
	public DodajStudenta() {
		super();
		
		Toolkit tkit = Toolkit.getDefaultToolkit();	
		Dimension screenSize = tkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(1 * screenWidth / 5, 1 * screenHeight / 5);	
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(350,600));
		setTitle("Dodavanje Studenta");
		setVisible(true);
	
		JPanel panCenter=new JPanel();
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
	    
<<<<<<< HEAD
		FocusList focusListener = new FocusList();
		FocusList focusListener1 = new FocusList();
=======
		
		
		JButton btnOk=new JButton("Potvrdi");
		btnOk.setEnabled(false);
		btnOk.setPreferredSize(new Dimension(75,25));
		
		
		FocusListener focus = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(!(ime == "" || prezime == "" || mailAdresa == "" || kontaktTelefon == "" || txtAdresaStanovanja.getText().trim().isEmpty() || godinaUpisa == ""
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
		
	
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
		
		Dimension dim=new Dimension(150,20);
		Dimension dim2=new Dimension(150,70);
		
<<<<<<< HEAD
		JLabel losUnos = new JLabel("<html> Popunite sva polja <br>"
				+ "Kada se uverite da ste uneli inofrmaciju <br>"
				+ "u dobrom formatu  pritisnite ENTER");
=======
		JLabel losUnos = new JLabel("<html> Popunite sva polja <br>");
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
		losUnos.setPreferredSize(new Dimension(150,100));
		panCenter.add(losUnos);
		JLabel losUnos2 = new JLabel("          ");
		losUnos2.setPreferredSize(dim2);
		//panCenter.add(losUnos2 );
		
		JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIme=new JLabel("Ime:");
        lblIme.setPreferredSize(dim);
<<<<<<< HEAD
        JTextField txtIme=new JTextField();
        lblIme.setPreferredSize(dim);
        txtIme.setPreferredSize(dim);
=======
        txtIme=new JTextField();
        lblIme.setPreferredSize(dim);
        txtIme.setPreferredSize(dim);
     
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
=======
				ime  = txtIme.getText();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
        JTextField txtPrezime=new JTextField();
=======
        txtPrezime=new JTextField();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
=======
				prezime  = txtPrezime.getText();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
				// TODO Auto-generated method stub
				try {
        			txtIme.getText().matches("[A-Z a-z]+");
					losUnos2.setText(" ");
<<<<<<< HEAD

=======
					
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
        JTextField txtDatumRodjenja=new JTextField();
=======
        txtDatumRodjenja=new JTextField();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
=======
				datumRodjenja  = txtDatumRodjenja.getText();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
				try {
        			txtDatumRodjenja.getText().matches("\\d{4}-\\d{2}-\\d{2}");
					losUnos2.setText("    ");

        		}catch (Exception ex) {
        			losUnos2.setText("<html>Lose unet datum rodjenja!<br>"
        					+ " Format je YYYY-MM-DD");
        			
        			datumRodjenja = "";
        		}
				if (!txtDatumRodjenja.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
					losUnos2.setText("<html>Lose unet datum rodjenja!<br>"
							+ " Format je YYYY-MM-DD");
<<<<<<< HEAD
        			
=======
					losUnos2.setVisible(true);
        			panCenter.add(losUnos2);
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
					datumRodjenja = "";	
				}
        	}
        });
        
        JPanel panAdresaStanovanja=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblAdresaStanovanja=new JLabel("Adresa stanovanja:");
        lblIme.setPreferredSize(dim);
<<<<<<< HEAD
        JTextField txtAdresaStanovanja=new JTextField();
=======
        txtAdresaStanovanja=new JTextField();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
        JTextField txtBrojTelefona=new JTextField();
=======
        txtBrojTelefona=new JTextField();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
=======
				kontaktTelefon  = txtBrojTelefona.getText();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
				try {
					txtBrojTelefona.getText().matches("[0-9]+");
					losUnos2.setText("    ");

        		}catch (Exception ex) {
        			losUnos2.setText("<html>Lose unet broj telefona!<br>");
<<<<<<< HEAD
        			
=======
        			losUnos2.setVisible(true);
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
        			kontaktTelefon = "";
        		}
				if (!txtBrojTelefona.getText().matches("[0-9]+")) {
					losUnos2.setText("<html>Lose unet broj telefona!<br>");
<<<<<<< HEAD
        			
=======
					losUnos2.setVisible(true);
        			panCenter.add(losUnos2);
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
					kontaktTelefon = "";	
				}
        	}
        });
        JPanel panMail=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblMail=new JLabel("E-mail adresa:");
        lblIme.setPreferredSize(dim);
<<<<<<< HEAD
        JTextField txtMail=new JTextField();
=======
        txtMail=new JTextField();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
				try {
					txtMail.getText().matches("[a-z0-9]+\\@uns.ns.rs");
=======
				mailAdresa  = txtMail.getText();
				try {
					txtMail.getText().matches("[a-z0-9]+\\@uns.ac.rs");
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
					losUnos2.setText("    ");

        		}catch (Exception ex) {
        			losUnos2.setText("<html>Lose unet mail!<br>"
        					+ "Mora se zavrsiti sa <br>"
<<<<<<< HEAD
        					+ "@uns.ns.rs");
        			
        			mailAdresa = "";
        		}
				if (!txtMail.getText().matches("[a-z0-9]+\\@uns.ns.rs")) {
					losUnos2.setText("<html>Lose unet mail!<br>"
							+  "Mora se zavrsiti sa <br>"
							+ "@uns.ns.rs");
        			
=======
        					+ "@uns.ac.rs");
        			
        			mailAdresa = "";
        		}
				if (!txtMail.getText().matches("[a-z0-9]+\\@uns.ac.rs")) {
					losUnos2.setText("<html>Lose unet mail!<br>"
							+  "Mora se zavrsiti sa <br>"
							+ "@uns.ac.rs");
					losUnos2.setVisible(true);
        			panCenter.add(losUnos2);
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
        JTextField txtIndeks=new JTextField();
=======
        txtIndeks=new JTextField();
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
        lblIndeks.setPreferredSize(dim);
        txtIndeks.setPreferredSize(dim);
        txtIndeks.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		brojIndeksa = arg0.getActionCommand();  
        		System.out.println(brojIndeksa);
        	}
        });
<<<<<<< HEAD
=======
        
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
        panIndeks.add(lblIndeks);
        panIndeks.add(txtIndeks);
        
        
        JPanel panGodUpisa=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblGodUpisa=new JLabel("Godina upisa:");
        lblGodUpisa.setPreferredSize(dim);
<<<<<<< HEAD
        JTextField txtGodUpisa=new JTextField();
        txtGodUpisa.setPreferredSize(dim);
        txtGodUpisa.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		godinaUpisa = arg0.getActionCommand();  
  
        		System.out.println(godinaUpisa);
        	}
        });
=======
        txtGodUpisa=new JTextField();
        txtGodUpisa.setPreferredSize(dim);
      
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
				try {
					txtGodUpisa.getText().matches("\\d{4}");
					losUnos2.setText("    ");

        		}catch (Exception ex) {
        			losUnos2.setText("<html>Lose uneta godina upisa!<br>"
        					+ " Format je YYYY");
        			
=======
				godinaUpisa  = txtGodUpisa.getText();
				try {
					godinaUpisa.matches("\\d{4}");
					losUnos2.setText("   ");
					losUnos2.setVisible(true);
        			panCenter.add(losUnos2);
					for(Student stud: BazaStudenata.getInstance().getStudenti()) {
    					if((txtIndeks.getText()+ "-" + txtGodUpisa.getText()).equals(stud.getIndeks())) {
    						losUnos2.setText("<html>Vec postoji student <br>"
    								+ "sa ovim indeksom!");
    						brojIndeksa = "";
    						txtIndeks.setText("");
    						txtGodUpisa.setText("");
    						return;
    					}
    					if(Integer.parseInt(txtGodUpisa.getText()) < 1960  |Integer.parseInt(txtGodUpisa.getText()) > 2021) {
    						losUnos2.setText("<html>Fakultet Tehnickih nauka <br>"
    	    						+ " u Novom Sadu osnovan je <br>"
    	    						+ "1960. godine!"
    	    						);
    							
    	    					godinaUpisa = "";
    	    					losUnos2.setVisible(true);
    	            			panCenter.add(losUnos2);
    	            			
    					}
    					
    				}

        		}catch (Exception ex) {
        			losUnos2.setText("<html>Fakultet Tehnickih nauka <br>"
    						+ " u Novom Sadu osnovan je <br>"
    						+ "1960. godine!"
    						);
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
        			godinaUpisa = "";
        		}
				if (!txtGodUpisa.getText().matches("\\d{4}")) {
					losUnos2.setText("<html>Lose uneta godina upisa!<br>"
							+ " Format je YYYY");
<<<<<<< HEAD
        			
					godinaUpisa = "";	
				}
=======
					losUnos2.setVisible(true);
        			panCenter.add(losUnos2);
					godinaUpisa = "";	
				}
				
				
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
<<<<<<< HEAD
				
=======
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
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
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
       
      
<<<<<<< HEAD
		
		JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		
		
		
		JButton btnOk=new JButton("Potvrdi");
		btnOk.setPreferredSize(new Dimension(75,25));
		btnOk.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		if (2021 - (Integer.parseInt(godinaUpisa)  ) <  trenutnaGodinaStudija ){
			losUnos2.setText("<html>Proverite godinu upisa<br>"
					+ " i trenutnu godinu studija!"
					);
				godinaUpisa = "";
				txtGodUpisa.setText(" ");
		}
        		if(ime == ""  | prezime == " " | brojIndeksa == "" | datumRodjenja == "" |
        				 adresaStanovanja == "" | kontaktTelefon  == " " | mailAdresa == "" | godinaUpisa == "" | trenutnaGodinaStudija == 0 | status == "" ){
        			losUnos.setText("<html>Niste popunili valjano sva polja!<br>"
        					+ " Pritisnite ENTER nakon<br>"
        					+ " svakog unosa!");
        			
        			
        		}else {
        	StudentiController.getInstance().dodajStudenta(ime,prezime,brojIndeksa,datumRodjenja, 
    				adresaStanovanja, kontaktTelefon,mailAdresa, godinaUpisa, trenutnaGodinaStudija, status,prosek);
        	losUnos.setText("Popunite sva polja");
        	txtIme.setText(" ");
        	txtPrezime.setText(" ");
        	txtIndeks.setText(" ");
        	txtMail.setText(" ");
        	txtBrojTelefona.setText(" ");
        	txtAdresaStanovanja.setText(" ");
        	txtDatumRodjenja.setText(" ");
        	txtGodUpisa.setText(" ");
=======

		
		
		
		btnOk.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		
        		if(ime == ""  | prezime == "" | txtIndeks.getText().trim().isEmpty() | datumRodjenja == "" |
        				txtAdresaStanovanja.getText().trim().isEmpty() | kontaktTelefon  == " " | mailAdresa == "" | godinaUpisa == "" | trenutnaGodinaStudija == 0 | status == "" ){
        			losUnos.setText("<html>Niste popunili valjano sva polja!<br>");	
        			
        			
        		
        			
        			
        		}else {
        			
        			
    				try {
    					datumRodjenjaa =  sdf.parse(txtDatumRodjenja.getText());
    				} catch (ParseException ex1) {
    					
    					ex1.printStackTrace();
    					return;
    				}
        			
        			
        	
				StudentiController.getInstance().dodajStudenta(ime,prezime,txtIndeks.getText(),datumRodjenjaa, 
						txtAdresaStanovanja.getText(), kontaktTelefon,mailAdresa, godinaUpisa, trenutnaGodinaStudija, status,prosek);
			
        	losUnos.setText("Popunite sva polja");
        	txtIme.setText("");
        	txtPrezime.setText("");
        	txtIndeks.setText("");
        	txtMail.setText("");
        	txtBrojTelefona.setText("");
        	txtAdresaStanovanja.setText("");
        	txtDatumRodjenja.setText("");
        	txtGodUpisa.setText("");
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
        	combo.setSelectedIndex(0);
        	combo2.setSelectedIndex(0);
        	}
        	}
        });
		
<<<<<<< HEAD
		

		
		
		
		
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
=======
		txtIme.addFocusListener(focus);
		txtPrezime.addFocusListener(focus);
		txtMail.addFocusListener(focus);
		txtBrojTelefona.addFocusListener(focus);
		txtAdresaStanovanja.addFocusListener(focus);
		txtIndeks.addFocusListener(focus);
		txtGodUpisa.addFocusListener(focus);
		combo.addFocusListener(focus);
		combo2.addFocusListener(focus);
		
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
		JButton btnCancel=new JButton("Odustani");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		btnCancel.setPreferredSize(new Dimension(90,25));
<<<<<<< HEAD
=======
		
		JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);	
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
		panBottom.add(Box.createGlue());
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		
		
		
		add(panBottom,BorderLayout.SOUTH);
		pack();
		
	}}