
public class Vague1 extends Vague
{
	private Ennemi[] tabEnnemiGEA;
	
	/**Vague de 10 gea*/
	public Vague1()
	{
		for(int indice=0; indice<10; indice++)
		{
			this.tabEnnemiGEA[indice]=new EnnemiGEA();
		}
	}
}
