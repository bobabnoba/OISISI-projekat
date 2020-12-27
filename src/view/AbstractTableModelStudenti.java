package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;


public class AbstractTableModelStudenti extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;

	public AbstractTableModelStudenti() {
	}

	// broj redova
	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size() ;
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
