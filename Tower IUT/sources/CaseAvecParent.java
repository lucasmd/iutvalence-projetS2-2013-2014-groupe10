
public class CaseAvecParent extends Case
{
	private Case caseParent;
	private Position posiCase;	
	private Etat etatCase;
	private int coutDAcces;
	
	public CaseAvecParent(int posiCaseLigne, int posiCaseColonne, Case casep, int cout)
	{
		super(posiCaseLigne,posiCaseColonne);
		caseParent=casep;
		coutDAcces=cout;
	}
}
