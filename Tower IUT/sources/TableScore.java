import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableScore {

	/** Nombre maximum de scores enregistrés. */
	private int nombreDeScoreMax = 10;
	/** Chemin du fichier des scores. */
	private String fichier = "score.csv";

	/** Créer un fichier de score vide. */
	public TableScore() {
		File score = new File(fichier);
		if (!score.exists()) {
			try {
				FileWriter fw = new FileWriter(fichier);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter fichierSortie = new PrintWriter(bw);
				fichierSortie.println("Classement;Pseudo;Score");
				for (int i = 1; i <= nombreDeScoreMax; i++)
					fichierSortie.println(i + ";Null;0");
				fichierSortie.close();
			} catch (Exception e) {
			}
		}
	}

	/** Affiche les scores. */
	public void afficherScore() {
		String chaine = "";
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				System.out.println(ligne.replace(';', ' '));
				chaine += ligne + "\n";
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/** Modifie les scores. */
	public void modifierScore(Joueur joueur) {
		int score = joueur.obtenirScoreJoueur();
		String chaine = "";
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			ligne = br.readLine();
			chaine += ligne + "\n";
			while ((ligne = br.readLine()) != null) {
				int scoreLigne = new Integer(ligne.split(";")[2]);
				System.out.println(scoreLigne);
				chaine += ligne + "\n";
				System.out.println(chaine);
				if (scoreLigne < score) {
					chaine += "num;laxe;1000\n";
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		/**
		 * TODO Rajouter la partie qui compare avec les scores, et qui ajoute au
		 * bon endroit si il le faut.
		 */
	}
}
