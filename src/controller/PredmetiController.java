package controller;

import java.util.List;

import javax.swing.JOptionPane;

import gui.MainFrame;
import model.BazaPredmeta;
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
	
	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, String godinaStudija,
			model.Profesor profesor, int espb, List<Student> polozili, List<Student> nisuPolozili ) {
		List<Student> p = (List<Student>) polozili;
		List<Student> np=  (List<Student>) nisuPolozili;
		BazaPredmeta.getInstance().dodajPredmet(sifraPredmeta, nazivPredmeta, semestar, 2, profesor, espb, p, np);
		MainFrame.getInstance().updateViewPred();
	}
	
	public void izmeniPredmet(int rowSelectedIndex, String sifraPredmeta, String nazivPredmeta, Semestar semestar, String godinaStudija,
			model.Profesor profesor, int espb, List<Student> polizili, List<Student> nisuPolozili) {
		if(rowSelectedIndex < 0) {
			JOptionPane.showMessageDialog(null,"Izaberite predmet!", "Greska", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		//BazaPredmeta.getInstance().izmeniPredmet()
	}
	
	public void ukloniPredmetIzTabele(Predmet predmet) {
		BazaPredmeta.getInstance().ukloniPredmetIzTabele(predmet);
		MainFrame.getInstance().updateViewPred();
	}
	
}
