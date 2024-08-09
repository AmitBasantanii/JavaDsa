package _2_4_Tree;

import java.util.Vector;

// Managing the nodes
public class Tree234 {
    private Node root;

    // Get and set for the root node
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // Constructor
    public Tree234() {
        this.root = new Node();
    }

    public int find(long key) {
        // Pointer used during the search starting from root
        Node currentNode = getRoot();

        // Child bookmark
        int childNumber;

        while (true) {
            // Return the child number
            if ((childNumber = currentNode.findItem(key)) != -1) {
                return childNumber;
            }

            // if end tree reached returned error
            else if (currentNode.isLeaf()) {
                return -1;
            }

            // Move to the next children
            else {
                currentNode = getNextChild(currentNode, key);
            }
        }
    }

    public Node getNextChild(Node theNode, long theValue) {
        // if less, return next child
        int k;
        for (k=0; k< theNode.getNumItems(); k++) {
            if (theValue < theNode.getItem(k).getKey()) {
                return theNode.getChild(k);
            }
        }
        // Return the right one otherwise
        return theNode.getChild(k);
    }

    // insert a NodeData
    public void insert(long dValue) {
        Node currentNode = getRoot();
        NodeData tempItem = new NodeData(dValue);

        while (true) {
            // just found a full node so it must split
            if (currentNode.isFull()) {
                split(currentNode);

                // Back up
                currentNode = currentNode.getParent();

                // Search
                currentNode = getNextChild(currentNode, dValue);
            }

            // if this is the leaf do the insert
            else if (currentNode.isLeaf()) {
                break;
            }

            // Neither a leaf nor full hence go to lower level
            else {
                currentNode = getNextChild(currentNode, dValue);
            }
        }
        currentNode.insertItem(tempItem);
    }

    public void split(Node oldNodeForSplit) {
        // Assuming the node is full, two pointers at 'B' and 'C' items are prepared
        NodeData bItem;
        NodeData cItem;

        // Parent node
        Node parent;

        // Assuming the node is full, two pointers at the two rightmost children are prepared
        Node child2;
        Node child3;

        // Index of items used later on
        int itemIndex;

        // Regardless whether or not root is being split, item 'C' and 'B' have to be disconnected
        cItem = oldNodeForSplit.removeItem();
        bItem = oldNodeForSplit.removeItem();

        // Regardless whether or not root is being slipt, the two rightmost children have to be disconnected
        child2 = oldNodeForSplit.disconnectChild(2);
        child3 = oldNodeForSplit.disconnectChild(3);

        // Create a new node that will be used by the split. Item 'C' will move here regardless whether or not root is being split
        Node newNodeForSplit = new Node();

        // If this is the root, create a new node, promote and connect it
        if (oldNodeForSplit == getRoot()) {
            // Create a new node
            setRoot(new Node());

            // The new root becomes the parent of the current node
            parent = getRoot();

            // Connect the new root to the old root
            root.connectChild(0, oldNodeForSplit);
        }

        // This is the root hence grab the parent of this node
        else {
            parent = oldNodeForSplit.getParent();
        }

        // Always move 'B' up ( root / non-root )
        itemIndex = parent.insertItem(bItem);

        // Make some space for the new children
        // Move parent's connection one child to the right
        for (int itemN = parent.getNumItems() - 1; itemN > itemIndex; itemN--) {
            Node temp = parent.disconnectChild(itemN);
            parent.connectChild(itemN + 1, temp);
        }

        // Connect newNodeForSplit to parent
        parent.connectChild(itemIndex + 1, newNodeForSplit);

        // Always insert 'C' into the new node ( root / non-root split )
        newNodeForSplit.insertItem(cItem);

        // Connect child 2
        newNodeForSplit.connectChild(0, child2);

        // Connect child 3
        newNodeForSplit.connectChild(1, child3);
    }

    public void printTree() {
        // Vector used just ot print the results
        Vector<String> treeV = new Vector<String>();

        treeInfoForPrinting(getRoot(), 0, 0, treeV);

        for (int i =0; i< treeV.size(); i++) {
            System.out.println("Level" + i + ": " + treeV.get(i));
        }
    }

    private void treeInfoForPrinting (Node thisNode, int level, int childN, Vector<String> treeV) {
        // Check whether the element is already present

        try {
            treeV.set(level, treeV.get(level) + " , Child " + childN + " = " + thisNode.displayNode());
        }
        catch (Exception e) {
            treeV.insertElementAt("Child " + childN + " = " + thisNode.displayNode(), level);
        }

        // Display for each child on this node
        for (int i =0; i<thisNode.getNumItems() + 1; i++) {
            Node nextNode = thisNode.getChild(i);

            if (nextNode != null) {
                treeInfoForPrinting(nextNode, level + 1, i, treeV);
            }

            else {
                return;
            }
        }
    }
}