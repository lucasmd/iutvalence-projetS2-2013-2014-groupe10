public class Resolution extends Option {
    
    /** Résolution. */
    private int resolution;
    
    /** Retourne la résolution. */
    public int obtenirResolution(){
	return resolution;
    }
    
    /** Modifie la résolution. */
    public void modifierResolution(int res){
	this.resolution = res;
    }
    
}
