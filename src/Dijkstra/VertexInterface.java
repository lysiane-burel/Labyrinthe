package Dijkstra;

/*Interface d'un sommet*/
public interface VertexInterface
{
	public String getLabel(); /*Signature de la méthode pour accéder au nom du sommet*/
	public boolean isEqual(VertexInterface vertex); /*Signature de la méthode qui renvoie si autre un sommet vertex est le même ou non*/
}
