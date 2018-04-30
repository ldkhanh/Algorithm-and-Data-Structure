package Graph.G4G;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class G_02_BFS {
    private int V;                          // Number of vertices
    private LinkedList<Integer> adj[];      // Adjacency Lists

    public G_02_BFS(int v) {
        this.V = v;
        adj = new LinkedList[this.V];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }
    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // print BFS traversal from a given source s
    public void BFS(int s) {
        // Mark all the vertices as not visited(default false)
        boolean visited[] = new boolean[V];
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        G_02_BFS g = new G_02_BFS(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println("Following is Breath First Traversal " + "(starting from vertex 2)");
        g.BFS(2);
    }

}
