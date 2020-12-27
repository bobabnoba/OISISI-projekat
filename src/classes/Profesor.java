package classes;

import java.util.Date;
import java.util.List;

public class Profesor {
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresa;
	private String email;
	private String brojLicneKarte;
	private Titula titula;
	private Zvanje zvanje;
	private List<Predmet> predmeti;
	
	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public Profesor(String prezime, String ime, Date datumRodjenja, String adresa, String email, String brojLicneKarte,
			Titula titula, Zvanje zvanje, List<Predmet> predmeti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.email = email;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
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

	@Override
	public String toString() {
		return "Profesor [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja + ", adresa="
				+ adresa + ", email=" + email + ", brojLicneKarte=" + brojLicneKarte + ", titula=" + titula
				+ ", zvanje=" + zvanje + ", predmeti=" + predmeti + "]";
	}
	
	
	
}
