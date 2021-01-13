package abstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import edit.IzmenaPredmeta;
import edit.IzmeniStudenta;
import gui.MainFrame;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.IzmjenaProfesora;

public class EditEntityAction  extends AbstractAction {
	
	public EditEntityAction() {
	
		putValue(SHORT_DESCRIPTION, "Izmjena entiteta");
		putValue(SMALL_ICON, new ImageIcon("icons/edit.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(MainFrame.getInstance().selectedTab()) {
		case 0: 
			if(!MainFrame.getInstance().indexCheckStud()) {
			int rows = MainFrame.getInstance().selectedStud();
			Student student = BazaStudenata.getInstance().getRow(rows);
			IzmeniStudenta is = new IzmeniStudenta(student);
        	is.setLocationRelativeTo(MainFrame.getInstance());
        	is.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Potrebno je selektovati studenta kog želite da editujete!", "Student nije izabran!", JOptionPane.ERROR_MESSAGE);

			}
        	break;
	case 1:			
		if(!MainFrame.getInstance().indexCheckProf()) {
			int rowp = MainFrame.getInstance().selectedProf();
			Profesor profesor = BazaProfesora.getInstance().getRow(rowp);
			IzmjenaProfesora ip = new IzmjenaProfesora(profesor);
			ip.setLocationRelativeTo(MainFrame.getInstance());
			ip.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Potrebno je selektovati profesora kog želite da editujete!", "Profesor nije izabran!", JOptionPane.ERROR_MESSAGE);
		}
		break;
	case 2:
		
		if(!MainFrame.getInstance().indexCheckPred()) {
			int rows = MainFrame.getInstance().selectedPred();
			Predmet predmet= BazaPredmeta.getInstance().getRow(rows);
			IzmenaPredmeta ipr = new IzmenaPredmeta(predmet);
			ipr.setLocationRelativeTo(MainFrame.getInstance());
			ipr.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Potrebno je selektovati predmet koji želite da editujete!", "Predmet nije izabran!", JOptionPane.ERROR_MESSAGE);

			}
        	break;
	default: 
		break;
		}
	}	
		
}