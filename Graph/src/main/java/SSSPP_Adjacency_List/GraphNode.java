package SSSPP_Adjacency_List;

import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false;

    public GraphNode parents;

    public ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

    public GraphNode (String name, int index) {
        this.name = name;
        this.index = index;
    }

}
