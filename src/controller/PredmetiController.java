package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import gui.MainFrame;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Student;
import model.Titula;
import model.Zvanje;

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
	
}
