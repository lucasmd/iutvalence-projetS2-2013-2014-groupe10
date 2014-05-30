import java.util.ArrayList;

import junit.framework.*;

public class EnnemiTest extends TestCase
{
	/**
	 * Constructeur
	 */
	EnnemiTest(String nom)
	{
		super(nom);
	}
	
	public void testTestMortEnnemi()
	{
		Ennemi ennemi = new EnnemiGEA();
		Joueur joueur= new Joueur("pseudo");
		Partie pat= new Partie(joueur, 1, new TableScore());
		pat.obtenirEnnemiAfficher().add(ennemi);
		
		int tailleListEnnemi=pat.obtenirEnnemiAfficher().size();
		boolean ennemiPresent=true;
		ennemi.testMortEnnemie(new Map(), pat.obtenirEnnemiAfficher(), pat.obtenirJoueurDeLaPartie());
		
		if(pat.obtenirEnnemiAfficher().size()!=tailleListEnnemi)
		{
			ennemiPresent=false;
		}
		assertEquals(ennemiPresent,true);
		ennemi.perdreVie(5);
		ennemi.testMortEnnemie(new Map(), pat.obtenirEnnemiAfficher(), pat.obtenirJoueurDeLaPartie());
		if(pat.obtenirEnnemiAfficher().size()!=tailleListEnnemi)
		{
			ennemiPresent=false;
		}
		assertEquals(ennemiPresent,false);
	}
	
	public void testTestVictoireEnnemi()
	{
		Joueur joueur= new Joueur("pseudo");
		Partie pat= new Partie(joueur, 1, new TableScore());
		Ennemi ennemi = new EnnemiGEA();
		pat.obtenirEnnemiAfficher().add(ennemi);
		
		int tailleListEnnemi=pat.obtenirEnnemiAfficher().size();
		boolean ennemiPresent=true;
		ennemi.testVictoireEnnemie(pat);
		if(pat.obtenirEnnemiAfficher().size()!=tailleListEnnemi)
		{
			ennemiPresent=false;
		}
		assertEquals(ennemiPresent,true);
		ennemi.changerCaseEnnemi(new Case(14,29));
		ennemi.testVictoireEnnemie(pat);
		if(pat.obtenirEnnemiAfficher().size()!=tailleListEnnemi)
		{
			ennemiPresent=false;
		}
		assertEquals(ennemiPresent,false);
		
	}
	public static Test suite() 
	{
		  TestSuite suite= new TestSuite();
		  suite.addTest(new EnnemiTest("testTestMortEnnemi"));
		  suite.addTest(new EnnemiTest("testTestVictoireEnnemi"));
		  return suite;
	}

}
