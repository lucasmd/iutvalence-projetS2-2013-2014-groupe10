
public class Vague4 extends Vague
{	
	
	public Vague4()
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
		this.tabEnnemi[15]=new EnnemiBoss2();
	}
}
