import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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
public class MenuIHM implements Runnable,ActionListener, KeyListener 
{
	private JSplitPane splitPaneGauche;
	private JFrame fenetre;
	private JButton Jouer;
	private JButton Redemarrer;
	private JButton Options;
	private JButton Pseudo;
	private JButton Score;
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
	
	this.Jouer = new JButton("Jouer");
	this.Jouer.addActionListener(this);
	
	this.Pseudo = new JButton("Pseudo");
	this.Pseudo.addActionListener(this);
	
	this.Score = new JButton("Score");
	this.Score.addActionListener(this);
	

	this.fenetre.setTitle("Menu TowerIUT");
	this.fenetre.setSize(100, 300);
	this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	
	
	
	//Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.WHITE);
    pan.add(this.Jouer);
    pan.add(this.Redemarrer);
    pan.add(this.Score);
    pan.add(this.Pseudo);
    pan.add(this.Options);
    pan.add(this.Quitter);
    pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
    Quitter.addActionListener
    ( new ActionListener () {public void actionPerformed ( ActionEvent e) {fenetre.dispose (); }}); 
    
   
	// Verouillage des dimensions de la fenêtre
	this.fenetre.setResizable(true);
	this.fenetre.setContentPane(pan);   
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
		// TODO Auto-generated methhhod stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}