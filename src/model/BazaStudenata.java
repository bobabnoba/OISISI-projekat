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
		
		studenti.add(new Student("Marko", "Milosevic", "ra2",d1 , "KaraÄ‘orÄ‘eva 83, Novi Sad", "021333555", "marko.milosevic@mailinator.com", "2020", 1, "b" , 0.0, new ArrayList<Ocena>(), new ArrayList<Predmet>()  ));
		studenti.add(new Student("Marija", "Milic", "ra3", d2 , "StraÅ¾ilovska 12, Novi Sad", "0215552222", "marija.milic@mailinator.com", "2019", 2, "s" , 0.0  ,new ArrayList<Ocena>() , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Nikola", "Nikolic", "ra3", d3  , "Knez Mihajlova 16, Beograd", "021135463", "nikola.nikolic@mailinator.com", "2017", 1, "b" , 0.0 ,new ArrayList<Ocena>() , new ArrayList<Predmet>()   ));
		studenti.add(new Student("Pera", "Peric", "ra134", d4 , "Gogoljeva 3, Novi Sad", "021903463", "pera.peric@mailinator.com", "2015", 3, "s" , 0.0 ,new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Sofija", "Ilic", "ra5",d5 , "MiÅ¡e DimitrijeviÄ‡a 44, Novi Sad ", "021731067", "sofija.ilic@mailinator.com", "2019", 3, "b" , 0.0, new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Martina", "Lukic", "ra8",d6 , "Vojvode Stepe 180, Beograd", "0114333800", "martina.lukic@mailinator.com", "2018", 3, "s" , 0.0, new ArrayList<Ocena>(), new ArrayList<Predmet>()  ));
		studenti.add(new Student("Stojan", "Stojakovic", "ra10", d7 , "1300 Kaplara, Å abac", "0113130007", "stojan.stojakovic@mailinator.com", "2017", 1, "b" , 0.0  ,new ArrayList<Ocena>() , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Milan", "Milanovic", "ra12", d8  , "Surepova 12, Å abac", "015313061", "milan.milanovic@mailinator.com", "2017", 2, "s" , 0.0 ,new ArrayList<Ocena>() , new ArrayList<Predmet>()   ));
		studenti.add(new Student("Miroslav", "Milic", "ra16", d9 , "Milovana GliÅ¡iÄ‡a, Valjevo", "021351091", "miroslav.milic@mailinator.com", "2019", 2, "b" , 0.0 ,new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Stefan", "Gojic", "ra21",d10 , "Bulevar Mihajla Pupina, Novi Sad ", "015324500", "stefan.gojic@mailinator.com", "2015", 3, "s" , 0.0, new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Anastasija", "Jokic", "ra9",d11 , "BraÄ‡e Ribnikar 12, Novi Sad", "0112333900", "anastasija.jokic@mailinator.com", "2020", 3, "b" , 0.0, new ArrayList<Ocena>(), new ArrayList<Predmet>()  ));
		studenti.add(new Student("Bogdan", "Bogdanovic", "ra4", d12 , "Cara DuÅ¡ana 42, Subotica", "021231114", "bogdan.bogdanovic@mailinator.com", "2017", 3, "s" , 0.0  ,new ArrayList<Ocena>() , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Ana", "Dabovic", "ra30", d13  , "Marka KraljeviÄ‡a 1, Kikinda", "014303007", "ana.dabovic@mailinator.com", "2019", 1, "b" , 0.0 ,new ArrayList<Ocena>() , new ArrayList<Predmet>()   ));
		studenti.add(new Student("Mika", "Mikic", "ra1", d14 , "Nikole StojanoviÄ‡a 2, Kraljevo", "015101909", "mika.mikic@mailinator.com", "2020", 1, "s" , 0.0 ,new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Jovan", "Deretic", "ra11",d15 , "Marka BratiÄ‡a  99, NiÅ¡ ", "002200300", "jovan.deretic@mailinator.com", "2018", 4, "b" , 0.0, new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Nikola", "Miskovic", "ra12",d16 , "Cara DuÅ¡ana 12, Banja Luka", "022123456", "nikola.miskovic@mailinator.com", "2018", 4, "s" , 0.0, new ArrayList<Ocena>(), new ArrayList<Predmet>()  ));
		studenti.add(new Student("Martin", "Stojanovic", "ra13", d17 , "Borisa BaÄ�kog 1, Bijeljina", "024321775", "martin.stojanovic@mailinator.com", "2018", 4, "s" , 0.0  ,new ArrayList<Ocena>() , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Tomislav", "Novakovic", "ra14", d18  , "Mirka MaksiÄ‡a 10, KruÅ¡evac", "0111188379", "tomislav.novakovic@mailinator.com", "2018", 4, "b" , 0.0 ,new ArrayList<Ocena>() , new ArrayList<Predmet>()   ));
		studenti.add(new Student("Lena", "Ivic", "ra154", d19 , "Stari Most 6, Sremska Mitrovica", "024333555", "lena.ivic@mailinator.com", "2016", 4, "b" , 0.0 ,new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Jovan", "Lazic", "ra23",d20 , "Nevesinjskih ustanika 10, Nevesinje ", "0251189479", "jovan.lazic@mailinator.com", "2020", 1, "b" , 0.0, new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Isidora", "Mikic", "ra1",d21 , "RadniÄ�ÐºÐ°  11, Novi Sad", "0111122366", "isidora.mikic@mailinator.com", "2019", 2, "b" , 0.0, new ArrayList<Ocena>(), new ArrayList<Predmet>()  ));
		studenti.add(new Student("Vladimir", "Ilic", "sw4", d22 , "MiloÅ¡a ObiliÄ‡a 1, Beograd", "0111122366", "vladimir.ilic@mailinator.com", "2014", 4, "b" , 0.0  ,new ArrayList<Ocena>() , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Mirko", "Alicic", "sw17", d23  , "Heroja Pinkija 112, Novi Sad", "0121122368", "mirko.alicic@mailinator.com", "2015", 3, "s" , 0.0 ,new ArrayList<Ocena>() , new ArrayList<Predmet>()   ));
		studenti.add(new Student("Milisav", "Perkovic", "sw17", d24 , "Pavla BakiÄ‡a 26, Novi Sad", "0121122369", "milisav.pejkovic@mailinator.com", "2016", 4, "s" , 0.0 ,new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Purisa", "Djordjevic", "sw27",d25 , "Pavla Papa 1, Novi Sad ", "0111543370", "purisa.djordjevic@mailinator.com", "2018", 2, "b" , 0.0, new ArrayList<Ocena>()  , new ArrayList<Predmet>()  ));
		studenti.add(new Student("Mikica", "Kovacevic", "ra226",d26 , "Valentina Vodnika 112, Novi Sad", "0111992371", "mikica.kovacevic@mailinator.com", "2017", 3, "s" , 0.0, new ArrayList<Ocena>(), new ArrayList<Predmet>()  ));
		studenti.add(new Student("Milos", "Milic", "sw12", d27 , "Neznanog junaka 12, Beograd", "0118172372", "milos.milic@mailinator.com", "2020", 1, "s" , 0.0  ,new ArrayList<Ocena>() , new ArrayList<Predmet>()  ));
		
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
