import java.io.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class TableScore {

	/** Nombre maximum de scores enregistrés. */
	private static final int NOMBRE_SCORE_MAX = 10;
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
				chaine += "<tr><td>" + ligne.replace(";", "</td><td>")
						+ "</td></tr>";
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
			String ligne = br.readLine();
			chaine += ligne + "\n";
			int num = 0;
			while ((ligne = br.readLine()) != null) {
				num++;
				int numLigne = new Integer(ligne.split(";")[0]);
				int scoreLigne = new Integer(ligne.split(";")[2]);
				if (scoreLigne <= score) {
					String chaineT = num + ";" + joueur.obtenirPseudo() + ";"
							+ joueur.obtenirScoreJoueur() + "\n";
					num++;
					chaineT += num + ";" + ligne.split(";")[1] + ";"
							+ ligne.split(";")[2];
					try {
						String fichierTemp = "temp.csv";
						FileWriter fw = new FileWriter(fichierTemp);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter fichierSortie = new PrintWriter(bw);
						while (((ligne = br.readLine()) != null)
								&& num <= NOMBRE_SCORE_MAX - 1) {
							num++;
							fichierSortie.println(num + ";"
									+ ligne.split(";")[1] + ";"
									+ ligne.split(";")[2]);
						}
						fichierSortie.close();
						InputStream ipsT = new FileInputStream(fichierTemp);
						InputStreamReader ipsrT = new InputStreamReader(ipsT);
						BufferedReader brT = new BufferedReader(ipsrT);
						String ligneT = "";
						while ((ligneT = brT.readLine()) != null) {
							chaineT += "\n" + ligneT;
						}
						chaine += chaineT;
						try {
							FileWriter fw2 = new FileWriter(fichier);
							BufferedWriter bw2 = new BufferedWriter(fw2);
							PrintWriter fichierSortie2 = new PrintWriter(bw2);
							fichierSortie2.println(chaine);
							fichierSortie2.close();
						} catch (Exception e) {
						}
						br.close();
						brT.close();
						return;
					} catch (Exception e) {
					}
				}
				if (numLigne == NOMBRE_SCORE_MAX - 1) {
					chaine += num + ";" + joueur.obtenirPseudo() + ";"
							+ joueur.obtenirScoreJoueur() + "\n";
					num++;
					chaine += num + ";" + ligne.split(";")[1] + ";"
							+ ligne.split(";")[2] + "\n";
					try {
						FileWriter fw3 = new FileWriter(fichier);
						BufferedWriter bw3 = new BufferedWriter(fw3);
						PrintWriter fichierSortie3 = new PrintWriter(bw3);
						fichierSortie3.print(chaine);
						fichierSortie3.close();
					} catch (Exception e) {
					}
					br.close();
					return;
				}
				chaine += ligne + "\n";
			}
			num++;
			chaine += num + ";" + joueur.obtenirPseudo() + ";"
					+ joueur.obtenirScoreJoueur() + "\n";
			try {
				FileWriter fw3 = new FileWriter(fichier);
				BufferedWriter bw3 = new BufferedWriter(fw3);
				PrintWriter fichierSortie3 = new PrintWriter(bw3);
				fichierSortie3.print(chaine);
				fichierSortie3.close();
			} catch (Exception e) {
			}
			br.close();
			return;
		} catch (Exception e) {
		}
	}
}
