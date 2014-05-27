import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * T�che g�rant l'IHM (cr�ation, affichage)
 * 
 */
public class JeuxIHM implements Runnable, ActionListener, KeyListener {
	private JFrame fenetre;
	private JButton Tower1;
	private JButton Tower2;
	private JButton Tower3;
	private JMenuBar barreDeMenu;
	private JMenu towerIUT;
	private JMenuItem JMIscores;
	private JMenuItem JMIregles;
	private JMenuItem JMIoptions;
	private JMenuItem JMIquitter;
	private MenuIHM partie;
	private ActionListener abonnement;
	private BCase bouton;

	public JeuxIHM(MenuIHM p) {
		this.partie = p;
	}

	private void initialiserLInterfaceGraphique() {
		this.fenetre = new JFrame();

		barreDeMenu = new JMenuBar();

		towerIUT = new JMenu("Tower IUT");

		this.JMIscores = new JMenuItem("Scores");
		this.JMIscores.addActionListener(this);
		towerIUT.add(this.JMIscores);

		this.JMIregles = new JMenuItem("Regles");
		this.JMIregles.addActionListener(this);
		towerIUT.add(this.JMIregles);

		this.JMIoptions = new JMenuItem("Options");
		this.JMIoptions.addActionListener(this);
		towerIUT.add(this.JMIoptions);

		this.JMIquitter = new JMenuItem("Quitter");
		this.JMIquitter.addActionListener(this);
		towerIUT.add(this.JMIquitter);

		barreDeMenu.add(towerIUT);

		this.fenetre.setJMenuBar(barreDeMenu);

		Font police = new Font("Arial", Font.BOLD, 16);
		towerIUT.setFont(police);
		JMIscores.setFont(police);
		JMIregles.setFont(police);
		JMIoptions.setFont(police);
		JMIquitter.setFont(police);

		this.fenetre.setTitle("TowerIUT");
		this.fenetre.setSize(1000, 1000);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.Tower1 = new JButton(new ImageIcon("docs/Tower1.png"));
		this.Tower1.addActionListener(this);
		this.Tower2 = new JButton(new ImageIcon("docs/Tower2.png"));
		this.Tower2.addActionListener(this);
		this.Tower3 = new JButton(new ImageIcon("docs/Tower3.png"));
		this.Tower3.addActionListener(this);

		// Instanciation d'un objet JPanel
		JPanel pan2 = new JPanel();
		// D�finition de sa couleur de fond
		pan2.setBackground(Color.WHITE);

		pan2.setLayout(new GridLayout(30, 30));
		for (int i = 0; i < Map.NOMBRE_LIGNE * Map.NOMBRE_COLONNE; i++) {
			//pan2.add(new JButton(new ImageIcon("docs/sol.png")));
			bouton = new BCase(Map.NOMBRE_LIGNE,Map.NOMBRE_COLONNE, abonnement);
			bouton.addActionListener(this);
			pan2.add(bouton);

		}
		// SwingUtilities.windowForComponent(pan2).pack();

		// Instanciation d'un objet JPanel
		JPanel pan3 = new JPanel();
		// D�finition de sa couleur de fond
		pan3.setBackground(Color.GRAY);
		pan3.add(this.Tower1);
		pan3.add(this.Tower2);
		pan3.add(this.Tower3);

		JSplitPane splitPaneBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPaneBas.setBottomComponent(pan3);
		splitPaneBas.setEnabled(false);
		splitPaneBas.setBorder(null);
		splitPaneBas.setResizeWeight(0.1);
		splitPaneBas.setDividerSize(0);

		// Verouillage des dimensions de la fen�tre
		this.fenetre.setResizable(true);

		JSplitPane splitPaneIntermediaire = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT);
		// splitPaneIntermediaire.add(pan2);
		// splitPaneIntermediaire.add(splitPaneBas);

		splitPaneIntermediaire.setTopComponent(pan2);
		splitPaneIntermediaire.setBottomComponent(splitPaneBas);
		splitPaneIntermediaire.setEnabled(false);
		splitPaneIntermediaire.setBorder(null);
		splitPaneIntermediaire.setResizeWeight(0.8);
		splitPaneIntermediaire.setDividerSize(0);

		this.fenetre.setContentPane(splitPaneIntermediaire);
		this.fenetre.setVisible(true);

	}

	public void run() {
		this.initialiserLInterfaceGraphique();
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JMIoptions) {
			partie.options.afficheOptionIHM();
		} else if (e.getSource() == JMIquitter) {
			fenetre.dispose();
		} else if (e.getSource() == JMIscores) {
			partie.scores.afficherScoreIHM();
		} else if (e.getSource() == JMIregles) {
			partie.regles.afficherReglesIHM();
		} else if (e.getSource() == bouton) {
			this.abonnement = this;
			System.out.println(bouton.obtenirLigne()+bouton.obtenirColonne());
		}
	}
}