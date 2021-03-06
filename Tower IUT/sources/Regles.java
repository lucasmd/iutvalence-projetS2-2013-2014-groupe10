import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Regles implements ActionListener {
	/** Règles du jeu. */
	private String texteDesRegles;
	private JFrame fenetre;
	private JDialog fenetreRegles;
	private JLabel regles;
	private JButton ok;

	public Regles() {
		this.texteDesRegles = "Vous devez emp�cher les GEA et les TC d'entrer dans la salle informatique...";
	}
	
	/** Constructeur des règles. */
	public Regles(JFrame parent) {
		this.texteDesRegles = "Vous devez emp�cher les GEA et les TC d'entrer dans la salle informatique...";
		this.fenetre = parent;
	}

	public void afficherReglesIHM() {
		Font police = new Font("Arial", Font.BOLD, 16);
		this.fenetreRegles = new JDialog(fenetre, "Regles", true);
		this.fenetreRegles
				.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.fenetreRegles.setSize(600, 200);
		this.fenetreRegles.setResizable(true);
		fenetreRegles.setLocationRelativeTo(null);
		regles = new JLabel(texteDesRegles, JLabel.CENTER);
		regles.setFont(police);
		this.fenetreRegles.add(regles);
		
		JPanel barreBas = new JPanel();
	    ok = new JButton("Ok");
	    ok.addActionListener(this);
		this.ok.setFont(police);
	    barreBas.add(ok);
	    this.fenetreRegles.add(barreBas, BorderLayout.SOUTH);
		this.fenetreRegles.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			fenetreRegles.dispose();
		}
	}

	/** Retourne les règles du jeu. */
	public String afficherRegles() {
		return texteDesRegles;
	}
}
