package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.BazaStudenata;
import controllers.StudentiController;



public class MyApp {

	public static void main(String[] args) {
		MainFrame mframe = new MainFrame();
		mframe.setVisible(true);
		
		MainFrame.getInstance();
		
		
	}

}
