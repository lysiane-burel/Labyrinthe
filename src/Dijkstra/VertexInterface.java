package Dijkstra;

/*Interface d'un sommet*/
public interface VertexInterface
{
	public String getLabel(); /*Signature de la m�thode pour acc�der au nom du sommet*/
	public boolean isEqual(VertexInterface vertex); /*Signature de la m�thode qui renvoie si autre un sommet vertex est le m�me ou non*/
}
