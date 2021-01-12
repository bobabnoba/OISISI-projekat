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
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import view.ATMPredmeti;
import view.ATMProfesori;
import view.AbstractTableModelStudenti;
import view.PredmetiTable;
import view.ProfesoriTable;
import view.StudentiJTable;


public class MainFrame extends JFrame {
		
	private static final long serialVersionUID = 4703527718003660405L;
	
	public static TableRowSorter<AbstractTableModelStudenti> trs ;
	private static MainFrame instance = null;
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public static int rowStud;
	
	public static ProfesoriTable profTable;
	JTabbedPane tabbedPane;
	JPanel tabsPanel;
	public static StudentiJTable tabelaStudenata;
	private PredmetiTable predTable;
	


	public MainFrame() {
		super();
		setTitle("Studentska Služba");
		setResizable(true);
		
		Toolkit tkit = Toolkit.getDefaultToolkit();	
		Dimension screenSize = tkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(3 * screenWidth / 4, 3 * screenHeight / 4);		

		setLocationRelativeTo(null);
		
		
		
		MenuBar menu = new MenuBar(this);
		Toolbar toolbar = new Toolbar(this);
		StatusBar status = new StatusBar();
		this.setJMenuBar(menu);
		
		tabsPanel = new JPanel();
		tabsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		tabsPanel.setBackground(Color.lightGray);
		tabsPanel.setLayout(new BorderLayout());		
		this.add(tabsPanel, BorderLayout.CENTER);
		this.add(toolbar, BorderLayout.NORTH);		
		this.add(status, BorderLayout.SOUTH);
		
		createTabbedPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		rowStud = tabelaStudenata.getSelectedRow();
		
	}
	
	
	
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
		tabelaStudenata.setAutoCreateRowSorter(true);
		JScrollPane sppstud = new JScrollPane(tabelaStudenata);
		sppstud.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.azurirajPrikaz(null, -1);
		return sppstud;
		
		
	}
	
	public  JScrollPane showProfesoriTable() {
		profTable = new ProfesoriTable();
		JScrollPane spprof = new JScrollPane(profTable);
		profTable.setAutoCreateRowSorter(true);

		spprof.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.updateViewProf();
		return spprof;
	}
	
	private JScrollPane showPredmetiTable() {
		predTable = new PredmetiTable();
		JScrollPane spppred = new JScrollPane(predTable);
		spppred.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.updateViewPred();
		return spppred;
	}
	
	public void updateViewProf() {
    	ATMProfesori model = (ATMProfesori) profTable.getModel();
    	model.fireTableDataChanged();
    	validate();
    }
	public void azurirajPrikaz(String akcija, int vrednost) {
		// azuriranje modela tabele, kao i njenog prikaza
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		model.fireTableDataChanged();
		trs = new TableRowSorter<AbstractTableModelStudenti>(model);
		validate();
	}
	
	public void updateViewPred() {
		ATMPredmeti model = (ATMPredmeti) predTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public int selectedTab() {
		return tabbedPane.getSelectedIndex();
	}
	
	public int selectedProf() {
		return profTable.convertRowIndexToModel(profTable.getSelectedRow());
	}
	
	public int selectedPred() {
		return predTable.convertRowIndexToModel(predTable.getSelectedRow());
	}
	
	public int selectedStud() {
		return tabelaStudenata.convertRowIndexToModel(tabelaStudenata.getSelectedRow());
	}
	
	public boolean indexCheckStud() {
		return tabelaStudenata.getSelectionModel().isSelectionEmpty();
	}
	
	public boolean indexCheckProf() {
		return profTable.getSelectionModel().isSelectionEmpty();
	}
	
	public boolean indexCheckPred() {
		return predTable.getSelectionModel().isSelectionEmpty();
	}
	
}