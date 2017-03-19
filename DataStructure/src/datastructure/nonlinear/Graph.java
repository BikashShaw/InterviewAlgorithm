package datastructure.nonlinear;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a directed graph using adjacency list representation
 * Created by Bikash on 3/18/2017.
 */
public class Graph {
    private int vertices;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    public Graph(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList();
        }
    }
    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void breadthFirstSearch(int s) {
        //size of the visited array is equal to number of vertices
        boolean visited[] = new boolean[this.vertices];
        //Created a queue for node we want to traverse
        Queue<Integer> queue = new LinkedList<>();
        //Add the start node in queue
        queue.add(s);

        //Loop still queue is not empty
        while (!queue.isEmpty()) {
            //Get the first node out of queue
            Integer current = queue.poll();
            //Print the node's value
            System.out.println(current);
            //set the visited flag true for the node
            visited[current] = true;
            //Get all the adjacent nodes of this visiting node
            Iterator<Integer> iterator = this.adj[current].iterator();

            while (iterator.hasNext()) {
                Integer next = iterator.next();
                //If the adjacent node not already visited then add it in queue.
                if(!visited[next]) {
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,2);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3); //Self-loop

        graph.breadthFirstSearch(2);
    }
}
