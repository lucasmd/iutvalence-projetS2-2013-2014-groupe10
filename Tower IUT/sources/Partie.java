import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.spec.PSource;

/**
 * Repr�sente l'�tat d'avancement du joueur et les vagues qu'il reste avant la
 * fin de la partie
 * 
 * @author Chevalier-Maxime
 * 
 */
public class Partie {

	/**
	 * permet d'adapter la difficult� de la partie
	 */
	private int niveau;

	/**
	 * tableau d'ennemi present sur la carte
	 */
	private ArrayList<Ennemi> ennemiAfficher;

	/**
	 * repr�sente le joueur de la partie
	 */
	private Joueur joueurDeLaPartie;

	/**
	 * nombre de vie du joueur
	 */
	private int vieJoueur;

	/**
	 * Tableau repr�sentant les vagues de la partie
	 */
	private Vague[] vaguePartie;

	/**
	 * Carte de la partie
	 */
	protected Map carteDeLaPartie;

	/**
	 * liste des tours pr�sentes sur la carte
	 */
	protected ArrayList<Tour> listeTour;

	/**
	 * num�ros du tour de jeu
	 */
	private int numTour;

	/**
	 * Tableau des scores
	 */
	private TableScore tabScore;

	/**
	 * argent par defaut du joueur
	 */
	public static final int ARGENT_PAR_DEFAUT = 100;

	/**
	 * vie par defaut du joueur
	 */
	public static final int VIE_JOUEUR_PAR_DEFAUT = 20;

	/**
	 * nombre de vagues niveau 1
	 */
	public static final int NOMBRE_DE_VAGUE_NIVEAU1 = 4;

	/**
	 * nombre de vagues niveau 2
	 */
	public static final int NOMBRE_DE_VAGUE_NIVEAU2 = 6;

	/**
	 * nombre de vagues niveau 3
	 */
	public static final int NOMBRE_DE_VAGUE_NIVEAU3 = 8;

	/**
	 * Creer une partie pour un joueur avec un niveau defini
	 * 
	 * @param joueur
	 *            Joueur de la partie
	 * @param niveau
	 *            Niveau de la partie
	 */

	/**
	 * Creer une partie pour un joueur avec un niveau defini
	 * 
	 * @param joueur
	 *            Joueur de la partie
	 * @param niveau
	 *            Niveau de la partie
	 * @param tableScore
	 *            Tableau des scores du jeu
	 */
	public Partie(Joueur joueur, int niveau, TableScore tableScore) {
		this.joueurDeLaPartie = joueur;
		this.niveau = niveau;
		this.vieJoueur = VIE_JOUEUR_PAR_DEFAUT;
		this.carteDeLaPartie = new Map();
		this.listeTour = new ArrayList<Tour>();
		this.numTour = 0;
		this.ennemiAfficher = new ArrayList<Ennemi>();
		this.tabScore = tableScore;
		/** TODO Generation des vagues a changer */
		switch (niveau) {
		case 1:
			this.vaguePartie = new Vague[NOMBRE_DE_VAGUE_NIVEAU1];
			this.vaguePartie[0] = new Vague1();
			this.vaguePartie[1] = new Vague1();
			this.vaguePartie[2] = new Vague1();
			this.vaguePartie[3] = new Vague2();

			break;

		case 2:
			this.vaguePartie = new Vague[NOMBRE_DE_VAGUE_NIVEAU2];
			this.vaguePartie[0] = new Vague1();
			this.vaguePartie[1] = new Vague1();
			this.vaguePartie[2] = new Vague2();
			this.vaguePartie[3] = new Vague2();
			this.vaguePartie[4] = new Vague2();
			this.vaguePartie[5] = new Vague3();
			break;

		case 3:
			this.vaguePartie = new Vague[NOMBRE_DE_VAGUE_NIVEAU3];
			this.vaguePartie[0] = new Vague1();
			this.vaguePartie[1] = new Vague1();
			this.vaguePartie[2] = new Vague1();
			this.vaguePartie[3] = new Vague3();
			this.vaguePartie[4] = new Vague2();
			this.vaguePartie[5] = new Vague2();
			this.vaguePartie[6] = new Vague2();
			this.vaguePartie[7] = new Vague4();
			break;

		}

	}

