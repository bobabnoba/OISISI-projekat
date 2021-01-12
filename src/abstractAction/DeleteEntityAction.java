package abstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.ProfesoriController;
import controller.StudentiController;
import gui.MainFrame;
import model.BazaPredmeta;
import model.Predmet;
import view.ObrisiPredmet;

public class DeleteEntityAction extends AbstractAction {
	
	public DeleteEntityAction() {
	
		putValue(SHORT_DESCRIPTION, "Brisanje entiteta");
		putValue(SMALL_ICON, new ImageIcon("icons/delete-bin.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(MainFrame.getInstance().selectedTab()) {
		case 0: 
			
			JFrame frame = new JFrame();
			String[] options = new String[2];
			options[0] = new String("Da");
			options[1] = new String("Ne");
			int n = JOptionPane.showOptionDialog(frame.getContentPane(),"Da li ste sigurni da zelite da obrisete studenta?","Brisanje studenta", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);				   
			if(n == JOptionPane.YES_OPTION) {
			MainFrame.getInstance();
			StudentiController.getInstance().izbrisiStudenta(MainFrame.tabelaStudenata.getSelectedRow());
		    }
		    if(n == JOptionPane.NO_OPTION) {
		          return;
		    }
			break;
		case 1:
			JFrame frame1 = new JFrame();
			String[] options1 = new String[2];
			options1[0] = new String("Da");
			options1[1] = new String("Ne");
			int n1 = JOptionPane.showOptionDialog(frame1.getContentPane(),"Da li ste sigurni da zelite da obrisete profesora?","Brisanje profesora", 0,JOptionPane.INFORMATION_MESSAGE,null,options1,null);				   
			if(n1 == JOptionPane.YES_OPTION) {
			MainFrame.getInstance();
			ProfesoriController.getInstance().izbrisiProfesora(MainFrame.profTable.getSelectedRow());
		    }
		    if(n1 == JOptionPane.NO_OPTION) {
		          return;
		    }
		    break;
		case 2: 
			if(!MainFrame.getInstance().indexCheckPred()) {
				int row = MainFrame.getInstance().selectedPred();
				Predmet predmet = BazaPredmeta.getInstance().getRow(row);
				ObrisiPredmet op = new ObrisiPredmet(predmet);
				op.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Potrebno je selektovati predmet koji želite da uklonite!", "Predmet nije izabran!", JOptionPane.ERROR_MESSAGE);
			}
			break;
		default: 
			break;
		    
		}
	}
	
	
}