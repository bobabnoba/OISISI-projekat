package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
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
		
		MenuBar menu = new MenuBar(this);
		Toolbar toolbar = new Toolbar();
		StatusBar status = new StatusBar();
		
		add(menu, BorderLayout.NORTH);
		
		//TODO: Prikaz entiteta sistema
		JPanel tabs = new JPanel();
		tabs.setBackground(Color.lightGray);
		tabs.setLayout(new BorderLayout());
		add(tabs);
		tabs.add(toolbar, BorderLayout.PAGE_START);		
		this.add(status, BorderLayout.SOUTH);
	}
}
