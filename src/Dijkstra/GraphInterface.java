package Dijkstra;

import java.util.ArrayList;

/*Interface d'un graphe*/
public interface GraphInterface
{
	public int getSize(); /*Signature de la méthode qui renvoie le nombre de sommets*/
	public ArrayList<VertexInterface> getAllVertices(); /*Signature de la méthode qui renvoie la liste de tous les sommets*/
	public ArrayList<VertexInterface> getSuccessors(VertexInterface parent); /*Signature de la méthode qui renvoie la liste des successeurs d'un sommet parent*/
	public int getWeight(VertexInterface src, VertexInterface dst); /*Signature de la méthode qui renvoie la valuation de l'arête {src, dst}*/
}