	/**
	 * Methode qui permet de jouer en mode console
	 */
	public void jouer() {

		while (this.vieJoueur > 0) {
			carteDeLaPartie.afficherMap();
			Scanner saisieClavierNiveau = new Scanner(System.in);
			while (true) {
				System.out
						.println("\n Menu-------- \n 1 Poser Tour\n 2 Lancer Vague\n --------\n Votre choix ? ");
				int choixMenu = saisieClavierNiveau.nextInt();

				switch (choixMenu) {
				case 1:
					System.out
							.println("\n Choix Tour-------- \n 1 Petite Tour (prix : 5)\n 2 Moyenne Tour (prix : 10)\n 3 Grande Tour (prix : 25)\n--------\n Votre choix ? ");
					choixMenu = saisieClavierNiveau.nextInt();
					int positionX;
					int positionY;

					/** TODO Empecher la creation d'une tour sur 14/0 */

					switch (choixMenu) {
					case 1:

						while (true) {
							while (true) {
								System.out.println("Entrez une position x");
								positionX = saisieClavierNiveau.nextInt();

								if ((positionX <= carteDeLaPartie.NOMBRE_COLONNE)
										&& (positionX >= 0)) {
									break;
								}
								System.out
										.println("position incorrecte (0-30)");
							}

							while (true) {
								System.out.println("Entrez une position y");
								positionY = saisieClavierNiveau.nextInt();

								if ((positionY <= carteDeLaPartie.NOMBRE_LIGNE)
										&& (positionY >= 0)) {
									break;
								}
								System.out
										.println("position incorrecte (0-30)");
							}

							if ((carteDeLaPartie.map[positionX][positionY] != carteDeLaPartie.map[14][0])
									&& (carteDeLaPartie.map[positionX][positionY] != carteDeLaPartie.map[14][29])) {
								try {
									listeTour
											.add(new Tour(
													EnumTour.petiteTour,
													carteDeLaPartie.map[positionX][positionY],
													this.joueurDeLaPartie,
													this.carteDeLaPartie));

								} catch (CasePleineException e) {
									System.out.println("Position occupé");
									break;
								} catch (ArgentInsuffisant e) {
									System.out.println("Argent insufisant");
									break;
								}

								/** TODO a supprimer */
								System.out.println("Petite Tour Créée");
								break;

							}
						}
						break;

					case 2:

						while (true) {
							while (true) {
								System.out.println("Entrez une position x");
								positionX = saisieClavierNiveau.nextInt();

								if ((positionX <= carteDeLaPartie.NOMBRE_COLONNE)
										&& (positionX >= 0)) {
									break;
								}
								System.out
										.println("position incorrecte (0-30)");
							}

							while (true) {
								System.out.println("Entrez une position y");
								positionY = saisieClavierNiveau.nextInt();

								if ((positionY <= carteDeLaPartie.NOMBRE_LIGNE)
										&& (positionY >= 0)) {
									break;
								}
								System.out
										.println("position incorrecte (0-30)");
							}

							if ((carteDeLaPartie.map[positionX][positionY] != carteDeLaPartie.map[14][0])
									&& (carteDeLaPartie.map[positionX][positionY] != carteDeLaPartie.map[14][29])) {
								try {
									listeTour
											.add(new Tour(
													EnumTour.moyenneTour,
													carteDeLaPartie.map[positionX][positionY],
													this.joueurDeLaPartie,
													this.carteDeLaPartie));
								} catch (CasePleineException e) {
									System.out.println("Position occupé");
									break;
								} catch (ArgentInsuffisant e) {
									System.out.println("Argent insufisant");
									break;
								}

								/** TODO a supprimer */
								System.out.println(" Moyenne Tour Créée");
								break;

							}
						}

						break;

					case 3:

						while (true) {
							while (true) {
								System.out.println("Entrez une position x");
								positionX = saisieClavierNiveau.nextInt();

								if ((positionX <= carteDeLaPartie.NOMBRE_COLONNE)
										&& (positionX >= 0)) {
									break;
								}
								System.out
										.println("position incorrecte (0-30)");
							}

							while (true) {
								System.out.println("Entrez une position y");
								positionY = saisieClavierNiveau.nextInt();

								if ((positionY <= carteDeLaPartie.NOMBRE_LIGNE)
										&& (positionY >= 0)) {
									break;
								}
								System.out
										.println("position incorrecte (0-30)");
							}

							if ((carteDeLaPartie.map[positionX][positionY] != carteDeLaPartie.map[14][0])
									&& (carteDeLaPartie.map[positionX][positionY] != carteDeLaPartie.map[14][29])) {
								try {
									listeTour
											.add(new Tour(
													EnumTour.grosseTour,
													carteDeLaPartie.map[positionX][positionY],
													this.joueurDeLaPartie,
													this.carteDeLaPartie));

								} catch (CasePleineException e) {
									System.out.println("Position occupé");
									break;
								} catch (ArgentInsuffisant e) {
									System.out.println("Argent insufisant");
									break;
								}

								/** TODO a supprimer */
								System.out.println(" Grosse Tour Créée");
								break;

							}
						}

						break;

					default:
						System.out.println("Choix menu invalide");

					}
					System.out.println("Qt argent : "
							+ this.joueurDeLaPartie.obtenirQtArgent());
					break;
				case 2:
					if (numTour >= this.vaguePartie.length) {
						System.out
								.println("vous avez gangé, passez au niveau suivant :)");
						return;
					} else if (this.vieJoueur <= 0) {
						System.out.println("vous avez perdu! try again");
						return;
					} else {
						this.lancerUnTour(numTour);
						this.numTour++;
					}
					System.out.println("Vie : " + this.vieJoueur);
					System.out.println("Score : "
							+ this.joueurDeLaPartie.obtenirScoreJoueur());

					break;
				default:
					System.out.println("Choix menu invalide");
				}

				carteDeLaPartie.afficherMap();
			}
		}
		this.tabScore.modifierScore(this.joueurDeLaPartie);
	}

