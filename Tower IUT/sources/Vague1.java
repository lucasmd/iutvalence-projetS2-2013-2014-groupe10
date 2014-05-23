
public class Vague1 extends Vague
{
	
	
	/**Vague de 10 gea*/
	public Vague1()
	{
		tabEnnemi= new Ennemi[10];
				
		for(int indice=0; indice<10; indice++)
		{
			this.tabEnnemi[indice]=new EnnemiGEA();
		}
	}
}
