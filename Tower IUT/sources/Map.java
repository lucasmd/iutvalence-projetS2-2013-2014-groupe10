public class Map
{
	/** Tableau de case qui forme la map. */
	private final static int NOMBRE_COLONNE=30;
	private final static int NOMBRE_LIGNE=30;
	private Case[][] map ;
	
	 /** Constructeur permettant d'initialiser la Map avec une taille de 50/50 */
	public Map()
	{
		map= new Case[NOMBRE_LIGNE][NOMBRE_COLONNE]; 
		for(int colonne=0; colonne<NOMBRE_COLONNE; colonne++)
		 { 
			for(int ligne=0; ligne<NOMBRE_LIGNE; ligne++)
			{
				map[ligne][colonne]=new Case(ligne,colonne);
			}
		 }
	}
	
	 
	 /** Retourne graphiquement la map (IHM). */
	public void afficherMap()
	 {
		for(int colonne=0; colonne<NOMBRE_COLONNE; colonne++)
		 { 
			for(int ligne=0; ligne<NOMBRE_LIGNE; ligne++)
			{
				System.out.print(map[ligne][colonne]);
			}
			System.out.println("\n");
		 }
	 }
	 
	 /** Met à jour le plateau. */
	public void miseAJourPlateau()
	 {
		 
	 }
	
}