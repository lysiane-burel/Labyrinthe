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
	
	/*Ceci est utilisé l'interface graphique*/
	ArrayList<Square> squareList = new ArrayList<>(); /*Création de la liste des carrés à afficher*/
	DrawingMaze drawingMaze = new DrawingMaze(squareList); /*Création du labyrinthe à afficher*/
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
	
	/*Méthode qui renvoie le nombre de cases du labyrinthe
	 * @return nombre de cases du labyrinthe*/
	@Override
	public int getSize()
	{
		return width*height;
	}

//__________________________________________________________________________________________________
	
	/*Méthode qui renvoie la liste des cases du labyrinthe
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
	
	/*Méthode qui renvoie la liste des cases franchissables adjascentes à la case vertex
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
	
	/*Méthode qui renvoie la valuation de l'arête {src, dst}.
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
	
	/*Méthode qui initialise le labyrinthe à partir d'un fichier texte "fileName"
	 * @param fileName*/
	public final void initFromTextFile(String fileName)
	{
		BufferedReader br = null;
		try
		{
			String sLine; /*Chaîne de caractères sur une ligne*/
			br = new BufferedReader(new FileReader(fileName));
			int line = 0; /*nombre de lignes*/
			int nbA = 0; /*Nombre de cases d'arrivée*/
			int nbD = 0; /*Nombre de cases de départ*/
			
			while ((sLine = br.readLine()) != null) /*On lit le fichier ligne par ligne*/
			{
				System.out.println(sLine); /*Affiche la ligne lue dans le terminal*/
				
				if(line >= this.height) /*Si le nombre de ligne n'est pas égal à la hauteur du labyrinthe*/
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
					switch(sLine.charAt(i)) /*on lit tous les caractères*/
					{
						case 'E' : 
							/*Si c'est un E (case franchissable), on ajoute une EBox dans le labyrinthe*/
							maze[line][i] = new EBox(line, i);
							/*Et dans le dessin du labyrinthe de l'interface graphique*/
							drawingMaze.addSquare(line*32 +10,  i*32+10, 30, maze[line][i].getColor());
							break;
							
						case 'A' :
							/*Si c'est un A (case d'arrivée), on ajoute une ABox dans le labyrinthe*/
							maze[line][i] = new ABox(line, i);
							/*Et dans le dessin du labyrinthe de l'interface graphique*/
							drawingMaze.addSquare(line*32 +10,  i*32+10, 30, maze[line][i].getColor()); 
							nbA++; /*On incrémente le nombre de cases d'arrivée*/
							break;
							
						case 'D' : 
							/*Si c'est un D (case de départ), on ajoute une DBox dans le labyrinthe*/
							maze[line][i] = new DBox(line, i); 
							/*Et dans le dessin du labyrinthe de l'interface graphique*/   
							drawingMaze.addSquare(line*32 +10,  i*32+10, 30, maze[line][i].getColor()); 
							nbD++; /*On incrémente le nombre de cases de départ*/
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
							throw new MazeReadingException(fileName, line, "La case n'est pas du bon type. Doit être 'E', 'W', 'D' ou 'A'"); 
					}
					if(nbA > 1) /*S'il n'y a pas une seule case de départ et une seule case d'arrivée*/
					{
						/*Affiche un message d'erreur
						 * @throw MazeReadingException*/
						throw new MazeReadingException(fileName, line, "Il y a trop de cases d'arrivée. Il faut une seule case d'arrivée");
					}
					if(nbD > 1) /*S'il n'y a pas une seule case de départ et une seule case d'arrivée*/
					{
						/*Affiche un message d'erreur
						 * @throw MazeReadingException*/
						throw new MazeReadingException(fileName, line, "Il y a trop de cases de départ. Il faut une seule case de départ");
					}
				}
				line ++;
			}
			if(nbA == 0) /*S'il n'y a pas une seule case de départ et une seule case d'arrivée*/
			{
				/*Affiche un message d'erreur
				 * @throw MazeReadingException*/
				throw new MazeReadingException(fileName, line, "Il n'y a aucune case d'arrivée. Il faut une case d'arrivée ('A')");
			}
			if(nbD == 0) /*S'il n'y a pas une seule case de départ et une seule case d'arrivée*/
			{
				/*Affiche un message d'erreur
				 * @throw MazeReadingException*/
				throw new MazeReadingException(fileName, line, "Il n'y a aucune case de départ. Il faut une case de départ ('D')");
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
	
	/*Méthode qui sauvegarde le labyrinthe dans un autre fichier texte "fileName"
	 * Dans cette méthode, une fenêtre de l'interface graphique est ouverte
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
		    		/*Ecrire dans le document le type de case à la ligne i et la position j*/
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
		new Window(drawingMaze); /*Ouvre une fenêtre de l'interface graphique*/
	}
	
//__________________________________________________________________________________________________
	
	/*Méthode qui renvoie une case selon son type
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
	
	/*Méthode qui renvoie la liste des sommets (dans l'ordre) qui se trouvent sur le plus court chemin entre la case départ D et la case d'arrivée A
	 * @return path la liste des sommets du plus court chemin entre D et A*/
	public final ArrayList<VertexInterface> getShortestPathFromDToA()
	{
		MBox D = this.getBoxByLabel("D"); /*D est la case de départ*/
		MBox A = this.getBoxByLabel("A"); /*A est la case d'arrivée*/
		PreviousInterface previous = Dijkstra.dijkstra(this, A); /*On fait le plus court chemin entre A et toutes les autres cases*/
		ArrayList<VertexInterface> path = previous.getShortestPathTo(D); /*On récupère path : la liste des cases qui se trouvent sur le plus court chemin entre A et D*/
		
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
	
	/*Méthode qui affiche le plus court chemin entre la case départ et la case d'arrivée
	 * Affiche en rouge le chemin dans le terminal, et en violet sur la fenêtre de l'interface graphique*/
	public final void showShortestPathFromDToA()
	{
		System.out.println();
		ArrayList<VertexInterface> path = getShortestPathFromDToA(); /*path est la liste des sommets qui se trouvent sur le plus court chemin entre la case départ et la case d'arrivée*/
		boolean isInPath = false; /*booléen pour savoir si une case se trouve dans path*/
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
			{
				MBox tmp = new EBox(i, j); /*Création d'une case temporaire*/
				isInPath = false;
				for(VertexInterface v : path)
				{
					if(v.isEqual((VertexInterface)tmp)) /*Si les 2 cases ont les mêmes coordonnées (x, y)*/
					{
						System.err.print(maze[i][j].getLabel()); /*Afficher la case en rouge dans le terminal*/
						if(maze[i][j].getLabel()=="D" || maze[i][j].getLabel()=="A")
						{
							/*Afficher, dans la fenêtre de l'interface graphique, la case en rouge ou vert si c'est la case départ ou arrivée*/
							drawingMaze.addSquare(i*32+10, j*32+400, 30, maze[i][j].getColor());
						}
						else
						{
							drawingMaze.addSquare(i*32+10, j*32+400, 30, purple); /*Afficher la case en violet dans la fenêtre de l'interface graphique*/
						}
						isInPath = true;
					}

				}
				if(!isInPath) /*Sinon*/
				{
					System.out.print(maze[i][j].getLabel()); /*Afficher la case en noir dans le terminal*/
					/*Afficher, dans la fenêtre de l'interface graphique, la case en gris ou noir, selon si c'est un mur ou une case franchissable*/
					drawingMaze.addSquare(i*32+10, j*32+400, 30, maze[i][j].getColor()); 
				}
			}
			System.out.println();
		}
		
	}
}
