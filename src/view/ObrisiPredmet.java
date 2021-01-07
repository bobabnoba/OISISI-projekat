package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PredmetiController;
import gui.MainFrame;
import model.Predmet;

public class ObrisiPredmet extends JDialog {
	
	
	private JPanel panelLabela;
	private JPanel panelDugmad;
	private JLabel labela;	
	private JButton btnDa;
	private JButton btnNe;
	private Predmet predmet;
	
	public ObrisiPredmet(Predmet p) {

		predmet = p;
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/3, d.height/1.5);
		setSize(d);
		setTitle("Brisanje predmeta");
		
		this.setModal(true);
		this.setResizable(false);
		//this.setLocationRelativeTo(null);
		//this.setLocationRelativeTo(this.getParent());
		this.setLocationRelativeTo(MainFrame.getInstance());
		getContentPane().setBackground(Color.WHITE);
		
		initComponents();
		
		pack();
		
	}
	
	private void initComponents() {
		panelLabela = new JPanel();
		panelDugmad = new JPanel();
		
		btnDa = new JButton("Da");
		btnNe = new JButton("Ne");
		btnDa.setBackground(Color.WHITE);
		btnNe.setBackground(Color.WHITE);
		
		labela = new JLabel();
		labela.setBackground(Color.WHITE);
		labela.setText("Da li ste sigurni da želite da uklonite predmet?");
		
		
		panelLabela.add(labela);
		panelDugmad.add(btnDa);
		panelDugmad.add(btnNe);
		
		
		btnDa.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnDa.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDa.setBackground(Color.LIGHT_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				PredmetiController.getInstance().ukloniPredmetIzTabele(predmet);
				//for(Student s : BazaStudenata.getInstance().getStudenti()) {
					//getSifrePredmeta kao funkcija koja ima listu sifri predmeta koje student nije polozio
					//if(s.getSpisakNepolozenihIspita().getSifrePredmeta().equals(predmet.getSifraPredmeta())
					//		s.getSpisakNepolozenihIspita().remove(predmet);
				//}
				
					
					
					dispose();
			}
		});
		
		
		btnNe.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnNe.setBackground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNe.setBackground(Color.LIGHT_GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		
		panelLabela.setBorder(new EmptyBorder(20, 20, 10, 20));
		panelDugmad.setBorder(new EmptyBorder(10, 20, 10, 20));
		panelLabela.setBackground(Color.WHITE);
		panelDugmad.setBackground(Color.WHITE);
		add(panelLabela, BorderLayout.CENTER);
		add(panelDugmad, BorderLayout.SOUTH);
		
	}
	
}

