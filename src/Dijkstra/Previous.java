package Dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

/*Classe Previous*/
public class Previous implements PreviousInterface
{
	
	private Hashtable<VertexInterface, VertexInterface> previous; /*previous est une fonction � valeur dans les sommets*/
	private VertexInterface origin; /*origin est la racine, dont on cherche le plus court chemin vers les autres sommets*/
	
//__________________________________________________________________________________________________
	
	/*Constructeur de la classe Previous*/
	public Previous(VertexInterface vertex)
	{
		previous = new Hashtable<>();
		this.origin = vertex;
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode pour affecter le sommet value � previous(vertex)
	 * Value est le p�re (= previous) dans le plus court chemin de la racine � vertex
	 * @param1 vertex
	 * @param2 value*/
	@Override
	public void setValue(VertexInterface vertex, VertexInterface value)
	{
		previous.put(vertex, value);
	}

//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie le p�re (= previous) de vertex
	 * @param vertex
	 * @return previous(vertex) l'ant�c�dent de vertex*/
	@Override
	public VertexInterface getValue(VertexInterface vertex)
	{
		return previous.get(vertex);
	}

//__________________________________________________________________________________________________
	
	/*M�thode qui permet � partir de la fonction previous, de r�cup�rer la liste des sommets (dans l'ordre) qui se trouvent sur le plus court chemin entre la racine (= origin) et le sommet vertex
	 * @param vertex
	 * @return shortestPath la liste des sommets sur le plus court chemin entre vertex et origin*/ 
	@Override
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex)
	{
		ArrayList<VertexInterface> shortestPath = new ArrayList<>(); /*On initialise la liste des sommets*/
		VertexInterface v = vertex;
		shortestPath.add(vertex); /*On ajoute vertex � la liste des sommets*/
		while(v!=null && !v.isEqual(origin)) /*Tant qu'on est pas arriv� � la racine*/
		{
			v = getValue(v); /*On regarde le p�re (= previous) du sommet v*/
			if(v!=null)
			{
				shortestPath.add(v); /*On l'ajoute dans la liste des sommets*/
			}
		}
		return shortestPath; /*On renvoie la liste des sommets, qui seront les sommets (dans l'ordre) qui se trouvent sur le plus court chemin de vertex � origin*/
	}
	
}
