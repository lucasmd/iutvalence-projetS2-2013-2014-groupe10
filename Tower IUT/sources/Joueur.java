/**
 * Permet de repr�senter un Joueur
 * @author Chevalier-Maxime
 *
 */
public class Joueur
{
	/**
	 * Chaine de caract�res contenant le pseudo du Joueur
	 */
	private final String pseudo;
	
	/**
	 * Entier contenant la valeur du score du joueur
	 */
	private int scoreJoueur;
	
	/**
	 * repr�sente la quantit�e d'argent poss�d� par le joueur
	 */
	private int qtArgent;
	
	
	/**
	 * Permet de creer un joueur avec un nom
	 * @param pseudoJoueur Nom du joueur
	 */
	public Joueur(String pseudoJoueur)
	{
		this.pseudo=pseudoJoueur;
		this.scoreJoueur=0;
		this.qtArgent=Partie.ARGENT_PAR_DEFAUT;
	}
	
	/**
	 * PErmet d'obtenir le nom du joueur
	 * @return le nom du joueur
	 */
	public String obtenirPseudo()
	{
		return this.pseudo;
	}
	
	/**
	 * Permet d'obtenir le score du joueur
	 * @return le score du joueur
	 */
	public int obtenirScoreJoueur()
	{
		return this.scoreJoueur;
	}
	
	/**
	 * Permet de mettre � jour le score du joueur en lui ajoutant (ou soustrayant) un score.
	 * @param scoreAAjouter score � ajout�
	 */
	public void mettreAJourScore(int scoreAAjouter)
	{
		this.scoreJoueur=this.scoreJoueur+scoreAAjouter;
	}
	
	public int obtenirQtArgent()
	{
		return qtArgent;
	}
	
	public void modifierQtArgent(int argent)
	{
		this.qtArgent=this.qtArgent+argent;
	}
	
}
