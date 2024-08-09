package _2_4_Tree;

// Storing the array of objects
public class Node {

    // Controls the number of children per node
    private static final int MAX_CHILDREN = 4;

    private static final int MAX_ITEMS_PER_NODE = MAX_CHILDREN - 1;

    private Node parent;

    // Array that stored all pointers to child / children
    private Node childArray[] = new Node[MAX_CHILDREN];

    // Each node will contain a number of items equal to the number of children - 1
    private NodeData itemArray[] = new NodeData[MAX_ITEMS_PER_NODE];

    // Number of item(s) currently stored
    private int numItems;

    // Useful methods for dealing with numItems
    public int getNumItems() {
        return numItems;
    }

    public void increaseItemNum() {
        numItems++;
    }

    public void decreaseItemNum() {
        numItems--;
    }

    // Useful methods to do work on childArray
    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public void setChild(int childNum, Node child) {
        childArray[childNum] = child;
    }

    // Useful methods to deal with itemArray
    public NodeData getItem(int index) {
        return itemArray[index];
    }

    public void setItem(int index, NodeData item) {
        itemArray[index] = item;
    }

    public boolean isItemNull(int index) {
        return (itemArray[index] == null) ? true : false;
    }

    // Useful methods to retrieve the child, parent and check whether the node is a leaf
    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return (getChild(0) == null) ? true : false;
    }

    public boolean isFull() {
        return ( getNumItems() == MAX_ITEMS_PER_NODE ) ? true : false;
    }

    // Connect child to this node
    public void connectChild(int childNum, Node child) {
        // update the pointers array
        setChild(childNum, child);

        // if the child exists, have the child pointing to this node
        // The two nodes now will be connected
        if (child != null) {
            child.parent = this;
        }
    }

    // Disconnect child from this node
    public Node disconnectChild (int childNum) {
        // Get a pointer to the child that has to be disconnected
        Node tempNode = getChild(childNum);

        // Remove the pointer to this child from the arrays
        setChild(childNum, null);

        // Return the pointer at the deleted item which still exists in the memory
        return tempNode;
    }

    // If found return index of item within node
    public int findItem(long key) {
        for (int i=0; i<MAX_ITEMS_PER_NODE; i++) {
            // Exit now as no more items in this node
            if (isItemNull(i)) {
                break;
            }
            // check whether this is the right key
            else if ( getItem(i).getKey() == key)
            // Return the index of the found item
            return i;
        }
        // could not find the item
        return -1;
    }

    public int insertItem(NodeData newItem) {
        // Assuming the node is not full , increase the counter
        increaseItemNum();

        // Start on right, analyze items
        for (int i = MAX_ITEMS_PER_NODE-1; i >= 0; i--) {
            // if item is null, move left one cell
            if (isItemNull(i)) {
                continue;
            }

            // not null, therefore get the key
            else {
                // if the new item is smaller, move the old item right to make some place
                if (newItem.getKey() < getItem(i).getKey()) {
                    setItem(i+1, getItem(i));
                }

                // They are already sorted, do insert
                else {
                    setItem(i+1, newItem);

                    // Return the index of the newItem
                    return i +1;
                }
            }
        }

        // First item in this node
        setItem(0, newItem);
        // return the index of the newItem
        return 0;
    }

    // Remove the largest item
    public NodeData removeItem() {
        // Assuming the node is empty, save the item
        NodeData temp = getItem(getNumItems() - 1);

        // Disconnect the item
        setItem(getNumItems() -1, null);

        // decrease the counter
        decreaseItemNum();

        return temp;
    }

    public String displayNode() {
        String x = new String("");
        for (int node = 0; node < getNumItems(); node++) {
            x = x + getItem(node).displayItem();

        }
        return x;
    }
}