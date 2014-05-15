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
	 
}