import java.util.ArrayList;


public abstract class Vague 
{
	public final static Position POSITION_DE_FIN=new Position(14,29);
	private Ennemi[] tabEnnemi;
	
	/**
	 * Constructeur
	 * @param niv
	 */
	public Vague()
	{
		//il faut creer un tableau de vague en fonction du niveau
	}
	
	public void lancerUnEnnemi(int place,Ennemi[] ennemiAfficher,Map mapDeJeu)
	{
		ennemiAfficher[place]=this.tabEnnemi[place];
		mapDeJeu.afficherEnnemi(tabEnnemi[place]);
	}
	
	public void faireAvancerLaVague(Ennemi[] ennemiAfficher,Map mapDeJeu)
	{
		for(int index=0; index<ennemiAfficher.length; index++)
		{
			ennemiAfficher[index].avancer(mapDeJeu);
			mapDeJeu.afficherEnnemi(ennemiAfficher[index]);
		}
	}
	/**
	 * Lancement de la vague
	 */
	/*public void LancerVague(Map mapDeJeu, ArrayList<Case> chemin, Partie partieDonnee)
	{
		
			
			
				
					while ((ennemiAfficher[index].obtenirCase().obtenirPosiCase()!=POSITION_DE_FIN))
					{
						mapDeJeu.afficherEnnemi(ennemiAfficher[index]);
						mapDeJeu.afficherMap();
						if (ennemiAfficher[index].obtenirCase().obtenirPosiCase().obtenirPositionLigne()==14)
						{
							if(ennemiAfficher[index].obtenirCase().obtenirPosiCase().obtenirPositionColonne()==29)
							{
								mapDeJeu.effacerEnnemi(ennemiAfficher[index]);
								partieDonnee.mettreAJourVie(ennemiAfficher[index].obtenirPtDegats());
							}
						}
					}
				}*/
				

}
