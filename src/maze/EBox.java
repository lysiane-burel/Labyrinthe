package maze;

import java.awt.Color;

/*Classe EBox*/
public class EBox extends MBox /*C'est une case que l'on peut traverser, c'est donc une case (= MBox)*/
{

	/*Constructeur de la classe EBox*/
	public EBox(int x, int y)
	{
		super(x, y, "E", new Color(220, 220, 220)/*Couleur gris clair*/);
	}


}
