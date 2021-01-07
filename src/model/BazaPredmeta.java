package model;

import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {
	
private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	
	private BazaPredmeta() {
		
		initPred();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("�ifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
	}
	
	public void initPred() {
		this.predmeti = new ArrayList<Predmet>();
		this.predmeti.add(new Predmet("E232", "Modelovanje i simulacija sistema", 8, 3, Semestar.ZIMSKI));
		this.predmeti.add(new Predmet("H308", "Industrijska robotika", 8, 3, Semestar.LJETNJI));
		this.predmeti.add(new Predmet("M119", "Energetske transformacije", 5, 2, Semestar.ZIMSKI));
		this.predmeti.add(new Predmet("E104", "Mehanika", 5, 1, Semestar.ZIMSKI));
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public Predmet getPredmet(int index) {
		return predmeti.get(index);
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch(column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return String.valueOf(predmet.getEspb());
		case 3: 
			return String.valueOf(predmet.getGodinaStudija());
		case 4: 
			return predmet.getSemestar().getNaziv();
		default: 
			return null;
		}
	}
	
	public void dodajPredmet(String sifra, String naziv, Semestar semestar, int godStud, Profesor predProf, int espb, List<Student> pol, List<Student> nisuPol) {
		this.predmeti.add(new Predmet(sifra, naziv, semestar, godStud, predProf, espb, pol, nisuPol));
	}
	
	public void ukloniPredmetIzTabele(Predmet predmet) {
				predmeti.remove(predmet);
	}
	
	public Predmet findByName(String name) {
		Predmet retVal = null;
		for(Predmet p : this.predmeti) {
			if(p.getNazivPredmeta().equals(name)){
				retVal = p;
			}
		}
		return retVal;	
	}

}
