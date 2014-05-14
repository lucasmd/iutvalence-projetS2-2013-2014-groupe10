
public class Partie {
	
	private int niveau;
	private int qtArgent;
	private int vie;
	private Vague[] listeDeVague;
	public final static int VIE_PAR_DEFAUT=20;
	public final static int QUANTITE_ARGENT_PAR_DEFAUT =100;
	
	public Partie(int niveau, String nomJoueur)
	{
		this.niveau=niveau;
		this.vie=VIE_PAR_DEFAUT;
		
	}

}
