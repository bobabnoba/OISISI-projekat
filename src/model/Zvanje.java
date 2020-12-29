package model;

public enum Zvanje {
	DOCENT("Docent"), SARADNIK("Saradnik u nastavi"),
	REDOVNI("Redovni profesor"), VANREDNI("Vanredni profesor"),
	ASISTENT("Asistent");
	
	private String naziv;
	
	Zvanje(String naziv) {
		this.naziv = naziv;
	}
	
	public String getNaziv() {
		return naziv;
	}
}