	/**
	 * Permet de mettre a jour la vie du joueur pour cette partie
	 * 
	 * @param vie
	 *            vie a enlever
	 */
	public void miseAJourDesVies(int vie) {
		this.vieJoueur = this.vieJoueur + vie;
	}

	/**
	 * Permet d'obtenir le joueur de la partie
	 * 
	 * @return le joueur de la partie
	 */
	public Joueur obtenirJoueurDeLaPartie() {
		return joueurDeLaPartie;
	}

	/**
	 * Permet d'obtenir le niveau de la partie
	 * 
	 * @return le niveau de la partie
	 */
	public int obtenirNiveau() {
		return niveau;
	}

	/**
	 * Permet d'obtenir le tableau de vague de la partie
	 * 
	 * @return le tableau de vaque de la partie
	 */
	public Vague[] obtenirVaguePartie() {
		return vaguePartie;
	}

	/**
	 * Permet d'obtenir les vies du joueur
	 * 
	 * @return le nombre de vie du joueur
	 */
	public int obtenirVieJoueur() {
		return vieJoueur;
	}

	/**
	 * Permet d'obtenir la carte de la partie
	 * 
	 * @return la carte de la partie
	 */
	public Map obtenirCarteDeLaPartie() {
		return carteDeLaPartie;
	}

