package abstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

<<<<<<< HEAD
=======
import edit.IzmeniStudenta;
import gui.MainFrame;

>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
public class EditEntityAction  extends AbstractAction {
	
	public EditEntityAction() {
	
		putValue(SHORT_DESCRIPTION, "Izmjena entiteta");
		putValue(SMALL_ICON, new ImageIcon("icons/edit.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
<<<<<<< HEAD
=======
		switch(MainFrame.getInstance().selectedTab()) {
		case 0: 
			
			IzmeniStudenta is = new IzmeniStudenta();
        	is.setLocationRelativeTo(MainFrame.getInstance());
        	is.setVisible(true);
        	break;
		}
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
	}
		
}