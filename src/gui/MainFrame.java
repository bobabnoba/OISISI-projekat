package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import studenti.view.AbstractTableModelStudenti;
import studenti.view.StudentiJTable;


public class MainFrame extends JFrame {
	
	
	private static final long serialVersionUID = 4703527718003660405L;

	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

	private JTable tabelaStudenata;

	public MainFrame() {
		super();
		setTitle("Studentska Sluzba");
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenDimension.width / 2, screenDimension.height / 2);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JTabbedPane tabbedPane = new JTabbedPane();

		JPanel mt = new JPanel();
		TableTab mt1 = new TableTab("Profesori");
		TableTab mt2 = new TableTab("Predmeti");
		
		tabbedPane.addTab("Studenti", mt);
		tabbedPane.addTab("Profesori", mt1);
		tabbedPane.addTab("Predmeti", mt2);
		
		
		MenuBar menu = new MenuBar(this);
		Toolbar toolbar = new Toolbar();
		StatusBar status = new StatusBar();
		add(menu, BorderLayout.NORTH);
		
		//TODO: Prikaz entiteta sistema
		JPanel tabs = new JPanel();
		tabs.setBackground(Color.lightGray);
		tabs.setLayout(new BorderLayout());
		add(tabs);
		tabs.add(toolbar, BorderLayout.PAGE_START);		
		tabs.add(tabbedPane, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);
		
		tabelaStudenata = new StudentiJTable();

		JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
		//DORADITI
		scrollPane.setPreferredSize(new Dimension(800,800));
		mt.add(scrollPane);
		
		
		this.azurirajPrikaz(null, -1);
		
		
	}
	public void azurirajPrikaz(String akcija, int vrednost) {
		// azuriranje modela tabele, kao i njenog prikaza
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		model.fireTableDataChanged();
		validate();
	}


}
