package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Ocena;
import model.Predmet;

public class ATMNepolozeni extends AbstractTableModel {
	
	private static List<Predmet> predmeti;
	private List<String> kolone;
	
	public ATMNepolozeni(List<Predmet> predmeti) {
		
		this.predmeti = predmeti;
		kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public Predmet getSelectedPredmet(int row) {
		return predmeti.get(row);
	}
	
	
	@Override
	public int getRowCount() {
		return predmeti.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	public String getColumnName(int column) {
		return kolone.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Predmet predmet = this.predmeti.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return predmet.getEspb();
		case 3: 
			return predmet.getGodinaStudija();
		case 4:
			return predmet.getSemestar();
		default: 
			return null;
		}
	}

	public static Predmet getRow(int rowIndex) {
		return predmeti.get(rowIndex);
	}


}
