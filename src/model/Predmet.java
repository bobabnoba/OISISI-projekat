package model;

import java.util.List;

public class Predmet {

	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private String godinaStudija;
	private Profesor predmetniProfesor;
	private int espb;
	private List<Student> polozili;
	private List<Student> nisuPolozili;
	
	public Predmet() {
		// TODO Auto-generated constructor stub
	}

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, String godinaStudija,
			Profesor predmetniProfesor, int espb, List<Student> polozili, List<Student> nisuPolozili) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.espb = espb;
		this.polozili = polozili;
		this.nisuPolozili = nisuPolozili;
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public String getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public List<Student> getPolozili() {
		return polozili;
	}

	public void setPolozili(List<Student> polozili) {
		this.polozili = polozili;
	}

	public List<Student> getNisuPolozili() {
		return nisuPolozili;
	}

	public void setNisuPolozili(List<Student> nisuPolozili) {
		this.nisuPolozili = nisuPolozili;
	}

	@Override
	public String toString() {
		return "Predmet [sifraPredmeta=" + sifraPredmeta + ", nazivPredmeta=" + nazivPredmeta + ", semestar=" + semestar
				+ ", godinaStudija=" + godinaStudija + ", predmetniProfesor=" + predmetniProfesor + ", espb=" + espb
				+ ", polozili=" + polozili + ", nisuPolozili=" + nisuPolozili + "]";
	}
	
}
