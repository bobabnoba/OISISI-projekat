package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD

import classes.BazaStudenata;
import controllers.StudentiController;
=======
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Student;
import controller.StudentiController;
import edit.IzmeniStudenta;
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615



public class MyApp {

	public static void main(String[] args) {
<<<<<<< HEAD
		BazaStudenata.getInstance();
		StudentiController.getInstance();
		MainFrame.getInstance();
		
=======
	/*	BazaStudenata.getInstance();
		StudentiController.getInstance();
		MainFrame.getInstance();*/
		
		MainFrame mframe = MainFrame.getInstance();
		mframe.setVisible(true);
		
		Date d = new Date();
		
		Predmet p = new Predmet("ra12", "analiza 1", Semestar.ZIMSKI, "1", 
			new Profesor(), 9,new ArrayList<Student>(), new ArrayList<Student>()	);
		Predmet p2 = new Predmet("ra122", "analiza 2", Semestar.ZIMSKI, "1", 
				new Profesor(), 7,new ArrayList<Student>(), new ArrayList<Student>()	);
			
		Ocena o = new Ocena(10, d,BazaStudenata.getInstance().getRow(0) , p);
		
		Ocena o1 = new Ocena(10, d,BazaStudenata.getInstance().getRow(1) , p);
		Ocena o2 = new Ocena(10, d,BazaStudenata.getInstance().getRow(2) , p);
		Ocena o3 = new Ocena(10, d,BazaStudenata.getInstance().getRow(3) , p);
		Ocena o12 = new Ocena(6, d,BazaStudenata.getInstance().getRow(0) , p2);

		BazaStudenata.getInstance().getRow(0).dodajPolozeni(o);
		BazaStudenata.getInstance().getRow(0).dodajPolozeni(o);
		BazaStudenata.getInstance().getRow(0).dodajPolozeni(o);
		BazaStudenata.getInstance().getRow(0).dodajPolozeni(o);
		BazaStudenata.getInstance().getRow(0).dodajPolozeni(o);
		BazaStudenata.getInstance().getRow(0).dodajPolozeni(o);
		BazaStudenata.getInstance().getRow(4).dodajPolozeni(o);

		BazaStudenata.getInstance().getRow(0).dodajPolozeni(o12);

		BazaStudenata.getInstance().getRow(1).dodajPolozeni(o1);
		BazaStudenata.getInstance().getRow(1).dodajPolozeni(o1);

		BazaStudenata.getInstance().getRow(2).dodajPolozeni(o2);
		BazaStudenata.getInstance().getRow(3).dodajPolozeni(o3);
		
		MainFrame.getInstance();
		
>>>>>>> 41735e3534d92b397c2226209f01fdd4ba863615
	}

}
