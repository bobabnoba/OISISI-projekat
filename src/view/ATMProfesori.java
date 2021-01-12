package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

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
	public Object getValueAt(int arg0, int arg1) {
		return BazaProfesora.getInstance().getValueAt(arg0, arg1);
	}
	
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}
	
	
}
