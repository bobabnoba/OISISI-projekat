package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import gui.MainFrame;

public class Polozeni extends AbstractTableModel {

	private static Polozeni instance = null;
	

	private Student s;
	private static List<Ocena> polozeni;
	private List<String> kolone;
	
	public Polozeni(ArrayList<Ocena> polozeni) {
		this.polozeni = polozeni;
		MainFrame.getInstance();
		int rows = MainFrame.getInstance().selectedStud();
		this.s = BazaStudenata.getInstance().getRow(rows);
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("ocena");
		this.kolone.add("Datum");
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
	public void setPolozeni(List<Ocena> polozeni) {
		this.polozeni =  polozeni;
	}
	
	public int getColumnCount() {
		return 5;
	}
	public String getColumnName(int index) {
		return this.kolone.get(index );
	}
	public static Ocena getRow(int rowIndex) {
		return polozeni.get(rowIndex);
	}



	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return polozeni.size();
	}
	
}
