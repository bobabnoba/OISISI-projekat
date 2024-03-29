package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import abstractAction.CreateEntityAction;
import abstractAction.DeleteEntityAction;
import abstractAction.EditEntityAction;
import abstractAction.SearchEntityAction;

public class Toolbar extends JToolBar {
	
	
	public static JTextField textField;
	public Toolbar(final JFrame parent) {
	super(SwingConstants.HORIZONTAL);
	
	CreateEntityAction cea = new CreateEntityAction();
	EditEntityAction eea = new EditEntityAction();
	DeleteEntityAction dea = new DeleteEntityAction();
	SearchEntityAction sea = new SearchEntityAction();
	
	JPanel leftPanel = new JPanel();
	setLayout(new BorderLayout());
	
	JButton btnCreate = new JButton(cea);

	JButton btnEdit = new JButton(eea);
	JButton btnDelete = new JButton(dea);
	
	leftPanel.add(btnCreate);
	leftPanel.add(btnEdit);
	leftPanel.add(btnDelete);
	
	add(leftPanel, BorderLayout.LINE_START);
	
	JPanel rightPanel = new JPanel();
	
	JButton btnSearch = new JButton(sea);
	
	 textField = new JTextField(25);
	textField.setToolTipText("Pretraga");
	
	rightPanel.add(textField);
	rightPanel.add(btnSearch);
	add(rightPanel, BorderLayout.LINE_END);
	
	
	setFloatable(false);
	
	}
}