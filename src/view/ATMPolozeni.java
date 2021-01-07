package view;

import javax.swing.table.AbstractTableModel;

import model.Polozeni;

public class ATMPolozeni extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return Polozeni.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return Polozeni.getInstance().getPolozeni().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return Polozeni.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	public String getColumnName(int column) {
		return Polozeni.getInstance().getColumnName(column);
	}
	public void setPolozeni() {
		Polozeni.getInstance().setPolozeni();
	}
	
}
