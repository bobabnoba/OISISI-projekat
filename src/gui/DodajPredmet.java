package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Profesor;
import controller.PredmetiController;
import model.BazaStudenata;
import model.Semestar;
import model.Student;
import controller.StudentiController;

public class DodajPredmet extends JFrame {
	String sifra = "";
	String naziv = "";
	
	
	String godinaStudija = "";
	String profesor = "";
	int espb;
	String espbString = "";

	
	private JTextField txtEspb;
//	private JTextField txtProfesor;
	private JTextField txtNaziv;
	private JTextField txtSifra;
	
public DodajPredmet() {		
	
	Toolkit tkit = Toolkit.getDefaultToolkit();	
	Dimension screenSize = tkit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setSize(1 * screenWidth / 5, 1 * screenHeight / 5);	
	setLocationRelativeTo(null);
	setPreferredSize(new Dimension(350,600));
	setTitle("Dodavanje predmeta");
	setVisible(true);

	JPanel panCenter=new JPanel();
	BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
	panCenter.setLayout(boxCenter);
    
	JButton btnOk=new JButton("Potvrdi");
	btnOk.setEnabled(false);
	btnOk.setPreferredSize(new Dimension(75,25));
	
	Dimension dim=new Dimension(150,20);
	Dimension dim2=new Dimension(150,70);
	
	JLabel losUnos = new JLabel("<html> Popunite sva polja <br>");
	losUnos.setPreferredSize(new Dimension(150,100));
	panCenter.add(losUnos);
	JLabel losUnos2 = new JLabel("          ");
	losUnos2.setPreferredSize(dim2);
	
	
	
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
	
	//SIFRA------------------------------------------------------------------------------------
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
	
	//NAZIV------------------------------------------------------------------------------------

	JPanel panNaziv=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblNaziv=new JLabel("Naziv predmeta:");
    lblNaziv.setPreferredSize(dim);
    txtNaziv = new JTextField();
	txtNaziv.setPreferredSize(dim);
	
	panNaziv.add(lblNaziv);
	panNaziv.add(txtNaziv);
	
	//TRENUTNA GODINA------------------------------------------------------------------------------------

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
	
	
	//SEMESTAR------------------------------------------------------------------------------------

	JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel lblSemestar= new JLabel("Semestar:");
	lblSemestar.setPreferredSize(dim);
	String[] semestri = { " ","ZIMSKI", "LETNJI"};
	final JComboBox<String> combo2 = new JComboBox<String>(semestri);
	
	panSemestar.add(lblSemestar);
	panSemestar.add(combo2);
	combo2.setSelectedIndex(0);
	
	//ESPB-------------------------------------------------
	
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
	
	
	
	
	
	btnOk.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent arg0) {
    		
    		try {
				 espb = Integer.valueOf(espbString);
			} catch (Exception ex) {
				losUnos2.setText("ESPB mora biti broj!");
				ex.printStackTrace();
				espb = 0;
				return;
			}
    		
    		if(sifra == ""  | txtNaziv.getText().trim().isEmpty()| godinaStudija == "0" | combo2.getSelectedIndex() == 0| espb == 0|
    				 espbString == ""){
    			losUnos.setText("<html>Niste popunili valjano sva polja!<br>");	
    			
    			
    		
    			
    			
    		}else {
    			
    			
    			
    			String semStr = combo2.getSelectedItem().toString();
    			Semestar sem = Semestar.valueOf(semStr);
    			
    			
    			
    	PredmetiController.getInstance().dodajPredmet(sifra, txtNaziv.getText(),sem ,Integer.parseInt(godinaStudija), new model.Profesor(), espb , 
    			new ArrayList<Student>(), new ArrayList<Student>());
    	losUnos.setText("Popunite sva polja");
    	txtSifra.setText("");
    	txtNaziv.setText("");
    	txtEspb.setText("");
    	combo.setSelectedIndex(0);
    	combo2.setSelectedIndex(0);
    	}
    	}
    });
	
	
	
	
	
	
	
	
	
	
	txtSifra.addFocusListener(focus);
	txtEspb.addFocusListener(focus);
	txtNaziv.addFocusListener(focus);
	combo.addFocusListener(focus);
	combo2.addFocusListener(focus);
	
	
	panCenter.add(panSifra);
	panCenter.add(panNaziv);
	panCenter.add(panTrenutnaGod);
	panCenter.add(panSemestar);
	panCenter.add(panEspb);
	add(panCenter, BorderLayout.CENTER);
	
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
	
	
	
	add(panBottom,BorderLayout.SOUTH);
	pack();
	}

	
}
