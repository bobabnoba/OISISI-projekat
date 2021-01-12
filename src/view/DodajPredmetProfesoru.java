package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ProfesoriController;
import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import net.miginfocom.swing.MigLayout;

public class DodajPredmetProfesoru extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> model;
	private JList<String> list;
	
	private String row;
	
	private JPanel panel1;
	private JPanel panel2;
	private JLabel lblPredmeti;
	//private JLabel lbl;
	private JScrollPane scrollPane;
	private JButton btnOK;
	private JButton btnCancel;

	public DodajPredmetProfesoru(Profesor profesor, ProfPredmetiTable predmetiTable) {
				
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/3, d.height/1.5);
		setSize(d);
		setTitle("Dodaj predmet");
		
		this.setModal(true);
		this.setResizable(false);
		setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
		getContentPane().setBackground(Color.WHITE);
		
		row = "";
		
		initComponents(profesor, predmetiTable);
		
		
		pack();
		
	}
	
	public JScrollPane predmetiList(Profesor profesor) {
		
		
		model = new DefaultListModel<String>();
		for(Predmet predmet : BazaPredmeta.getInstance().getPredmeti()) {
			if(predmet.getPredmetniProfesor() == null) {		//dozvolimo samo predmete koje nemaju profesora
				if(!profesor.getSifrePred().contains(predmet.getSifraPredmeta())) {
					model.addElement(predmet.getNazivPredmeta());
				}
			}
			}
	
		list = new JList<String>(model);
	    JScrollPane scrollPane = new JScrollPane(list);
	    
	    list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					row = list.getSelectedValue();
				}
			}
		});
		return scrollPane;
	}
	
	
	
	public void initComponents(Profesor profesor, ProfPredmetiTable predmetiTable) {
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setLayout(new MigLayout(null, null, "[]20[]20[]"));
		panel2.setLayout(new MigLayout());
		
		setLayout(new BorderLayout());

		lblPredmeti = new JLabel("Predmeti:");
		scrollPane = predmetiList(profesor);
		btnOK = new JButton("Potvrdi");
		btnCancel = new JButton("Odustani");
		
		panel1.add(lblPredmeti, "wrap");
		panel1.add(scrollPane, "wrap");
		panel2.add(btnOK, "align center, tag ok");
		panel2.add(btnCancel, "align center, tag cancel");
	
		
		btnCancel.addMouseListener(new MouseListener() {
			
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
				btnCancel.setBackground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setBackground(Color.LIGHT_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		
		btnOK.addMouseListener(new MouseListener() {
			
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
				btnOK.setBackground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOK.setBackground(Color.LIGHT_GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ProfesoriController.getInstance().dodajPredmetProfesoru(profesor, row);
				ATMProfPredmeti modelPred = (ATMProfPredmeti) predmetiTable.getModel();
				modelPred.fireTableDataChanged();
				validate();
				model.removeElement(row);
				list.updateUI();
				dispose();
			}
		});
		
	
		panel1.setBorder(new EmptyBorder(10, 10, 0, 10));
		panel2.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.EAST);
		
		
	}
	
	
}
