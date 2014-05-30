
public class Vague3 extends Vague
{
	
	/**
	 * Constructeur(10 gea,5 TC, 1Boss1)
	 */
	public Vague3()
	{
		tabEnnemi= new Ennemi[16];
		for(int indice=0; indice<10; indice++)
		{
			this.tabEnnemi[indice]=new EnnemiGEA();
		}
		for(int indice=10; indice<15; indice++)
		{
			this.tabEnnemi[indice]=new EnnemiTC();
		}
		this.tabEnnemi[15]=new EnnemiBoss1();
	}

}
