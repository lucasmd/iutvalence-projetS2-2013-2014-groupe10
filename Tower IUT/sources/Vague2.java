
public class Vague2 extends Vague
{
	private Ennemi[] tabEnnemiVague;
	
	public Vague2()
	{
		for(int indice=0; indice<5; indice++)
		{
			this.tabEnnemiVague[indice]=new EnnemiGEA();
		}
		for(int indice=5; indice<15; indice++)
		{
			this.tabEnnemiVague[indice]=new EnnemiTC();
		}
	}

}
