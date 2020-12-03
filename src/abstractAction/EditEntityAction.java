package abstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class EditEntityAction  extends AbstractAction {
	
	public EditEntityAction() {
	
		putValue(SHORT_DESCRIPTION, "Izmjena entiteta");
		putValue(SMALL_ICON, new ImageIcon("icons/edit.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
		
}