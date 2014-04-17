public class Case
{
	/** État de la case. */
	private boolean casePleine;
	
	/** Constructeur de case. */
	public Case()
	{
		this.casePleine = false;
	}

	 /** Retourne l'�tat d'une case, true=occupée, false=libre. */
	public boolean obtenirContenu()
	 {
		 if (this.casePleine==false)
			 return true;
		 else
			 return false;
	 }
}
