package window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import maze.Maze;
import maze.MBox;
import Dijkstra.VertexInterface;

/* Classe WindowPanel. C'est la classe qui va cr�er la fen�tre*/
public class WindowPanel extends JPanel
{
	/*Constructeur de la classe WindowPanel
	 * @param1 window
	 * @param2 drawingMaze*/
	public WindowPanel(Window window, DrawingMaze drawingMaze)
	{
		setPreferredSize(new Dimension(800, 400)); /*La taille de la fen�tre sera 800*400*/
		setLayout(new BorderLayout());
		add(new TitlePanel(), BorderLayout.NORTH); /*Le titre sera �crit en haut de la fen�tre*/
		add(drawingMaze, BorderLayout.CENTER); /*Le labyrinthe sera au milieu de la fen�tre*/
		add(new TextPanel(), BorderLayout.SOUTH); /*La description des cases sera en bas de la fen�tre*/
	}
}
