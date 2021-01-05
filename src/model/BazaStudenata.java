package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BazaStudenata {
	
	
	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance()  {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

	private Date d1;
	private Date d2;
	private Date d3;
	private Date d4;
	
	
	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudenata() {
	
		
		
		
		
	
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");

	}

	private void initStudente()  {
		
		try {
			 d1 = sdf.parse("1999-12-03");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d2 = sdf.parse("1989-02-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d3 = sdf.parse("1999-02-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d4 = sdf.parse("2000-03-10");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.studenti = new ArrayList<Student>();
		
		studenti.add(new Student("Mika", "Mikic", "ra172",d1 , "Petra Drapsina 10", "656448998", "mm@uns.ac.rs.com", "2018", 3, "s" , 9.2, new ArrayList<Ocena>()   ));
		studenti.add(new Student("Deki", "Dekic", "ra170", d2 , "Petra Drapsina 1", "656448900", "mm32@uns.ac.rs.com", "2018", 2, "b" , 8.42  ,new ArrayList<Ocena>()  ));
		studenti.add(new Student("Ristana", "Cukic", "ra12", d3  , "Petra Drapsina 10", "656448118", "xnm3@uns.ac.rs.com", "2018", 1, "b" , 7.06 ,new ArrayList<Ocena>()   ));
		studenti.add(new Student("Dejana", "Pavlovic", "ra12", d4 , "Petra Drapsina 10", "656448268", "m2n@uns.ac.rs.com", "2017", 1, "s" , 6.06 ,new ArrayList<Ocena>()   ));
		studenti.add(new Student("Mario", "Jocic", "ra173",d1 , "Potok ", "656448998", "makijatom@uns.ac.rs", "2018", 3, "s" , 6.02, new ArrayList<Ocena>()   ));


	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setIgraci(List<Student> studenti) {
		this.studenti = studenti;
	}

	

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getIndeks();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return String.valueOf(student.getTrenutnaGodinaStudija());
		case 4:
			return student.getStatus();
		case 5:
			return String.valueOf(student.getProsek());
		default:
			return null;
		}
	}
	public void dodajStudenta(String ime, String prezime, String brojIndeksa, Date i, String adresaStanovanja,
			String kontaktTelefon, String mailAdresa, String j, int trenutnaGodinaStudija, String status,
			double prosek) {
		this.studenti.add(new Student(ime,prezime, brojIndeksa, i, adresaStanovanja, kontaktTelefon, mailAdresa, j, trenutnaGodinaStudija,status, prosek, new ArrayList<Ocena>()));
	}
	
	public void izmeniStudenta(String id, String ime, String prezime, String brojIndeksa, Date i, String adresaStanovanja,
			String kontaktTelefon, String mailAdresa, String j, int trenutnaGodinaStudija, String status,
			double prosek) {
		for(Student st : studenti) {
			if(st.getBrojIndeksa() == id) {
				st.setIme(ime);
				st.setPrezime(prezime);
				st.setBrojIndeksa(brojIndeksa);
				st.setDatumRodjenja(i);
				st.setAdresaStanovanja(adresaStanovanja);
				st.setKontaktTelefon(kontaktTelefon);
				st.setMailAdresa(mailAdresa);
				st.setGodinaUpisa(j);
				st.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
				st.setStatus(status);
			}
		}
	}
	
	public void izbrisiStudenta(String id) {
		for(Student s : studenti) {
			if(s.getBrojIndeksa() == id) {
				studenti.remove(s);
				break;
			}
		}
	}

	
	
	

}
