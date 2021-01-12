package model;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


enum status { B, S };


public class Student {

	
	//private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

	private String ime;
	private String prezime;
	private String brojIndeksa;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String mailAdresa;
	private String godinaUpisa;
	private int trenutnaGodinaStudija;
	private String status;
	private double prosek; 
	ArrayList<Predmet> spisakPolozenihPredmeta = new ArrayList<Predmet>();
    ArrayList<Ocena> spisakPolozenihIspita = new ArrayList<Ocena>();
	ArrayList<Predmet> spisakNepolozenihIspita = new ArrayList<Predmet>();
	
	public Student() {}
	
	
	public Student(String ime, String prezime, String brojIndeksa, Date i, String adresaStanovanja, String kontaktTelefon2, String mailAdresa, String j, int trenutnaGodinaStudija, 
		String status, double prosek, ArrayList<Ocena> polozeni, ArrayList<Predmet> nepolozeni	) {
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
		this.spisakPolozenihIspita = polozeni;
		this.spisakNepolozenihIspita = nepolozeni;
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

	public Date getDatumRodjenja() {
		return (datumRodjenja);
	}
	



	public void setDatumRodjenja(Date i) {
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
		return (godinaUpisa);
	}

	public void setGodinaUpisa(String j) {
		this.godinaUpisa = j;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public double getProsek() {
		double sum = 0;
		for(Ocena o : this.spisakPolozenihIspita) {
			sum += o.getOcena();
		}
		if(String.valueOf(sum/spisakPolozenihIspita.size()) == "NaN") {
			return 0.0;
		}
		return sum/spisakPolozenihIspita.size();
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}
	
	public void dodajPolozeni(Ocena o) {
		this.spisakPolozenihIspita.add(o);
	}
	
	public int getEspb() {
		int sum = 0;
		for(Ocena o : this.spisakPolozenihIspita) {
			sum+=o.getPredmet().getEspb();
		}
		return sum;
	}
	
	public String getIndeks() {
		return brojIndeksa + "-" + godinaUpisa;
	}
	public void removePolozeni(Ocena o) {
		this.spisakPolozenihIspita.remove(o);
	}
	
	
	public ArrayList<Predmet> getSpisakPolozenihPredmeta(){
		for(Ocena o : this.getSpisakPolozenihIspita()) {
			this.spisakPolozenihPredmeta.add(o.getPredmet());
		}
		return this.spisakPolozenihPredmeta;
	}
	
	public ArrayList<Predmet> getSpisakNepolozenihIspita() {
		return spisakNepolozenihIspita;
	}
	public ArrayList<Ocena> getSpisakPolozenihIspita() {
		return spisakPolozenihIspita;
	}
	}
