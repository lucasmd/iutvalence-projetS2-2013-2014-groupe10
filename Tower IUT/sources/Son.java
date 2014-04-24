public class Son extends Option {
    
    /** Volume. */
    private int son;
    
    /** Retourne le volume. */
    public int obtenirSon(){
	return son;
    }
    
    /** Modifie le volume. */
    public void modifierSon(int vol){
	this.son = vol;
    }
}
