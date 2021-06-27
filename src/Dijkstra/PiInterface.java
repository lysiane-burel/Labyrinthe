package Dijkstra;

/*Interface de la classe Pi*/
public interface PiInterface
{
	public void setValue(VertexInterface vertex, int value); /*Signature de la m�thode qui modifie la valeur de pi(vertex) par value*/
	public int getValue(VertexInterface vertex); /*Signature de la m�thode qui renvoie la valeur de pi(vertex)*/
}
