package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class ProfesoriTable extends JTable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = -6682511672404365480L;
private static ProfesoriTable instance = null;

	public static ProfesoriTable getInstance() {
		if(instance == null) {
			instance = new ProfesoriTable();
		}
		return instance;
	}
	private ATMProfesori model;
	private static TableRowSorter<ATMProfesori> sorter;
	
	public ProfesoriTable() {
		this.setRowSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.model = new ATMProfesori();
		this.setModel(model);
		
		sorter = new TableRowSorter<ATMProfesori>(model);
		
		//sortiramo po imenu, prezimenu, tituli i zvanju - po svim kolonama
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
	
	public static void newFilter(String arg, int column) {
		RowFilter<? super ATMProfesori, ? super Integer> rf = null;
		try {
			rf = RowFilter.regexFilter("(?i)" + arg, column);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		getSorter().setRowFilter(rf);
	}
	public ATMProfesori getModel() {
		return model;
	}

	public static TableRowSorter<ATMProfesori> getSorter() {
		return sorter;
	}
	
}
