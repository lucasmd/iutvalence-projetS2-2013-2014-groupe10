import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BCase extends JButton {
	private int ligne;
	private int colonne;
	
	public BCase(int numL, int numC, ActionListener abonnement){
	    this.ligne = numL;
	    this.colonne = numC;
	    this.addActionListener(abonnement);
	}
	
	public int obtenirLigne(){
		return ligne;
	}
	
	public int obtenirColonne(){
		return colonne;
	}
	
}