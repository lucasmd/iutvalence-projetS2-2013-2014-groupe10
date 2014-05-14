import java.security.SecureRandom;

/**
 * 
 * @author Groupe 10
 *
 */
public abstract class Ennemi 
{
	private Position positionEnnemi;
	private String nomEnnemi;
	private int vie_Ennemi;
	private int pointDegats;


	/**
	 * Constructeur ennemi
	 * @param nom
	 * @param vie
	 * @param degat
	 * @param posiDepart
	 */
	public Ennemi(String nom, int vie, int degat, Position posiDepart)
	{
		positionEnnemi = posiDepart;
		nomEnnemi = nom;
		vie_Ennemi = vie;
		pointDegats = degat;
	}
	/**
	 * Methode qui permet d'attaquer une tour
	 * @param tourAttaque
	 */
	public abstract void attaquer(Tour tourAttaque);
	//faire des methode pour obetenir l'etat des position dessous dessus droite gauche
	public void avancer()
	{
		Position posiGauche=this.positionEnnemi;
		posiGauche.changerPositionLigne(-1);
		
		Position posiDroit=this.positionEnnemi;
		posiGauche.changerPositionLigne(1);
		
		Position posiDessus=this.positionEnnemi;
		posiGauche.changerPositionColonne(1);
		
		Position posiDessous=this.positionEnnemi;
		posiGauche.changerPositionLigne(-1);
		
		if (posiDessus.obtenirPositionEtat()==Etat.VIDE)
		{
			this.avancerAuDessus();
		}
		
		if ((posiDroit.obtenirPositionEtat()==Etat.VIDE) && (posiGauche.obtenirPositionEtat()==Etat.VIDE))
		{
			SecureRandom genarateurAleatoireDeDirection= new SecureRandom();
			int deplacement=genarateurAleatoireDeDirection.nextInt(1);
			if(deplacement==0)
			{
				this.avancerADroite();
			}
			else
			{
				this.avancerAGauche();
			}
		}
		else
		{
			if (posiDroit.obtenirPositionEtat()==Etat.VIDE)
				this.avancerAGauche();
			if (posiGauche.obtenirPositionEtat()==Etat.VIDE)
				this.avancerADroite();
			else
				this.avancerAuDessous();
		}
	}

	public void avancerADroite()
	{
		this.positionEnnemi.changerPosiEtat(Etat.VIDE);
		this.positionEnnemi.changerPositionLigne(-1);
		this.positionEnnemi.changerPosiEtat(Etat.ENNEMI);
		
	}
	
	public void avancerAGauche()
	{
		this.positionEnnemi.changerPosiEtat(Etat.VIDE);
		this.positionEnnemi.changerPositionLigne(1);
		this.positionEnnemi.changerPosiEtat(Etat.ENNEMI);
	}
	
	public void avancerAuDessus()
	{
		this.positionEnnemi.changerPosiEtat(Etat.VIDE);
		this.positionEnnemi.changerPositionColonne(1);
		this.positionEnnemi.changerPosiEtat(Etat.ENNEMI);
	}
	
	public void avancerAuDessous()
	{
		this.positionEnnemi.changerPosiEtat(Etat.VIDE);
		this.positionEnnemi.changerPositionColonne(-1);
		this.positionEnnemi.changerPosiEtat(Etat.ENNEMI);
	}

	public Position obtenirPosition()
	{
		return this.positionEnnemi;
	}

	public int obtenirVie()
	{
		return this.vie_Ennemi;
	}

	public int obtenirPtDegats()
	{
		return this.pointDegats;
	}
}
