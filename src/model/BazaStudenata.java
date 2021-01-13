package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.MainFrame;

public class BazaStudenata {
	
	
	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance()  {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private DateFormat sdf;
	private Date d1;
	private Date d2;
	private Date d3;
	private Date d4;
	private Date d5;
	private Date d6;
	private Date d7;
	private Date d8;
	private Date d9;
	private Date d10;
	private Date d11;
	private Date d12;
	private Date d13;
	private Date d14;
	private Date d15;
	private Date d16;
	private Date d17;
	private Date d18;
	private Date d19;
	private Date d20;
	private Date d21;
	private Date d22;
	private Date d23;
	private Date d24;
	private Date d25;
	private Date d26;
	private Date d27;
	
	
	
	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudenata() {
	
		sdf = new SimpleDateFormat("dd.MM.yyyy.");
		
		
		
	
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
		
		
		
		this.studenti = new ArrayList<Student>();
		
	
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

	
	public Student getStudent(int index) {
		return studenti.get(index);
	}
	
	
	public Student getStudentByIndeks(String indeks) {
		Student st = null;
		for(Student s : this.studenti) {
			if(s.getIndeks().equals(indeks)) {
				st = s;
			}
		}
		return st;
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
		this.studenti.add(new Student(ime,prezime, brojIndeksa, i, adresaStanovanja, kontaktTelefon, mailAdresa, j, trenutnaGodinaStudija,status, prosek, new ArrayList<Ocena>(), new ArrayList<Predmet>() ));
	}
	
	public void izmeniStudenta( String ime, String prezime, String brojIndeksa, Date i, String adresaStanovanja,
			String kontaktTelefon, String mailAdresa, String j, int trenutnaGodinaStudija, String status,
			double prosek, List<Ocena> polozeni, List<Predmet> nepolozeni) {
		for(Student st : this.studenti) {
			if(st.getIndeks().equals(brojIndeksa+"-"+j) ) {
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
				st.spisakNepolozenihIspita = (ArrayList<Predmet>) nepolozeni;
				st.spisakPolozenihIspita = (ArrayList<Ocena>) polozeni;
			}
		}
	}
	
	public void izbrisiStudenta(String id) {
		for(Student s : studenti) {
			if(s.getIndeks().equals(id)) {
				studenti.remove(s);
				break;
			}
		}
	}

	
	public void dodajPredmetStudentu(Student student, String ispis) {
		
		
		if (ispis == "" || ispis == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Potrebno je selektovati predmet koji zelite dodati studentu!", "Predmet nije izabran!", JOptionPane.ERROR_MESSAGE);

		}else {
			String[] str = ispis.split("-", 2);
		this.getStudentByIndeks(student.getIndeks()).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmetBySifra(str[0]));
	}}
	
	public void ukloniIzNepolozenih(Predmet predmet) {
		List<Predmet> zaBrisanje = new ArrayList<Predmet>();
		for(Student s : this.studenti) {
			for(Predmet pred : s.getSpisakNepolozenihIspita()) {
				if(pred.getSifraPredmeta().equals(predmet.getSifraPredmeta()))
					zaBrisanje.add(pred);
			}
			for(Predmet p : zaBrisanje)
				s.getSpisakNepolozenihIspita().remove(p);
		}
	}
	
	//mozda ce i ovde trebati odraditi kao za prof i nepolozene!!
	public void ukloniIzPolozenih(Predmet predmet) {
		for(Student s : this.studenti) {
			for(Ocena o : s.getSpisakPolozenihIspita()) {
				if(o.getPredmet().equals(predmet))
					s.getSpisakPolozenihIspita().remove(o);
			}
		}
	}
	
	public void serializeStudent() {
		try {
			FileOutputStream fosStudent = new FileOutputStream("studenti.ser");
			ObjectOutputStream outStudent = new ObjectOutputStream(fosStudent);
			outStudent.writeObject(BazaStudenata.getInstance().getStudenti());
			
			outStudent.close();
			fosStudent.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	public void deserijalizacijaStudenta(){
		try{
			System.out.println("\n\n");
			FileInputStream fOUTStudent = new FileInputStream("studenti.ser");
			ObjectInputStream studentIn= new ObjectInputStream(fOUTStudent);
			@SuppressWarnings("unchecked")
			ArrayList<Student> studenti= (ArrayList<Student>) studentIn.readObject();
			BazaStudenata.getInstance().setStudenti(studenti);
			MainFrame.getInstance().azurirajPrikaz(null,-1);
			
			fOUTStudent.close();
			studentIn.close();
		}catch(IOException exp) {
			exp.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
	}

}
