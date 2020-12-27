package classes;

import java.sql.Date;
import java.util.ArrayList;


enum status { B, S };


public class Student {

	
	
	private String ime;
	private String prezime;
	private String brojIndeksa;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String mailAdresa;
	private String godinaUpisa;
	private int trenutnaGodinaStudija;
	private String status;
	private double prosek; 
	 ArrayList<Ocena> spisakPolozenihIspita = new ArrayList<Ocena>();
	
	
	public Student() {}
	
	
	public Student(String ime, String prezime, String brojIndeksa, String i, String adresaStanovanja, String kontaktTelefon2, String mailAdresa, String j, int trenutnaGodinaStudija, 
		String status, double prosek	) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brojIndeksa = brojIndeksa;
		this.datumRodjenja = i;
		this.adresaStanovanja = adresaStanovanja;
		
		this.kontaktTelefon = kontaktTelefon2;
		this.mailAdresa = mailAdresa;
		this.godinaUpisa = j;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija; 
		this.status = status;
		this.prosek = prosek;
	}
	
	

	/* public void dodajPolozeni(Ocena ocena) {
		if (ocena.getOcena() >= 6) 
			spisakPolozenihIspita.add(1,ocena);
	} */
	
	// GETERI I SETERI
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime ;
	}
	
	public String getPrezime() {
		return prezime;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String i) {
		this.datumRodjenja = i;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon2) {
		this.kontaktTelefon = kontaktTelefon2;
	}

	public String getMailAdresa() {
		return mailAdresa;
	}

	public void setMailAdresa(String mailAdresa) {
		this.mailAdresa = mailAdresa;
	}

	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}

	public String getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(String j) {
		this.godinaUpisa = j;
	}

	public String getStatus() {
		return status;
	}

	public double getProsek() {
		return prosek;
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}
	
	public String getIndeks() {
		return brojIndeksa + "-" + godinaUpisa;
	}
}
