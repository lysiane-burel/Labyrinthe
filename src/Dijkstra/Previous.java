package Dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

/*Classe Previous*/
public class Previous implements PreviousInterface
{
	
	private Hashtable<VertexInterface, VertexInterface> previous; /*previous est une fonction à valeur dans les sommets*/
	private VertexInterface origin; /*origin est la racine, dont on cherche le plus court chemin vers les autres sommets*/
	
//__________________________________________________________________________________________________
	
	/*Constructeur de la classe Previous*/
	public Previous(VertexInterface vertex)
	{
		previous = new Hashtable<>();
		this.origin = vertex;
	}
	
//__________________________________________________________________________________________________
	
	/*Méthode pour affecter le sommet value à previous(vertex)
	 * Value est le père (= previous) dans le plus court chemin de la racine à vertex
	 * @param1 vertex
	 * @param2 value*/
	@Override
	public void setValue(VertexInterface vertex, VertexInterface value)
	{
		previous.put(vertex, value);
	}

//__________________________________________________________________________________________________
	
	/*Méthode qui renvoie le père (= previous) de vertex
	 * @param vertex
	 * @return previous(vertex) l'antécédent de vertex*/
	@Override
	public VertexInterface getValue(VertexInterface vertex)
	{
		return previous.get(vertex);
	}

//__________________________________________________________________________________________________
	
	/*Méthode qui permet à partir de la fonction previous, de récupérer la liste des sommets (dans l'ordre) qui se trouvent sur le plus court chemin entre la racine (= origin) et le sommet vertex
	 * @param vertex
	 * @return shortestPath la liste des sommets sur le plus court chemin entre vertex et origin*/ 
	@Override
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex)
	{
		ArrayList<VertexInterface> shortestPath = new ArrayList<>(); /*On initialise la liste des sommets*/
		VertexInterface v = vertex;
		shortestPath.add(vertex); /*On ajoute vertex à la liste des sommets*/
		while(v!=null && !v.isEqual(origin)) /*Tant qu'on est pas arrivé à la racine*/
		{
			v = getValue(v); /*On regarde le père (= previous) du sommet v*/
			if(v!=null)
			{
				shortestPath.add(v); /*On l'ajoute dans la liste des sommets*/
			}
		}
		return shortestPath; /*On renvoie la liste des sommets, qui seront les sommets (dans l'ordre) qui se trouvent sur le plus court chemin de vertex à origin*/
	}
	
}
