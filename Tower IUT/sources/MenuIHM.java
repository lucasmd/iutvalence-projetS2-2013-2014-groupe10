import java.awt.Font;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Tâche gérant l'IHM (création, affichage)
 * 
 */
public class MenuIHM implements Runnable, ActionListener, KeyListener {
	protected JFrame fenetre;
	private JButton Jouer;
	private JButton Options;
	private JButton Scores;
	private JButton Quitter;
	private JButton Regles;
	protected TableScore scores;
	protected Option options;
	protected Regles regles;

	private void initialiserLInterfaceGraphique() {
		this.fenetre = new JFrame();
		Font police = new Font("Arial", Font.BOLD, 16);

		this.Options = new JButton("Options");
		this.Options.addActionListener(this);
		Options.setFont(police);

		this.Quitter = new JButton("Quitter");
		this.Quitter.addActionListener(this);
		Quitter.setFont(police);
		
		//Initialisation de boutons

		this.Jouer = new JButton("Jouer");
		this.Jouer.addActionListener(this);
		Jouer.setFont(police);

		this.Scores = new JButton("Scores");
		this.Scores.addActionListener(this);
		Scores.setFont(police);

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
		fenetre.add(this.Scores);
		fenetre.add(this.Regles);
		fenetre.add(this.Options);
		fenetre.add(this.Quitter);

		// Verouillage des dimensions de la fenêtre
		this.fenetre.setResizable(true);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);

	}

	public void run() {
		regles = new Regles(fenetre);
		scores = new TableScore(fenetre);
		options = new Option(fenetre);
		this.initialiserLInterfaceGraphique();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Jouer) {
			SwingUtilities.invokeLater(new JeuxIHM(this));
		} else if (e.getSource() == Regles) {
			regles.afficherReglesIHM();

		} else if (e.getSource() == Scores) {
			scores.afficherScoreIHM();

		} else if (e.getSource() == Options) {
			options.afficheOptionIHM();

		} else if (e.getSource() == Quitter) {
			fenetre.dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
