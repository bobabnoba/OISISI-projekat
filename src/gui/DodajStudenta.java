package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	String status = "";
	double prosek; 
	
	
	
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
	    
		FocusList focusListener = new FocusList();
		FocusList focusListener1 = new FocusList();
		
		Dimension dim=new Dimension(150,20);
		Dimension dim2=new Dimension(150,70);
		
		JLabel losUnos = new JLabel("<html> Popunite sva polja <br>"
				+ "Kada se uverite da ste uneli inofrmaciju <br>"
				+ "u dobrom formatu  pritisnite ENTER");
		losUnos.setPreferredSize(new Dimension(150,100));
		panCenter.add(losUnos);
		JLabel losUnos2 = new JLabel("          ");
		losUnos2.setPreferredSize(dim2);
		//panCenter.add(losUnos2 );
		
		JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIme=new JLabel("Ime:");
        lblIme.setPreferredSize(dim);
        JTextField txtIme=new JTextField();
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
        			
					datumRodjenja = "";	
				}
        	}
        });
        
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
				try {
					txtBrojTelefona.getText().matches("[0-9]+");
					losUnos2.setText("    ");

        		}catch (Exception ex) {
        			losUnos2.setText("<html>Lose unet broj telefona!<br>");
        			
        			kontaktTelefon = "";
        		}
				if (!txtBrojTelefona.getText().matches("[0-9]+")) {
					losUnos2.setText("<html>Lose unet broj telefona!<br>");
        			
					kontaktTelefon = "";	
				}
        	}
        });
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
				try {
					txtMail.getText().matches("[a-z0-9]+\\@uns.ns.rs");
					losUnos2.setText("    ");

        		}catch (Exception ex) {
        			losUnos2.setText("<html>Lose unet mail!<br>"
        					+ "Mora se zavrsiti sa <br>"
        					+ "@uns.ns.rs");
        			
        			mailAdresa = "";
        		}
				if (!txtMail.getText().matches("[a-z0-9]+\\@uns.ns.rs")) {
					losUnos2.setText("<html>Lose unet mail!<br>"
							+  "Mora se zavrsiti sa <br>"
							+ "@uns.ns.rs");
        			
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
				try {
					txtGodUpisa.getText().matches("\\d{4}");
					losUnos2.setText("    ");

        		}catch (Exception ex) {
        			losUnos2.setText("<html>Lose uneta godina upisa!<br>"
        					+ " Format je YYYY");
        			
        			godinaUpisa = "";
        		}
				if (!txtGodUpisa.getText().matches("\\d{4}")) {
					losUnos2.setText("<html>Lose uneta godina upisa!<br>"
							+ " Format je YYYY");
        			
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
       
      
		
		JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		
		
		
		JButton btnOk=new JButton("Potvrdi");
		btnOk.setPreferredSize(new Dimension(75,25));
		btnOk.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		
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
        	combo.setSelectedIndex(0);
        	combo2.setSelectedIndex(0);
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