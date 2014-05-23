
public class Vague3 extends Vague
{
	private Ennemi[] tabEnnemiVagueBoss;
	
	public Vague3()
	{
		for(int indice=0; indice<10; indice++)
		{
			this.tabEnnemiVagueBoss[indice]=new EnnemiGEA();
		}
		for(int indice=10; indice<15; indice++)
		{
			this.tabEnnemiVagueBoss[indice]=new EnnemiTC();
		}
		this.tabEnnemiVagueBoss[15]=new EnnemiBoss1();
	}

}
