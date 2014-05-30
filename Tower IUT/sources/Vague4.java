
public class Vague4 extends Vague
{	
	/**
	 * Constructeur(5 gea, 10 TC, 1 Boss2)
	 */
	public Vague4()
	{
		tabEnnemi= new Ennemi[16];
		for(int indice=0; indice<5; indice++)
		{
			this.tabEnnemi[indice]=new EnnemiGEA();
		}
		for(int indice=5; indice<15; indice++)
		{
			this.tabEnnemi[indice]=new EnnemiTC();
		}
		this.tabEnnemi[15]=new EnnemiBoss2();
	}
}
