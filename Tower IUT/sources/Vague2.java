
public class Vague2 extends Vague
{
	/**
	 * Constructeur 5 gea, 10 tc
	 */
	public Vague2()
	{
		tabEnnemi= new Ennemi[15];
		
		for(int indice=0; indice<5; indice++)
		{
			this.tabEnnemi[indice]=new EnnemiGEA();
		}
		for(int indice=5; indice<15; indice++)
		{
			this.tabEnnemi[indice]=new EnnemiTC();
		}
	}

}
