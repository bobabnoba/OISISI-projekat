package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BazaProfesora {
	
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private List<Profesor> profesori;
	private List<String> kolone;
	
	private BazaProfesora() {
		
		initProf();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Prezime");
		this.kolone.add("Ime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}
	
	public void initProf() {
		this.profesori = new ArrayList<Profesor>();
		this.profesori.add(new Profesor("Mirko", "Mirković", Titula.DR, Zvanje.REDOVNI));
		this.profesori.add(new Profesor("Marko", "Marković", Titula.PROF, Zvanje.REDOVNI));
	}
	
	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch(column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getTitula().getNaziv();
		case 3: 
			return profesor.getZvanje().getNaziv();
		default: 
			return null;
		}
	}
	public void dodajProfesora(String prezime, String ime, Date datumRodjenja, String adresa, String email, String blk,
			Titula titula, Zvanje zvanje, List<Predmet> predmeti) {
		this.profesori.add(new Profesor(prezime, ime, datumRodjenja, adresa, email, blk, titula, zvanje, predmeti));
	}
	
}
