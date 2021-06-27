package maze;
import Dijkstra.Dijkstra;
import Dijkstra.GraphInterface;
import Dijkstra.PreviousInterface;
import Dijkstra.VertexInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import window.*;
import window.Window;

import java.awt.*;


/*Classe Maze, qui est un graphe. C'est le labyrinthe*/
public class Maze implements GraphInterface
{
	
//__________________________________________________________________________________________________
	
	private int width; /*largeur du labyrinthe*/
	private int height; /*Hauteur du labyrinthe*/
	private MBox[][] maze; /*Le labyrinthe est un tableau de cases*/
	
//__________________________________________________________________________________________________
	
	/*Ceci est utilis� l'interface graphique*/
	ArrayList<Square> squareList = new ArrayList<>(); /*Cr�ation de la liste des carr�s � afficher*/
	DrawingMaze drawingMaze = new DrawingMaze(squareList); /*Cr�ation du labyrinthe � afficher*/
	Color purple = new Color(150, 85, 210); /*Couleur violette*/
	
//__________________________________________________________________________________________________
	
	/*Constructeur de la classe Maze*/
	public Maze(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.maze = new MBox[width][height];
	}

//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie le nombre de cases du labyrinthe
	 * @return nombre de cases du labyrinthe*/
	@Override
	public int getSize()
	{
		return width*height;
	}

//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie la liste des cases du labyrinthe
	 * @return allVertices, la liste des cases du labyrinthe*/
	@Override
	public ArrayList<VertexInterface> getAllVertices()
	{
		ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
		for(int i=0; i<width; i++)
		{
			for(int j=0; j<height; j++)
			{
				allVertices.add(maze[i][j]);
			}
		}
		return allVertices;
	}

//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie la liste des cases franchissables adjascentes � la case vertex
	 * @param vertex
	 * @return successors, la liste des successeurs de vertex*/
	@Override
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex)
	{
		MBox box = (MBox) vertex;
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		int i = box.getX();
		int j = box.getY();
		if(i+1<width && maze[i+1][j].getLabel() != "W")
		{
			successors.add(maze[i+1][j]);
		}
		if(i-1>=0 && maze[i-1][j].getLabel() != "W")
		{
			successors.add(maze[i-1][j]);
		}
		if(j+1<height && maze[i][j+1].getLabel() != "W")
		{
			successors.add(maze[i][j+1]);
		}
		if(j-1>=0 && maze[i][j-1].getLabel() != "W")
		{
			successors.add(maze[i][j-1]);
		}
		return successors;
	}

