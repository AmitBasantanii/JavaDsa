package Topology_Sort_Adjacency_Matrix;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));
        nodeList.add(new GraphNode("H", 7));

        Graph newGraph = new Graph(nodeList);

        newGraph.addDirectedEdge(0,2);
        newGraph.addDirectedEdge(2,4);
        newGraph.addDirectedEdge(4,7);
        newGraph.addDirectedEdge(4,5);
        newGraph.addDirectedEdge(5,6);
        newGraph.addDirectedEdge(1,2);
        newGraph.addDirectedEdge(1,3);
        newGraph.addDirectedEdge(3,5);

        System.out.print(newGraph.toString());
        newGraph.topologicalSort();
    }
}
