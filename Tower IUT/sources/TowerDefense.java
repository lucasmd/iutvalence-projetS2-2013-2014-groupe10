import java.util.*;

public class TowerDefense{
	
	/** Partie. */
	private Partie laPartie;
	
	/** Tableau des scores. */
	//private TableScore[] leTableauDesScores;
	
	/** Options du jeu. */
	private Option lesOptions;
	
	/** Règles du jeu. */
	private Regles lesRegles;
	
	public static void main (String[] args)
	{
		
		Scanner saisieClavierMenu = new Scanner(System.in);
		System.out.println(" Menu\n --------\n 1 Jouer\n 2 Regles\n 3 Options\n 4 Tableau des scores\n --------\n Votre choix ? ");
		int choixMenu = saisieClavierMenu.nextInt();
		
		switch (choixMenu)
		{
		case 1:
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Votre nom ?");
			String nomJoueur = sc.nextLine();
			
			Joueur JoueurDeLaPartie = new Joueur(nomJoueur);
			
			Scanner saisieClavierNiveau = new Scanner(System.in);
			System.out.println(" Choix du niveau\n --------\n 1 Facile\n 2 Normal\n 3 Difficile\n --------\n Votre choix ? ");
			int choixNiveau = saisieClavierNiveau.nextInt();
			
			Partie partie= new Partie(choixNiveau, nomJoueur);
			partie.jouer();
			break;
			
		case 2:
			Regles regle= new Regles();
			
			regle.afficherRegle();
			
		}
		
		
	}
}
