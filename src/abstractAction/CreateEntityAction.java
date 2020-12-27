package abstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import gui.MainFrame;
import view.DodajProfesora;

public class CreateEntityAction extends AbstractAction {

	public CreateEntityAction() {
		putValue(SHORT_DESCRIPTION, "Kreiranje novog entiteta"); 
		putValue(SMALL_ICON, new ImageIcon("icons/add.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(MainFrame.getInstance().selectedTab()) {
		case 0:
			//dodavanje studenta
			break;
		case 1:
			DodajProfesora dp = new DodajProfesora();
			dp.setLocationRelativeTo(MainFrame.getInstance());
			dp.setVisible(true);
			break;
		case 2:
			//dodavanje predmeta
			break;
		default: 
			break;
		}
	}
}
