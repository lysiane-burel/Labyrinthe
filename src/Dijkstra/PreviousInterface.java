package Dijkstra;
import java.util.ArrayList;

/*Interface de la Classe Previous*/
public interface PreviousInterface
{
	public void setValue(VertexInterface vertex, VertexInterface value); /*Signature de la m�thode pour affecter le sommet value � previous(vertex). Value est le p�re (= previous) dans le plus court chemin de la racine � vertex*/
	public VertexInterface getValue(VertexInterface vertex); /*Signature de la m�thode qui renvoie le p�re (= previous) de vertex*/
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); /*Signature de la m�thode qui permet � partir de la fonction previous, de r�cup�rer la liste des sommets (dans l'ordre) qui se trouvent sur le plus court chemin entre la racine (= origin) et le sommet vertex*/
	
}
