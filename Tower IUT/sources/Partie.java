
/**
 * Représente l'état d'avancement du joueur et les vagues qu'il reste avant la fin de la partie
 * @author Chevalier-Maxime
 *
 */
public class Partie
{

	/**
	 * permet d'adapter la difficulté de la partie
	 */
	private int niveau;
	
	/**
	 * représente la quantitée d'argent possédé par le joueur
	 */
	private int qtArgent;
	
	/**
	 * représente le joueur de la partie
	 */
	private Joueur joueurDeLaPartie;
	
	/**
	 * nombre de vie du joueur
	 */
	private int vieJoueur;
	
	/**
	 * Tableau représentant les vagues de la partie
	 */
	private Vague[] vaguePartie;
	
	/**
	 * argent par defaut du joueur
	 */
	public static final int ARGENT_PAR_DEFAUT = 100;
	
	/**
	 * vie par defaut du joueur
	 */
	public static final int VIE_JOUEUR_PAR_DEFAUT = 20;
	
	public static final int NOMBRE_DE_VAGUE_NIVEAU1=20;
	
	public static final int NOMBRE_DE_VAGUE_NIVEAU2=30;
	
	public static final int NOMBRE_DE_VAGUE_NIVEAU3=40;
	
	/**
	 * Creer une partie pour un joueur avec un niveau defini
	 * @param joueur Joueur de la partie
	 * @param niveau Niveau de la partie
	 */
	public Partie(Joueur joueur, int niveau)
	{
		this.joueurDeLaPartie=joueur;
		this.niveau=niveau;
		this.qtArgent= ARGENT_PAR_DEFAUT;
		this.vieJoueur=VIE_JOUEUR_PAR_DEFAUT;
		
		//Generation des vagues a changer
		switch (niveau)
		{
			case 1 : this.vaguePartie = new Vague[NOMBRE_DE_VAGUE_NIVEAU1];
					 for (int i=0; i<NOMBRE_DE_VAGUE_NIVEAU1;i++)
					 {
						 this.vaguePartie[i]=new Vague(niveau);
					 }
					 break;
					 
			case 2 : this.vaguePartie = new Vague[NOMBRE_DE_VAGUE_NIVEAU2];
			 		 for (int i=0; i<NOMBRE_DE_VAGUE_NIVEAU2;i++)
			 		 {
			 			 this.vaguePartie[i]=new Vague(niveau);
			 		 }
			 		 break;
			 		 
			case 3 : this.vaguePartie = new Vague[NOMBRE_DE_VAGUE_NIVEAU3];
	 		 		 for (int i=0; i<NOMBRE_DE_VAGUE_NIVEAU3;i++)
	 		 		 {
	 		 			 this.vaguePartie[i]=new Vague(niveau);
	 		 		 }
	 		 		 break;
	 				
		}
		
	}
	
	//a completer
	public void jouer()
	{
		
	}
	
	
	/**
	 * Permet de mettre a jour la vie du joueur pour cette partie
	 * @param vie vie a enlever
	 */
	public void miseAJourDesVies(int vie)
	{
		this.vieJoueur=this.vieJoueur+vie;
	}
	
	
	public void miseAJourDeLArgent(int argent)
	{
		this.qtArgent=this.qtArgent+argent;
	}
	
	
	
	public Joueur obtenirJoueurDeLaPartie() {
		return joueurDeLaPartie;
	}
	
	public int obtenirNiveau() {
		return niveau;
	}
	public int obtenirQtArgent() {
		return qtArgent;
	}
	public Vague[] obtenirVaguePartie() {
		return vaguePartie;
	}
	public int obtenirVieJoueur() {
		return vieJoueur;
	}
	
	
}
