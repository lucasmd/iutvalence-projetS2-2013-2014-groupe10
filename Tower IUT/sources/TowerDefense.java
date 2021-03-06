import java.util.*;

import javax.swing.SwingUtilities;

/**
 * Permet de lancer le jeu
 * @author Maxime
 *
 */
public class TowerDefense {

	public final static Position POSITION_DE_FIN = new Position(14, 29);
	/** Partie. */
	private Partie laPartie;

	/** Tableau des scores. */
	private static TableScore leTableauDesScores;

	/** Options du jeu. */
	private static Option lesOptions;

	/** RÃ¨gles du jeu. */
	private static Regles lesRegles;

	/**
	 * Methode main qui permet de choisir entre l'affichage console et l'affichage graphique
	 * @param args Ne prend pas de paramtres en entr�e.
	 */
	public static void main(String[] args) {

		
		final Scanner reader = new Scanner(System.in, "UTF-8");
		boolean choixInterface = false;
		String consoleOuGraph = "";
		while (!choixInterface) {
			System.out
					.println("Choix du type d'interface\n --------\n 1 Console\n 2 Graphique\n --------\n Votre choix ? ");
			consoleOuGraph = reader.nextLine();
			if ((consoleOuGraph.equalsIgnoreCase("1"))
					|| (consoleOuGraph.equalsIgnoreCase("2"))) {
				choixInterface = true;
			}
		}
		if (consoleOuGraph.equalsIgnoreCase("2")) {
			SwingUtilities.invokeLater(new MenuIHM());
		} else if (consoleOuGraph.equalsIgnoreCase("1")) {
			TowerDefense.afficherMenu();
		}
	}
	
	/**
	 * Permet d'afficher le menu en console et de jouer.
	 */
	public static void afficherMenu() {
		lesRegles = new Regles();
		leTableauDesScores = new TableScore();
		lesOptions = new Option();
		Scanner saisieClavierMenu = new Scanner(System.in);

		/**
		 * TODO demander comment eviter d'utiliser une valeur ici et comment
		 * eviter d'utiliser saisieCorrecte qui est inutile dans la boucle
		 */

		int choixMenu = 1;

		// gestion erreur choix menu
		while (true) {
			while (true) {
				System.out
						.println(" Menu\n --------\n 1 Jouer\n 2 Regles\n 3 Options\n 4 Tableau des scores\n 5 Quitter\n --------\n Votre choix ? ");
				choixMenu = saisieClavierMenu.nextInt();

				if ((choixMenu == 1) || (choixMenu == 2) || (choixMenu == 3)
						|| (choixMenu == 4) || (choixMenu == 5)) {
					break;
				}
				System.out
						.println(" Vous n'avez pas s�l�ction� une rubrique valide\n");
			}

			switch (choixMenu) {
			case 1:

				Scanner sc = new Scanner(System.in);
				System.out.println("Votre nom ?");
				String nomJoueur = sc.nextLine();

				Joueur JoueurDeLaPartie = new Joueur(nomJoueur);
				Scanner saisieClavierNiveau = new Scanner(System.in);

				/**
				 * TODO demander comment eviter d'utiliser une valeur ici et
				 * comment eviter d'utiliser saisieCorrecte qui est inutile dans
				 * la boucle
				 */

				int choixNiveau = 1;

				// gestion erreur choix niveau
				while (true) {
					System.out
							.println(" Choix du niveau\n --------\n 1 Facile\n 2 Normal\n 3 Difficile\n --------\n Votre choix ? ");
					choixNiveau = saisieClavierNiveau.nextInt();

					if ((choixNiveau == 1) || (choixNiveau == 2)
							|| (choixNiveau == 3)) {
						break;
					}
					System.out
							.println(" Vous n'avez pas sï¿½lï¿½ctionnï¿½ un niveau valide\n");
				}

				Partie partie = new Partie(JoueurDeLaPartie, choixNiveau, leTableauDesScores);

				System.out.println("Je joue et je termine ma partie");
				partie.jouer();
				break;

			case 2:
				System.out.println(lesRegles.afficherRegles() + "\n");
				break;

			case 3:
				System.out.println(lesOptions.afficheOption() + "\n");
				break;

			case 4:
				System.out.println(leTableauDesScores.afficherScoreConsole() + "\n");
				break;

			case 5:
				System.exit(0);
				break;
			}
		}
	}
}
