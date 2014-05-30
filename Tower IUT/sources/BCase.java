import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/** Bouton du plateau de jeu */
public class BCase extends JButton {
	
	/** position du bouton */
	private Position position;
	
	/** Etat du bouton */
	private Etat etat;
	
	private int ligne;
	private int colonne;
	
	/** Type de tour  */
	private EnumTour typeTour;

	/** Créer un bouton sur le plateau de jeu  */
	public BCase(int numL, int numC, Etat etat, ActionListener abonnement) {
		this.ligne = numL;
		this.colonne = numC;
		this.position = new Position(numL, numC);
		this.etat = etat;
		this.addActionListener(abonnement);
		if(etat == Etat.TOUR){
			setBackground(Color.blue);
		}
		else if(etat == Etat.ENNEMI){
			setBackground(Color.red);
		}
		else if(etat == Etat.CHEMIN){
			setBackground(Color.white);
		}
	}

	/** Permet d'obtenir la position x */
	public int obtenirX() {
		return ligne;
	}

	/** Permet d'obtenir la position y */
	public int obtenirY() {
		return colonne;
	}

	/** Permet d'obtenir la position */
	public Position obtenirPosition() {
		return position;
	}

	/** Permet d'obtenir l'etat */
	public Etat obtenirEtat() {
		return etat;
	}

	/** Permet de placer une tour */
	public void changerEtat(Etat nouvelEtat, EnumTour typeTour) {
		this.typeTour = typeTour;
		this.etat = nouvelEtat;
		if (this.typeTour == EnumTour.petiteTour)
			this.setIcon(new ImageIcon("docs/tower1.png"));
		else if (typeTour == EnumTour.moyenneTour)
			this.setIcon(new ImageIcon("docs/tower2.png"));
		else if (typeTour == EnumTour.grosseTour)
			this.setIcon(new ImageIcon("docs/tower3.png"));
	}
}