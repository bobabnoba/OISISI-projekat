package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Predmet;

public class ATMProfPredmeti extends AbstractTableModel {
	
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	
	public ATMProfPredmeti(List<Predmet> predmeti) {
		
		this.predmeti = predmeti;
		kolone = new ArrayList<String>();
		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
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
		return 4;
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
			return predmet.getGodinaStudija();
		case 3:
			return predmet.getSemestar();
		default: 
			return null;
		}
	}

	
}
