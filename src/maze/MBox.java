package maze;

import Dijkstra.VertexInterface;
import java.awt.Color;

/*Classe MBox, c'est la classe des les cases du labyrinthe*/
public abstract class MBox implements VertexInterface
{
	
	private int x; /*Coordonn�e x de la case*/
	private int y; /*Coordonn�e y de la case*/
	private String label; /*Nom de la case (= type de case (mur, sol, d�part, arriv�e))*/
	private Color color; /*Couleur de la case. La couleur d�pendra du type de case*/
	
//__________________________________________________________________________________________________
	
	/*Constructeur de la classe MBox*/
	public MBox(int x, int y, String label, Color color)
	{
		this.x = x;
		this.y = y;
		this.label = label;
		this.color = color;
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie la coordonn�e x de la case
	 * @return x*/
	public int getX()
	{
		return x;
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie la coordonn�e y de la case
	 * @return y*/
	public int getY()
	{
		return y;
	}	
	
//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie le type de case
	 * @return label*/
	@Override
	public String getLabel()
	{
		return label;
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie la couleur de la case
	 * @return color*/
	public Color getColor()
	{
		return color;
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie si autre un sommet vertex est le m�me ou non
	 * @param vertex
	 * @return true si les sommets ont les m�mes coordonn�es
	 * @return false sinon*/
	@Override
	public boolean isEqual(VertexInterface vertex)
	{
		MBox box = (MBox) vertex;
		if(box.getX()==x && box.getY()==y) /*On compare les coordonn�es des 2 cases*/
		{
			return true;
		}
		return false;
	}
	
}
