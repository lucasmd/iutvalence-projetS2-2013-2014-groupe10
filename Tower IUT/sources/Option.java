import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

public class Option implements ActionListener {

	private JFrame fenetre;
	private JDialog fenetreOptions;
	private JLabel jLabVolume;
	private JLabel jLabResolution;
	private JSlider jSlidVolume;
	JComboBox jComboResolution;
	private JSplitPane splitBas, splitHaut, splitGlobal;
	private JButton valider;
    private JButton annuler;

	public Option() {
	}
	
	public Option(JFrame parent) {
		this.fenetre = parent;
	}

	/** Creer les options. */
	public Option(Option o) {

	}

	/** Affiche les options console. */
	public String afficheOption() {
		return ("Voici un affichage des options");
	}

	/** Affiche les options IHM. */
	public void afficheOptionIHM() {
		this.fenetreOptions = new JDialog(fenetre, "Options", true);
		this.fenetreOptions.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.fenetreOptions.setSize(600, 500);
		this.fenetreOptions.setResizable(true);
		this.fenetreOptions.setLocationRelativeTo(null);
		
		Font police = new Font("Arial", Font.BOLD, 16);
		jLabVolume = new JLabel("Volume :", JLabel.CENTER);
		jLabVolume.setFont(police);
		jLabResolution = new JLabel("Résolution :", JLabel.CENTER);
		jLabResolution.setFont(police);
		jSlidVolume = new JSlider();
		jSlidVolume.setMaximum(100);
		jSlidVolume.setMinimum(0);
		jSlidVolume.setValue(25);
		jSlidVolume.setPaintTicks(true);
		jSlidVolume.setPaintLabels(true);
		jSlidVolume.setMinorTickSpacing(10);
		jSlidVolume.setMajorTickSpacing(20);
		jSlidVolume.setFont(police);
		String[] tabResolution = {"Normal", "Plein écrand"};
		jComboResolution = new JComboBox(tabResolution);
	    jComboResolution.setPreferredSize(new Dimension(150, 30));
	    jComboResolution.setFont(police);
	    JPanel hautG = new JPanel();      
	    JPanel hautD = new JPanel();
	    JPanel basG = new JPanel();
	    JPanel basD = new JPanel();
	    
	    splitBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, hautG, hautD);
	    this.splitBas.setResizeWeight(0.35);
	    this.splitBas.setDividerSize(0);
	    this.splitBas.setEnabled(false);
		this.splitBas.setBorder(null);
	    splitHaut = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, basG, basD);
	    this.splitHaut.setResizeWeight(0.35);
	    this.splitHaut.setDividerSize(0);
	    this.splitHaut.setEnabled(false);
		this.splitHaut.setBorder(null);
	    splitGlobal = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitBas, splitHaut);
	    this.splitGlobal.setResizeWeight(0.5);
	    this.splitGlobal.setDividerSize(0);
	    this.splitGlobal.setEnabled(false);
		this.splitGlobal.setBorder(null);
	    
		hautG.setLayout(new GridBagLayout());
		basG.setLayout(new GridBagLayout());
		hautD.setLayout(new GridBagLayout());
		basD.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
	    this.fenetreOptions.add(splitGlobal);
	    hautG.add(jLabVolume, gbc);
	    basG.add(jLabResolution, gbc);
	    hautD.add(jSlidVolume, gbc);
	    basD.add(jComboResolution, gbc);
	    
	    JPanel barreBas = new JPanel();
	    valider = new JButton("Valider");
	    valider.addActionListener(this);
		this.valider.setFont(police);
	    annuler = new JButton("Annuler");
	    annuler.addActionListener(this);
		this.annuler.setFont(police);
	    barreBas.add(valider);
	    barreBas.add(annuler);
	    this.fenetreOptions.add(barreBas, BorderLayout.SOUTH);
		this.fenetreOptions.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == valider) {
		}
		else if (e.getSource() == annuler) {
			fenetreOptions.dispose();
		}
	}

	/** Modifie les options. */
	public void modifierOption(int num) {
	}
}
