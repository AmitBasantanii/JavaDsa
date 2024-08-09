package Bellman_Ford_Algorithm;

import java.util.ArrayList;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public static void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    void bellmanFord( WeightedNode sourceNode ) {
        sourceNode.distance = 0;

        for (int i =0; i<nodeList.size(); i++) {
            for (WeightedNode currentNode : nodeList) {

                for (WeightedNode neighbor : currentNode.neighbors) {

                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = ( currentNode.distance + currentNode.weightMap.get(neighbor));

                        neighbor.parent = currentNode;
                    }
                }
            }
        }

        System.out.println("Checking for negative cycle : ");

        for (WeightedNode currentNode : nodeList) {
            for (WeightedNode neighbor : currentNode.neighbors) {

                if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {

                    System.out.println("Negative cycle found : \n");
                    System.out.println("Vertex name : " + neighbor.name);

                    System.out.println("Old cost : " + neighbor.distance);

                    int newDistance = currentNode.distance + currentNode.weightMap.get(neighbor);

                    System.out.println("New cost : " + newDistance);
                    return;
                }
            }
        }

        System.out.println("Negative Cycle not found !!");

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node" + nodeToCheck + ", distance : " + nodeToCheck.distance + ", Path : ");

            pathPrint(nodeToCheck);

            System.out.println();
        }
    }
}
