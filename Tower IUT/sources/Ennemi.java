
/**
 * 
 * @author Groupe 10
 *
 */
public class Ennemi 
{
	private Position positionEnnemi;
	private String nomEnnemi;
	private int vie_Ennemi;
	private int pointDegats;
	
	/**
	 * Constructeur ennemi
	 * @param nom
	 * @param vie
	 * @param degat
	 * @param posiDepart
	 */
	public Ennemi(String nom, int vie, int degat, Position posiDepart)
	{
		positionEnnemi = posiDepart;
		nomEnnemi = nom;
		vie_Ennemi = vie;
		pointDegats = degat;
	}
	/**
	 * Methode qui permet d'attaquer une tour
	 * @param tourAttaque
	 */
	public void attaquer(Tour tourAttaque)
	{
		
	}
	
	/**
	 * Methode qui permet à l'ennemi d'avancer(elle a été omise dans D2)
	 * @param positionOrigine
	 */
	public void ennemiAvancer(Position positionOrigine)
	{
		
	}
}
