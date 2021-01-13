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
		
		
		
		
		try {
			 d1 = sdf.parse("12.03.2001.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d2 = sdf.parse("12.01.2000.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d3 = sdf.parse("30.08.2001.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d4 = sdf.parse("07.06.1995.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			 d5 = sdf.parse("06.05.1999.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d6 = sdf.parse("16.05.1999.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d7 = sdf.parse("19.10.2001.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d8 = sdf.parse("02.11.2000.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d9 = sdf.parse("11.10.2000.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d10 = sdf.parse("01.05.1999.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d11 = sdf.parse("11.07.1999.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d12 = sdf.parse("23.07.1999.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d13 = sdf.parse("12.12.2001.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d14 = sdf.parse("05.11.2001.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d15 = sdf.parse("10.09.1998.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d16 = sdf.parse("03.08.1998.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d17 = sdf.parse("01.05.1998.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d18 = sdf.parse("25.02.1996.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d19 = sdf.parse("11.05.1998.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d20 = sdf.parse("22.01.2001.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d21 = sdf.parse("31.12.2000.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d22 = sdf.parse("31.08.1998.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d23 = sdf.parse("21.07.1999.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d24 = sdf.parse("28.09.1998.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			 d25 = sdf.parse("29.02.2000.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d26 = sdf.parse("23.03.1999.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 d27 = sdf.parse("21.10.2001.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			MainFrame.getInstance().updateViewProf();
			
			fOUTStudent.close();
			studentIn.close();
		}catch(IOException exp) {
			exp.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
	}

}
