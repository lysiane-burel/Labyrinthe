package Dijkstra;

/*Interface de la classe ASet*/
public interface ASetInterface
{
	public void add(VertexInterface vertex);/*Signature de la méthode d'ajout d'un sommet*/
	public boolean contains(VertexInterface vertex);/*Signature de la méthode pour savoir si un sommet est dans aset*/
}
