package Adjacency_Matrix;

import java.util.ArrayList;

// Adjacency Matrix - It is a square matrix or a 2D array and the elements of the matrix indicate
// whether pairs of vertices are adjacent or not in the graph.

// If the graph is complete or almost complete then we should use adjacency matrix

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 3));
        nodeList.add(new GraphNode("D", 4));
        nodeList.add(new GraphNode("E", 5));

        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0,1);
        graph.addUndirectedEdge(0,2);
        graph.addUndirectedEdge(0,3);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(3,4);
        System.out.print(graph.toString());

    }
}