//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie la valuation de l'ar�te {src, dst}.
	 * Renvoie 1 si src et dst sont des cases franchissables, et MAX_VALUE sinon
	 * @param1 src
	 * @param2 dst
	 * @return 1 si src et dst ne sont pas des murs
	 * @return MAX_VALUE sinon*/
	@Override
	public int getWeight(VertexInterface src, VertexInterface dst)
	{
		MBox boxA = (MBox) src;
		MBox boxB = (MBox) dst;
		String LabA = boxA.getLabel();
		String LabB = boxB.getLabel();
		if(LabA != "W" && LabB != "W")
		{
			return 1;
		}
		return Integer.MAX_VALUE;
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode qui initialise le labyrinthe � partir d'un fichier texte "fileName"
	 * @param fileName*/
	public final void initFromTextFile(String fileName)
	{
		BufferedReader br = null;
		try
		{
			String sLine; /*Cha�ne de caract�res sur une ligne*/
			br = new BufferedReader(new FileReader(fileName));
			int line = 0; /*nombre de lignes*/
			int nbA = 0; /*Nombre de cases d'arriv�e*/
			int nbD = 0; /*Nombre de cases de d�part*/
			
			while ((sLine = br.readLine()) != null) /*On lit le fichier ligne par ligne*/
			{
				System.out.println(sLine); /*Affiche la ligne lue dans le terminal*/
				
				if(line >= this.height) /*Si le nombre de ligne n'est pas �gal � la hauteur du labyrinthe*/
				{
					/*Affiche un message d'erreur
					 * @throw MazeReadingException*/
					throw new MazeReadingException(fileName, line, "La hauteur du labyrinthe n'est pas correcte");
				}
				
				if(sLine.length() != this.width) /*Si la longueur de la ligne n'est pas la largeur du labyrinthe*/
				{
					/*Affiche un message d'erreur
					 * @throw MazeReadingException*/
					throw new MazeReadingException(fileName, line, "La largeur du labyrinthe n'est pas correcte");		
				}
				
				for(int i=0; i<this.width; i++) /*Sur toute la ligne, */
				{
					switch(sLine.charAt(i)) /*on lit tous les caract�res*/
					{
						case 'E' : 
							/*Si c'est un E (case franchissable), on ajoute une EBox dans le labyrinthe*/
							maze[line][i] = new EBox(line, i);
							/*Et dans le dessin du labyrinthe de l'interface graphique*/
							drawingMaze.addSquare(line*32 +10,  i*32+10, 30, maze[line][i].getColor());
							break;
							
						case 'A' :
							/*Si c'est un A (case d'arriv�e), on ajoute une ABox dans le labyrinthe*/
							maze[line][i] = new ABox(line, i);
							/*Et dans le dessin du labyrinthe de l'interface graphique*/
							drawingMaze.addSquare(line*32 +10,  i*32+10, 30, maze[line][i].getColor()); 
							nbA++; /*On incr�mente le nombre de cases d'arriv�e*/
							break;
							
						case 'D' : 
							/*Si c'est un D (case de d�part), on ajoute une DBox dans le labyrinthe*/
							maze[line][i] = new DBox(line, i); 
							/*Et dans le dessin du labyrinthe de l'interface graphique*/   
							drawingMaze.addSquare(line*32 +10,  i*32+10, 30, maze[line][i].getColor()); 
							nbD++; /*On incr�mente le nombre de cases de d�part*/
							break;
							
						case 'W' :
							/*Si c'est un W (mur), on ajoute une WBox dans le labyrinthe*/
							maze[line][i] = new WBox(line, i); 
							/*Et dans le dessin du labyrinthe de l'interface graphique*/   
							drawingMaze.addSquare(line*32 +10,  i*32+10, 30, maze[line][i].getColor()); 
							break;
							
						default :
							/*Sinon, on affiche un message d'erreur
							 * @throw MazeReadingException*/
							throw new MazeReadingException(fileName, line, "La case n'est pas du bon type. Doit �tre 'E', 'W', 'D' ou 'A'"); 
					}
					if(nbA > 1) /*S'il n'y a pas une seule case de d�part et une seule case d'arriv�e*/
					{
						/*Affiche un message d'erreur
						 * @throw MazeReadingException*/
						throw new MazeReadingException(fileName, line, "Il y a trop de cases d'arriv�e. Il faut une seule case d'arriv�e");
					}
					if(nbD > 1) /*S'il n'y a pas une seule case de d�part et une seule case d'arriv�e*/
					{
						/*Affiche un message d'erreur
						 * @throw MazeReadingException*/
						throw new MazeReadingException(fileName, line, "Il y a trop de cases de d�part. Il faut une seule case de d�part");
					}
				}
				line ++;
			}
			if(nbA == 0) /*S'il n'y a pas une seule case de d�part et une seule case d'arriv�e*/
			{
				/*Affiche un message d'erreur
				 * @throw MazeReadingException*/
				throw new MazeReadingException(fileName, line, "Il n'y a aucune case d'arriv�e. Il faut une case d'arriv�e ('A')");
			}
			if(nbD == 0) /*S'il n'y a pas une seule case de d�part et une seule case d'arriv�e*/
			{
				/*Affiche un message d'erreur
				 * @throw MazeReadingException*/
				throw new MazeReadingException(fileName, line, "Il n'y a aucune case de d�part. Il faut une case de d�part ('D')");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (br != null)br.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode qui sauvegarde le labyrinthe dans un autre fichier texte "fileName"
	 * Dans cette m�thode, une fen�tre de l'interface graphique est ouverte
	 * @param fileName*/
	public final void saveToTextFile(String fileName)
	{
		PrintWriter pw = null;
		try
		{
			FileOutputStream fos = new FileOutputStream(fileName);
			pw = new PrintWriter(fos);
		    for(int i=0; i<width; i++)
		    {
		    	for(int j=0; j<height; j++)
		    	{
		    		/*Ecrire dans le document le type de case � la ligne i et la position j*/
		    		pw.print(maze[i][j].getLabel());
		    	}
		    	pw.print("\n");
		    }
			
		}
		catch (Exception e)
		{
		    e.printStackTrace();	      
		}
		finally
		{
		    try
		    {
		        if(pw != null)
		        {
		        	pw.close();
		        }
		    }
		    catch (Exception ex)
		    {
		        ex.printStackTrace();
		    }
		}
		new Window(drawingMaze); /*Ouvre une fen�tre de l'interface graphique*/
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie une case selon son type
	 * @param label
	 * @return vertex, un sommet qui a pour label "label"
	 * @return null s'il n'existe pas de vertex qui a pour label "label"*/
	public final MBox getBoxByLabel(String label)
	{
		for(VertexInterface vertex : getAllVertices())
		{
			if(label.equals(((MBox)vertex).getLabel()))
			{
				return (MBox)vertex;
			}
		}
		return null;
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode qui renvoie la liste des sommets (dans l'ordre) qui se trouvent sur le plus court chemin entre la case d�part D et la case d'arriv�e A
	 * @return path la liste des sommets du plus court chemin entre D et A*/
	public final ArrayList<VertexInterface> getShortestPathFromDToA()
	{
		MBox D = this.getBoxByLabel("D"); /*D est la case de d�part*/
		MBox A = this.getBoxByLabel("A"); /*A est la case d'arriv�e*/
		PreviousInterface previous = Dijkstra.dijkstra(this, A); /*On fait le plus court chemin entre A et toutes les autres cases*/
		ArrayList<VertexInterface> path = previous.getShortestPathTo(D); /*On r�cup�re path : la liste des cases qui se trouvent sur le plus court chemin entre A et D*/
		
		try
		{
			if(path==null || path.size()==1) /*S'il n'y a pas de plus court chemin*/
			{
				/*On affiche un message d'erreur
				 * @throw NoShortestPathException*/
				throw new NoShortestPathException();
			}
			ArrayList<VertexInterface> boxList = getAllVertices();
			for(VertexInterface vertex : boxList)
			{
				if(((MBox)vertex).getLabel()=="W" && path.contains(vertex)) /*Si une des cases est un mur*/
				{
					/* @throw NoShortestPathException*/
					throw new NoShortestPathException(); /*On affiche un message d'erreur*/
				}
			}
		}
		catch(NoShortestPathException e)
		{
			e.printStackTrace();
		}
		return path;	
	}
	
//__________________________________________________________________________________________________
	
	/*M�thode qui affiche le plus court chemin entre la case d�part et la case d'arriv�e
	 * Affiche en rouge le chemin dans le terminal, et en violet sur la fen�tre de l'interface graphique*/
	public final void showShortestPathFromDToA()
	{
		System.out.println();
		ArrayList<VertexInterface> path = getShortestPathFromDToA(); /*path est la liste des sommets qui se trouvent sur le plus court chemin entre la case d�part et la case d'arriv�e*/
		boolean isInPath = false; /*bool�en pour savoir si une case se trouve dans path*/
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
			{
				MBox tmp = new EBox(i, j); /*Cr�ation d'une case temporaire*/
				isInPath = false;
				for(VertexInterface v : path)
				{
					if(v.isEqual((VertexInterface)tmp)) /*Si les 2 cases ont les m�mes coordonn�es (x, y)*/
					{
						System.err.print(maze[i][j].getLabel()); /*Afficher la case en rouge dans le terminal*/
						if(maze[i][j].getLabel()=="D" || maze[i][j].getLabel()=="A")
						{
							/*Afficher, dans la fen�tre de l'interface graphique, la case en rouge ou vert si c'est la case d�part ou arriv�e*/
							drawingMaze.addSquare(i*32+10, j*32+400, 30, maze[i][j].getColor());
						}
						else
						{
							drawingMaze.addSquare(i*32+10, j*32+400, 30, purple); /*Afficher la case en violet dans la fen�tre de l'interface graphique*/
						}
						isInPath = true;
					}

				}
				if(!isInPath) /*Sinon*/
				{
					System.out.print(maze[i][j].getLabel()); /*Afficher la case en noir dans le terminal*/
					/*Afficher, dans la fen�tre de l'interface graphique, la case en gris ou noir, selon si c'est un mur ou une case franchissable*/
					drawingMaze.addSquare(i*32+10, j*32+400, 30, maze[i][j].getColor()); 
				}
			}
			System.out.println();
		}
		
	}
}
