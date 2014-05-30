import java.util.ArrayList;


public abstract class Vague 
{
	public final static Position POSITION_DE_FIN=new Position(14,29);
	protected Ennemi[] tabEnnemi;
	
	/**
	 * Constructeur
	 * @param niv
	 */
	public Vague()
	{
		//il faut creer un tableau de vague en fonction du niveau
	}
	
	/**
	 * Permet de poser un ennemi sur sur la case de depart
	 * @param place
	 * @param ennemiAfficher
	 * @param mapDeJeu
	 */
	public void lancerUnEnnemi(int place,ArrayList<Ennemi> ennemiAfficher,Map mapDeJeu)
	{
		int placeAfficher=ennemiAfficher.size();
		ennemiAfficher.add(placeAfficher,this.tabEnnemi[place]);
		mapDeJeu.afficherEnnemi(tabEnnemi[place]);
	}
	
	/**
	 * Permet de faire avancer les ennemis present sur la map 
	 * @param ennemiAfficher
	 * @param mapDeJeu
	 */
	public void faireAvancerLaVague(ArrayList<Ennemi> ennemiAfficher,Map mapDeJeu)
	{
		for(int index=0; index<ennemiAfficher.size(); index++)
		{
			ennemiAfficher.get(index).avancer(mapDeJeu);
			mapDeJeu.afficherEnnemi(ennemiAfficher.get(index));
		}
	}
	
	/**
	 * Accesseur du tableau d'ennemi
	 * @return
	 */
	public Ennemi[] obtenirTabEnnemi() 
	{
		return tabEnnemi;
	}

				

}
