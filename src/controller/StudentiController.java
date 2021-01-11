package controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import gui.MainFrame;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
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
	
	public void izmeniStudenta(String ime, String prezime, String brojIndeksa, Date i, String adresaStanovanja, String kontaktTelefon, String mailAdresa, String j, int trenutnaGodinaStudija, 
			String status, double prosek, ArrayList<Ocena> polozeni, ArrayList<Predmet> nepolozeni) {
		
		List<Ocena> pol = (List<Ocena>) polozeni;
		List<Predmet> nepol = (List<Predmet>) nepolozeni;
		BazaStudenata.getInstance().izmeniStudenta( ime, prezime, brojIndeksa, i, adresaStanovanja, kontaktTelefon, mailAdresa, j , trenutnaGodinaStudija, status, prosek, pol, nepol );		
		MainFrame.getInstance().azurirajPrikaz(null, -1);
	}
   
	public void izbrisiStudenta(int rowSelectedIndex) {
		if(rowSelectedIndex < 0) {
			return;
		}
		int rows = MainFrame.getInstance().selectedStud();
		Student student = BazaStudenata.getInstance().getRow(rows);
		BazaStudenata.getInstance().izbrisiStudenta(student.getIndeks());
		MainFrame.getInstance().azurirajPrikaz("uklonjen", rowSelectedIndex);
	}
	
	
}

