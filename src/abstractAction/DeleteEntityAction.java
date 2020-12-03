package abstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class DeleteEntityAction extends AbstractAction {
	
	public DeleteEntityAction() {
	
		putValue(SHORT_DESCRIPTION, "Brisanje entiteta");
		putValue(SMALL_ICON, new ImageIcon("icons/delete-bin.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
}
