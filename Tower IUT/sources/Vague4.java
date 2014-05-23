
public class Vague4 extends Vague
{	
	private Ennemi[] tabEnnemiVagueBoss2;
	
	public Vague4()
	{
		for(int indice=0; indice<5; indice++)
		{
			this.tabEnnemiVagueBoss2[indice]=new EnnemiGEA();
		}
		for(int indice=5; indice<15; indice++)
		{
			this.tabEnnemiVagueBoss2[indice]=new EnnemiTC();
		}
		this.tabEnnemiVagueBoss2[15]=new EnnemiBoss2();
	}
}
