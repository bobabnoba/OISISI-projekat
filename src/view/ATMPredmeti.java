package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class ATMPredmeti extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return BazaPredmeta.getInstance().getValueAt(arg0, arg1);
	}

	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
}
