package model;

import java.io.Serializable;
import java.util.List;

public class Predmet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaStudija;
	private Profesor predmetniProfesor;
	private int espb;
	private List<Student> polozili;
	private List<Student> nisuPolozili;
	
	public Predmet() {
		// TODO Auto-generated constructor stub
	}

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,
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
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, int espb,  int godinaStudija, Semestar semestar) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.espb = espb;
		this.godinaStudija = godinaStudija;
		this.semestar = semestar;
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

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
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

	public Profesor getProfesor() {
		return predmetniProfesor;
	}
	@Override
	public String toString() {
		return "Predmet [sifraPredmeta=" + sifraPredmeta + ", nazivPredmeta=" + nazivPredmeta + ", semestar=" + semestar
				+ ", godinaStudija=" + godinaStudija + ", predmetniProfesor=" + predmetniProfesor + ", espb=" + espb
				+ ", polozili=" + polozili + ", nisuPolozili=" + nisuPolozili + "]";
	}
	
}
