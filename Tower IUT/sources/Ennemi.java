import java.security.SecureRandom;

/**
 * 
 * @author Groupe 10
 *
 */
public abstract class Ennemi 
{
	private Position positionEnnemi;
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
	public Ennemi(String nom, int vie, int degat, Position posiDepart)
	{
		positionEnnemi = posiDepart;
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
	public Case[] definitionChemin(Case caseDeDepart)
	{
		Case[] chemin;
		CaseAvecParent[] listeCaseTraitee = new CaseAvecParent[900];
		CaseAvecParent[] listeCaseATraitee = new CaseAvecParent[900];
		
		
		
		return chemin;
	}
		
	public CaseAvecParent[] trouverCaseAdjacentes(Case caseParent, Map laMap)
	{
		int indice =0;
		Case[] caseAdjacentes= new Case[8];
		CaseAvecParent[] caseAdjacentesAvecParent= new CaseAvecParent[8]; 
		
		int positionLigneParent=caseParent.obtenirPosiCase().obtenirPositionLigne();
		int positionColonneParent=caseParent.obtenirPosiCase().obtenirPositionColonne();
		
		if (positionColonneParent-1>=0)
		{
			caseAdjacentes[indice]=laMap[positionLigneParent][positionColonneParent-1];
			indice++;
		}
		if (positionColonneParent+1<=29)
		{
			caseAdjacentes[indice]=laMap[positionLigneParent][positionColonneParent+1];
			indice++;
		}
		if (positionLigneParent-1>=0)
		{
			caseAdjacentes[indice]=laMap[positionLigneParent-1][positionColonneParent];
			indice++;
		}
		if (positionLigneParent+1<=29)
		{
			caseAdjacentes[indice]=laMap[positionLigneParent+1][positionColonneParent];
			indice++;
		}
		
		
		if ((positionLigneParent-1>=0) && (positionColonneParent-1>=0))
		{
			caseAdjacentes[indice]=laMap[positionLigneParent-1][positionColonneParent-1];
			indice++;
		}
		if ((positionLigneParent-1>=0) && (positionColonneParent+1<=29))
		{
			caseAdjacentes[indice]=laMap[positionLigneParent+1][positionColonneParent-1];
			indice++;
		}
		if ((positionLigneParent+1<=29) && (positionColonneParent)-1>=0))
		{
			caseAdjacentes[indice]=laMap[positionLigneParent-1][positionColonneParent+1];
			indice++;
		}
		if ((positionLigneParent+1<=29) && (positionColonneParent+1<=29))
		{
			caseAdjacentes[indice]=laMap[positionLigneParent+1][positionColonneParent+1];
			indice++;
		}
		
		
		caseAdjacentes
		
		
	}
	
	
	
	public Position obtenirPosition()
	{
		return this.positionEnnemi;
	}

	public int obtenirVie()
	{
		return this.vie_Ennemi;
	}

	public int obtenirPtDegats()
	{
		return this.pointDegats;
	}
}
