package Dijkstra;

import java.util.Hashtable;

/*Classe de la fonction Pi. La fonction pi appliquée à un sommet x quelconque doit renvoyer la longueur du plus court chemin entre r (la racine) et x*/
public class Pi implements PiInterface
{
	
	private Hashtable<VertexInterface, Integer> pi; /*La fonction pi associe un sommet à un entier*/
	
//__________________________________________________________________________________________________
	
	/*Constructeur de la fonction pi*/
	public Pi()
	{
		pi = new Hashtable<>();
	}
	
//__________________________________________________________________________________________________
	
	/*Méthode qui modifie la valeur de pi(vertex) par value
	 * @param1 vertex
	 * @param2 value*/
	@Override
	public void setValue(VertexInterface vertex, int value)
	{
		pi.put(vertex, value);
		
	}

//__________________________________________________________________________________________________
	
	/*Méthode qui renvoie la valeur de pi(vertex)
	 * @param vertex
	 * @return la valeur de pi(vertex)*/
	@Override
	public int getValue(VertexInterface vertex)
	{
		return pi.get(vertex);
	}

}
