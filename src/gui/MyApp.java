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
		mframe.azurirajPrikaz(null, -1);
		mframe.setVisible(true);
		

		
		
		/*
			
		Ocena o11 = new Ocena(10, new Date(), BazaStudenata.getInstance().getStudent(3), BazaPredmeta.getInstance().getPredmet(4));
		Ocena o12 = new Ocena(9, new Date(), BazaStudenata.getInstance().getStudent(3), BazaPredmeta.getInstance().getPredmet(2));
		Ocena o13 = new Ocena(8, new Date(), BazaStudenata.getInstance().getStudent(3), BazaPredmeta.getInstance().getPredmet(0));
		Ocena o21 = new Ocena(10, new Date(), BazaStudenata.getInstance().getStudent(1), BazaPredmeta.getInstance().getPredmet(0));
		Ocena o22 = new Ocena(10, new Date(), BazaStudenata.getInstance().getStudent(1), BazaPredmeta.getInstance().getPredmet(4));
		Ocena o31 = new Ocena(9, new Date(), BazaStudenata.getInstance().getStudent(14), BazaPredmeta.getInstance().getPredmet(14));
		Ocena o32 = new Ocena(10, new Date(), BazaStudenata.getInstance().getStudent(14), BazaPredmeta.getInstance().getPredmet(15));
		Ocena o41 = new Ocena(10, new Date(), BazaStudenata.getInstance().getStudent(15), BazaPredmeta.getInstance().getPredmet(14));
		Ocena o42 = new Ocena(8, new Date(), BazaStudenata.getInstance().getStudent(15), BazaPredmeta.getInstance().getPredmet(15));
		
		
		BazaStudenata.getInstance().getStudent(4).dodajPolozeni(o11);
		BazaStudenata.getInstance().getStudent(3).dodajPolozeni(o12);
		BazaStudenata.getInstance().getStudent(3).dodajPolozeni(o13);
		
		BazaStudenata.getInstance().getStudent(1).dodajPolozeni(o21);
		BazaStudenata.getInstance().getStudent(1).dodajPolozeni(o22);

		BazaStudenata.getInstance().getStudent(14).dodajPolozeni(o31);
		BazaStudenata.getInstance().getStudent(14).dodajPolozeni(o32);

		
		BazaStudenata.getInstance().getStudent(15).dodajPolozeni(o41);
		BazaStudenata.getInstance().getStudent(15).dodajPolozeni(o42);

		
		BazaStudenata.getInstance().getStudent(3).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(1));
		BazaStudenata.getInstance().getStudent(3).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(3));
		
		BazaStudenata.getInstance().getStudent(16).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(14));
		BazaStudenata.getInstance().getStudent(17).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(14));
		BazaStudenata.getInstance().getStudent(21).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(17));
		BazaStudenata.getInstance().getStudent(22).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(17));
		BazaStudenata.getInstance().getStudent(23).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(17));
		BazaStudenata.getInstance().getStudent(25).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(17));
		BazaStudenata.getInstance().getStudent(21).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(18));
		BazaStudenata.getInstance().getStudent(22).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(18));
		BazaStudenata.getInstance().getStudent(23).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(18));
		BazaStudenata.getInstance().getStudent(25).getSpisakNepolozenihIspita().add(BazaPredmeta.getInstance().getPredmet(18));


		*/
		
		
		
		
		
	}

}