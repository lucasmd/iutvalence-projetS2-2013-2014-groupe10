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

	 
}