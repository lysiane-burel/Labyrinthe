package maze;

import java.awt.Color;

/*Classe ABox*/
public class ABox extends MBox /*C'est la case d'arriv�e, c'est donc une case (=MBox)*/
{

	/*Constructeur de la classe ABox*/
	public ABox(int x, int y)
	{
		super(x, y, "A", new Color(220, 20, 20) /*Couleur rouge*/);
	}
	
}
