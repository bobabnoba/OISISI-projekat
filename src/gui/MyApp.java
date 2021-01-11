package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Student;
import controller.StudentiController;
import edit.IzmeniStudenta;



public class MyApp {

	public static void main(String[] args) {
	/*	BazaStudenata.getInstance();
		StudentiController.getInstance();
		MainFrame.getInstance();*/
		
		MainFrame mframe = MainFrame.getInstance();
		mframe.setVisible(true);
		
		
		
		
			
		//Ocena o11 = new Ocena(10, new Date(), BazaStudenata.getInstance().getStudent(4), BazaPredmeta.getInstance().getPredmet(5));
		Ocena o12 = new Ocena(9, new Date(), BazaStudenata.getInstance().getStudent(3), BazaPredmeta.getInstance().getPredmet(2));
		Ocena o13 = new Ocena(8, new Date(), BazaStudenata.getInstance().getStudent(3), BazaPredmeta.getInstance().getPredmet(1));


		
		
		
		//BazaStudenata.getInstance().getStudent(4).dodajPolozeni(o11);
		BazaStudenata.getInstance().getStudent(3).dodajPolozeni(o12);
		BazaStudenata.getInstance().getStudent(3).dodajPolozeni(o13);
		
		MainFrame.getInstance();
		
	}

}