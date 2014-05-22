import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * 
 * @author Groupe 10
 *
 */
public abstract class Ennemi 
{
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
	
	public void avancer(ArrayList<Case> cheminDefini, Map mapPartie)
	{
		
		this.caseEnnemi.changerPosiEtat(Etat.VIDE);

		int caseEnnemiPositionLigne=this.caseEnnemi.obtenirPosiCase().obtenirPositionLigne();
		int caseEnnemiPositionColonne=this.caseEnnemi.obtenirPosiCase().obtenirPositionColonne();
		mapPartie.map[caseEnnemiPositionLigne][caseEnnemiPositionColonne].changerPosiEtat(Etat.VIDE);
		
		for(int indice=0; indice<cheminDefini.size(); indice++)
		{
			if((cheminDefini.get(indice).obtenirPosiCase().obtenirPositionLigne()==caseEnnemiPositionLigne)&&(cheminDefini.get(indice).obtenirPosiCase().obtenirPositionColonne()==caseEnnemiPositionColonne))
			{
				if (indice-1>=0)
				{
					caseEnnemiPositionLigne=cheminDefini.get(indice-1).obtenirPosiCase().obtenirPositionLigne();
					caseEnnemiPositionColonne=cheminDefini.get(indice-1).obtenirPosiCase().obtenirPositionColonne();
					mapPartie.map[caseEnnemiPositionLigne][caseEnnemiPositionColonne].changerPosiEtat(Etat.ENNEMI);
					this.changerCaseEnnemi(cheminDefini.get(indice-1));
					break;
				}
				
			}
			
		}
		
		
	}
	
	
}
