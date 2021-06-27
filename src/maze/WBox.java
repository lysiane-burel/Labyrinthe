package maze;

import java.awt.Color;

/*Classe WBox*/
public class WBox extends MBox /*C'est mur, qui est considéré comme une case (= MBox)*/
{

	/*Constructeur de la classe WBox*/
	public WBox(int x, int y)
	{
		super(x, y, "W", new Color(0, 0, 0)/*Couleur noir*/);
	}
}
