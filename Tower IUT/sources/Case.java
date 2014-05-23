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
	
	public void changerPosiEtat(Etat nouvelEtat)
	{
		this.etatCase=nouvelEtat;
	}
	
	public Etat obtenirCaseEtat() 
	{
		return this.etatCase;
	}
	
	 public String toString() 
	 {
	    return("|"+this.etatCase+"|");
	 }
	 public Position obtenirPosiCase()
	 {
		 return this.posiCase;
	 }
	 
	 public ArrayList<Case> trouverCaseAdjacentes()
		{
			ArrayList<Case> caseAdjacentes= new ArrayList<Case>(); 
			
			int positionLigneParent=this.obtenirPosiCase().obtenirPositionLigne();
			int positionColonneParent=this.obtenirPosiCase().obtenirPositionColonne();

			
			if (positionColonneParent-1>=0)
			{
					caseAdjacentes.add(new Case(positionLigneParent, positionColonneParent-1));
				
				if (positionLigneParent-1>=0)
					caseAdjacentes.add(new Case(positionLigneParent-1, positionColonneParent-1));
				if (positionLigneParent+1<=29)
					caseAdjacentes.add(new Case(positionLigneParent+1, positionColonneParent-1));
			}
				
			if (positionColonneParent+1<=29)
			{	
				caseAdjacentes.add(new Case(positionLigneParent, positionColonneParent+1));
				if (positionLigneParent+1<=29)
					caseAdjacentes.add(new Case(positionLigneParent+1, positionColonneParent+1));
				
				if(positionLigneParent-1>=0)
					caseAdjacentes.add(new Case(positionLigneParent-1, positionColonneParent+1 ));
			}
			
			if (positionLigneParent-1>=0)
				caseAdjacentes.add(new Case(positionLigneParent-1, positionColonneParent ));

			if (positionLigneParent+1<=29)
				caseAdjacentes.add(new Case(positionLigneParent+1, positionColonneParent ));
			
			return caseAdjacentes;
		}
	 
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
