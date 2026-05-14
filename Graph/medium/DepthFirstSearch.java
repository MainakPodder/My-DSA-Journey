package Graph.medium;

import java.util.*;

/**
 * Class containing DFS traversal logic for graphs.
 */
class GraphTraversal {

    /**
     * Performs Depth First Search (DFS) starting from a given vertex.
     *
     * @param currentVertex The current vertex being visited.
     * @param adjacencyList The adjacency list representing the graph.
     * @param visited       Boolean array to track visited vertices.
     * @param traversalPath List to store the DFS traversal order.
     */
    public void depthFirstSearch(int currentVertex,
            List<Integer>[] adjacencyList,
            boolean[] visited,
            List<Integer> traversalPath) {

        // Mark the current vertex as visited
        visited[currentVertex] = true;

        // Add the current vertex to traversal path
        traversalPath.add(currentVertex);

        // Explore all unvisited neighbors recursively
        for (int neighbor : adjacencyList[currentVertex]) {
            if (!visited[neighbor]) {
                depthFirstSearch(neighbor, adjacencyList, visited, traversalPath);
            }
        }
    }
}

/**
 * Driver class to test DFS traversal.
 */
public class DepthFirstSearch {
    public static void main(String[] args) {
        // Number of vertices in the graph
        int vertices = 5;

        // Initialize adjacency list
        List<Integer>[] adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Add edges (undirected graph)
        adjacencyList[0].addAll(Arrays.asList(1, 2));
        adjacencyList[1].addAll(Arrays.asList(0, 3));
        adjacencyList[2].addAll(Arrays.asList(0, 4));
        adjacencyList[3].add(1);
        adjacencyList[4].add(2);

        // Initialize visited array
        boolean[] visited = new boolean[vertices];

        // List to store DFS traversal result
        List<Integer> traversalPath = new ArrayList<>();

        // Create GraphTraversal object
        GraphTraversal graphTraversal = new GraphTraversal();

        // Perform DFS starting from vertex 0
        graphTraversal.depthFirstSearch(0, adjacencyList, visited, traversalPath);

        // Print DFS traversal order
        System.out.println("DFS Traversal Order:");
        for (int vertex : traversalPath) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}
