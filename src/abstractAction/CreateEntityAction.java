package abstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateEntityAction extends AbstractAction {

	public CreateEntityAction() {
		putValue(SHORT_DESCRIPTION, "Kreiranje novog entiteta"); 
		putValue(SMALL_ICON, new ImageIcon("icons/add.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}
