package _2_4_Tree;

public class NodeData {

    private long key;

    long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    // Constructor
    public NodeData(long keyVal) {
        this.key = keyVal;
    }

    // Method to display key used for printing
    public String displayItem() {
        return ( "{"+ getKey() + "}");
    }
}
