package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gui.MainFrame;

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
					"Puškinova 14, Novi Sad", "0664139899", "mirkom@uns.ac.rs", "NTP", "45J697E2", Titula.DR, Zvanje.REDOVNI, pred));
			/*this.profesori.add(new Profesor("MarkoviÄ‡", "Marko",sdf.parse("03.07.1974."), 
					"RumenaÄ�ki put 66, Novi Sad", "markom@uns.ac.rs", "6E43RJ77", Titula.PROF, Zvanje.REDOVNI, pred2));
		*/} catch (ParseException e) {
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
			return profesor.getPrezime();
		case 1:
			return profesor.getIme();
		case 2:
			return profesor.getTitula().getNaziv();
		case 3: 
			return profesor.getZvanje().getNaziv();
		default: 
			return null;
		}
	}
	public void dodajProfesora(String prezime, String ime, Date datRodj, String adresa, String telefon, String email, String adresaKanc, String blk, Titula titula, Zvanje zvanje, List<Predmet> predmeti) {
		this.profesori.add(new Profesor(prezime, ime, datRodj, adresa, telefon, email, adresaKanc, blk, titula, zvanje, predmeti));
	}
	
	public void izbrisiProfesora(String id) {
		for(Profesor p : profesori) {
			if(p.getBrojLicneKarte() == id) {
				profesori.remove(p);
				break;
			}
		}
	}
	
	public void izmijeniProfesora(String prezime, String ime, Date datRodj, String adresa, String telefon, String email, String adresaKanc, String blk, Titula titula, Zvanje zvanje, List<Predmet> predmeti) {
		for(Profesor p : this.profesori) {
			if(p.getBrojLicneKarte().equals(blk)) {
				p.setPrezime(prezime);
				p.setIme(ime);
				p.setDatumRodjenja(datRodj);
				p.setAdresaStanovanja(adresa);
				p.setTelefon(telefon);
				p.setEmail(email);
				p.setAdresaKancelarije(adresaKanc);
				p.setTitula(titula);
				p.setZvanje(zvanje);
				p.setPredmeti(predmeti);
			}
		}
	}
	
	
	public void dodajPredmetProfesoru(Profesor profesor, String nazivPredmeta) {
		this.getProfesor(profesor.getBrojLicneKarte()).getPredmeti().add(BazaPredmeta.getInstance().findByName(nazivPredmeta));
		BazaPredmeta.getInstance().findByName(nazivPredmeta).setPredmetniProfesor(profesor);
	}
	
	public void ukloniPredmet( Predmet predmet) {
		
		List<Predmet> zaBrisati = new ArrayList<Predmet>();
		
			for(Profesor p : this.profesori) {

				for(Predmet pred : p.getPredmeti()) {
					if(pred.getSifraPredmeta().equals(predmet.getSifraPredmeta())){
						zaBrisati.add(pred);
					}	
				}

				for(Predmet p2 : zaBrisati) {
					p.getPredmeti().remove(p2);
				}
			}
			
	}
	public void serializeProfesor() {
		try {
			FileOutputStream fosProfesor = new FileOutputStream("profesori.ser");
			ObjectOutputStream outProfesor = new ObjectOutputStream(fosProfesor);
			outProfesor.writeObject(BazaProfesora.getInstance().getProfesori());
			
			outProfesor.close();
			fosProfesor.close();
		}catch(IOException exp) {
			exp.printStackTrace();
		}
	}
	
	public void deserijalizacijaProfesora(){
		try{
			System.out.println("\n\n");
			FileInputStream fOUTProfesor = new FileInputStream("profesori.ser");
			ObjectInputStream profesorIn= new ObjectInputStream(fOUTProfesor);
			@SuppressWarnings("unchecked")
			ArrayList<Profesor> profesori = (ArrayList<Profesor>) profesorIn.readObject();
			BazaProfesora.getInstance().setProfesori(profesori);
			MainFrame.getInstance().updateViewProf();
			
			fOUTProfesor.close();
			profesorIn.close();
		}catch(IOException exp) {
			exp.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
}
