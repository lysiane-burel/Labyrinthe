package window;
import java.awt.FlowLayout;

import javax.swing.*;

/* Classe Window. C'est la classe qui va dessiner le labyrinthe construit via DrawingMaze*/
public class Window extends JFrame
{
	private final WindowPanel windowPanel;
	
	/*Constructeur de la classe Window
	 * @param drawingMaze*/
	public Window(DrawingMaze drawingMaze)
	{
		super("Maze");
		setContentPane(windowPanel = new WindowPanel(this, drawingMaze));/* Dessine le labyrinthe*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
