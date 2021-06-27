package maze;

import java.awt.Color;

/*Classe DBox*/
public class DBox extends MBox /*C'est la case de départ, c'est donc une case (= MBox)*/
{

	/*Constructeur de la classe DBox*/
	public DBox(int x, int y)
	{
		super(x, y, "D", new Color(20, 220, 20)/*Couleur verte*/);
	}

}
