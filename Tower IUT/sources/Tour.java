import java.util.ArrayList;

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
	private EnumTour typeTour;
	private Case caseTour;

	private final static int PERIMETRE_PETITE_TOUR = 1;
	public final static int PRIX_PETITE_TOUR = 5;
	private final static int PUISSANCE_ATTAQUE_PETITE_TOUR = 2;

	private final static int PERIMETRE_MOYENNE_TOUR = 4;
	public final static int PRIX_MOYENNE_TOUR = 10;
	private final static int PUISSANCE_ATTAQUE_MOYENNE_TOUR = 5;

	private final static int PERIMETRE_GRANDE_TOUR = 4;
	public final static int PRIX_GRANDE_TOUR = 25;
	private final static int PUISSANCE_ATTAQUE_GRANDE_TOUR = 15;


	/**
	 * Permet de creer une nouvelle tour
	 * @param typeTour typeTour Type de la tour Ã  creer (Petite, Moyenne ou grande)
	 * @param positionTour position où l'on souhaite creer la tour
	 * @param joueur Joueur de la partie qui créer la Tour
	 * @param carte Carte où l'on veut creer la tour
	 * @throws CasePleineException si la case n'est pas VIDE on ne peut pas creer de tour
	 * @throws ArgentInsuffisant si le joueur n'a pas assez d'argent il ne peut creer la tour
	 */
	public Tour(EnumTour typeTour, Case positionTour, Joueur joueur, Map carte)
			throws CasePleineException, ArgentInsuffisant
	{ 
		if (positionTour.obtenirCaseEtat() == Etat.VIDE)
		{
		carte.map[positionTour.obtenirPosiCase().obtenirPositionLigne()][positionTour.obtenirPosiCase().obtenirPositionColonne()].changerPosiEtat(Etat.TOUR);
		

			if (typeTour == EnumTour.petiteTour)
			{
				if (joueur.obtenirQtArgent()>=PRIX_PETITE_TOUR)
				{
				this.caseTour = positionTour;
				this.perimettreAttaque = PERIMETRE_PETITE_TOUR;
				this.prix = PRIX_PETITE_TOUR;
				this.puissanceAttaque = PUISSANCE_ATTAQUE_PETITE_TOUR;
				joueur.enleverArgent(PRIX_PETITE_TOUR);
				
				
				
				}
				else
					throw new ArgentInsuffisant();
			}
			else if (typeTour == EnumTour.moyenneTour)
			{
				if (joueur.obtenirQtArgent()>=PRIX_MOYENNE_TOUR)
				{
				this.caseTour = positionTour;
				this.perimettreAttaque = PERIMETRE_MOYENNE_TOUR;
				this.prix = PRIX_MOYENNE_TOUR;
				this.puissanceAttaque = PUISSANCE_ATTAQUE_MOYENNE_TOUR;
				joueur.enleverArgent(PRIX_MOYENNE_TOUR);
				}
				else
					throw new ArgentInsuffisant();
			}
			else if (typeTour == EnumTour.grosseTour)
			{
				if (joueur.obtenirQtArgent()>=PRIX_GRANDE_TOUR)
				{
				this.caseTour = positionTour;
				this.perimettreAttaque = PERIMETRE_GRANDE_TOUR;
				this.prix = PRIX_GRANDE_TOUR;
				this.puissanceAttaque = PUISSANCE_ATTAQUE_GRANDE_TOUR;
				joueur.enleverArgent(PRIX_GRANDE_TOUR);
				}
				else
					throw new ArgentInsuffisant();
			}
			
			
			
		}
		else
			throw new CasePleineException();
	}

	
	/**
	 * Permet à la tour d'attaquer tous les ennemis dans sont perimetre
	 * @param tabEnnemi un tableau d'ennemis positioné sur la carte
	 * @param mapDePartie carte de la partie
	 * @param joueur Joueur de la partie
	 */
	public void attaquer(ArrayList<Ennemi> tabEnnemi, Map mapDePartie, Joueur joueur)
	{
		ArrayList<Case> listeCaseAction=this.caseTour.trouverCaseAdjacentes(this.perimettreAttaque,mapDePartie);
		for (int indice=0; indice<listeCaseAction.size(); indice++)
		{
			if(listeCaseAction.get(indice).obtenirCaseEtat()==Etat.ENNEMI)
			{
				for(int index=0; index<tabEnnemi.size(); index++)
				{
					if(listeCaseAction.get(indice).obtenirPosiCase()==tabEnnemi.get(index).obtenirCase().obtenirPosiCase())
					{
						tabEnnemi.get(index).perdreVie(this.puissanceAttaque);
						tabEnnemi.get(index).testMortEnnemie(mapDePartie, tabEnnemi, joueur );
					}
				}
			}
		}
		

	}

}
