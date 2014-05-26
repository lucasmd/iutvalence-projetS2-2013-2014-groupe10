import java.util.ArrayList;


public class CaseAvecParent extends Case
{
	private Case caseDepart;
	private CaseAvecParent caseParent;
	private Position posiCase;	
	private Etat etatCase;
	private int coutDAcces;
	private int coutDArrivee;
	
	public CaseAvecParent(int posiCaseLigne, int posiCaseColonne, Case casep, int cout, int couta)
	{
		super(posiCaseLigne,posiCaseColonne);
		caseDepart=casep;
		coutDAcces=cout;
		coutDArrivee= couta;
	}
	
	public CaseAvecParent(int posiCaseLigne, int posiCaseColonne, CaseAvecParent casep, int cout, int couta)
	{
		super(posiCaseLigne,posiCaseColonne);
		caseParent=casep;
		coutDAcces=cout;
		coutDArrivee= couta;
	}
	
	public int obtenirCoutDAcces()
	{
		return this.coutDAcces;
	}
	
	public int obtenirCoutDArrivee()
	{
		return this.coutDArrivee;
	}
	
	public ArrayList<CaseAvecParent> trouverCaseAdjacentesAvecParent()
	{
		ArrayList<CaseAvecParent> caseAdjacentesAvecParent= new ArrayList<CaseAvecParent>(); 
		
		int positionLigneParent=this.obtenirPosiCase().obtenirPositionLigne();
		int positionColonneParent=this.obtenirPosiCase().obtenirPositionColonne();
		int coutDeCaseParent= this.obtenirCoutDAcces();
		
		if (positionColonneParent-1>=0)
		{
				caseAdjacentesAvecParent.add(new CaseAvecParent(positionLigneParent, positionColonneParent-1, this, 10+coutDeCaseParent,((Math.abs(positionLigneParent-14)+Math.abs(positionColonneParent-1-29)))*10 ));
			
			if (positionLigneParent-1>=0)
				caseAdjacentesAvecParent.add(new CaseAvecParent(positionLigneParent-1, positionColonneParent-1, this, 14+coutDeCaseParent,((Math.abs(positionLigneParent-1-14)+Math.abs(positionColonneParent-1-29)))*10 ));
			if (positionLigneParent+1<=29)
				caseAdjacentesAvecParent.add(new CaseAvecParent(positionLigneParent+1, positionColonneParent-1, this, 14+coutDeCaseParent,((Math.abs(positionLigneParent-1-14)+Math.abs(positionColonneParent-1-29)))*10 ));
		}
			
		if (positionColonneParent+1<=29)
		{	
			caseAdjacentesAvecParent.add(new CaseAvecParent(positionLigneParent, positionColonneParent+1, this, 10+coutDeCaseParent,((Math.abs(positionLigneParent-14)+Math.abs(positionColonneParent+1-29)))*10 ));
			if (positionLigneParent+1<=29)
				caseAdjacentesAvecParent.add(new CaseAvecParent(positionLigneParent+1, positionColonneParent+1, this, 14+coutDeCaseParent,((Math.abs(positionLigneParent+1-14)+Math.abs(positionColonneParent+1-29)))*10 ));
			
			if(positionLigneParent-1>=0)
				caseAdjacentesAvecParent.add(new CaseAvecParent(positionLigneParent-1, positionColonneParent+1, this, 14+coutDeCaseParent,((Math.abs(positionLigneParent-1-14)+Math.abs(positionColonneParent+1-29)))*10 ));
		}
		
		if (positionLigneParent-1>=0)
			caseAdjacentesAvecParent.add(new CaseAvecParent(positionLigneParent-1, positionColonneParent, this, 10+coutDeCaseParent,((Math.abs(positionLigneParent-1-14)+Math.abs(positionColonneParent-29)))*10 ));

		if (positionLigneParent+1<=29)
			caseAdjacentesAvecParent.add(new CaseAvecParent(positionLigneParent+1, positionColonneParent, this, 10+coutDeCaseParent,((Math.abs(positionLigneParent+1-14)+Math.abs(positionColonneParent-29)))*10 ));

			
		
		return caseAdjacentesAvecParent;
	}
	
	public void changerParent(CaseAvecParent nvCaseParent)
	{
		this.caseParent=nvCaseParent;
	}
	
	public Case obtenirParent()
	{
		return this.caseParent;
	}
	
	public CaseAvecParent obtenirParentAvecParent()
	{
		return this.caseParent;
	}
	
	public void changerCoutDAcces(int nouveauCout)
	{
		this.coutDAcces=nouveauCout;
	}
	
	
	public void ajoutDesCarreAdjacent(ArrayList<CaseAvecParent> listeOuverte, Map map)
	{
		ArrayList<CaseAvecParent> listeCarreAdjacent= new ArrayList<CaseAvecParent>();
		int index=0;
		Case parent;
		
		listeCarreAdjacent=this.trouverCaseAdjacentesAvecParent();
		
		for(int indice=0; indice<listeCarreAdjacent.size(); indice++ )
		{
			Case caseDeLaMapTraitee=map.map[listeCarreAdjacent.get(indice).obtenirPosiCase().obtenirPositionLigne()][listeCarreAdjacent.get(indice).obtenirPosiCase().obtenirPositionColonne()];
			if (caseDeLaMapTraitee.obtenirCaseEtat()==Etat.VIDE)
			{
				if (listeOuverte.contains(listeCarreAdjacent.get(indice)))
				{	
					index=listeOuverte.indexOf(listeCarreAdjacent.get(indice));
				
					if (listeCarreAdjacent.get(indice).obtenirCoutDAcces()<listeOuverte.get(index).obtenirCoutDAcces())
					{
						listeCarreAdjacent.get(indice).changerParent(listeOuverte.get(index).obtenirParentAvecParent());
						parent=listeCarreAdjacent.get(indice).obtenirParent();
							if ((listeCarreAdjacent.get(indice).obtenirPosiCase().obtenirPositionLigne()-parent.obtenirPosiCase().obtenirPositionLigne()==0)||(listeCarreAdjacent.get(indice).obtenirPosiCase().obtenirPositionColonne()-parent.obtenirPosiCase().obtenirPositionColonne()==0))
							{
								listeCarreAdjacent.get(indice).changerCoutDAcces(10+((CaseAvecParent) parent).obtenirCoutDAcces());
							}
							else
							{
								listeCarreAdjacent.get(indice).changerCoutDAcces(14+((CaseAvecParent) parent).obtenirCoutDAcces());
							}
					}
					else
					{
						listeOuverte.add(listeOuverte.size(),listeCarreAdjacent.get(indice));
					}
				}
				else
				{
					listeOuverte.add(listeOuverte.size(),listeCarreAdjacent.get(indice));
				}
			}
		}
	}
	
}
