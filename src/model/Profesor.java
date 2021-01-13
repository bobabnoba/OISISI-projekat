package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profesor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private Titula titula;
	private Zvanje zvanje;
	private List<Predmet> predmeti;
	
	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public Profesor(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje,
			List<Predmet> predmeti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = predmeti;
	}

	public Profesor(String prezime, String ime, Titula titula, Zvanje zvanje) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.titula = titula;
		this.zvanje = zvanje;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public Titula getTitula() {
		return titula;
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public List<String> getSifrePred(){
		List<String> sifre = new ArrayList<String>();
		for(Predmet p : this.predmeti) {
			sifre.add(p.getSifraPredmeta());
		}
		return sifre;
	}

	@Override
	public String toString() {
		return "Profesor [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", telefon=" + telefon + ", email=" + email
				+ ", adresaKancelarije=" + adresaKancelarije + ", brojLicneKarte=" + brojLicneKarte + ", titula="
				+ titula + ", zvanje=" + zvanje + ", predmeti=" + predmeti + "]";
	}
	
	
}
