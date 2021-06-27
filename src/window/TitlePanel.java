package window;

import java.awt.*;

import javax.swing.*;

/*Classe TitlePanel. C'est la classe qui va afficher ce qui est écrit au dessus des labyrinthes. Il sera écrit le type du labyrinthe (avec plus court chemin ou pas)*/
public class TitlePanel extends JPanel
{
	/*Constructeur de la classe TitlePanel*/
	public TitlePanel()
	{
		setBackground(Color.WHITE);
		/*On écrit en violet foncé*/
		Color darkPurple = new Color(90, 40, 100);
		
		/*Initialisation des textes et de leur couleur*/
		JLabel texteLabyrinthe1 = new JLabel("   Labyrinthe originel");
		texteLabyrinthe1.setForeground(darkPurple);
		JLabel texteLabyrinthe2 = new JLabel("Labyrinthe avec le plus court chemin en violet");
		texteLabyrinthe2.setForeground(darkPurple);
		/**/
		
		/*Affichage du type des labyrinthes*/
		setLayout(new GridLayout(2, 2));
		add(new JLabel(" "));
		add(new JLabel(" "));
		add(texteLabyrinthe1); /*Affiche "Labyrinthe originel" en violet foncé*/
		add(texteLabyrinthe2); /*Affiche "Labyrinthe avec le plus court chemin en violet" en violet foncé*/
	}
}
