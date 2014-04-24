/**
 * Permet de représenter un Joueur
 * @author Chevalier-Maxime
 *
 */
public class Joueur
{
	/**
	 * Chaine de caractères contenant le pseudo du Joueur
	 */
	private final String pseudo;
	
	/**
	 * Entier contenant la valeur du score du joueur
	 */
	private int scoreJoueur;
	
	
	/**
	 * Permet de creer un joueur avec un nom
	 * @param pseudoJoueur Nom du joueur
	 */
	public Joueur(String pseudoJoueur)
	{
		this.pseudo=pseudoJoueur;
		this.scoreJoueur=0;
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
	 * Permet de mettre à jour le score du joueur en lui ajoutant (ou soustrayant) un score.
	 * @param scoreAAjouter score à ajouté
	 */
	public void mettreAJourScore(int scoreAAjouter)
	{
		this.scoreJoueur=this.scoreJoueur+scoreAAjouter;
	}
	
	
	
}
