package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Ocena {

	private List<Student> studentKojiJePolozio = new ArrayList<Student>();
	
	private int ocena;
	private Date datumPolaganja;
	
	
	public Ocena(Student studentKojiJePolozio, int ocena, Date datumPolaganja) {
	
		this.ocena = ocena;
		this.datumPolaganja = datumPolaganja;
	}
	
	public int getOcena() {
		return ocena;
	}
	
	public void addStudentKojiJePolozio() {};
	
	

}
