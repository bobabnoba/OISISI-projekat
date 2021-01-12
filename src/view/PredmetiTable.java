package view;

import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class PredmetiTable extends JTable {

	private static PredmetiTable instance = null;

	public static PredmetiTable getInstance() {
		if(instance == null) {
			instance = new PredmetiTable();
		}
		return instance;
	}
	
	private ATMPredmeti model;
	private static TableRowSorter<ATMPredmeti> sorter;
	private List<SortKey> sortKeys;
	private Icon ascIcon;
	private Icon descIcon;
	private JLabel icon;
	
	@SuppressWarnings("unchecked")
	public PredmetiTable() {
		this.setRowSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.model = new ATMPredmeti();
		this.setModel(model);
		
		sorter = new TableRowSorter<ATMPredmeti>(model);
		for(int i = 0; i < model.getColumnCount(); i++) {
			sorter.setSortable(i, true);
		}
		this.setRowSorter(sorter);
	}
		
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		
		return c;
	}
	
	public static void newFilter(String arg) {
		RowFilter<? super ATMPredmeti, ? super Integer> rf = null;
		try {
			// samo po nazivu predmeta /kolona1/
			rf = RowFilter.regexFilter("(?i)" + arg, 1);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		getSorter().setRowFilter(rf);
	}
	
	public ATMPredmeti getModel() {
		return model;
	}

	public static TableRowSorter<ATMPredmeti> getSorter() {
		return sorter;
	}
}
