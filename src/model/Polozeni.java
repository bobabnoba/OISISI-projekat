package model;

import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;

public class Polozeni {

	private static Polozeni instance = null;
	
	public static Polozeni getInstance() {
		if(instance == null) {
			instance = new Polozeni();
		}
		return instance;
	}
	private Student s;
	private List<Ocena> polozeni;
	private List<String> kolone;
	
	public Polozeni() {
		initPolozene();
		MainFrame.getInstance();

		this.s = BazaStudenata.getInstance().getRow(MainFrame.tabelaStudenata.getSelectedRow());
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("ocena");
		this.kolone.add("Datum");
	}
	
	private void initPolozene() {
		this.polozeni = new ArrayList<Ocena>();
		MainFrame.getInstance();
		s = BazaStudenata.getInstance().getRow(MainFrame.tabelaStudenata.getSelectedRow());
		for(Ocena o : s.spisakPolozenihIspita) {
			polozeni.add(o);
		}
	}
	
	public String getValueAt(int row, int column) {
		Ocena ocena = this.polozeni.get(row);
		switch(column) {
		case 0:
			return ocena.getPredmet().getSifraPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return String.valueOf(ocena.getPredmet().getEspb());
		case 3:
			return String.valueOf(ocena.getOcena());
		case 4:
			return String.valueOf(ocena.getDatumPolaganja());
			default:
				return null;			
		}
	}
	
	public List<Ocena> getPolozeni(){
		return polozeni;
	}
	public void setPolozeni() {
		this.polozeni =  BazaStudenata.getInstance().getRow(MainFrame.tabelaStudenata.getSelectedRow()).spisakPolozenihIspita;
	}
	
	public int getColumnCount() {
		return 5;
	}
	public String getColumnName(int index) {
		return this.kolone.get(index );
	}
	public Ocena getRow(int rowIndex) {
		return this.polozeni.get(rowIndex);
	}
	
}
