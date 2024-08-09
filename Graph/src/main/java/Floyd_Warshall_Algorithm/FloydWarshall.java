package Floyd_Warshall_Algorithm;

import java.util.ArrayList;

public class FloydWarshall {

    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

    // Constructor
    public FloydWarshall (ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    void floydWarshall() {
        int size = nodeList.size();

        int[][] Vertex = new int[size][size];

        // Initializing Distance table from Adjacency List

        for (int i=0; i<size; i++) {
            WeightedNode first = nodeList.get(i);

            for (int j=0; j<size; j++) {
                WeightedNode second = nodeList.get(j);

                if ( i == j) {
                    Vertex[i][j] = 0;
                }

                else if ( first.weightMap.containsKey(second)) {
                    // We have directed edge between i and j

                    Vertex[i][j] = first.weightMap.get(second);
                }

                else {
                    // no direct edge between i and j, so mark it as infinity
                    // we will divide by 10 to avoid arithmetic overflow

                    Vertex[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }

        // Floyd Warshall's Algorithm

        for (int k = 0; k<nodeList.size(); k++) {

            for (int i=0; i<nodeList.size(); i++) {

                for (int j=0; j<nodeList.size(); j++) {

                    if (Vertex[i][j] > Vertex[i][k] + Vertex[k][j] ) {
                        // if update is possible, then update the path
                        Vertex[i][j] = Vertex[i][k] + Vertex[k][j];
                        // this will keep a track on path
                    }
                }
            }
        }

        // Print table of node with minimum distance and strongest path from each source
        for (int i=0; i<size; i++) {
            System.out.print("Printing distance list for node " + nodeList.get(i) + " : ");

            for (int j=0; j<size; j++) {
                System.out.print(Vertex[i][j] + " ");
            }

            System.out.println();
        }
    }

    // add a weighted edge between two nodes
    public void addWeightedEdge (int i, int j, int d) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, d);
    }
}