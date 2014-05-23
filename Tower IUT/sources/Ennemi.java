import java.security.SecureRandom;
import java.util.ArrayList;


/**
 * 
 * @author Groupe 10
 *
 */
public abstract class Ennemi 
{
	public final static Position POSITION_DE_FIN=new Position(14,29);
	
	private Case caseEnnemi;
	private String nomEnnemi;
	private int vie_Ennemi;
	private int pointDegats;


	/**
	 * Constructeur ennemi
	 * @param nom
	 * @param vie
	 * @param degat
	 * @param posiDepart
	 */
	public Ennemi(String nom, int vie, int degat, Case caseDepart)
	{
		caseEnnemi = caseDepart;
		nomEnnemi = nom;
		vie_Ennemi = vie;
		pointDegats = degat;
	}
	/**
	 * Methode qui permet d'attaquer une tour
	 * @param tourAttaque
	 */
	public abstract void attaquer(Tour tourAttaque);
	//faire des methode pour obetenir l'etat des position dessous dessus droite gauche
		
	public Case obtenirCase()
	{
		return this.caseEnnemi;
	}
	
	public void changerCaseEnnemi(Case nvCase)
	{
		this.caseEnnemi=nvCase;
	}

	public int obtenirVie()
	{
		return this.vie_Ennemi;
	}

	public int obtenirPtDegats()
	{
		return this.pointDegats;
	}
	
	public void avancer(Map mapPartie)
	{
		
		this.caseEnnemi.changerPosiEtat(Etat.VIDE);

		int caseEnnemiPositionLigne=this.caseEnnemi.obtenirPosiCase().obtenirPositionLigne();
		int caseEnnemiPositionColonne=this.caseEnnemi.obtenirPosiCase().obtenirPositionColonne();
		mapPartie.map[caseEnnemiPositionLigne][caseEnnemiPositionColonne].changerPosiEtat(Etat.VIDE);
		
		for(int indice=0; indice<mapPartie.cheminLePlusCourt.size(); indice++)
		{
			if((mapPartie.cheminLePlusCourt.get(indice).obtenirPosiCase().obtenirPositionLigne()==caseEnnemiPositionLigne)&&(mapPartie.cheminLePlusCourt.get(indice).obtenirPosiCase().obtenirPositionColonne()==caseEnnemiPositionColonne))
			{
				if (indice-1>=0)
				{
					caseEnnemiPositionLigne=mapPartie.cheminLePlusCourt.get(indice-1).obtenirPosiCase().obtenirPositionLigne();
					caseEnnemiPositionColonne=mapPartie.cheminLePlusCourt.get(indice-1).obtenirPosiCase().obtenirPositionColonne();
					mapPartie.map[caseEnnemiPositionLigne][caseEnnemiPositionColonne].changerPosiEtat(Etat.ENNEMI);
					this.changerCaseEnnemi(mapPartie.cheminLePlusCourt.get(indice-1));
					break;
				}				
			}			
		}
	}
	
	public void testVictoireEnnemie(Map carteJeu, Partie partieDonnee)
	{
		if (this.obtenirCase().obtenirPosiCase().obtenirPositionLigne()==14)
		{
			if(this.obtenirCase().obtenirPosiCase().obtenirPositionColonne()==29)
			{
				carteJeu.effacerEnnemi(this);
				partieDonnee.miseAJourDesVies(this.pointDegats);
			}
		}
	}
	
	public void testMortEnnemie(Map carteJeu)
	{
		if (this.vie_Ennemi==0)
			carteJeu.effacerEnnemi(this);
	}
	
	
	/*public void avancerVersFin(Map mapDeJeu, ArrayList<Case> chemin)
	{
		while ((this.obtenirCase().obtenirPosiCase()!=POSITION_DE_FIN))
		{
			this.avancer(mapDeJeu);
			mapDeJeu.afficherEnnemi(this);
			mapDeJeu.afficherMap();
			
		}
	}*/
	
}
