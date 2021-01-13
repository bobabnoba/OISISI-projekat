package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ocena implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Student> studentKojiJePolozio = new ArrayList<Student>();
	
	private int ocena;
	private Date datumPolaganja;
	Student student;
	Predmet predmet;
	
	public Ocena(int ocena, Date datumPolaganja, Student student, Predmet predmet) {
	
		this.ocena = ocena;
		this.datumPolaganja = datumPolaganja;
		this.student = student;
		this.predmet = predmet;
	}
	
	public int getOcena() {
		return ocena;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public Student getStudent() {
		return student;
	}
	
	public Date getDatumPolaganja(){
		return datumPolaganja;
	}

}
