<h1>Utilisation du programme</h1>
<p>La classe <b>MainTest</b> exécute le programme.</p>
<p>Le labyrinthe est initialisé à partir du fichier texte <b>labyrinthe.txt</b> qui se trouve dans le dossier <b>data</b>. Il est ensuite sauvegardé dans un deuxième fichier texte "labyrinthe2.txt".</p>
<p>Le labyrinthe originel est affiché dans le terminal, et dans la fenêtre de l'interface graphique.</p>
<p>Ensuite, le plus court chemin est trouvé avec la méthode shortestPathFromDToA. Le plus court chemin est affiché dans le terminal en rouge <i>(parfois l'affichage ne se fait pas bien dans le terminal, et il suffit de relancer le programme)</i>. Le plus court chemin est affiché dans la fenêtre de l'interface graphique en violet.</p>
<p><i>Ce projet a été réalisé avec Eclipse</i></p>

<h3>L'affichage dans le terminal</h3>
<ul>
<li>E : Une case qu'il est possible de traverser</li>
<li>W : Un mur, que l'on ne peut pas traverser</li>
<li>D : La case départ</li>
<li>A : La case d'arrivée</li>
</ul>

<h3>L'affichage dans la fenêtre</h3>
<ul>
<li>Carré gris : Une case qu'il est possible de traverser</li>
<li>Carré noir : Un mur, que l'on ne peut pas traverser</li>
<li>Carré vert : La case départ</li>
<li>Carré rouge : La case d'arrivée</li>
</ul>
<h3>Exécution du programme avec un labyrinthe différent</h3>
<p>Si vous désirer exécuter le programme avec un labyrinthe différent, il faut modifier le fichier <b>labyrinthe.txt</b>. Il faut écrire un <b>E</b> pour une case franchissable, un <b>W</b> pour un mur, un <b>D</b> pour une case de départ et un <b>A</b> pour une case d'arrivée.</p>
<p>De plus, il faut modifier la taille du labyrinthe dans la ligne <b>"Maze maze = new Maze(10,10);"</b> de la classe MainTest.</p>

<h3>Les messages d'erreur</h3>
<ul>
<li>"La largeur du labyrinthe n'est pas correcte à la ligne <i>line</i> dans le fichier <i>fileName</i>"</li>
<li>"La hauteur du labyrinthe n'est pas correcte à la ligne <i>line</i> dans le fichier <i>fileName</i>"</li>
<li>"Il n'y a aucune case d'arrivée. Il faut une case d'arrivée ('A') à la ligne <i>line</i> dans le fichier <i>fileName</i>"</li>
<li>"Il n'y a aucune case de départ. Il faut une case de départ ('D') à la ligne <i>line</i> dans le fichier <i>fileName</i>"</li>
<li>"Il y a trop de cases d'arrivée. Il faut une seule case d'arrivée à la ligne <i>line</i> dans le fichier <i>fileName</i>"</li>
<li>"Il y a trop de cases de départ. Il faut une seule case de départ à la ligne <i>line</i> dans le fichier <i>fileName</i>"</li>
<li>"La case n'est pas du bon type. Doit être 'E', 'W', 'D' ou 'A' à la ligne <i>line</i> dans le fichier <i>fileName</i>"</li>
<li>"Il n'y a pas de chemin entre la case d'arrivée et la case de départ"</li>
</ul>

<h3>Les principales méthodes</h3>
<ul>
<li>Classe Dijkstra
<ul>
<li><i>public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous);</i> : implémente l'algorithme de Dijkstra.</li>
</ul>
</li>
<li>Classe Previous
<ul>
<li><i>public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);</i> : renvoie la liste des sommets sur le plus court chemin entre vertex et origin</li>
</ul>
</li>
<li>Classe Maze
<ul>
<li><i>public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);</i> : renvoie la liste des cases franchissables adjascentes à vertex</li>
<li><i>public final void initFromTextFile(String fileName);</i> : initialise le labyrinthe à partir d'un fichier texte "fileName"</li>
<li><i>public final void saveToTextFile(String fileName);</i> : sauvegarde le labyrinthe dans un autre fichier texte "fileName" et ouvre une fenêtre de l'interface graphique.</li>
<li><i>public final ArrayList<VertexInterface> getShortestPathFromDToA();</i> : renvoie la liste des sommets (dans l'ordre) qui se trouvent sur le plus court chemin entre la case départ D et la case d'arrivée A</li>
<li><i>public final void showShortestPathFromDToA();</i> : affiche le plus court chemin entre la case départ et la case d'arrivée. Affiche en rouge le chemin dans le terminal, et en violet sur la fenêtre de l'interface graphique</li>
</ul>
</li>
</ul>
