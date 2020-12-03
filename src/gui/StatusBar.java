package gui;

import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public StatusBar() {
		
		this.setBackground(Color.lightGray);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JLabel labela = new JLabel ("Studentska Služba");
		this.add(labela);
		 this.add(Box.createHorizontalGlue());
		
		JLabel labela2 = new JLabel ("vreme");
		labela2.setText(DateFormat.getDateTimeInstance().format(new Date()));
		this.add(labela2);		
		
	}
}

