import maze.Maze;

/* Classe MainTest. C'est la classe qui exécute le programme*/
public class MainTest
{
	public static void main(String args[])
	{
		Maze maze = new Maze(10,10); /*Créé un nouveau labyrinthe de taille 10*10 (largeur*hauteur)*/
		maze.initFromTextFile("data/labyrinthe.txt"); /*Initialise le labyrinthe à partir du fichier texte labyrinthe.txt*/
		maze.showShortestPathFromDToA(); /*Affiche le plus court chemin entre D et A*/
		maze.saveToTextFile("data/labyrinthe2.txt"); /* Sauvegarde le labyrinthe dans un second fichier texte labyrinthe2.txt*/
	}
}
