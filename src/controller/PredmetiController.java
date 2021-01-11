package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import gui.MainFrame;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Semestar;
import model.Student;

public class PredmetiController {
	
private static PredmetiController instance = null;
	
	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}

	private PredmetiController() {
	}
	
	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,
			model.Profesor profesor, int espb, List<Student> polozili, List<Student> nisuPolozili ) {
		List<Student> p = (List<Student>) polozili;
		List<Student> np=  (List<Student>) nisuPolozili;
		BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, semestar, godinaStudija, profesor, espb, p, np);
		MainFrame.getInstance().updateViewPred();
	}
	
	
	
	public void izmeniPredmet(String sifra, String naziv,int espb,   int godinaStudija, Semestar semestar) {
		
		
		BazaPredmeta.getInstance().izmeniPredmet( sifra, naziv , espb, godinaStudija, semestar );		
		MainFrame.getInstance().updateViewPred();
	}
	
	public void ukloniPredmetIzTabele(Predmet predmet) {
		BazaPredmeta.getInstance().ukloniPredmetIzTabele(predmet);
		MainFrame.getInstance().updateViewPred();
	}
	
}
