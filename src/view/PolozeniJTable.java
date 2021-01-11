package view;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.Polozeni;
import model.Student;

public class PolozeniJTable extends JTable {

	private static final long serialVersionUID = 8900651367165240112L;

	public PolozeniJTable(Student student) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new Polozeni(student.getSpisakPolozenihIspita()));
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
		// System.out.println(row + " " + column);
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

}
