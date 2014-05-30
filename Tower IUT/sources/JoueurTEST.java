import junit.framework.TestCase;

/**
 * Test méthodes Joueur
 * @author Maxime
 *
 */
public class JoueurTEST extends TestCase {
	
	public JoueurTEST(String name)
	{
		super(name);
	}
	
	public void testAjouterArgent()
	{
		Joueur joueur = new Joueur("TesT");
		
		joueur.ajouterArgent(10);
		
		assertEquals(joueur.obtenirQtArgent(), 110);
		
		joueur.ajouterArgent(-10);
		
		assertEquals(joueur.obtenirQtArgent(), 120);
		
	}
	
	public void testEnleverArgent()
	{
		Joueur joueur = new Joueur("TesT");
		
		joueur.enleverArgent(10);
		
		assertEquals(joueur.obtenirQtArgent(), 90);
		
		joueur.enleverArgent(-10);
		
		assertEquals(joueur.obtenirQtArgent(), 80);
		
	}
}
