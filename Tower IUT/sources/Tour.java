/**
 * Définition d'une tour
 * 
 * @author prinsacn
 * 
 */

public class Tour
{

	private int perimettreAttaque;
	private int prix;
	private int puissanceAttaque;
	private int pointDeVie;
	private EnumTour typeTour;
	private Case positionTour;

	private final static int PERIMETRE_PETITE_TOUR = 2;
	private final static int PRIX_PETITE_TOUR = 5;
	private final static int PUISSANCE_ATTAQUE_PETITE_TOUR = 2;
	private final static int POINT_DE_VIE_PETITE_TOUR = 5;

	private final static int PERIMETRE_MOYENNE_TOUR = 4;
	private final static int PRIX_MOYENNE_TOUR = 10;
	private final static int PUISSANCE_ATTAQUE_MOYENNE_TOUR = 5;
	private final static int POINT_DE_VIE_MOYENNE_TOUR = 10;

	private final static int PERIMETRE_GRANDE_TOUR = 4;
	private final static int PRIX_GRANDE_TOUR = 25;
	private final static int PUISSANCE_ATTAQUE_GRANDE_TOUR = 15;
	private final static int POINT_DE_VIE_GRANDE_TOUR = 15;

	/**
	 * Permet de creer une nouvelle tour
	 * @param typeTour Type de la tour à creer (Petite, Moyenne ou grande)
	 * @param positionTour position où l'on souhaite creer la tour
	 * @throws CasePleineException si la case est pleine on ne peut pas creer de tour
	 */
	public Tour(EnumTour typeTour, Case positionTour)
			throws CasePleineException
	{
		if (positionTour.obtenirCaseEtat() == Etat.VIDE)
		{

			if (typeTour == EnumTour.petiteTour)
			{
				this.positionTour = positionTour;
				this.perimettreAttaque = PERIMETRE_PETITE_TOUR;
				this.prix = PRIX_PETITE_TOUR;
				this.puissanceAttaque = PUISSANCE_ATTAQUE_PETITE_TOUR;
				this.pointDeVie = POINT_DE_VIE_PETITE_TOUR;
			}
			else if (typeTour == EnumTour.moyenneTour)
			{
				this.positionTour = positionTour;
				this.perimettreAttaque = PERIMETRE_MOYENNE_TOUR;
				this.prix = PRIX_MOYENNE_TOUR;
				this.puissanceAttaque = PUISSANCE_ATTAQUE_MOYENNE_TOUR;
				this.pointDeVie = POINT_DE_VIE_PETITE_TOUR;
			}
			else if (typeTour == EnumTour.grosseTour)
			{
				this.positionTour = positionTour;
				this.perimettreAttaque = PERIMETRE_GRANDE_TOUR;
				this.prix = PRIX_GRANDE_TOUR;
				this.puissanceAttaque = PUISSANCE_ATTAQUE_GRANDE_TOUR;
				this.pointDeVie = POINT_DE_VIE_GRANDE_TOUR;
			}
		}
		else
			throw new CasePleineException();
	}

	
	public void suppressionTour()
	{
		this.positionTour.changerPosiEtat(Etat.VIDE);
		/**TODO Comment supprimer ma tour ?*/
		//this.finalize();
	}

	public void attaquer()
	{
		

	}

}
