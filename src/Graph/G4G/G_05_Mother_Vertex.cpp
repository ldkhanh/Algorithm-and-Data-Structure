// C++ program to find a mother vertex in O(V+E) time
#include <bits/stdc++.h>
using namespace std;

class Graph {
    int V;      // No of vertices
    list<int> *adj;     // adjacency lists

    // A recursive function to print DFS starting from v
    void DFSUtil(int v, vector<bool> &visited);
public:
    Graph(int V);
    void addEdge(int v, int w);
    int findMother();
}

Graph::Graph(int V) {
    this->V = V;
    adj = new list<int>[V];
}

// A recursive function to print DFS starting from v
void Graph::DFSUtil(int v, vector<bool> &visited) {
    // Mark the current node as visited and print it
    visited[v] = true;
    // Recursive for all the vertices adjacent to this vertex
    list<int>::iterator i;
    for (i = adj[v].begin(); i != adj[v].end(); ++i)
        if(!visited[*i])
            DFSUtil(*i, visited);
}

void Graph::addEdge(int v, int w) {
    adj[v].push_back(w);        // Add w to v's list.
}

// Returns a mother vertex if exists. Otherwise returns -1
int Graph::findMother() {
    // visited[] is used for DFS. Initially all are initialized as not visited.
    vector<bool> visited(V, false);
    // To store last finished vertex (or mother vertex)
    int v = 0;
    // Do a DFS traversal and find the last finished vertex
    for (int i = 0; i < V; i++) {
        if (visited[i] == false) {
            DFSUtil(i,visited);
            v = i;
        }
    }

    // If there exist mother vertex (or vetices) in given graph, then v must be one (or one of them)
    // Now check if v is actually a mother vertex (or graph 

}