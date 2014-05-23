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
public class Partie
{

	/**
	 * permet d'adapter la difficult� de la partie
	 */
	private int niveau;
	
	/**
	 * tableau d'ennemi present sur la carte
	 */
	private Ennemi[] ennemiAfficher;
	
	/**
	 * repr�sente la quantit�e d'argent poss�d� par le joueur
	 */
	private int qtArgent;

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

	private Map carteDeLaPartie;

	private ArrayList<Tour> listeTour;

	/**
	 * argent par defaut du joueur
	 */
	public static final int ARGENT_PAR_DEFAUT = 100;

	/**
	 * vie par defaut du joueur
	 */
	public static final int VIE_JOUEUR_PAR_DEFAUT = 20;

	public static final int NOMBRE_DE_VAGUE_NIVEAU1 = 20;

	public static final int NOMBRE_DE_VAGUE_NIVEAU2 = 30;

	public static final int NOMBRE_DE_VAGUE_NIVEAU3 = 40;

	/**
	 * Creer une partie pour un joueur avec un niveau defini
	 * 
	 * @param joueur
	 *            Joueur de la partie
	 * @param niveau
	 *            Niveau de la partie
	 */
	public Partie(Joueur joueur, int niveau)
	{
		this.joueurDeLaPartie = joueur;
		this.niveau = niveau;
		this.qtArgent = ARGENT_PAR_DEFAUT;
		this.vieJoueur = VIE_JOUEUR_PAR_DEFAUT;
		this.carteDeLaPartie = new Map();
		this.listeTour = new ArrayList<Tour>();

		/** TODO Generation des vagues a changer */
		switch (niveau)
		{
			case 1:
				this.vaguePartie = new Vague[NOMBRE_DE_VAGUE_NIVEAU1];
				for (int i = 0; i < NOMBRE_DE_VAGUE_NIVEAU1; i++)
				{
					this.vaguePartie[i] = new Vague(niveau);
				}
				break;

			case 2:
				this.vaguePartie = new Vague[NOMBRE_DE_VAGUE_NIVEAU2];
				for (int i = 0; i < NOMBRE_DE_VAGUE_NIVEAU2; i++)
				{
					this.vaguePartie[i] = new Vague(niveau);
				}
				break;

			case 3:
				this.vaguePartie = new Vague[NOMBRE_DE_VAGUE_NIVEAU3];
				for (int i = 0; i < NOMBRE_DE_VAGUE_NIVEAU3; i++)
				{
					this.vaguePartie[i] = new Vague(niveau);
				}
				break;

		}

	}

