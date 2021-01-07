package controller;



import java.util.Date;

import javax.swing.JOptionPane;

import gui.MainFrame;
import model.BazaStudenata;
import model.Student;

public class StudentiController {

	private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private StudentiController() {}
	
	public void dodajStudenta(String ime, String prezime, String brojIndeksa, Date i, String adresaStanovanja, String kontaktTelefon, String mailAdresa, String j, int trenutnaGodinaStudija, 
			String status, double prosek) {
		// izmena modela
		BazaStudenata.getInstance().dodajStudenta(ime, prezime, brojIndeksa, i , adresaStanovanja, kontaktTelefon, mailAdresa, j, trenutnaGodinaStudija, status, prosek);
		// azuriranje prikaza
		MainFrame.getInstance().azurirajPrikaz("dodat", -1);
	}
	
	public void izmeniStudenta(int rowSelectedIndex,String ime, String prezime, String brojIndeksa, Date i, String adresaStanovanja, String kontaktTelefon, String mailAdresa, String j, int trenutnaGodinaStudija, 
			String status, double prosek) {
		if(rowSelectedIndex<0) {
			JOptionPane.showMessageDialog(null,"Izaberite studenta!", "Greska", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izmeniStudenta(student.getBrojIndeksa(),  ime, prezime, brojIndeksa, i, adresaStanovanja, kontaktTelefon, mailAdresa, j , trenutnaGodinaStudija,
				status, prosek);
		
		MainFrame.getInstance().azurirajPrikaz(null, -1);
	}
   
	public void izbrisiStudenta(int rowSelectedIndex) {
		if(rowSelectedIndex < 0) {
			return;
		}
		Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izbrisiStudenta(student.getBrojIndeksa());
		MainFrame.getInstance().azurirajPrikaz("uklonjen", rowSelectedIndex);
	}
	
	
}

