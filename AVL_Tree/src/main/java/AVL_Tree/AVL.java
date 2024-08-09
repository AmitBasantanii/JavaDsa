package AVL_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    BinaryNode root;

    // Constructor
    AVL() {
        root = null;
    }

    // PreOrder Traversal
    public void preOrder (BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " "); // root
        preOrder(node.left); // left
        preOrder(node.right); // right
    }

    // InOrder Traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left); // left
        System.out.print(node.value + " "); // root
        inOrder(node.right); // right
    }

    // PostOrder Traversal
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left); // left
        postOrder(node.right); // right
        System.out.print(node.value + " "); // root
    }

    // LevelOrder Traversal
    public void levelOrder(BinaryNode node) {

        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");

            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }

            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    // Search Method
    BinaryNode search (BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value " + value + " not found in AVL Tree !! " );
            return null;
        }
        else if (node.value == value) {
            System.out.println(" Value : " + value + " is found in the AVL Tree !!");
            return node;
        }

        // if the value is less than the node then search in left subtree
        else if ( value < node.value) {
            return search(node.left, value);
        }

        // if the value is more than the node then search in right search tree
        else {
            return search(node.right, value);
        }
    }

    // getHeight method
    public int getHeight (BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // ROTATION METHODS

    // Rotate right
    private BinaryNode rotateRight (BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;

        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));

        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    // rotate left
    private BinaryNode rotateLeft (BinaryNode disbalancedNode ) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;

        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));

        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    // getBalance method - to check if the tree is already balanced or not
    public int getBalance (BinaryNode node ) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // INSERTION NODE METHOD
    private BinaryNode insertNode (BinaryNode node, int nodeValue ) {

        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        }

        else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        }

        else {
            node.right = insertNode(node.right, nodeValue);
        }

        node.height = 1 + Math.max(getHeight(node.left) , getHeight(node.right));

        int balance = getBalance(node);

        // LEFT - LEFT CONDITION - means we need to ROTATE RIGHT
        if (balance > 1 && nodeValue < node.left.value) {
            return rotateRight(node);
        }

        // LEFT RIGHT CONDITION - first ROTATE LEFT and then ROTATE RIGHT
        if (balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // RIGHT - RIGHT CONDITION -> means we need to ROTATE LEFT
        if ( balance < -1 && nodeValue > node.right.value ) {
            return rotateLeft(node);
        }

        // RIGHT - LEFT CONDITION -> means first ROTATE RIGHT and then ROTATE LEFT
        if (balance < -1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }
    // TIME COMPLEXITY for INSERTION : O ( LOG N )

    // HELPER FUNCTION
    // MINIMUM NODE

    public static BinaryNode minimumNode (BinaryNode root) {
        if (root.left == null) {
            return root;
        }

        else {
            return minimumNode(root.left);
        }
    }
    // TIME COMPLEXITY to find MINIMUM NODE : O ( LOG N )

    // Delete Node Method
    public BinaryNode deleteNode (BinaryNode node, int value) {

        if (node == null) {
            System.out.println("Value not found in AVL Tree");
            return node;
        }

        else if (value < node.value) {
            node.left = deleteNode(node.left, value);
        }

        else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        }

        else {
            if (node.left != null && node.right != null) {
                BinaryNode temp = node;
                BinaryNode minNodeForRight = minimumNode(temp.right);

                node.value = minNodeForRight.value;
                node.right = deleteNode(node.right, minNodeForRight.value);
            }

            else if (node.left != null) {
                node = node.left;
            }

            else if (node.right != null) {
                node = node.right;
            }

            else {
                node = null;
            }
        }

        // CASE 2 : ROTATION REQUIRED
//        System.out.println("1");
//        node.height = 1 + Math.max(getHeight(node.left) , getHeight(node.right));

        int balance = getBalance(node);

        // LEFT - LEFT CONDITION
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // LEFT - RIGHT CONDITION
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // RIGHT - RIGHT CONDITION
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // RIGHT - LEFT CONDITION
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // DELETE METHOD
    public void delete (int value) {
        root = deleteNode(root, value);
    }
    // TIME AND SPACE COMPLEXITY FOR DELETION : 0 ( LOG N )

    public void deleteAVL() {
        root = null;
        System.out.println("AVL has been successfully deleted !!");
    }
}
