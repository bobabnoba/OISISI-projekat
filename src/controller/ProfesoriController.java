package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gui.MainFrame;
import model.BazaProfesora;
import model.Predmet;
import model.Titula;
import model.Zvanje;

public class ProfesoriController {
	
private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}

	private ProfesoriController() {
	}
	
	public void dodajProfesora(String prezime, String ime, Date datRodj, String adresa, String email, String blk, Titula titula, Zvanje zvanje, ArrayList<Predmet> predmeti) {
		List<Predmet> p = (List<Predmet>) predmeti;
		BazaProfesora.getInstance().dodajProfesora(prezime, ime, datRodj, adresa, email, blk, titula, zvanje, p);
		MainFrame.getInstance().updateViewProf();
	}
	
	
}
