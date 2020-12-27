package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.BazaStudenata;
import controllers.StudentiController;



public class MyApp {

	public static void main(String[] args) {
	/*	BazaStudenata.getInstance();
		StudentiController.getInstance();
		MainFrame.getInstance();*/
		
		MainFrame mframe = MainFrame.getInstance();
		mframe.setVisible(true);
		
	}

}
