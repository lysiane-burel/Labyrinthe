package maze;

/*Classe de l'exception, s'il n'y a pas de plus court chemin*/
public class NoShortestPathException extends Exception
{
	/*Constructeur de la classe MazeReadingException*/
	public NoShortestPathException()
	{
		super("Il n'y a pas de chemin entre la case d'arrivée et la case de départ"); /*Affiche le message*/
	}
}