	// a completer
	public void jouer()
	{

		while (this.vieJoueur > 0)
		{
			carteDeLaPartie.afficherMap();
			Scanner saisieClavierNiveau = new Scanner(System.in);
			while (true)
			{
				System.out
						.println("\n Menu-------- \n 1 Poser Tour\n 2 Lancer Vague\n --------\n Votre choix ? ");
				int choixMenu = saisieClavierNiveau.nextInt();

				switch (choixMenu)
				{
					case 1:
						System.out
								.println("\n Choix Tour-------- \n 1 Petite Tour (prix : 5)\n 2 Moyenne Tour (prix : 10)\n 3 Grande Tour (prix : 25)\n--------\n Votre choix ? ");
						choixMenu = saisieClavierNiveau.nextInt();
						int positionX;
						int positionY;
						
						switch (choixMenu)
						{
							case 1:
								
								if(this.qtArgent>= Tour.PRIX_PETITE_TOUR)
								{
								while (true)
								{
									while (true)
									{
										System.out
												.println("Entrez une position x");
										positionX = saisieClavierNiveau
												.nextInt();

										if ((positionX <= carteDeLaPartie.NOMBRE_COLONNE)
												&& (positionX >= 0))
										{
											break;
										}
										System.out
												.println("position incorrecte (0-30)");
									}

									while (true)
									{
										System.out
												.println("Entrez une position y");
										positionY = saisieClavierNiveau
												.nextInt();

										if ((positionY <= carteDeLaPartie.NOMBRE_LIGNE)
												&& (positionY >= 0))
										{
											break;
										}
										System.out
												.println("position incorrecte (0-30)");
									}

									if (carteDeLaPartie.map[positionX][positionY]
											.obtenirCaseEtat() == Etat.VIDE)
									{
										try
										{
											listeTour
													.add(new Tour(
															EnumTour.petiteTour,
															carteDeLaPartie.map[positionX][positionY]));
											carteDeLaPartie.map[positionX][positionY]
													.changerPosiEtat(Etat.TOUR);
											this.qtArgent=this.qtArgent-Tour.PRIX_PETITE_TOUR;
										} catch (CasePleineException e)
										{

										}
										/** TODO a supprimer */
										System.out.println("Petite Tour Créée");
										break;

									}
									else
									{
										System.out.println("Position occupé");
										break;
									} 
								}
								}
								else
								{
									System.out.println("Argent insufisant");
								}
									
							case 2:
								
								if(this.qtArgent>= Tour.PRIX_MOYENNE_TOUR)
								{
								while (true)
								{
									while (true)
									{
										System.out
												.println("Entrez une position x");
										positionX = saisieClavierNiveau
												.nextInt();

										if ((positionX <= carteDeLaPartie.NOMBRE_COLONNE)
												&& (positionX >= 0))
										{
											break;
										}
										System.out
												.println("position incorrecte (0-30)");
									}

									while (true)
									{
										System.out
												.println("Entrez une position y");
										positionY = saisieClavierNiveau
												.nextInt();

										if ((positionY <= carteDeLaPartie.NOMBRE_LIGNE)
												&& (positionY >= 0))
										{
											break;
										}
										System.out
												.println("position incorrecte (0-30)");
									}

									if (carteDeLaPartie.map[positionX][positionY]
											.obtenirCaseEtat() == Etat.VIDE)
									{
										try
										{
											listeTour
													.add(new Tour(
															EnumTour.moyenneTour,
															carteDeLaPartie.map[positionX][positionY]));
											carteDeLaPartie.map[positionX][positionY]
													.changerPosiEtat(Etat.TOUR);
											this.qtArgent=this.qtArgent-Tour.PRIX_MOYENNE_TOUR;
										} catch (CasePleineException e)
										{

										}
										/** TODO a supprimer */
										System.out.println(" Moyenne Tour Créée");
										break;

									}
									else
									{
										System.out.println("Position occupé");
										break;
									}
								}
								}
								else
								{
									System.out.println("Argent insufisant");
								}

								break;
								
							case 3:
								
								if(this.qtArgent>= Tour.PRIX_GRANDE_TOUR)
								{
								while (true)
								{
									while (true)
									{
										System.out
												.println("Entrez une position x");
										positionX = saisieClavierNiveau
												.nextInt();

										if ((positionX <= carteDeLaPartie.NOMBRE_COLONNE)
												&& (positionX >= 0))
										{
											break;
										}
										System.out
												.println("position incorrecte (0-30)");
									}

									while (true)
									{
										System.out
												.println("Entrez une position y");
										positionY = saisieClavierNiveau
												.nextInt();

										if ((positionY <= carteDeLaPartie.NOMBRE_LIGNE)
												&& (positionY >= 0))
										{
											break;
										}
										System.out
												.println("position incorrecte (0-30)");
									}

									if (carteDeLaPartie.map[positionX][positionY]
											.obtenirCaseEtat() == Etat.VIDE)
									{
										try
										{
											listeTour
													.add(new Tour(
															EnumTour.grosseTour,
															carteDeLaPartie.map[positionX][positionY]));
											carteDeLaPartie.map[positionX][positionY]
													.changerPosiEtat(Etat.TOUR);
											this.qtArgent=this.qtArgent-Tour.PRIX_GRANDE_TOUR;
										} catch (CasePleineException e)
										{

										}
										/** TODO a supprimer */
										System.out.println(" Grosse Tour Créée");
										break;

									}
									else
									{
										System.out.println("Position occupé");
										break;
									}
								}
								}
								else
								{
									System.out.println("Argent insufisant");
								}

								break;
							
							default:
								System.out.println("Choix menu invalide");
									

						}
						break;
					case 2 :
						/** TODO Lancer Vague*/
						break;
					default:
						System.out.println("Choix menu invalide");
				}

				carteDeLaPartie.afficherMap();
			}
		}

	}
	
	
	

	/**
	 * Permet de mettre a jour la vie du joueur pour cette partie
	 * 
	 * @param vie
	 *            vie a enlever
	 */
	public void miseAJourDesVies(int vie)
	{
		this.vieJoueur = this.vieJoueur + vie;
	}

	public void miseAJourDeLArgent(int argent)
	{
		this.qtArgent = this.qtArgent + argent;
	}

	public Joueur obtenirJoueurDeLaPartie()
	{
		return joueurDeLaPartie;
	}

	public int obtenirNiveau()
	{
		return niveau;
	}

	public int obtenirQtArgent()
	{
		return qtArgent;
	}

	public Vague[] obtenirVaguePartie()
	{
		return vaguePartie;
	}

	public int obtenirVieJoueur()
	{
		return vieJoueur;
	}
	
	public void lancerUnTour(int nbTour)
	{
		boolean finDuTour=false;
		int numTour=0;
		int numEnnemi=0;
		
		while(finDuTour==false)
		{
			if (numTour%2==0)
			{
				this.vaguePartie[nbTour].lancerUnEnnemi(numEnnemi, ennemiAfficher, this.carteDeLaPartie);
				numEnnemi++;
			}
			for(int indice=0; indice<this.listeTour.size(); indice++)
			{
				this.listeTour.get(indice).attaquer();
			}
			this.vaguePartie[nbTour].faireAvancerLaVague(ennemiAfficher, this.carteDeLaPartie);
			numTour++;
		}
	}

}
