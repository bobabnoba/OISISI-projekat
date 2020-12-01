package dialog;

import java.awt.Frame;

import javax.swing.JDialog;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 3591599721565020284L;

	public Dialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(500, 500);
		setLocationRelativeTo(parent);

	}

}
