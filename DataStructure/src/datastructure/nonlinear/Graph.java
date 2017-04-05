package datastructure.nonlinear;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a directed graph using adjacency list representation
 * Created by Bikash on 3/18/2017.
 */
public class Graph {
    int vertices;   // No. of vertices
    LinkedList<Integer> adj[]; //Adjacency Lists

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

    public void depthFirstSearch(int s, boolean visited[]) {
        visited[s] = true;
        System.out.println(s);

        Iterator<Integer> iterator = this.adj[s].iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if(!visited[next]){
                depthFirstSearch(next, visited);
            }
        }
    }

    public boolean isReachable(int src, int dest) {
        boolean visited[] = new boolean[this.vertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            System.out.println("Visiting: " + current);
            if(current == dest) {
                return true;
            }

            visited[current] = true;
            Iterator<Integer> neighbours = this.adj[current].iterator(); // All adjacent vertices

            while (neighbours.hasNext()) {
                Integer next = neighbours.next();
                if(next == dest) {
                    System.out.println("Found: " + next);
                    return true;
                }
                if(!visited[next]) {
                    queue.add(next);
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,2);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3); //Self-loop

        System.out.println("**Breadth First Search Starts**");
        graph.breadthFirstSearch(2);
        System.out.println("**Breadth First Search Ends**");

        System.out.println("**Depth First Search Starts**");
        graph.depthFirstSearch(0, new boolean[graph.vertices]);
        System.out.println("**Depth First Search Ends**");

        System.out.println("Is 0 reachable to 3: " + graph.isReachable(0,3));
        System.out.println("Is 3 reachable to 0: " + graph.isReachable(3,0));
        System.out.println("Is 2 reachable to 3: " + graph.isReachable(2,3));
        System.out.println("Is 2 reachable to 3: " + graph.isReachable(2,3));
        System.out.println("Is 2 reachable to 1: " + graph.isReachable(2,1));

    }
}
