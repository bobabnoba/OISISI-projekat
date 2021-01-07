package abstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import gui.MainFrame;
import gui.Toolbar;
import view.AbstractTableModelStudenti;

public class SearchEntityAction extends AbstractAction {
	
	public SearchEntityAction() {
		
		putValue(SHORT_DESCRIPTION, "Pretraga entiteta");
		putValue(SMALL_ICON, new ImageIcon("icons/search.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		MainFrame.getInstance();
		MainFrame.tabelaStudenata.setRowSorter(MainFrame.trs);
		//String query = Toolbar.textField.getText().toLowerCase();
		//MainFrame.trs.setRowFilter(RowFilter.regexFilter(query));
		
		if(!(Toolbar.textField.getText().trim().isEmpty())) {
			String query1 = "";
			String query2 = "";
			String query3 = "";
			String query[] = Toolbar.textField.getText().toLowerCase().split(" ", 3);
			try {
			query1 = query[0];
			query2 = query[1];
			query3 = query[2];
			
		java.util.List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(3);
		filters.add(RowFilter.regexFilter( "( )?" +  query1.substring(0,1).toUpperCase() + query1.substring(1), 2));
		filters.add(RowFilter.regexFilter("( a-z )?" + query2.substring(0,1).toUpperCase() + query2.substring(1), 1));
		filters.add(RowFilter.regexFilter("( a-z )?" + query3, 0));
		
		 RowFilter<Object,Object> serviceFilter = RowFilter.andFilter(filters);
	        MainFrame.trs.setRowFilter(serviceFilter);
			}
			catch(Exception e) {
				//e.printStackTrace();
				try {
				query1 = query[0];
				query2 = query[1];
				java.util.List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
				filters.add(RowFilter.regexFilter( "( )?" +  query1.substring(0,1).toUpperCase() + query1.substring(1), 2));
				filters.add(RowFilter.regexFilter("( a-z )?" + query2.substring(0,1).toUpperCase() + query2.substring(1), 1));
				
				RowFilter<Object,Object> serviceFilter = RowFilter.andFilter(filters);
		        MainFrame.trs.setRowFilter(serviceFilter);
				} catch(Exception e1) {
					query1 = query[0];
					java.util.List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(1);
					filters.add(RowFilter.regexFilter( "( )?" +  query1.substring(0,1).toUpperCase() + query1.substring(1), 2));
					RowFilter<Object,Object> serviceFilter = RowFilter.andFilter(filters);
			        MainFrame.trs.setRowFilter(serviceFilter);
			} 
				
			}
		} else {
		
		java.util.List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(1);
		filters.add(RowFilter.regexFilter( "( )?" + Toolbar.textField.getText().toLowerCase(), 2));
		
		RowFilter<Object,Object> serviceFilter = RowFilter.andFilter(filters);
        MainFrame.trs.setRowFilter(serviceFilter);
	}
	}
	
}