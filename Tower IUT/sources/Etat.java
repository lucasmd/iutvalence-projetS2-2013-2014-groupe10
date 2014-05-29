
public enum Etat 
{
	VIDE(" "),
	TOUR("T"),
	ENNEMI("E"),
	CHEMIN("_");
	
	private final String representation;
    
    /**
     * Constructeur d'une couleur
     * @param representation
     */
    Etat(String representation) 
    {
        this.representation = representation;
    }

    /** affiche la representation texte de la couleur lorsque l'on demande d'afficher la couleur*/
    @Override
    public String toString() 
    {
        return representation;
    }
}