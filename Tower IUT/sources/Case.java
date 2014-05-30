import java.util.ArrayList;

public class Case {
	/** État de la case. */
	
	private Position posiCase;
	
	private Etat etatCase;

	/** Constructeur de case. */
	public Case(int posiCaseLigne, int posiCaseColonne) 
	{
		this.etatCase = Etat.VIDE;
		this.posiCase= new Position(posiCaseLigne,posiCaseColonne);
	}
	
	/**
	 * Permet de changer l'etat d'une case
	 * @param nouvelEtat
	 */
	public void changerPosiEtat(Etat nouvelEtat)
	{
		this.etatCase=nouvelEtat;
	}
	/**
	 * Accesseur de l'etat de la case
	 * @return
	 */
	public Etat obtenirCaseEtat() 
	{
		return this.etatCase;
	}
	/**
	 * Representation textuel de la case
	 */
	 public String toString() 
	 {
	    return("|"+this.etatCase+"|");
	 }
	 /**
	  * Accesseur de la position de la case
	  * @return
	  */
	 public Position obtenirPosiCase()
	 {
		 return this.posiCase;
	 }
	 
	 /**
	  * Donne les cases adjacentes d'une tour
	  * @param nombreDeCaseAdjacentes
	  * @param cartePartie
	  * @return
	  */
	 public ArrayList<Case> trouverCaseAdjacentes(int nombreDeCaseAdjacentes, Map cartePartie)
		{
			ArrayList<Case> caseAdjacentes= new ArrayList<Case>(); 
			
			int positionLigneParent=this.obtenirPosiCase().obtenirPositionLigne();
			int positionColonneParent=this.obtenirPosiCase().obtenirPositionColonne();
			
			int longueurMaxLigne=nombreDeCaseAdjacentes*2+1;
			int longueurMaxColonne=nombreDeCaseAdjacentes*2+1;
			
			
			int positionLigneCaseDepart=positionLigneParent-nombreDeCaseAdjacentes;
			int positionColonneCaseDepart=positionColonneParent-nombreDeCaseAdjacentes;
			
			
			

			for (int indiceLigne=0; indiceLigne<longueurMaxLigne; indiceLigne++)
			{
				for (int indiceColonne=0; indiceColonne<longueurMaxColonne; indiceColonne++)
				{
					if(((positionLigneCaseDepart+indiceLigne)>=0)&&((positionLigneCaseDepart+indiceLigne)<=Map.NOMBRE_LIGNE-1))
					{
						if(((positionColonneCaseDepart+indiceColonne)>=0)&&((positionColonneCaseDepart+indiceColonne)<=Map.NOMBRE_COLONNE-1))
						{
							caseAdjacentes.add(cartePartie.map[positionLigneCaseDepart+indiceLigne][positionColonneCaseDepart+indiceColonne]);
						}
					}
				}
			}
			//caseAdjacentes.remove(new Case(positionLigneParent,positionColonneParent));
			
			return caseAdjacentes;
		}
}
