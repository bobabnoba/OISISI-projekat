package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {

	public Toolbar() {
	super(SwingConstants.HORIZONTAL);
	
	JPanel leftPanel = new JPanel();
	setLayout(new BorderLayout());
	
	JButton btnAdd = new JButton();
	btnAdd.setToolTipText("Kreiranje entiteta");
	btnAdd.setIcon(new ImageIcon("icons/add.png"));
	
	JButton btnEdit = new JButton();
	btnEdit.setToolTipText("Izmjena entiteta");
	btnEdit.setIcon(new ImageIcon("icons/edit.png"));

	
	JButton btnDelete = new JButton();
	btnDelete.setToolTipText("Brisanje entiteta");
	btnDelete.setIcon(new ImageIcon("icons/delete-bin.png"));
	
	leftPanel.add(btnAdd);
	leftPanel.add(btnEdit);
	leftPanel.add(btnDelete);
	
	add(leftPanel, BorderLayout.LINE_START);
	
	JPanel rightPanel = new JPanel();
	
	JButton btnSearch = new JButton();
	btnSearch.setToolTipText("Pretraga entiteta");
	btnSearch.setIcon(new ImageIcon("icons/search.png"));
	
	JTextField textField = new JTextField(25);
	textField.setToolTipText("Pretraga");
	
	rightPanel.add(textField);
	rightPanel.add(btnSearch);
	add(rightPanel, BorderLayout.LINE_END);
	
	
	setFloatable(false);
	
	}
}
