/**
 * Permet de reprï¿½senter un Joueur
 * @author Chevalier-Maxime
 *
 */
public class Joueur
{
	/**
	 * Chaine de caractï¿½res contenant le pseudo du Joueur
	 */
	private final String pseudo;
	
	/**
	 * Entier contenant la valeur du score du joueur
	 */
	private int scoreJoueur;
	
	/**
	 * reprï¿½sente la quantitï¿½e d'argent possï¿½dï¿½ par le joueur
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
	 * Permet de mettre ï¿½ jour le score du joueur en lui ajoutant (ou soustrayant) un score.
	 * @param scoreAAjouter score ï¿½ ajoutï¿½
	 */
	public void mettreAJourScore(int scoreAAjouter)
	{
		this.scoreJoueur=this.scoreJoueur+scoreAAjouter;
	}
	
	/**
	 * Permet d'obtenir l'argent du joueur
	 * @return qtArgent que possède le joueur
	 */
	public int obtenirQtArgent()
	{
		return qtArgent;
	}
	
	/**
	 * Permet d'ajouter de l'argent au joueur
	 * @param argent argent à ajouter
	 */
	public void ajouterArgent(int argent)
	{
		this.qtArgent=this.qtArgent+Math.abs(argent);
	}

	/**
	 * Permet d'enlever de l'argent au joueur
	 * @param argent Argent à enlever
	 */
	public void enleverArgent(int argent)
	{
		// TODO Auto-generated method stub
		this.qtArgent=this.qtArgent-Math.abs(argent);
	}
	
}
