package Dijkstra;
import java.util.HashSet;

/*Classe ASet, pour utiliser dans la fonction dijkstra. C'est l'ensemble des sommets couverts par l'arborescence*/
public class ASet implements ASetInterface
{
	
	private HashSet<VertexInterface> aSet; /*aSet est un ensemble de sommets*/
	
//__________________________________________________________________________________________________
	
	/*Constructeur de l'arborescence aSet*/
	public ASet()
	{
		aSet = new HashSet<>();
	}
	
//__________________________________________________________________________________________________
	
	/*Méthode d'ajout d'un sommet
	 * @param vertex*/
	@Override
	public void add(VertexInterface vertex)
	{
		aSet.add(vertex);
	}
	
//__________________________________________________________________________________________________
	
	/*Méthode pour savoir si un sommet est dans aset
	 * @param vertex
	 * @return false si vertex n'est pas dans aSet
	 * @return true si vertex est dans aSet*/
	@Override
	public boolean contains(VertexInterface vertex)
	{		
		return aSet.contains(vertex);
	}

}
