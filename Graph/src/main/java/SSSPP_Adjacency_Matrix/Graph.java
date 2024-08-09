package SSSPP_Adjacency_Matrix;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    ArrayList<SSSPP_Adjacency_Matrix.GraphNode> nodeList = new ArrayList<SSSPP_Adjacency_Matrix.GraphNode>();
    int[][] adjacencyMatrix;

    public Graph(ArrayList<SSSPP_Adjacency_Matrix.GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    // to print the graph elements
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i =0; i<nodeList.size(); i++) {
            sb.append(nodeList.get(i).name = " ");
        }

        sb.append("\n");
        for (int i=0; i<nodeList.size(); i++) {
            sb.append(nodeList.get(i).name + " : ");
            for (int j : adjacencyMatrix[i]) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    // get Neighbors
    public ArrayList<SSSPP_Adjacency_Matrix.GraphNode> getNeighbors(GraphNode node) {
        ArrayList<SSSPP_Adjacency_Matrix.GraphNode> neighbors = new ArrayList<GraphNode>();
        int nodeIndex = node.index;

        for (int i=0; i<adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }

        return neighbors;
    }

    // Print path of each of the vertex from source
    public static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
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

            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);

            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;
                }
            }
        }
    }
}
