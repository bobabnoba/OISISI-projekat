package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import studenti.view.AbstractTableModelStudenti;
import studenti.view.StudentiJTable;
import view.ATMProfesori;
import view.ProfesoriTable;


public class MainFrame extends JFrame {
	
	//public static int TAB;
	
	private static final long serialVersionUID = 4703527718003660405L;

	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

	private ProfesoriTable profTable;
	JTabbedPane tabbedPane;
	JPanel tabsPanel;
	private JTable tabelaStudenata;

	public MainFrame() {
		super();
		setTitle("Studentska Sluzba");
		setResizable(true);
		
		Toolkit tkit = Toolkit.getDefaultToolkit();	
		Dimension screenSize = tkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4, 3 * screenHeight / 4);		

		setLocationRelativeTo(null);
		
		/*Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenDimension.width / 2, screenDimension.height / 2);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);*/
		
		/*JTabbedPane tabbedPane = new JTabbedPane();

		JPanel mt = new JPanel();
		TableTab mt1 = new TableTab("");
		TableTab mt2 = new TableTab("");
		
		tabbedPane.addTab("Studenti", mt);
		tabbedPane.addTab("Profesori", mt1);
		tabbedPane.addTab("Predmeti", mt2);
		
		tabbedPane.addChangeListener(new ChangeListener() {

	        public void stateChanged(ChangeEvent e) {

	            setTab(tabbedPane.getSelectedIndex());	           
	        }
	    });*/
		
		MenuBar menu = new MenuBar(this);
		Toolbar toolbar = new Toolbar(this);
		StatusBar status = new StatusBar();
		//add(menu, BorderLayout.NORTH);
		this.setJMenuBar(menu);
		
		//TODO: Prikaz entiteta sistema
		tabsPanel = new JPanel();
		tabsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		tabsPanel.setBackground(Color.lightGray);
		tabsPanel.setLayout(new BorderLayout());		
		this.add(tabsPanel, BorderLayout.CENTER);
		this.add(toolbar, BorderLayout.NORTH);		
		this.add(status, BorderLayout.SOUTH);
		
		createTabbedPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*tabelaStudenata = new StudentiJTable();

		JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
		//DORADITI
		scrollPane.setPreferredSize(new Dimension(800,800));
		mt.add(scrollPane);
		
		
		this.azurirajPrikaz(null, -1);
		*/
		
	}
	public void azurirajPrikaz(String akcija, int vrednost) {
		// azuriranje modela tabele, kao i njenog prikaza
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	//public static void setTab(int index) {TAB = index;}
	//public static int getTab() {return TAB;}
	
	
	private void createTabbedPane() {
		tabbedPane = new JTabbedPane();
		
		JScrollPane studentiTab = showStudentiTable();
		JScrollPane profesoriTab = showProfesoriTable();
		JScrollPane predmetiTab = showPredmetiTable();
		
		tabbedPane.add("Studenti", studentiTab);
		tabbedPane.add("Profesori", profesoriTab);
		tabbedPane.add("Predmeti", predmetiTab);
		
		tabsPanel.add(tabbedPane, BorderLayout.CENTER);
		
	}
		
	
	private JScrollPane showStudentiTable() {
		tabelaStudenata = new StudentiJTable();
		JScrollPane sppstud = new JScrollPane(tabelaStudenata);
		sppstud.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.azurirajPrikaz(null, -1);
		return sppstud;
		
		
	}
	
	private JScrollPane showProfesoriTable() {
		profTable = new ProfesoriTable();
		JScrollPane spprof = new JScrollPane(profTable);
		spprof.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.updateViewProf();
		return spprof;
	}
	
	private JScrollPane showPredmetiTable() {
		JScrollPane spppred = new JScrollPane();
		spppred.setBorder(new EmptyBorder(20, 20, 20, 20));
		//this.updateViewPred();
		return spppred;
	}
	
	public void updateViewProf() {
    	ATMProfesori model = (ATMProfesori) profTable.getModel();
    	model.fireTableDataChanged();
    	validate();
    }
	
	public int selectedTab() {
		return tabbedPane.getSelectedIndex();
	}
}
