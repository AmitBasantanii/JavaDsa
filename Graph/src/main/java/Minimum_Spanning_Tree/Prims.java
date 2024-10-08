package Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

    // Constructor
    public Prims(ArrayList< WeightedNode> nodeList )  {
        this.nodeList = nodeList;
    }

    // Prim's Algorithm from Source Node
    void prims (WeightedNode node) {
        for (int counter = 0; counter<nodeList.size(); counter++) {
            nodeList.get(counter).distance = Integer.MAX_VALUE;
        }

        node.distance = 0;
        // Setting '0' distance for source vertex

        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();

        queue.addAll(nodeList);

        while (!queue.isEmpty()) {

            WeightedNode presentNode = queue.remove();
            // Remove vertex which has min distance

            for (WeightedNode neighbor : presentNode.neighbors) {
                if (queue.contains(neighbor)) {
                    // If vertex is not processed, only then enter in if-else
                    // If known weight of this adjacent vertex is more than current edge,
                    // then update adjacent vertex distance and parent

                    if (neighbor.distance > presentNode.weightMap.get(neighbor)) {

                        neighbor.distance = presentNode.weightMap.get(neighbor);

                        neighbor.parent = presentNode;
                        queue.remove(neighbor);

                        // Refresh the priority queue
                        queue.add(neighbor);
                    }
                }
            }
        }

        int cost = 0;
        // print table of node with minimum distance and shorted path from source

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node " + nodeToCheck + ", key : " + nodeToCheck.distance + ", Parent : " + nodeToCheck.parent);

            cost = cost + nodeToCheck.distance;
        }

        System.out.println("\n Total cost for MST : " + cost);
    }

    // add a weighted undirected edge between two nodes
    public void addWeightedUndirectedEdge (int i, int j, int d) {

        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);

        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, d);
        second.weightMap.put(first, d);
    }
}
