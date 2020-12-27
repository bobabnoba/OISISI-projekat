package classes;

import java.util.ArrayList;
import java.util.List;

public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}



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

	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student("Mika", "Mikic", "ra172", "1999-10-12" , "Petra Drapsina 10", "656448998", "mm@gmail.com", "2018", 3, "s" , 9.2   ));
		studenti.add(new Student("Deki", "Dekic", "ra170", "1989-02-01" , "Petra Drapsina 1", "656448998", "mm@gmail.com", "2018", 2, "b" , 8.42   ));
		studenti.add(new Student("Ristana", "Cukic", "ra12", "1999-02-01"  , "Petra Drapsina 10", "656448998", "mm@gmail.com", "2018", 1, "b" , 7.06   ));
		studenti.add(new Student("Dejana", "Pavlovic", "ra12", "1999-03-1999" , "Petra Drapsina 10", "656448998", "mm@gmail.com", "2018", 1, "s" , 6.06   ));


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
	public void dodajStudenta(String ime, String prezime, String brojIndeksa, String i, String adresaStanovanja,
			String kontaktTelefon, String mailAdresa, String j, int trenutnaGodinaStudija, String status,
			double prosek) {
		this.studenti.add(new Student(ime,prezime, brojIndeksa, i, adresaStanovanja, kontaktTelefon, mailAdresa, j, trenutnaGodinaStudija,status, prosek));
	}

	
	
	

}
