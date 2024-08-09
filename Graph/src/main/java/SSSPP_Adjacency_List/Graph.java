package SSSPP_Adjacency_List;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    ArrayList<SSSPP_Adjacency_List.GraphNode> nodeList = new ArrayList<SSSPP_Adjacency_List.GraphNode>();

    public Graph (ArrayList<SSSPP_Adjacency_List.GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge (int i, int j) {
        SSSPP_Adjacency_List.GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    // for printing graph to console
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<nodeList.size(); i++) {
            sb.append(nodeList.get(i).name + " : ");

            for (int j=0; j<nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size()){
                    sb.append((nodeList.get(i).neighbors.get(j).name));
                }
                else {
                    sb.append((nodeList.get(i).neighbors.get(j).name + " -> "));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Breadth First Search - BFS
    public static void pathPrint(GraphNode node) {
        if (node.parents != null) {
            pathPrint(node.parents);
        }
        System.out.print(node.name + " ");
    }

    public void BFSForSSSPP (GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;

            System.out.print("Printing path for node " + currentNode.name + " : ");

            pathPrint(currentNode);
            System.out.println();

            for (GraphNode neighbor : currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parents = currentNode;
                }
            }
        }
    }
}
