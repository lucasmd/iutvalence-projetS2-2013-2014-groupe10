import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BCase extends JButton {
	private Position position;
	private Etat etat;
	private EnumTour typeTour;
	private Ennemi typeEnnemi;
	private int x;
	private int y;

	public BCase(int numL, int numC, Etat etat, ActionListener abonnement) {
		x = numL;
		y = numC;
		this.position = new Position(numL,numC);
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

	public int obtenirX(){
		return x;
	}
	
	public int obtenirY(){
		return y;
	}
	
	public Position obtenirPosition()
	 {
		 return position;
	 }
	
	public Etat obtenirEtat(){
		return etat;
	}
	
	public void changerEtat(Etat nouvelEtat, EnumTour typeTour)
	{
		this.typeTour = typeTour;
		this.etat = nouvelEtat;
		if(typeTour == EnumTour.petiteTour)
			this.setIcon(new ImageIcon("docs/tower1.png"));
		else if(typeTour == EnumTour.moyenneTour)
			this.setIcon(new ImageIcon("docs/tower2.png"));
		else if(typeTour == EnumTour.grosseTour)
			this.setIcon(new ImageIcon("docs/tower3.png"));
	}
	
	public void changerEtat(Etat nouvelEtat, Ennemi typeEnnemi)
	{
		this.typeEnnemi = typeEnnemi;
		this.etat = nouvelEtat;
		if(typeEnnemi.obtenirNomEnnemi() == "gea")
			this.setIcon(new ImageIcon("docs/gea.png"));
		if(typeEnnemi.obtenirNomEnnemi() == "tc")
			this.setIcon(new ImageIcon("docs/tc.png"));
		if(typeEnnemi.obtenirNomEnnemi() == "boss1")
			this.setIcon(new ImageIcon("docs/boss1.png"));
		if(typeEnnemi.obtenirNomEnnemi() == "boss2")
			this.setIcon(new ImageIcon("docs/boss2.png"));
	}
}