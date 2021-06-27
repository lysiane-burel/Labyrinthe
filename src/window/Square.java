package window;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/* Classe Square. C'est la classe des carr�s du labyrinthe de l'interface graphique*/
public class Square
{
	
	private int x; /*Coordonn�e x du carr�*/
	private int y; /* Coordonn�e y du carr�*/
	private int length; /* Longueur d'un c�t� du carr�*/
	private Color color; /* Couleur du carr�*/
	private Color darkPurple = new Color(90, 40, 100); /*Couleur violet fonc� pour le contour des carr�s*/
	
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
	
	/* M�thode pour afficher un carr� sur l'interface graphique
	 * @param g*/
	public void drawSquare(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, length, length); /*Affiche le carr� en couleur color, de taille length*length aux coordonn�es (x, y)*/
		g.setColor(darkPurple);
		g.drawRect(x, y, length, length); /*Affiche le contour du carr� en violet fonc�*/
	}
	
}
