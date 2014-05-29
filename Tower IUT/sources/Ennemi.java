import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * 
 * @author Groupe 10
 * 
 */
public abstract class Ennemi {
	public final static Position POSITION_DE_FIN = new Position(14, 29);

	private Case caseEnnemi;
	private String nomEnnemi;
	private int vie_Ennemi;
	private int pointDegats;
	private int scoreGagne;

	/**
	 * Constructeur ennemi
	 * 
	 * @param nom
	 * @param vie
	 * @param degat
	 * @param posiDepart
	 */
	public Ennemi(String nom, int vie, int degat, Case caseDepart, int score) {
		caseEnnemi = caseDepart;
		nomEnnemi = nom;
		vie_Ennemi = vie;
		pointDegats = degat;
		scoreGagne = score;
	}

	public Case obtenirCase() {
		return this.caseEnnemi;
	}

	public void changerCaseEnnemi(Case nvCase) {
		this.caseEnnemi = nvCase;
	}

	public int obtenirVie() {
		return this.vie_Ennemi;
	}

	public int obtenirPtDegats() {
		return this.pointDegats;
	}

	public void avancer(Map mapPartie) {

		int caseEnnemiPositionLigne = this.caseEnnemi.obtenirPosiCase().obtenirPositionLigne();
		int caseEnnemiPositionColonne = this.caseEnnemi.obtenirPosiCase().obtenirPositionColonne();
		mapPartie.map[caseEnnemiPositionLigne][caseEnnemiPositionColonne].changerPosiEtat(Etat.CHEMIN);

		for (int indice = 0; indice < mapPartie.chemin.size(); indice++) 
		{
			if ((mapPartie.chemin.get(indice).obtenirPosiCase().obtenirPositionLigne() == caseEnnemiPositionLigne)&& (mapPartie.chemin.get(indice).obtenirPosiCase().obtenirPositionColonne() == caseEnnemiPositionColonne)) {
				if (indice +1< mapPartie.chemin.size()) 
				{
					caseEnnemiPositionLigne = mapPartie.chemin.get(indice + 1).obtenirPosiCase().obtenirPositionLigne();
					caseEnnemiPositionColonne = mapPartie.chemin.get(indice + 1).obtenirPosiCase().obtenirPositionColonne();
					mapPartie.map[caseEnnemiPositionLigne][caseEnnemiPositionColonne].changerPosiEtat(Etat.ENNEMI);
					this.changerCaseEnnemi(mapPartie.chemin.get(indice + 1));
					break;
				}
			}
		}
	}

	public void testVictoireEnnemie(Partie partieDonnee) {
		if (this.obtenirCase().obtenirPosiCase().obtenirPositionLigne() == 14) {
			if (this.obtenirCase().obtenirPosiCase().obtenirPositionColonne() == 29) {
				partieDonnee.obtenirCarteDeLaPartie().effacerEnnemi(this);
				partieDonnee.obtenirEnnemiAfficher().remove(
						partieDonnee.obtenirEnnemiAfficher().indexOf(this));
				partieDonnee.miseAJourDesVies(-this.pointDegats);
			}
		}
	}

	public void testMortEnnemie(Map carteJeu,
			ArrayList<Ennemi> listeEnnemiAffiche, Joueur joueur) {
		if (this.vie_Ennemi <= 0) {
			carteJeu.effacerEnnemi(this);
			listeEnnemiAffiche.remove(listeEnnemiAffiche.indexOf(this));
			joueur.mettreAJourScore(this.scoreGagne);
		}

	}

	public void perdreVie(int degats) {
		this.vie_Ennemi = this.vie_Ennemi - degats;
	}

}
