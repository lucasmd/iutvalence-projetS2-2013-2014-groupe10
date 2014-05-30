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
 * Création de la classe permettant d'afficher la JFrame ou se trouve la grille de jeu 
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
	private JLabel pseudo;
	private JRadioButton niv1Button;
	private JRadioButton niv2Button;
	private JRadioButton niv3Button;
	private JTextField pseudochoix;
	private EnumTour typeTour = EnumTour.petiteTour;
	private Joueur joueur1;
	private JButton lancerVague;
	int nbTour=0;
	private JLabel argent;
	protected Partie partie;
	private Tour tour;
	protected JPanel plateauJeu;

	public JeuxIHM(MenuIHM p) {
		this.initial = p;
	}

	private void initialiserLInterfaceGraphique() {
		/** Fenetre de jeu */
		this.fenetre = new JFrame();
		this.fenetre.setTitle("TowerIUT");
		this.fenetre.setSize(1000, 1000);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setResizable(true);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		/** Barre de menu */
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

		/** Plateau du jeu */
		plateauJeu = new JPanel();
		plateauJeu.setBackground(Color.WHITE);
		plateauJeu.setLayout(new GridLayout(30, 30));
		
		for (int i = 0; i < Map.NOMBRE_LIGNE; i++) {
			for (int j = 0; j < Map.NOMBRE_COLONNE; j++) {
				plateauJeu.add(new BCase(i, j, partie.carteDeLaPartie.map[i][j].obtenirCaseEtat(), this));
			}
		}
		
		/** Barre de jeu */
		JPanel barreJeu = new JPanel();
		barreJeu.setBackground(Color.GRAY);
		this.Tower1 = new JButton(new ImageIcon("docs/Tower1.png"));
		this.Tower1.addActionListener(this);
		this.Tower2 = new JButton(new ImageIcon("docs/Tower2.png"));
		this.Tower2.addActionListener(this);
		this.Tower3 = new JButton(new ImageIcon("docs/Tower3.png"));
		this.Tower3.addActionListener(this);
		barreJeu.add(new JLabel("$"+Tour.PRIX_PETITE_TOUR));
		barreJeu.add(this.Tower1);
		barreJeu.add(new JLabel("$"+Tour.PRIX_MOYENNE_TOUR));
		barreJeu.add(this.Tower2);
		barreJeu.add(new JLabel("$"+Tour.PRIX_GRANDE_TOUR));
		barreJeu.add(this.Tower3);
		argent = new JLabel("Argent : "+this.joueur1.obtenirQtArgent()+"$");
		barreJeu.add(argent);
		this.lancerVague = new JButton("Lancer une vague");
		this.lancerVague.addActionListener(this);
		barreJeu.add(this.lancerVague);
		
		/** Jeu complet */
		JSplitPane complet = new JSplitPane(JSplitPane.VERTICAL_SPLIT, plateauJeu, barreJeu);
		complet.setResizeWeight(0.9);
	    complet.setDividerSize(0);
	    complet.setEnabled(false);
		complet.setBorder(null);
		this.fenetre.add(complet);
		
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

		this.pseudo = new JLabel("Pseudo");
		pseudo.setFont(police);
		JPanel panneauChoixDuPseudo = new JPanel();
		panneauChoixDuPseudo.add(pseudo);
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
		} else if (e.getSource() == lancerVague){
			partie.lancerUnTourIHM(nbTour,this);
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
			partie = new Partie(joueur, niveauChoisi, initial.scores);
			this.initialiserLInterfaceGraphique();
			fenetreNiveauEtPseudo.dispose();
			initial.fenetre.dispose();
		} else if (e.getSource() == annuler) {
			fenetreNiveauEtPseudo.dispose();
		} else {
			BCase bcase = (BCase) e.getSource();
			if (bcase.obtenirEtat() == Etat.VIDE) {
				try{
					partie.listeTour.add(new Tour(typeTour, partie.carteDeLaPartie.map[bcase.obtenirX()][bcase.obtenirY()], joueur1, partie.carteDeLaPartie));
				}
				catch(CasePleineException err){
					System.err.println("Position occupÃ©");
				} catch (ArgentInsuffisant err) {
					System.err.println("Argent insufisant");
				}
				bcase.changerEtat(Etat.TOUR, typeTour);
				argent.setText("Argent : "+this.joueur1.obtenirQtArgent()+"$");
			}
		}
	}
}
