import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
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
	private JDialog fenetreNiveauEtPseudo;
	private JButton Tower1;
	private JButton Tower2;
	private JButton Tower3;
	private JMenuBar barreDeMenu;
	private JMenu towerIUT;
	private JMenuItem JMIscores;
	private JMenuItem JMIregles;
	private JMenuItem JMIoptions;
	private JMenuItem JMIquitter;
	private MenuIHM initial;
	private JButton valider;
	private JButton annuler;
	private JLabel Pseudo;
	private JRadioButton niv1Button;
	private JRadioButton niv2Button;
	private JRadioButton niv3Button;
	private JTextField pseudochoix;
	private EnumTour typeTour = EnumTour.petiteTour;
	private Joueur joueur1;

	public JeuxIHM(MenuIHM p) {
		this.initial = p;
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
		this.fenetre.setSize(740, 1000);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.Tower1 = new JButton(new ImageIcon("docs/Tower1.png"));
		this.Tower1.addActionListener(this);
		this.Tower2 = new JButton(new ImageIcon("docs/Tower2.png"));
		this.Tower2.addActionListener(this);
		this.Tower3 = new JButton(new ImageIcon("docs/Tower3.png"));
		this.Tower3.addActionListener(this);
		
		JPanel pan2 = new JPanel();
		pan2.setBackground(Color.WHITE);
		pan2.setLayout(new GridLayout(30, 30));

		for (int i = 0; i < Map.NOMBRE_LIGNE; i++) {
			for (int j = 0; j < Map.NOMBRE_COLONNE; j++) {
				if((i==0) && (j == 14)){
					pan2.add(new BCase(i, j));
				}
				else if((i == 29) && (j == 14)){
					pan2.add(new BCase(i, j));
				}
				else {
					pan2.add(new BCase(i, j, this));
				}
			}
		}

		JPanel pan3 = new JPanel();
		pan3.setBackground(Color.GRAY);
		pan3.add(new JLabel("$"+Tour.PRIX_PETITE_TOUR));
		pan3.add(this.Tower1);
		pan3.add(new JLabel("$"+Tour.PRIX_MOYENNE_TOUR));
		pan3.add(this.Tower2);
		pan3.add(new JLabel("$"+Tour.PRIX_GRANDE_TOUR));
		pan3.add(this.Tower3);
		
		pan3.add(new JLabel("Argent : "+this.joueur1.obtenirQtArgent()));
		
		
		JSplitPane splitPaneBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPaneBas.setBottomComponent(pan3);
		splitPaneBas.setEnabled(false);
		splitPaneBas.setBorder(null);
		splitPaneBas.setResizeWeight(0.3);
		splitPaneBas.setDividerSize(0);
		

		this.fenetre.setResizable(true);

		JSplitPane splitPaneIntermediaire = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		splitPaneIntermediaire.setTopComponent(pan2);
		splitPaneIntermediaire.setBottomComponent(splitPaneBas);
		splitPaneIntermediaire.setEnabled(false);
		splitPaneIntermediaire.setBorder(null);
		splitPaneIntermediaire.setResizeWeight(0.8);
		splitPaneIntermediaire.setDividerSize(0);

		this.fenetre.setContentPane(splitPaneIntermediaire);
		this.fenetre.setVisible(true);


		

	}

	private void demandePseudoNiveau() {
		Font police = new Font("Arial", Font.BOLD, 16);
		
		niv1Button = new JRadioButton("Niveau 1");
		niv1Button.setMnemonic(KeyEvent.VK_B);
		niv1Button.setFont(police);
		niv1Button.setActionCommand("Niveau 1");
		niv1Button.setSelected(true);

		niv2Button = new JRadioButton("Niveau 2");
		niv2Button.setMnemonic(KeyEvent.VK_C);
		niv2Button.setFont(police);
		niv2Button.setActionCommand("Niveau 2");

		niv3Button = new JRadioButton("Niveau 3");
		niv3Button.setMnemonic(KeyEvent.VK_D);
		niv3Button.setFont(police);
		niv3Button.setActionCommand("Niveau 3");

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(niv1Button);
		group.add(niv2Button);
		group.add(niv3Button);

		// Register a listener for the radio buttons.
		niv1Button.addActionListener(this);
		niv2Button.addActionListener(this);
		niv3Button.addActionListener(this);

		pseudochoix = new JTextField();
		pseudochoix.setFont(police);
		pseudochoix.setPreferredSize(new Dimension(100, 30));

		
		
		JPanel panneauChoixDuNiveau = new JPanel();
		panneauChoixDuNiveau.add(niv1Button);
		panneauChoixDuNiveau.add(niv2Button);
		panneauChoixDuNiveau.add(niv3Button);

		this.Pseudo = new JLabel("Pseudo");

		JPanel panneauChoixDuPseudo = new JPanel();
		panneauChoixDuPseudo.add(Pseudo);
		panneauChoixDuPseudo.add(pseudochoix);

		JSplitPane ChoixDuNiveauEtPseudo = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT);
		ChoixDuNiveauEtPseudo.setBottomComponent(panneauChoixDuPseudo);
		ChoixDuNiveauEtPseudo.setTopComponent(panneauChoixDuNiveau);
		ChoixDuNiveauEtPseudo.setEnabled(false);
		ChoixDuNiveauEtPseudo.setBorder(null);
		ChoixDuNiveauEtPseudo.setResizeWeight(0.5);
		ChoixDuNiveauEtPseudo.setDividerSize(0);

		this.fenetreNiveauEtPseudo = new JDialog(fenetre,"Choix du niveau et du pseudo", true);
		this.fenetreNiveauEtPseudo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.fenetreNiveauEtPseudo.setSize(600, 500);
		this.fenetreNiveauEtPseudo.setResizable(true);
		this.fenetreNiveauEtPseudo.setLocationRelativeTo(null);
		this.fenetreNiveauEtPseudo.add(ChoixDuNiveauEtPseudo);
		
		
		
		JPanel barreBas = new JPanel();
		valider = new JButton("Valider");
		valider.setFont(police);
		valider.addActionListener(this);
		this.valider.setFont(police);
		annuler = new JButton("Annuler");
		annuler.setFont(police);
		annuler.addActionListener(this);
		this.annuler.setFont(police);
		barreBas.add(valider);
		barreBas.add(annuler);
		this.fenetreNiveauEtPseudo.add(barreBas, BorderLayout.SOUTH);
		this.fenetreNiveauEtPseudo.setVisible(true);
	}
	
	public void run() {
		this.demandePseudoNiveau();
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JMIoptions) {
			initial.options.afficheOptionIHM();
		} else if (e.getSource() == JMIquitter) {
			fenetre.dispose();
		} else if (e.getSource() == JMIscores) {
			initial.scores.afficherScoreIHM();
		} else if (e.getSource() == JMIregles) {
			initial.regles.afficherReglesIHM();
		} else if (e.getSource() == Tower1) {
			this.typeTour = EnumTour.petiteTour;
		} else if (e.getSource() == Tower2) {
			this.typeTour = EnumTour.moyenneTour;
		} else if (e.getSource() == Tower3) {
			this.typeTour = EnumTour.grosseTour;
		}

		else if (e.getSource() == valider) {
			int niveauChoisi = 1;
			boolean choix1 = niv1Button.isSelected();
			if (choix1 == true) {
				niveauChoisi = 1;
			}
			boolean choix2 = niv2Button.isSelected();
			if (choix2 == true) {
				niveauChoisi = 2;
			}
			boolean choix3 = niv3Button.isSelected();
			if (choix3 == true) {
				niveauChoisi = 3;
			}

			String pseudoJoueur = this.pseudochoix.getText().toString();
			Joueur joueur = new Joueur(pseudoJoueur);
			this.joueur1 = joueur;
			/**TODO il faut ajouter en parametre le tableau des scores, mais comment l'avoir dans cette IHM ? (Max)*/
			
			Partie partie = new Partie(joueur, niveauChoisi, initial.scores);
			this.initialiserLInterfaceGraphique();
			fenetreNiveauEtPseudo.dispose();

		} else if (e.getSource() == annuler) {
			fenetreNiveauEtPseudo.dispose();
		} else {
			BCase bcase = (BCase) e.getSource();
			if (bcase.obtenirType() == null) {
				bcase.poserTour(typeTour, joueur1);
			}
		}
	}
}
