package abstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class SearchEntityAction extends AbstractAction {
	
	public SearchEntityAction() {
		
		putValue(SHORT_DESCRIPTION, "Pretraga entiteta");
		putValue(SMALL_ICON, new ImageIcon("icons/search.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}
