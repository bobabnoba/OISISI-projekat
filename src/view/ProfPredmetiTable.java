package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.Profesor;

public class ProfPredmetiTable extends JTable {


	public ProfPredmetiTable(Profesor profesor) {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new ATMProfPredmeti(profesor.getPredmeti()));
	}
		
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.MAGENTA);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
