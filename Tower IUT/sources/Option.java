import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;

public class Option {

	private JFrame fenetre;
	private JDialog fenetreOptions;
	private JLabel volume;
	private JLabel resolution;
	private JSlider slide;

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
		this.fenetreOptions
				.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.fenetreOptions.setSize(600, 500);
		this.fenetreOptions.setResizable(true);
		fenetreOptions.setLocationRelativeTo(null);
		Font police = new Font("Arial", Font.BOLD, 16);
		fenetreOptions.setLayout(new GridLayout(2, 2));
		volume = new JLabel("Volume :", JLabel.CENTER);
		volume.setFont(police);
		slide = new JSlider();
		slide.setMaximum(100);
		slide.setMinimum(0);
		slide.setValue(25);
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setMinorTickSpacing(10);
		slide.setMajorTickSpacing(20);
		resolution = new JLabel("Résolution :", JLabel.CENTER);
		resolution.setFont(police);
		this.fenetreOptions.add(volume);
		this.fenetreOptions.add(slide, BorderLayout.WEST);
		this.fenetreOptions.add(resolution);
		this.fenetreOptions.setVisible(true);
	}

	/** Modifie les options. */
	public void modifierOption(int num) {
	}
}
