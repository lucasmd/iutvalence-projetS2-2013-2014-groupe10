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
					fichierSortie.println(i + "; ; ");
				fichierSortie.close();
			} catch (Exception e) {
			}
		}
	}

	/** Affiche les scores pour console. */
	public String afficherScoreConsole() {
		String chaine = "";
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				chaine += ligne.replace(';', ' ') + "\n";
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return chaine;
	}
	
	/** Affiche les scores pour IHM. */
	public String afficherScoreIHM() {
		String chaine = "<html><table>";
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				chaine += "<tr><td>"+ligne.replace(";", "</td><td>") + "</td></tr>";
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		chaine += "</table></html>";
		return chaine;
	}

	/** Modifie les scores. */
	public void modifierScore(Joueur joueur) {
		int score = joueur.obtenirScoreJoueur();
		String chaine = "";
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne= br.readLine();
			String dernLigne = "";
			chaine += ligne + "\n";
			int nombreTours = 1;
			while ((ligne = br.readLine()) != null) {
				nombreTours++;
				int scoreLigne = new Integer(ligne.split(";")[2]);
				if (scoreLigne <= score) {
					chaine += ligne.split(";")[0]+";"+joueur.obtenirPseudo()+";"+joueur.obtenirScoreJoueur()+"\n";
					chaine += ligne.split(";")[0]+";"+ligne.split(";")[1]+";"+ligne.split(";")[2]+"\n";
					while ((ligne = br.readLine()) != null) {
						nombreTours++;
						chaine += nombreTours+";"+ligne.split(";")[1]+";"+ligne.split(";")[2]+"\n";
					}
					dernLigne = ligne;
					System.out.println(chaine);
					br.close();
					return;
				}
				chaine += ligne + "\n";
				dernLigne = ligne;
			}
			System.out.println(chaine);
			br.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
