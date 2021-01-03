package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import controller.ProfesoriController;
import controller.StudentiController;
import dialog.Dialog;
import edit.IzmeniStudenta;
import view.DodajProfesora;


public class MenuBar extends JMenuBar implements ActionListener{

	private static final long serialVersionUID = -7863806568418316202L;

	
	public MenuBar(final JFrame parent) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		JMenuItem miNew = new JMenuItem("New", KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.setIcon(new ImageIcon("icons/add.png"));
		miNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(MainFrame.getInstance().selectedTab()) {
				case 0: 
					DodajStudenta ds = new DodajStudenta();
		        	ds.setLocationRelativeTo(parent);
		        	ds.setVisible(true);
		        	break;
				case 1:
					DodajProfesora dp = new DodajProfesora();
					dp.setLocationRelativeTo(parent);
					dp.setVisible(true);
					break;
				case 2:
					//DodajPredmet dpr = new DodajPredmet();
					//dpr.setLocationRelativeTo(parent);
					//dpr.setVisible(true);
					break;
				default:
					break;
				}
			//	if(MainFrame.getTab() == 0) {
			/*	if(MainFrame.getInstance().selectedTab() == 0) {
	        	DodajStudenta ds = new DodajStudenta();
	        	ds.setLocationRelativeTo(parent);
	        	ds.setVisible(true);
				}*/ 
	        	
			}});
		miNew.setActionCommand("napravi");
		
		JMenuItem miClose = new JMenuItem("Close", KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.setIcon(new ImageIcon("icons/delete.png"));
		file.add(miNew);
		file.add(miClose);
		miClose.addActionListener(this);
		miClose.setActionCommand("exit");
		
		
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic('E');
		JMenuItem miEdit = new JMenuItem("Edit", KeyEvent.VK_E);
		miEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(MainFrame.getInstance().selectedTab()) {
				case 0: 
					
					IzmeniStudenta is = new IzmeniStudenta();
		        	is.setLocationRelativeTo(parent);
		        	is.setVisible(true);
		        	break;
				}
			}
		});
		JMenuItem miDelete = new JMenuItem("Delete", KeyEvent.VK_D);
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.setIcon(new ImageIcon("icons/edit.png"));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.setIcon(new ImageIcon("icons/delete.png"));
		miDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(MainFrame.getInstance().selectedTab()) {
				case 0: 
					
					JFrame frame = new JFrame();
					String[] options = new String[2];
					options[0] = new String("Da");
					options[1] = new String("Ne");
					int n = JOptionPane.showOptionDialog(frame.getContentPane(),"Da li ste sigurni da zelite da obrisete studenta?","Brisanje studenta", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);				   
					if(n == JOptionPane.YES_OPTION) {
					MainFrame.getInstance();
					StudentiController.getInstance().izbrisiStudenta(MainFrame.tabelaStudenata.getSelectedRow());
				    }
				    if(n == JOptionPane.NO_OPTION) {
				          return;
				    }
					break;
				case 1:
					JFrame frame1 = new JFrame();
					String[] options1 = new String[2];
					options1[0] = new String("Da");
					options1[1] = new String("Ne");
					int n1 = JOptionPane.showOptionDialog(frame1.getContentPane(),"Da li ste sigurni da zelite da obrisete profesora?","Brisanje profesora", 0,JOptionPane.INFORMATION_MESSAGE,null,options1,null);				   
					if(n1 == JOptionPane.YES_OPTION) {
					MainFrame.getInstance();
					ProfesoriController.getInstance().izbrisiProfesora(MainFrame.profTable.getSelectedRow());
				    }
				    if(n1 == JOptionPane.NO_OPTION) {
				          return;
				    }
					break;
				case 2:
					
					break;
				default:
					break;
				}
			
	        	
			}});
		
		
		edit.add(miEdit);
		edit.add(miDelete);
		
		
		JMenu help = new JMenu("Help");
		help.setMnemonic('H');
		JMenuItem miHelp = new JMenuItem("Help", KeyEvent.VK_H);
		JMenuItem miAbout = new JMenuItem("About", KeyEvent.VK_A);
		
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("icons/help.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		miHelp.setIcon(imageIcon1);
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("icons/about.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

		miAbout.setIcon(imageIcon2);

		
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

		miHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Dialog dialog = new Dialog(parent, "Help", false);
				dialog.add(new JLabel("<html> Do sada su definisane klase MainFrame, MenuBar, StatusBar i Toolbar.<br> "
						+ "Meni bar se sastoji od 3 menija.  <br>"
						+ "1. File, koji se sastoji od stavki:<br>"
						+ "		New - dodavanje novog entiteta u sistem (precica ctrl+n) <br>"
						+ "		Close - zatvaranje aplikacije (precica ctrl+c)<br>"
						+ "2. Edit, koji se sastoji od stavki:<br>"
						+ "		Edit - izmena postojeceg entiteta(precica ctrl+e)<br>"
						+ "		Delete - brisanje postojeceg entiteta(precica ctrl+d)<br>"
						+ "3. Help, koji se sastoji od stavki:<br>"
						+ "		Help - ovde se trenutno nalazite(precica ctrl+d)<br>"
						+ "		About - bice dodatno implementirano(precica ctrl+a)</html>"));
				dialog.setVisible(true);
				
			}
		});
		
		
		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Dialog dialog = new Dialog(parent, "Help", false);
				dialog.add(new JLabel("<html> Odradjen domaci 1. <br> "
						+ "student 1: Dusan Markovic ra172-2018 <br>"
						+ "student 2: Bozana Ruljic ra173-2018 "));
				dialog.setVisible(true);
				
			}
		});
		
		
		help.add(miHelp);
		help.add(miAbout);
		
		
		add(file);
		add(edit);
		add(help);
		
		
	}


		 @Override
		    public void actionPerformed(ActionEvent e) {
		       System.exit(0);	        
		    }
		 }
		
	

