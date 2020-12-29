package model;

public enum Titula {

	PROF("Prof. dr"), DR("dr"), MR("mr"), MSC("MSc"), BSc("BSc");

	private String naziv;
	
	Titula(String naziv) {
		this.naziv = naziv;
	}
	
	public String getNaziv() { 
		return naziv;
	}
}
