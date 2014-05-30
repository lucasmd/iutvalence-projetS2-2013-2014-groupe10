import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TableScore implements ActionListener{

	/** Nombre maximum de scores enregistrés. */
	private static final int NOMBRE_SCORE_MAX = 10;
	/** Chemin du fichier des scores. */
	private String fichier = "score.csv";
	
	private JFrame fenetre;
	private JDialog fenetreScores;
	private JLabel scores;
	private JButton ok;

	/** Créer un fichier de score (console) */
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
	
	/** Créer un fichier de score vide (ihm) */
	public TableScore(JFrame parent) {
		this.fenetre = parent;
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
	public void afficherScoreIHM() {
		String chaine = "<html><table>";
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				chaine += "<tr><td align='center'>" + ligne.replace(";", "</td><td align='center'>") + "</td></tr>";
			}
			br.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		chaine += "</table></html>";
		Font police = new Font("Arial", Font.BOLD, 16);
		this.fenetreScores = new JDialog(fenetre, "Scores", true);
		this.fenetreScores
				.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.fenetreScores.setSize(500, 400);
		this.fenetreScores.setResizable(true);
		fenetreScores.setLocationRelativeTo(null);
		scores = new JLabel(chaine, JLabel.CENTER);
		scores.setFont(police);
		this.fenetreScores.add(scores);
		
		JPanel barreBas = new JPanel();
	    ok = new JButton("Ok");
	    ok.addActionListener(this);
		this.ok.setFont(police);
	    barreBas.add(ok);
	    this.fenetreScores.add(barreBas, BorderLayout.SOUTH);
		this.fenetreScores.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			fenetreScores.dispose();
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
						File temp = new File(fichierTemp);
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
						ecrireDansFichier(fichier, chaine);
						br.close();
						brT.close();
						temp.delete();
						return;
					} catch (Exception e) {
					}
				}
				if (numLigne == NOMBRE_SCORE_MAX - 1) {
					chaine += num + ";" + ligne.split(";")[1] + ";"
							+ ligne.split(";")[2] + "\n";
					num++;
					chaine += num + ";" + joueur.obtenirPseudo() + ";"
							+ joueur.obtenirScoreJoueur() + "\n";
					ecrireDansFichier(fichier, chaine);
					br.close();
					return;
				}
				chaine += ligne + "\n";
			}
			num++;
			chaine += num + ";" + joueur.obtenirPseudo() + ";"
					+ joueur.obtenirScoreJoueur() + "\n";
			ecrireDansFichier(fichier, chaine);
			br.close();
			return;
		} catch (Exception e) {
		}
	}

	/** Ecrit dans un fichier */
	private void ecrireDansFichier(String chemin, String texte) {
		try {
			FileWriter fw = new FileWriter(chemin);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
			fichierSortie.print(texte);
			fichierSortie.close();
		} catch (Exception e) {
		}
	}
}
