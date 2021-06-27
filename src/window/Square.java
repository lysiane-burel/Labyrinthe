package window;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/* Classe Square. C'est la classe des carrés du labyrinthe de l'interface graphique*/
public class Square
{
	
	private int x; /*Coordonnée x du carré*/
	private int y; /* Coordonnée y du carré*/
	private int length; /* Longueur d'un côté du carré*/
	private Color color; /* Couleur du carré*/
	private Color darkPurple = new Color(90, 40, 100); /*Couleur violet foncé pour le contour des carrés*/
	
//__________________________________________________________________________________________________
	
	/* Constructeur de la classe Square*/
	public Square(int x, int y, int length, Color color)
	{
		this.x = x;
		this.y = y;
		this.length = length;
		this.color = color;
	}
	
//__________________________________________________________________________________________________
	
	/* Méthode pour afficher un carré sur l'interface graphique
	 * @param g*/
	public void drawSquare(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, length, length); /*Affiche le carré en couleur color, de taille length*length aux coordonnées (x, y)*/
		g.setColor(darkPurple);
		g.drawRect(x, y, length, length); /*Affiche le contour du carré en violet foncé*/
	}
	
}