	/**
	 * Permet d'obtenir la liste des ennemis de la partie
	 * 
	 * @return la liste des ennemis
	 */
	public ArrayList<Ennemi> obtenirEnnemiAfficher() {
		return ennemiAfficher;
	}

	/** TODO Mettre a jour le score + test attaque de tour */

	/**
	 * Permet de faire un tour de jeu. Le tour se fini si tous les ennemis de la
	 * vague sont morts, ou si le joueur n'a plus de vies.
	 * 
	 * @param nbTour
	 *            num�ro du tour de jeu
	 */
	public void lancerUnTour(int nbTour) {
		boolean finDuTour = false;
		int numTour = 0;
		int numEnnemi = 0;

		/* this.carteDeLaPartie.changerChemin(); */

		while ((finDuTour == false) && (this.vieJoueur > 0)) {
			if (numEnnemi == this.vaguePartie[nbTour].obtenirTabEnnemi().length) {
				if (this.ennemiAfficher.size() == 0) {
					System.out.println("Fin du tour");
					finDuTour = true;
					break;
				}
			}
			if ((numTour % 2 == 0)
					&& (numEnnemi < this.vaguePartie[nbTour].obtenirTabEnnemi().length)) {
				this.vaguePartie[nbTour].lancerUnEnnemi(numEnnemi,
						ennemiAfficher, this.carteDeLaPartie);
				numEnnemi++;
			}
			for (int indice = 0; indice < this.listeTour.size(); indice++) {
				this.listeTour.get(indice).attaquer(ennemiAfficher,
						this.carteDeLaPartie, this.joueurDeLaPartie);
			}

			for (int index = 0; index < ennemiAfficher.size(); index++) {
				ennemiAfficher.get(index).testVictoireEnnemie(this);
			}
			this.carteDeLaPartie.afficherMap();
			this.vaguePartie[nbTour].faireAvancerLaVague(ennemiAfficher,
					this.carteDeLaPartie);

			System.out.println("Tour n�" + numTour);
			numTour++;

		}
	}

	public void lancerUnTour(int nbTour, JeuxIHM jeu) {
		boolean finDuTour = false;
		int numTour = 0;
		int numEnnemi = 0;

		/* this.carteDeLaPartie.changerChemin(); */

		while ((finDuTour == false) && (this.vieJoueur > 0)) {
			if (numEnnemi == this.vaguePartie[nbTour].obtenirTabEnnemi().length) {
				if (this.ennemiAfficher.size() == 0) {
					finDuTour = true;
					break;
				}
			}
			if ((numTour % 2 == 0)
					&& (numEnnemi < this.vaguePartie[nbTour].obtenirTabEnnemi().length)) {
				this.vaguePartie[nbTour].lancerUnEnnemi(numEnnemi,
						ennemiAfficher, this.carteDeLaPartie);
				numEnnemi++;
			}
			for (int indice = 0; indice < this.listeTour.size(); indice++) {
				this.listeTour.get(indice).attaquer(ennemiAfficher,
						this.carteDeLaPartie, this.joueurDeLaPartie);
			}

			for (int index = 0; index < ennemiAfficher.size(); index++) {
				ennemiAfficher.get(index).testVictoireEnnemie(this);
			}

			jeu.plateauJeu.removeAll();
			jeu.plateauJeu.setLayout(new GridLayout(30, 30));

			for (int i = 0; i < Map.NOMBRE_LIGNE; i++) {
				for (int j = 0; j < Map.NOMBRE_COLONNE; j++) {
					jeu.plateauJeu.add(new BCase(i, j,
							jeu.partie.carteDeLaPartie.map[i][j]
									.obtenirCaseEtat(), jeu));
				}
			}
			jeu.plateauJeu.validate();
			nbTour++;
			// this.carteDeLaPartie.afficherMap();
			this.vaguePartie[nbTour].faireAvancerLaVague(ennemiAfficher,
					this.carteDeLaPartie);
			

			numTour++;

		}
	}
}
