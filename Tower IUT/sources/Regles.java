public class Regles
{
	/** Règles du jeu. */
	private String texteDesRegles;
	
	/** Constructeur des règles. */
	public Regles(){
		this.texteDesRegles="Vous devez emp�cher les GEA et les TC d'entrer dans la salle informatique...";
	}
	
	/** Retourne les règles du jeu. */
	public String afficherRegles(){
		return texteDesRegles;
	}
}
