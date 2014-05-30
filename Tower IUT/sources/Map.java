import java.util.ArrayList;

/**
 * Classe pour d�finir la Map et cr�er une nouvelle map prete a jouer
 */
public class Map
 {
	
	public final static int NOMBRE_COLONNE=30;
	public final static int NOMBRE_LIGNE=30;
	
	
	
	/** Tableau de case qui forme l amap. */
	public Case[][] map ;
	/**
	 * liste de case representant le chemin le plus court
	 */
	public ArrayList<Case> cheminLePlusCourt;
	
	public ArrayList<Case> chemin;
	
	/** Constructeur permettant d'initialiser la Map avec une taille de 30/30 et initialisation du chemin */
	public Map()
	{
		map= new Case[NOMBRE_LIGNE][NOMBRE_COLONNE]; 
		this.chemin=new ArrayList<Case>();
		
		for(int colonne=0; colonne<NOMBRE_COLONNE; colonne++)
		 { 
			for(int ligne=0; ligne<NOMBRE_LIGNE; ligne++)
			{
				map[ligne][colonne]=new Case(ligne,colonne);
			}
		 }
		for(int indice=0; indice<4; indice++)
		{
			this.map[14][indice].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[14][indice]);
			
		}
		for(int indice=13; indice>4; indice--)
		{
			this.map[indice][3].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[indice][3]);
		}
		for(int indice=4; indice<15; indice++)
		{
			this.map[5][indice].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[5][indice]);
		}
		for(int indice=6; indice<25; indice++)
		{
			this.map[indice][14].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[indice][14]);
		}
		for(int indice=15; indice<27; indice++)
		{
			this.map[24][indice].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[24][indice]);
		}
		for(int indice=23; indice>13; indice--)
		{
			this.map[indice][26].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[indice][26]);
		}
		for(int indice=27; indice<30; indice++)
		{
			this.map[14][indice].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[14][indice]);
		}
		
		/*try{this.cheminLePlusCourt= this.definitionChemin(this.map[14][0]);}catch (CheminInfesable e){}*/
	}
	
	
	/** affiche ma map en console */
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
	
	
	/**Affiche l'ennemi sur la map*/
	public void afficherEnnemi(Ennemi ennemiAAfficher)
	{
		this.map[ennemiAAfficher.obtenirCase().obtenirPosiCase().obtenirPositionLigne()][ennemiAAfficher.obtenirCase().obtenirPosiCase().obtenirPositionColonne()].changerPosiEtat(Etat.ENNEMI);
	}
	
	/**Effacer l'ennemi sur la map*/
	public void effacerEnnemi(Ennemi ennemiAEffacer)
	{
		this.map[ennemiAEffacer.obtenirCase().obtenirPosiCase().obtenirPositionLigne()][ennemiAEffacer.obtenirCase().obtenirPosiCase().obtenirPositionColonne()].changerPosiEtat(Etat.CHEMIN);
	}
	
}

