
/**
 * Cr�ation de la classe Case
 *
 */
public class Case
{
	private boolean casePleine;
	
	
	/**
	 * constructeur de case, par d�fault false (vide)
	 */
	public Case()
	{
		this.casePleine = false;
	}

	 /**
	 * methode permettant de renvoyer l'�tat d'une case, vide ou pleine (bool�en)
	 */
	public boolean obtenirContenu()
	 {
		 if (this.casePleine==false)
			 return true;
		 else
			 return false;
						
	 }
}
