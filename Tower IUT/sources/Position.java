/**
 * Donne la position d'une case ou d'une tour
 * 
 * @author prinsacn
 * 
 */

public class Position {

	/**
	 * Numéro de la ligne
	 */
	private int posiLigne;
	/**
	 * Numéro de la colonne
	 */
	private int posiColonne;
	

	/**
	 * Permet d'initialiser une position
	 * 
	 * @param posiLigne
	 * @param posiColonne
	 */
	public Position(int posiLigne, int posiColonne) 
	{
		this.posiLigne = posiLigne;
		this.posiColonne = posiColonne;
	}
	
	/**
	 * Retourne le numéro de colonne
	 */
	public int obtenirPositionColonne() {
		return this.posiColonne;
	}
	
	public boolean equals(Position posi)
	{
		if(this.posiColonne==posi.obtenirPositionColonne())
		{
			if(this.posiLigne==posi.obtenirPositionLigne())
				return true;
		}
		return false;
	}
	/**
	 * Retourne le numéro de ligne
	 */
	public int obtenirPositionLigne() {
		return this.posiLigne;
	}
}