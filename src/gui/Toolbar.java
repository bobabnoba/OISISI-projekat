package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import abstractAction.CreateEntityAction;
import abstractAction.DeleteEntityAction;
import abstractAction.EditEntityAction;
import abstractAction.SearchEntityAction;

public class Toolbar extends JToolBar {

	public Toolbar() {
	super(SwingConstants.HORIZONTAL);
	
	CreateEntityAction cea = new CreateEntityAction();
	EditEntityAction eea = new EditEntityAction();
	DeleteEntityAction dea = new DeleteEntityAction();
	SearchEntityAction sea = new SearchEntityAction();
	
	JPanel leftPanel = new JPanel();
	setLayout(new BorderLayout());
	
	JButton btnCreate = new JButton(cea);
	btnCreate.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
        	DodajStudenta ds = new DodajStudenta();
        	ds.setVisible(true);
        
		}});
	JButton btnEdit = new JButton(eea);
	JButton btnDelete = new JButton(dea);
	
	leftPanel.add(btnCreate);
	leftPanel.add(btnEdit);
	leftPanel.add(btnDelete);
	
	add(leftPanel, BorderLayout.LINE_START);
	
	JPanel rightPanel = new JPanel();
	
	JButton btnSearch = new JButton(sea);
	
	JTextField textField = new JTextField(25);
	textField.setToolTipText("Pretraga");
	
	rightPanel.add(textField);
	rightPanel.add(btnSearch);
	add(rightPanel, BorderLayout.LINE_END);
	
	
	setFloatable(false);
	
	}
}
