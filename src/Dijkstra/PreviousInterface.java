package Dijkstra;
import java.util.ArrayList;

/*Interface de la Classe Previous*/
public interface PreviousInterface
{
	public void setValue(VertexInterface vertex, VertexInterface value); /*Signature de la méthode pour affecter le sommet value à previous(vertex). Value est le père (= previous) dans le plus court chemin de la racine à vertex*/
	public VertexInterface getValue(VertexInterface vertex); /*Signature de la méthode qui renvoie le père (= previous) de vertex*/
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); /*Signature de la méthode qui permet à partir de la fonction previous, de récupérer la liste des sommets (dans l'ordre) qui se trouvent sur le plus court chemin entre la racine (= origin) et le sommet vertex*/
	
}
