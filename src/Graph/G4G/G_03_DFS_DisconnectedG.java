package Graph.G4G;

import java.io.*;
import java.util.*;

public class G_03_DFS_DisconnectedG {
    private int V;
    private LinkedList<Integer> adj[];
    // Constructor
    public G_03_DFS_DisconnectedG(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited
        visited[v] = true;
        System.out.print(v + " ");

        // Recursive for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[v])
                DFSUtil(n, visited);
        }
    }

    public void DFS() {
        // Mark all the vertices as not visited (set as false)
        boolean visited[] = new boolean[this.V];
        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        for (int i = 0; i < this.V; i++)
            if (visited[i] == false)
                DFSUtil(i,visited);
    }

    public static void main(String[] args) {
        G_03_DFS_DisconnectedG g = new G_03_DFS_DisconnectedG(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal");

        g.DFS();
    }
}
