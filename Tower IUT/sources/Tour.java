/**
 * D�finition d'une tour
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
			this.taille=1;//� d�cider
			this.perimettreAttaque=3;//� d�cider
			this.prix=5;//� d�cider
			this.puissanceAttaque=3;//� d�cider
			this.pointDegats=5;//� d�cider
		}
		else if (typeTour==moyenneTour){
			this.taille=1;//� d�cider
			this.perimettreAttaque=4;//� d�cider
			this.prix=10;//� d�cider
			this.puissanceAttaque=2;//� d�cider
			this.pointDegats=10;//� d�cider
		}
		else if (typeTour==grosseTour){
			this.taille=1;//� d�cider
			this.perimettreAttaque=6;//� d�cider
			this.prix=20;//� d�cider
			this.puissanceAttaque=1;//� d�cider
			this.pointDegats=20;//� d�cider
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
