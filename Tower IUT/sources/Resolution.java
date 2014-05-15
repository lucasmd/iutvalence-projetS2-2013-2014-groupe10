import java.awt.Toolkit;

public class Resolution extends Option {
    
    /** Résolution du PC. */
    private int[] resolutionPC;
    /** Résolution du jeu. */
    private int[] resolutionJeu;
    
    /** Retourne la résolution du PC. */
    public int[] obtenirResolutionPC(){
    	resolutionPC = new int[2];
    	resolutionPC[0] = Toolkit.getDefaultToolkit().getScreenSize().width;
    	resolutionPC[1] = Toolkit.getDefaultToolkit().getScreenSize().height;
    	return resolutionPC;
    }
    
    /** Retourne la résolution du jeu. */
    public int[] obtenirResolutionJeu(){
    	resolutionJeu = new int[2];
    	/**TODO Remplacer f par le nom de la fenetre. (Frame f = new Frame();) */
    	int largeur = f.getSize().width;
    	int hauteur = f.getSize().height;
    }
    
    /** Modifie la résolution du jeu. */
    public void modifierResolutionJeu(int[] res){
    	/** TODO Appeller la méthode qui redimenssionne la fenetre. */
    }
    
}
