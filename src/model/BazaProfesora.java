package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private DateFormat sdf;

	
	private BazaProfesora() {
		
		sdf = new SimpleDateFormat("dd.MM.yyyy.");

		
		initProf();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Prezime");
		this.kolone.add("Ime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}
	
	public void initProf() {
		this.profesori = new ArrayList<Profesor>();
		ArrayList<Predmet> pred = new ArrayList<Predmet>();
		pred.add(BazaPredmeta.getInstance().getPredmet(2));
		ArrayList<Predmet> pred2 = new ArrayList<Predmet>();
		pred2.add(BazaPredmeta.getInstance().getPredmet(3));
		pred2.add(BazaPredmeta.getInstance().getPredmet(0));
		try {
			this.profesori.add(new Profesor("Mirković", "Mirko", sdf.parse("12.12.1987."), 
					"Puškinova 14, Novi Sad", "mirkom@uns.ac.rs", "45J697E2", Titula.DR, Zvanje.REDOVNI, pred));
			this.profesori.add(new Profesor("Marković", "Marko",sdf.parse("03.07.1974."), 
					"Rumenački put 66, Novi Sad", "markom@uns.ac.rs", "6E43RJ77", Titula.PROF, Zvanje.REDOVNI, pred2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public Profesor getProfesor(String blk) {
		Profesor ret = null;
		for(Profesor p : this.profesori) {
			if (p.getBrojLicneKarte().equals(blk)){
				ret = p;
			} 
			}
		return ret;
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
	
	public void izbrisiProfesora(String id) {
		for(Profesor p : profesori) {
			if(p.getBrojLicneKarte() == id) {
				profesori.remove(p);
				break;
			}
		}
	}
	
	public void izmijeniProfesora(String prezime, String ime, Date datumRodjenja, String adresa, String email, String blk,
			Titula titula, Zvanje zvanje, List<Predmet> predmeti) {
		for(Profesor p : this.profesori) {
			if(p.getBrojLicneKarte().equals(blk)) {
				p.setPrezime(prezime);
				p.setIme(ime);
				p.setDatumRodjenja(datumRodjenja);
				p.setAdresa(adresa);
				p.setEmail(email);
				p.setTitula(titula);
				p.setZvanje(zvanje);
				p.setPredmeti(predmeti);
			}
		}
	}
	
	
	public void dodajPredmetProfesoru(Profesor profesor, String nazivPredmeta) {
		this.getProfesor(profesor.getBrojLicneKarte()).getPredmeti().add(BazaPredmeta.getInstance().findByName(nazivPredmeta));
	}
	
	
	
}
