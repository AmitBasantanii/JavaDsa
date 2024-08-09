package Route_Between_Nodes;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    static ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public enum State {
        Univisited,
        Visited,
        Visiting;
    }

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addDirectedEdge (int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
    }

    // Route between nodes
    public static boolean search (GraphNode start, GraphNode end) {
        LinkedList<GraphNode> linkedList = new LinkedList<GraphNode>();

       for (GraphNode node : nodeList) {
           node.state = State.Univisited;
       }

       start.state = State.Visiting;
       linkedList.add(start); //enqueue

        GraphNode currentNode;

        while (!linkedList.isEmpty()) {
            // dequeue
            currentNode = linkedList.removeFirst();

            if (currentNode != null) {
                for (GraphNode v : currentNode.neighbors) {
                    if (v.state == State.Univisited) {
                        if (v == end) {
                            return true;
                        }

                        else {
                            v.state = State.Visiting;
                            linkedList.add(v);
                        }
                    }
                }
                currentNode.state = State.Visited;

            }
        }
        return false;
    }
}
