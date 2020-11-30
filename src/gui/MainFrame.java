package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	public MainFrame() {
		super();

		setTitle("Studentska služba");
		setResizable(true);

		Toolkit tkit = Toolkit.getDefaultToolkit();	
		Dimension screenSize = tkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4, 3 * screenHeight / 4);		

		setLocationRelativeTo(null);
		
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
		
		//TODO: Prikaz entiteta sistema
		JPanel tabs = new JPanel();
		tabs.setBackground(Color.lightGray);
		add(tabs);
		
		StatusBar status = new StatusBar();
		this.add(status, BorderLayout.SOUTH);
	}
}
