package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edit.IzmeniStudenta;
import model.Ocena;
import model.Polozeni;
import model.Predmet;
import model.Student;
import net.miginfocom.swing.MigLayout;

public class UpisOcjene extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1630983448882363514L;
	@SuppressWarnings("unused")
	private Date datum;
	private JPanel panelPolja;
	private JPanel panelDugmad;
	
	private JLabel lblSifra;
	private JTextField tfSifra;
	private JLabel lblNaziv;
	private JTextField tfNaziv;
	private JLabel lblOcjena;
	private JTextField tfOcjena;
	private JLabel lblDatum;
	private JTextField tfDatum;
	
	private JButton btnOK;
	private JButton btnCancel;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	public UpisOcjene(Predmet p, Student s) {
			
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/3, d.height/1.5);
		setSize(d);
		setTitle("Unos ocjene");
		
		this.setModal(true);
		this.setResizable(false);
		//TODO: postaviti centriranje u odnosu na tabelu predmeta
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		
		initComponents(p, s);
		
		pack();
	}
	
	FocusListener focus = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			if(!(tfOcjena.getText().trim().isEmpty() || tfDatum.getText().trim().isEmpty() || Integer.parseInt(tfOcjena.getText()) < 6 || Integer.parseInt(tfOcjena.getText()) > 10)) {
				datum = new Date();
				try {
					datum = sdf.parse(tfDatum.getText());
					btnOK.setEnabled(true);
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(null, "Datum unesite u formatu (dd.MM.yyyy.)", "Greška", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					return;
				}
			}
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
	};	
	
		private void initComponents(Predmet p, Student s){
			panelPolja = new JPanel();
			panelDugmad = new JPanel();
			panelPolja.setLayout(new MigLayout(null, "[]30[]", "[]20[]20[]20[]20[]20[]20"));

			panelDugmad.setLayout(new MigLayout());
			
			panelPolja.setBackground(Color.WHITE);
			panelDugmad.setBackground(Color.WHITE);
			
			setLayout(new BorderLayout());
			
			lblSifra = new JLabel("Šifra*");
			tfSifra = new JTextField(20);
			tfSifra.setText(p.getSifraPredmeta());
			tfSifra.setEditable(false);
			
			lblNaziv = new JLabel("Naziv*");
			tfNaziv = new JTextField(20);
			tfNaziv.setText(p.getNazivPredmeta());
			tfNaziv.setEditable(false);

			lblOcjena = new JLabel("Ocjena");
			tfOcjena = new JTextField(20);
			tfOcjena.addFocusListener(focus);

			lblDatum = new JLabel("Datum");
			tfDatum = new JTextField(20);
			tfDatum.addFocusListener(focus);
			
			btnOK = new JButton("Potvrdi");
			btnOK.setEnabled(false);
			btnCancel = new JButton("Odustani");
			
			panelPolja.add(lblSifra);
			panelPolja.add(tfSifra, "wrap");
			panelPolja.add(lblNaziv);
			panelPolja.add(tfNaziv, "wrap");
			panelPolja.add(lblOcjena);
			panelPolja.add(tfOcjena, "wrap");
			panelPolja.add(lblDatum);
			panelPolja.add(tfDatum, "wrap");
			panelDugmad.add(btnOK, "cell 0 3, span 2 1, align center, tag ok");
			panelDugmad.add(btnCancel, "cell 0 3, align center, tag cancel");
	
			
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
					
					Date datum = new Date();
					try {
						datum = sdf.parse(tfDatum.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					s.getSpisakNepolozenihIspita().remove(p);
					ATMNepolozeni model = (ATMNepolozeni) IzmeniStudenta.nepolozeniTable.getModel();
					model.fireTableDataChanged();
					validate();
					s.getSpisakPolozenihIspita().add(new Ocena(Integer.parseInt(tfOcjena.getText()), datum, s, p));
					Polozeni model2 = (Polozeni) IzmeniStudenta.pol.getModel(); //ATM polozenih
					model2.fireTableDataChanged();
					validate();
					dispose();
					
				}
			});
			
			panelPolja.setBorder(new EmptyBorder(20, 20, 10, 20));
			panelDugmad.setBorder(new EmptyBorder(10, 20, 10, 20));
			add(panelPolja, BorderLayout.NORTH);
			add(panelDugmad, BorderLayout.EAST);
			
			
		}
}
