import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JSplitPane;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
* Tâche gérant l'IHM (création, affichage)
*
*/
public class JeuxIHM implements Runnable,ActionListener, KeyListener 
{
	private JSplitPane splitPaneGauche;
	private JFrame fenetre;
	private JButton Options;
	private JButton Redemarrer;
	private JButton Quitter;


	
	private void initialiserLInterfaceGraphique()
	{
	this.fenetre = new JFrame();
	
	this.Options = new JButton("Options");
	this.Options.addActionListener(this);
	
	this.Redemarrer = new JButton("Redemarrer");
	this.Redemarrer.addActionListener(this);
	
	this.Quitter = new JButton("Quitter");
	this.Quitter.addActionListener(this);
	

	this.fenetre.setTitle("TowerIUT");
	this.fenetre.setSize(1000, 1000);
	this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	
	//Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.WHITE);
    pan.add(this.Options);
    pan.add(this.Redemarrer);
    pan.add(this.Quitter);
    
    //Instanciation d'un objet JPanel
    JPanel pan2 = new JPanel();
    //Définition de sa couleur de fond
    pan2.setBackground(Color.BLUE);
   
	
	
	// Verouillage des dimensions de la fenêtre
	this.fenetre.setResizable(false);

	JSplitPane splitPaneIntermediaire = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	splitPaneIntermediaire.add(pan);
	splitPaneIntermediaire.add(new JButton("Test"));
	splitPaneIntermediaire.setEnabled(false);
	splitPaneIntermediaire.setBorder(null);
	splitPaneIntermediaire.setDividerSize(0);
	
    this.fenetre.setContentPane(splitPaneIntermediaire);   
	this.fenetre.setVisible(true);
	}
	
	public void run()
	{
		this.initialiserLInterfaceGraphique();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}