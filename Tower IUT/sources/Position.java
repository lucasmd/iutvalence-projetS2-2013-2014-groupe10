/**
 * Donne la position d'une case ou d'une tour
 * 
 * @author prinsacn
 * 
 */

public class Position {

	/**
	 * Num�ro de la ligne
	 */
	private int posiLigne;
	/**
	 * Num�ro de la colonne
	 */
	private int posiColonne;
	
	private Etat posiEtat;

	/**
	 * Permet d'initialiser une position
	 * 
	 * @param posiLigne
	 * @param posiColonne
	 */
	public Position(int posiLigne, int posiColonne, Etat etatOrigine) 
	{
		this.posiLigne = posiLigne;
		this.posiColonne = posiColonne;
		this.posiEtat= etatOrigine;
	}
	
	

	/**
	 * Retourne le num�ro de colonne
	 */
	public int obtenirPositionColonne() {
		return this.posiColonne;
	}
	
	public void changerPositionLigne(int num)
	{
		this.posiLigne= this.posiLigne+num;
	}
	
	public void changerPositionColonne(int num)
	{
		this.posiColonne= this.posiColonne+num;
	}
	
	public void changerPosiEtat(Etat nouvelEtat)
	{
		this.posiEtat=nouvelEtat;
	}
	
	public Etat obtenirPositionEtat() {
		return this.posiEtat;
	}
	/**
	 * Retourne le num�ro de ligne
	 */
	public int obtenirPositionLigne() {
		return this.posiLigne;
	}
}