
/**
 * Création de la classe Case
 *
 */
public class Case
{
	private boolean casePleine;
	
	
	/**
	 * constructeur de case, par défault false (vide)
	 */
	public Case()
	{
		this.casePleine = false;
	}

	 /**
	 * methode permettant de renvoyer l'état d'une case, vide ou pleine (booléen)
	 */
	public boolean obtenirContenu()
	 {
		 if (this.casePleine==false)
			 return true;
		 else
			 return false;
						
	 }
}
