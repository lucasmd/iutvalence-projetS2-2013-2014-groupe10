/**
 * Définition d'une tour
 * 
 * @author prinsacn
 * 
 */

public class Tour {

	private int taille;
	private int perimettreAttaque;
	private int prix;
	private int puissanceAttaque;
	private int pointDegats;
	private EnumTour petiteTour;
	private EnumTour moyenneTour;
	private EnumTour grosseTour;
	private int positionLigne;
	private int positionColonne;

	public Tour(EnumTour typeTour)
	{
		if (typeTour==petiteTour){
			this.taille=;//à décider
			this.perimettreAttaque=;//à décider
			this.prix=;//à décider
			this.puissanceAttaque=;//à décider
			this.pointDegats=;//à décider
		}
		else if (typeTour==moyenneTour){
			this.taille=;//à décider
			this.perimettreAttaque=;//à décider
			this.prix=;//à décider
			this.puissanceAttaque=;//à décider
			this.pointDegats=;//à décider
		}
		else if (typeTour==grosseTour){
			this.taille=;//à décider
			this.perimettreAttaque=;//à décider
			this.prix=;//à décider
			this.puissanceAttaque=;//à décider
			this.pointDegats=;//à décider
		}
	}

	public void poserTour() {
		if (Case.obtenirContenu() == false) {
			Case.casePleine = true;
		}
	}

	public void suppressionTour() {
		if (Case.obtenirContenu() == true) {
			Case.casePleine = false;
		}
	}

	public void attaquer() {

	}

	public void creerTour(EnumTour typeTour) {
		
	}

}
