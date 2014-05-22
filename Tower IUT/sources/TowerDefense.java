import java.util.*;

public class TowerDefense{
	
	
	public final static Position POSITION_DE_FIN=new Position(14,29);
	/** Partie. */
	private Partie laPartie;
	
	/** Tableau des scores. */
	//private TableScore[] leTableauDesScores;
	
	/** Options du jeu. */
	private Option lesOptions;
	
	/** RÃ¨gles du jeu. */
	private Regles lesRegles;
	
	public static void main (String[] args)
	{
		
		TowerDefense.afficherMenu();
		
		
		
		
	}
	
	public static void afficherMenu()
	{
		
		Scanner saisieClavierMenu = new Scanner(System.in);
		
		/**TODO demander comment eviter d'utiliser une valeur ici
		 *  et comment eviter d'utiliser saisieCorrecte qui est inutile dans la boucle 
		 */
		
		
		Map mapJeu=new Map();
		
		mapJeu.map[14][5].changerPosiEtat(Etat.TOUR);
		mapJeu.map[14][8].changerPosiEtat(Etat.TOUR);
		mapJeu.map[14][15].changerPosiEtat(Etat.TOUR);
		mapJeu.map[14][16].changerPosiEtat(Etat.TOUR);

		ArrayList<Case> cheminDef=mapJeu.definitionChemin(mapJeu.map[14][0]);
		Ennemi ennemiGea=new EnnemiGEA();
		/*mapJeu.afficherEnnemi(ennemiGea);
		ennemiGea.avancer(cheminDef,mapJeu);*/
		mapJeu.afficherEnnemi(ennemiGea);
		
		
		while ((ennemiGea.obtenirCase().obtenirPosiCase()!=POSITION_DE_FIN))
		{
			ennemiGea.avancer(cheminDef,mapJeu);
			mapJeu.afficherEnnemi(ennemiGea);
			mapJeu.afficherMap();
			if (ennemiGea.obtenirCase().obtenirPosiCase().obtenirPositionLigne()==14)
			{
				if(ennemiGea.obtenirCase().obtenirPosiCase().obtenirPositionColonne()==29)
				{
					break;
				}
			}
			System.out.println("/n/n");
		}
		mapJeu.afficherMap();
		
		int choixMenu=1;
		
		//gestion erreur choix menu
		while(true)
		{
		while (true)
		{
			System.out.println(" Menu\n --------\n 1 Jouer\n 2 Regles\n 3 Options\n 4 Tableau des scores\n --------\n Votre choix ? ");
			choixMenu = saisieClavierMenu.nextInt();
			
			if ((choixMenu==1)||(choixMenu==2)||(choixMenu==3)||(choixMenu==4))
			{
				break;
			}
			System.out.println(" Vous n'avez pas séléctionné une rubrique valide\n");
		}
		
		switch (choixMenu)
		{
		case 1:
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Votre nom ?");
			String nomJoueur = sc.nextLine();
			
			Joueur JoueurDeLaPartie = new Joueur(nomJoueur);
			Scanner saisieClavierNiveau = new Scanner(System.in);
			
			/**TODO demander comment eviter d'utiliser une valeur ici
			 *  et comment eviter d'utiliser saisieCorrecte qui est inutile dans la boucle 
			 */
			
			int choixNiveau=1;
			
			//gestion erreur choix niveau
			while (true)
			{
				System.out.println(" Choix du niveau\n --------\n 1 Facile\n 2 Normal\n 3 Difficile\n --------\n Votre choix ? ");
				choixNiveau = saisieClavierNiveau.nextInt();
				
				if ((choixNiveau==1)||(choixNiveau==2)||(choixNiveau==3))
				{
					break;
				}
				System.out.println(" Vous n'avez pas séléctionné un niveau valide\n");
			}
			
			
			
			Partie partie= new Partie(JoueurDeLaPartie, choixNiveau);
			
			System.out.println("Je joue et je termine ma partie");
			//partie.jouer();
			break;
			
		case 2:
			Regles regle= new Regles();
			System.out.println(regle.afficherTexte()+"\n");
			break;
			
		case 3:
			Option option = new Option();
			System.out.println(option.afficheOption()+"\n");
			break;
			
		case 4:
			/**TODO Faire rubrique menu */
			System.out.println("affichage des score\n");
			break;
			
		}
	}
  }
}
