public class Case {
	/** État de la case. */
	private static boolean casePleine;

	/** Constructeur de case. */
	public Case() {
		this.casePleine = false;
	}

	/** Retourne l'état d'une case, true=occupée, false=libre. */
	public static boolean obtenirContenu() {
		return casePleine;
	}
}
