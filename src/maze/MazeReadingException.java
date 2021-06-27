package maze;

/*Classe des exceptions lors de la lecture du labyrinthe*/
public class MazeReadingException extends Exception
{
	/*Constructeur de la classe MazeReadingException*/
	public MazeReadingException(String fileName, int line, String msg)
	{
		super(msg + " à la ligne " + line + " dans le fichier " + fileName); /*Affiche le message*/
	}
}
