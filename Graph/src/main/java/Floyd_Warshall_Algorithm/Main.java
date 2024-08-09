package Floyd_Warshall_Algorithm;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));

        FloydWarshall newGraph = new FloydWarshall(nodeList);

        newGraph.addWeightedEdge(0,3,1);
        newGraph.addWeightedEdge(0, 1, 8);
        newGraph.addWeightedEdge(1,2,1);
        newGraph.addWeightedEdge(2,0,4);
        newGraph.addWeightedEdge(3,1,2);
        newGraph.addWeightedEdge(3,2,9);

        System.out.println("Printing Floyd Warshall algorithm from source : A");
        newGraph.floydWarshall();
    }
}
