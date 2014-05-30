import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BCase extends JButton {
	private int ligne;
	private int colonne;
	private Etat etat;
	private EnumTour typeTour;
	private Ennemi typeEnnemi;

	public BCase(int numL, int numC, Etat etat, ActionListener abonnement) {
		this.ligne = numL;
		this.colonne = numC;
		this.etat = etat;
		this.addActionListener(abonnement);
		if(etat == Etat.TOUR){
			this.setBackground(Color.red);
		}
		else if(etat == Etat.ENNEMI){
			this.setBackground(Color.blue);
		}
		else if(etat == Etat.CHEMIN){
			this.setBackground(Color.white);
		}
	}

	public void poserTour(EnumTour typeTour, Joueur joueur) {
		this.typeTour = typeTour;
		if (typeTour == EnumTour.petiteTour){
			this.setIcon(new ImageIcon("docs/tower1.png"));
			joueur.enleverArgent(Tour.PRIX_PETITE_TOUR);
		}
		else if (typeTour == EnumTour.moyenneTour){
			this.setIcon(new ImageIcon("docs/tower2.png"));
			joueur.enleverArgent(Tour.PRIX_MOYENNE_TOUR);
		}
		else if (typeTour == EnumTour.grosseTour){
			this.setIcon(new ImageIcon("docs/tower3.png"));
			joueur.enleverArgent(Tour.PRIX_GRANDE_TOUR);
		}
		
	}

	public void poserEnnemi(Ennemi typeEnnemi) {
		this.typeEnnemi = typeEnnemi;
	}

	public int obtenirLigne() {
		return ligne;
	}

	public int obtenirColonne() {
		return colonne;
	}
	
	public Etat obtenirEtat(){
		return etat;
	}

	public EnumTour obtenirType(){
		return typeTour;
	}
}