package Dijkstra;

import java.util.ArrayList;

/*Classe Dijkstra*/
public class Dijkstra
{
	
	/*M�thode qui impl�mente l'algorithme de Dijkstra
	 * @param1 g
	 * @param2 r
	 * @param3 a
	 * @param4 pi
	 * @param5 previous
	 * @return previous qui permet d'acc�der � tous plus courts chemins (previous contient les ant�c�dents de chaque sommet dans le plus court chemin*/
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous)
	{
		VertexInterface pivot = r; /*On fixe un pivot*/
		a.add(r); /*On ajoute le sommet r � l'arborescence a*/
		int n = g.getSize(); /*n est le nombre de sommets du graphe g*/
		ArrayList<VertexInterface> listVertex = g.getAllVertices(); /*On fait la liste de tous les sommets*/
		
		for(VertexInterface y : listVertex)
		{
			pi.setValue(y, Integer.MAX_VALUE); /*On fixe la longueur du plus court chemin de y � r � MAX_VALUE*/
		}
		pi.setValue(r, 0); /*La longueur du plus court chemin de r � r est 0*/
		
		for(int i=0; i<n; i++)
		{		
			ArrayList<VertexInterface> suc = g.getSuccessors(pivot); /*On fait la liste des successeurs du sommet pivot*/
			for(VertexInterface y : suc) /*Pour tous les sommets y successeurs de pivot...*/
			{
				if(!a.contains(y)) /*... qui ne sont pas dans l'arborescence a*/
				{
					if(pi.getValue(pivot) + g.getWeight(pivot, y) < pi.getValue(y)) /*Si le chemin de y � r est plus court en passant par pivot*/
					{
						pi.setValue(y, pi.getValue(pivot) + g.getWeight(pivot, y)); /*On met � jour la valeur de la longueur du chemin de y � r*/
						previous.setValue(y, pivot); /*Et le p�re (= previous) de y devient pivot*/
					}
				}
			}
			
			int min = Integer.MAX_VALUE; /*On fixe un minimum � MAX_VALUE*/
			for(VertexInterface y : listVertex) /*On cherche parmis les sommets*/
			{				
				if(!a.contains(y)) /*Un sommet y qui n'est pas dans l'arborescence a*/
				{
					if(pi.getValue(y)<min) /*Et tel que la longueur du chemin de y � r soit minimale*/
					{
						min = pi.getValue(y);
						pivot = y; /*Ce sommet y devient le nouveau pivot*/
					}
				}
			}
			a.add(pivot); /*On ajoute le nouveau pivot � l'arborescence a*/
		}
		
		return previous; /*On renvoie la fonction previous, qui permet d'acc�der � tous les chemins*/
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode de dijkstra avec des nouveaux ASet, Pi et Previous
	 * @param1 g
	 * @param2 r
	 * @return previous qui permet d'acc�der � tous plus courts chemins (previous contient les ant�c�dents de chaque sommet dans le plus court chemin)*/
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r)
	{
		return dijkstra(g, r, new ASet(), new Pi(), new Previous(r));
	}
}
