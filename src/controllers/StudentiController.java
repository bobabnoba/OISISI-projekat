package controllers;



import classes.BazaStudenata;
import gui.MainFrame;

public class StudentiController {

	private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private StudentiController() {}
	
	public void dodajStudenta(String ime, String prezime, String brojIndeksa, String i, String adresaStanovanja, String kontaktTelefon, String mailAdresa, String j, int trenutnaGodinaStudija, 
			char status, double prosek) {
		// izmena modela
		BazaStudenata.getInstance().dodajStudenta(ime, prezime, brojIndeksa, i , adresaStanovanja, kontaktTelefon, mailAdresa, j, trenutnaGodinaStudija, status, prosek);
		// azuriranje prikaza
		MainFrame.getInstance().azurirajPrikaz("dodat", -1);
	}
	
   
	
	
}

