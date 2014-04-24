
public class EnnemiGEA extends Ennemi
{	
	public final static Position POSITION_PAR_DEFAUT = new Position(0,0);
	private Position[8] porteAttaque; 
	
	public EnnemiGEA()
	{
		super("gea", 3, 1, POSITION_PAR_DEFAUT );
		for (int indice=0, indice<8, )
		
	}
	
	public void attaquer(Tour tourAttaque)
	{
		
	}
	
	public abstract void ennemiAvancer(Position positionOrigine);
	
	

}
