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
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.PredmetiController;
import controller.StudentiController;
import gui.MainFrame;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import view.ProfesoriTable;

public class IzmenaPredmeta extends JFrame{

	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

	String naziv;
	String sifra;
	String godinaStudija;
	String espbString;
	int espb;
	
	private JTextField txtEspb;
	private JTextField txtNaziv;
	private JTextField txtSifra;
	
	
	
	public IzmenaPredmeta(Predmet predmet) {
		
		Toolkit tkit = Toolkit.getDefaultToolkit();	
		Dimension screenSize = tkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(1 * screenWidth / 4, 1 * screenHeight / 2);	
		setLocationRelativeTo(null);
		//setPreferredSize(new Dimension(52222200,6222200));
		setTitle("Izmena studenta");
		setVisible(true);
		
		
		JPanel panCenter = new JPanel();
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		
		JButton btnOk=new JButton("Potvrdi");
		//btnOk.setEnabled(false);
		btnOk.setPreferredSize(new Dimension(75,25));
		
		Dimension dim=new Dimension(220,20);
		Dimension dim2=new Dimension(150,70);
		
		JLabel losUnos = new JLabel("<html> Izmenite podatke o predmetu <br>");
		losUnos.setPreferredSize(new Dimension(150,100));
		panCenter.add(losUnos);
		JLabel losUnos2 = new JLabel("          ");
		losUnos2.setPreferredSize(dim2);
		
		//btnOk.setEnabled(false);
		
	    
		
		FocusListener focus = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(!(sifra == "" || txtNaziv.getText().trim().isEmpty() || espbString == "" )) {
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
		
		JPanel panSifra=new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lblSifra=new JLabel("Sifra predmeta:");
	    lblSifra.setPreferredSize(dim);
	    txtSifra = new JTextField();
		txtSifra.setPreferredSize(dim);
		txtSifra.addKeyListener(new KeyListener() {

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
				sifra = txtSifra.getText();
				try {
	    			txtSifra.getText().matches("[A-Za-z0-9]+");
					losUnos2.setText(" ");

	    		}catch (Exception ex) {
	    			losUnos2.setText("Pogresno uneta sifra");
	    			sifra = "";	
	    		}
				if (!txtSifra.getText().matches("[A-Za-z0-9]+")) {
					losUnos2.setText("Pogresno uneta sifra!");
	    			losUnos2.setVisible(true);
	    			panCenter.add(losUnos2);
	    			sifra = "";	
				}
	    	}
	    });
		
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		
		
		JPanel panNaziv=new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lblNaziv=new JLabel("Naziv predmeta:");
	    lblNaziv.setPreferredSize(dim);
	    txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dim);
		
		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);
		
		
		JPanel panTrenutnaGod = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lblTrenutnaGod= new JLabel("Godina studija:");
	    lblTrenutnaGod.setPreferredSize(dim);
	    String[] godine = { " ","I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
		final JComboBox<String> combo = new JComboBox<String>(godine);
		combo.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String temp = (String) combo.getSelectedItem();
				if (temp == "I (prva)") {
					godinaStudija = "1" ;
					}else if (temp == "II (druga)") {
						godinaStudija = "2" ;
					}else if (temp == "III (treca)") {
						godinaStudija = "3" ;
					}else if (temp == "IV (cetvrta)") {
						godinaStudija = "4" ;
					} else {
						godinaStudija = "0" ;
					}
			}
					
		});	
		panTrenutnaGod.add(lblTrenutnaGod);
		panTrenutnaGod.add(combo);
		combo.setSelectedIndex(0);
		
		
		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSemestar= new JLabel("Semestar:");
		lblSemestar.setPreferredSize(dim);
		String[] semestri = { " ","ZIMSKI", "LJETNJI"};
		final JComboBox<String> combo2 = new JComboBox<String>(semestri);
		
		panSemestar.add(lblSemestar);
		panSemestar.add(combo2);
		combo2.setSelectedIndex(0);
		
		
		
		JPanel panEspb=new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel lblEspb=new JLabel("ESPB:");
	    lblEspb.setPreferredSize(dim);
	    txtEspb = new JTextField();
		txtEspb.setPreferredSize(dim);
		txtEspb.addKeyListener(new KeyListener() {

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
				espbString  = txtEspb.getText();

				try {
					txtEspb.getText().matches("[0-9]+");
					losUnos2.setText("    ");
					
					espbString  = txtEspb.getText();

	    		}catch (Exception ex) {
					losUnos2.setText("<html>Lose unet broj ESPB poena!<br>");
	    			losUnos2.setVisible(true);
	    			espbString = "";
	    			espb = 0;
	    		}
				if (!txtEspb.getText().matches("[0-9]+")) {
					losUnos2.setText("<html>Lose unet broj ESPB poena!<br>");
					losUnos2.setVisible(true);
	    			panCenter.add(losUnos2);
	    			espbString = "";	
	    			espb = 0;
				}
	    	}


	    });
		panEspb.add(lblEspb);
		panEspb.add(txtEspb);
		
		
		
		txtSifra.setText(predmet.getSifraPredmeta());
		txtNaziv.setText(predmet.getNazivPredmeta());
		txtEspb.setText(String.valueOf(predmet.getEspb()));
		
		txtSifra.addFocusListener(focus);
		txtNaziv.addFocusListener(focus);
		txtEspb.addFocusListener(focus);
		combo.addFocusListener(focus);
		combo2.addFocusListener(focus);
		
		if(predmet.getGodinaStudija() == 0) {
			combo.setSelectedIndex(0);
			btnOk.setEnabled(false);
		} else if (predmet.getGodinaStudija() == 1) {
			combo.setSelectedIndex(1);
		}else if (predmet.getGodinaStudija() == 2) {
			combo.setSelectedIndex(2);
		}else if (predmet.getGodinaStudija() == 3) {
			combo.setSelectedIndex(3);
		}else if (predmet.getGodinaStudija() == 4) {
			combo.setSelectedIndex(4);
		}
		
		if(predmet.getSemestar() == Semestar.ZIMSKI) {
			combo2.setSelectedIndex(1);
		}else if (predmet.getSemestar() == Semestar.LETNJI) {
			combo2.setSelectedIndex(2);
		}
		
		
		
		JButton btnCancel=new JButton("Odustani");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		btnCancel.setPreferredSize(new Dimension(90,25));
		
		
		
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtSifra.getText() == ""  | txtNaziv.getText() == "" | txtEspb.getText() == "") {
					losUnos.setText("Niste popunili valjano sva polja!");
				}else {
					
					String semStr = combo2.getSelectedItem().toString();
	    			Semestar sem = Semestar.valueOf(semStr);
					PredmetiController.getInstance().izmeniPredmet(txtSifra.getText(), txtNaziv.getText(), Integer.valueOf(txtEspb.getText()), Integer.valueOf(godinaStudija), sem);
					dispose();
				}
					
			}
			
		});
		
		JPanel panProf = new JPanel();
		JPanel panProfBot = new JPanel();
		JLabel labProf = new JLabel("Profesor:\t ");
		if(predmet.getProfesor() == null) {
			labProf.setText("Profesor: ");
		} else {
		labProf.setText("Profesor: " + predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime());
		}
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		panProf.add(labProf);
		panProfBot.add(plus, BorderLayout.LINE_END);
		panProfBot.add(minus);
		
		
		if(labProf.getText() == "Profesor: ") {
			minus.setEnabled(false);
		} else {
			minus.setEnabled(true);
		}
		
		if(!(labProf.getText() == "Profesor: ")) {
			plus.setEnabled(false);
		}else {
			plus.setEnabled(true);
		}
		
		JDialog diag = new JDialog();
		JPanel bot = new JPanel();
		diag.setSize(500,500);
		JPanel panel = new JPanel();
		diag.add(panel);
		diag.add(bot, BorderLayout.SOUTH);
		
		JButton ok = new JButton("Potvrdi");
		JButton cancel = new JButton("Odustani");
		bot.add(ok);
		bot.add(cancel);
		
		
		diag.setLocationRelativeTo(MainFrame.getInstance());
		
		MainFrame.getInstance();				
		ProfesoriTable profT = new ProfesoriTable();
		JScrollPane prof = new JScrollPane(profT);
		panel.add(prof);
		
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub				
				
				diag.setVisible(true);			
			}
			
		});
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				diag.dispose();
			}
			
		});
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = profT.convertRowIndexToModel(profT.getSelectedRow());
				Profesor profesor = BazaProfesora.getInstance().getRow(row);
				predmet.setPredmetniProfesor(profesor);
				profesor.getPredmeti().add(predmet);
				labProf.setText("Profesor: " + profesor.getIme() + " " + profesor.getPrezime());
				labProf.setVisible(true);
				plus.setEnabled(false);
				minus.setEnabled(true);
				diag.dispose();
			}
			
		});
		
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labProf.setText("");
				labProf.setVisible(false);
				predmet.setPredmetniProfesor(null);
				plus.setEnabled(true);
				minus.setEnabled(false);
			}
		});
		
		
		

		
		JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);	
		panBottom.add(Box.createGlue());
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		
		
		panCenter.add(panSifra);
		panCenter.add(panNaziv);
		panCenter.add(panTrenutnaGod);
		panCenter.add(panSemestar);
		panCenter.add(panEspb);
	    panCenter.add(Box.createVerticalStrut(25));
	    panCenter.add(panProf);
	    panCenter.add(panProfBot);
	    panCenter.add(panBottom);
		
		
		
		this.add(panCenter);
	}
}
