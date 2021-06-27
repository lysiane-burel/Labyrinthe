package window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/* Classe DrawingMaze. C'est la classe du labyrinthe de l'interface graphique*/
public class DrawingMaze extends JPanel
{
	
	private ArrayList<Square> squareList = new ArrayList<>(); /*Le labyrinthe est une liste de carrés*/

//__________________________________________________________________________________________________
	
	/* Constructeur de la classe DrawingMaze*/
	public DrawingMaze(ArrayList<Square> squareList)
	{
		this.squareList = squareList;
		setBackground(Color.WHITE);
		
	}
	
//__________________________________________________________________________________________________
	
	/* Méthode pour dessiner le labyrinthe
	 * @param g*/
	@Override
	protected final void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Square square : squareList)
		{
			square.drawSquare(g);
		}
	}
	
//__________________________________________________________________________________________________
	
	/* Méthode pour ajouter un carré au labyrinthe
	 * @param1 x
	 * @param2 y
	 * @param3 length
	 * @param4 color*/
	public void addSquare(int x, int y, int length, Color color)
	{
		squareList.add(new Square(y, x, length, color));
		repaint();
	}
	
}
