package window;

import java.awt.*;

import javax.swing.*;

/* Classe TextPanel. C'est la classe du texte qui sera affich� en dessous du labyrinthe. C'est la description des cases du labyrinthe*/
public class TextPanel extends JPanel
{
	/*Constructeur de la classe TextPanel*/
	public TextPanel()
	{
		setBackground(Color.WHITE);
		/*Liste des cases*/
		JLabel greenText = new JLabel("  Point de d�part");
		JLabel redText = new JLabel("Point d'arriv�e");
		JLabel grayText = new JLabel("Case franchissable");
		JLabel blackText = new JLabel("Mur");
		/**/
		
		/*On �crit chaque texte dans la couleur de la bo�te*/
		greenText.setForeground(new Color(20, 220, 20)/*Couleur vert*/);
		redText.setForeground(new Color(220, 20, 20)/*Couleur rouge*/);
		grayText.setForeground(new Color(190, 190, 190)/*Couleur gris*/);
		blackText.setForeground(new Color(0, 0, 0)/*Couleur noir*/);
		/**/
		
		/*Affichage du nom des cases*/
		setLayout(new GridLayout(2, 4));
		add(greenText); /*Affiche "Point de d�part" en vert*/
		add(redText); /*Affiche "Point de d'arriv�e" en rouge*/
		add(grayText); /*Affiche "Case franchissable" en gris*/
		add(blackText); /*Affiche "Mur" en noir*/
		add(new JLabel(" "));
		add(new JLabel(" "));
		add(new JLabel(" "));
		add(new JLabel(" "));
		/**/
	}
}
