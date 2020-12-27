package view;

import javax.swing.table.AbstractTableModel;

import classes.BazaProfesora;

public class ATMProfesori extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}
	
}
