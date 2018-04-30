package Graph.G4G;

import java.io.*;
import java.util.*;

public class G_03_DFS {
    private int V;      // Number of vertices
    private LinkedList<Integer> adj[];

    // Constructor
    public G_03_DFS(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    // Function add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);      // Add w to v's list.
    }

    // A function used by DFS
    public void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recursive for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n])
                DFSUtil(n, visited);
        }
    }
    // The function to do DFS traversal. It uses recursive DFSUtil()
    public void DFS(int v) {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[this.V];
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        G_03_DFS g = new G_03_DFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
