import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Tâche gérant l'IHM (création, affichage)
 * 
 */
public class MenuIHM implements Runnable, ActionListener, KeyListener {
	private JSplitPane splitPaneGauche;
	private JFrame fenetre;
	private JButton Jouer;
	private JButton Redemarrer;
	private JButton Options;
	private JButton Pseudo;
	private JButton Score;
	private JButton Quitter;
	private JButton Regles;
	private JDialog fenetreRegles;
	private JDialog fenetreScores;
	private JLabel texteRegles;
	private JLabel scores;

	private void initialiserLInterfaceGraphique() {
		this.fenetre = new JFrame();
		Font police = new Font("Arial", Font.BOLD, 15);

		this.Options = new JButton("Options");
		this.Options.addActionListener(this);
		Options.setFont(police);

		this.Quitter = new JButton("Quitter");
		this.Quitter.addActionListener(this);
		Quitter.setFont(police);

		this.Jouer = new JButton("Jouer");
		this.Jouer.addActionListener(this);
		Jouer.setFont(police);

		this.Score = new JButton("Score");
		this.Score.addActionListener(this);
		Score.setFont(police);

		this.Regles = new JButton("Regles");
		this.Regles.addActionListener(this);
		Regles.setFont(police);

		this.fenetre.setTitle("Menu TowerIUT");
		this.fenetre.setSize(600, 500);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// Instanciation d'un objet JPanel
		fenetre.setLayout(new GridLayout(5, 1));
		// Définition de sa couleur de fond
		fenetre.add(this.Jouer);
		fenetre.add(this.Score);
		fenetre.add(this.Regles);
		fenetre.add(this.Options);
		fenetre.add(this.Quitter);

		// Verouillage des dimensions de la fenêtre
		this.fenetre.setResizable(true);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);

	}

	public void run() {
		this.initialiserLInterfaceGraphique();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated methhhod stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Font police = new Font("Arial", Font.BOLD, 15);
		if (e.getSource() == Jouer) {
			SwingUtilities.invokeLater(new JeuxIHM());
		} else if (e.getSource() == Regles) {
			
			this.fenetreRegles = new JDialog (fenetre, "Regles", true);
			this.fenetreRegles.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.fenetreRegles.setSize(600, 200);
			this.fenetreRegles.setResizable(true);
			fenetreRegles.setLocationRelativeTo(null);
			Regles r = new Regles();
			texteRegles = new JLabel(r.afficherRegles(),JLabel.CENTER);
			texteRegles.setFont(police);
			this.fenetreRegles.add(texteRegles);
			this.fenetreRegles.setVisible(true);
			
		} else if (e.getSource() == Score) {
			
			this.fenetreScores = new JDialog (fenetre, "Regles", true);
			this.fenetreScores.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.fenetreScores.setSize(500, 400);
			this.fenetreScores.setResizable(true);
			fenetreScores.setLocationRelativeTo(null);
			TableScore score = new TableScore();
			scores = new JLabel(score.afficherScoreIHM(),JLabel.CENTER);
			scores.setFont(police);
			this.fenetreScores.add(scores);
			this.fenetreScores.setVisible(true);
			
		} else if (e.getSource() == Quitter) {
			fenetre.dispose();
		}
	}
}
