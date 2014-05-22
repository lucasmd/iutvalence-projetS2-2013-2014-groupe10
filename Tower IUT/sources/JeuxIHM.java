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
public class JeuxIHM implements Runnable,ActionListener, KeyListener 
{
	private JSplitPane splitPaneGauche;
	private JFrame fenetre;
	private JButton Options;
	private JButton Redemarrer;
	
	private JButton Quitter;
	private JButton Tower1;
	private JButton Tower2;
	private JButton Tower3;



	
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

	this.Tower1 = new JButton(new ImageIcon("docs/Tower1.png" ));
	this.Tower1.addActionListener(this);
	this.Tower2 = new JButton(new ImageIcon("docs/Tower2.png" ));
	this.Tower2.addActionListener(this);
	this.Tower3 = new JButton(new ImageIcon("docs/Tower3.png" ));
	this.Tower3.addActionListener(this);
	
	
	//Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.WHITE);
    pan.add(this.Options);
    pan.add(this.Redemarrer);
    pan.add(this.Quitter);
    pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
    
    
    //Instanciation d'un objet JPanel
    JPanel pan2 = new JPanel();
    //Définition de sa couleur de fond
    pan2.setBackground(Color.WHITE);
   
    pan2.setLayout(new GridLayout(30,30));
    for (int i=0;i<Map.NOMBRE_LIGNE*Map.NOMBRE_COLONNE;i++){
    	pan2.add(new JButton(new ImageIcon("docs/sol.png" )));
   
    }
    //SwingUtilities.windowForComponent(pan2).pack();
 
    //Instanciation d'un objet JPanel
    JPanel pan3 = new JPanel();
    //Définition de sa couleur de fond
    pan3.setBackground(Color.GRAY);
    pan3.add(this.Tower1);
    pan3.add(this.Tower2);
    pan3.add(this.Tower3);
   
    JSplitPane splitPaneBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    splitPaneBas.setTopComponent(pan);
    splitPaneBas.setBottomComponent(pan3);
    splitPaneBas.setEnabled(false);
    splitPaneBas.setBorder(null);
    splitPaneBas.setResizeWeight(0.1);
    splitPaneBas.setDividerSize(0);
	
	// Verouillage des dimensions de la fenêtre
	this.fenetre.setResizable(true);

	JSplitPane splitPaneIntermediaire = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	//splitPaneIntermediaire.add(pan2);
	//splitPaneIntermediaire.add(splitPaneBas);
	
	splitPaneIntermediaire.setTopComponent(pan2);
	splitPaneIntermediaire.setBottomComponent(splitPaneBas);
	splitPaneIntermediaire.setEnabled(false);
	splitPaneIntermediaire.setBorder(null);
	splitPaneIntermediaire.setResizeWeight(0.8);
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
		// TODO Auto-generated methhhod stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}