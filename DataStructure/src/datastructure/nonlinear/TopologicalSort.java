package datastructure.nonlinear;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Bikash on 4/5/2017.
 */
public class TopologicalSort {

    private void topologicalSortUtil(Graph graph, int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        Iterator<Integer> iterator = graph.adj[v].iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if(!visited[next]) {
                topologicalSortUtil(graph,next,visited,stack);
            }
        }

        stack.push(v);
    }

    private void topologicalSort(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.vertices; i++) {
            if(!visited[i]) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     *  0->2
     *  1->2
     *  2->3
     *  2->4
     *  4->5
     * @param args
     */
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);

        new TopologicalSort().topologicalSort(graph);

    }
}
