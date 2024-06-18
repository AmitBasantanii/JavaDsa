package Binary_Tree_Using_Linked_List;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
    BinaryNode root;

    public BinaryTreeLL() {
        this.root = null;
    }

    // PreOrder Traversal
    void preOrder(BinaryNode binaryNode) {
        if(binaryNode == null) {
            return;
        }
        System.out.print(binaryNode.value + " ");
        preOrder(binaryNode.left);
        preOrder(binaryNode.right);
    }

    // InOrder Traversal
    void inOrder(BinaryNode binaryNode) {
        if(binaryNode == null) {
            return;
        }
        inOrder(binaryNode.left);
        System.out.print(binaryNode.value + " "); // root node
        inOrder(binaryNode.right);
    }

    // Post Order Traversal
    void postOrder (BinaryNode node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level Order
    void levelOrder() {
        Queue<BinaryNode> binaryNodeQueue = new LinkedList<BinaryNode>();

        binaryNodeQueue.add(root);
        while (!binaryNodeQueue.isEmpty()) {
            BinaryNode presentNode = binaryNodeQueue.remove();
            System.out.print(presentNode.value + " ");

            if(presentNode.left != null) {
                binaryNodeQueue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                binaryNodeQueue.add(presentNode.right);
            }
        }
    }

    // Search Method
    public void search(String value) {
        Queue<BinaryNode> binaryNodeQueue = new LinkedList<BinaryNode>();

        binaryNodeQueue.add(root);
        while (!binaryNodeQueue.isEmpty()) {
            BinaryNode presentNode = binaryNodeQueue.remove();

            if(presentNode.value == value) {
                System.out.print("The value-" + value + " is found in the Tree" );
                return;
            }
            else {
                if(presentNode.left != null) {
                    binaryNodeQueue.add(presentNode.left);
                }
                if(presentNode.right != null) {
                    binaryNodeQueue.add(presentNode.right);
                }
            }
        }
        System.out.println( "The value " + value + " is not found in the tree");
    }

    // Insert method
    void insert(String value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if(root == null) {
            root = newNode;
            System.out.print("Inserted new node at Root");
            return;
        }
        Queue<BinaryNode> binaryNodeQueue = new LinkedList<BinaryNode>();
        binaryNodeQueue.add(root);

        while(!binaryNodeQueue.isEmpty()) {
            BinaryNode presentNode = binaryNodeQueue.remove();
            if(presentNode.left == null) {
                presentNode.left = newNode;
                System.out.println("Successfully inserted");
                break;
            }
            else if (presentNode.right == null) {
                presentNode.right = newNode;
                System.out.println("Successfully Inserted !!");
                break;
            }
            else {
                binaryNodeQueue.add(presentNode.left);
                binaryNodeQueue.add(presentNode.right);
            }
        }
    }

    // Get Deepest Node
    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> binaryNodeQueue = new LinkedList<BinaryNode>();
        binaryNodeQueue.add(root);
        BinaryNode presentNode = null;

        while(!binaryNodeQueue.isEmpty()) {
            presentNode = binaryNodeQueue.remove();

            if(presentNode.left != null) {
                binaryNodeQueue.add(presentNode.left);
            }

            if(presentNode.right != null) {
                binaryNodeQueue.add(presentNode.right);
            }
        }
        return presentNode;
    }

    // Delete Deepest Node
    public void deleteDeepestNode() {
        Queue<BinaryNode> binaryNodeQueue = new LinkedList<BinaryNode>();
        binaryNodeQueue.add(root);

        BinaryNode previousNode, presentNode = null;

        while (!binaryNodeQueue.isEmpty()) {
            previousNode = presentNode;
            presentNode = binaryNodeQueue.remove();
            if(presentNode.left == null) {
                previousNode.right = null;
                return;
            }
            else if (presentNode.right == null) {
                previousNode.left = null;
                return;
            }
            binaryNodeQueue.add(presentNode.left);
            binaryNodeQueue.add(presentNode.right);
        }
    }

    // Delete Given Node
    void deleteNode(String value) {
        Queue<BinaryNode> binaryNodeQueue = new LinkedList<BinaryNode>();
        binaryNodeQueue.add(root);

        while (!binaryNodeQueue.isEmpty()) {
            BinaryNode presentNode = binaryNodeQueue.remove();

            if(presentNode.value == value) {
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The Node is deleted !!");
                return;
            }
            else {
                if(presentNode.left != null) {
                    binaryNodeQueue.add(presentNode.left);
                }
                if(presentNode.right != null) {
                    binaryNodeQueue.add(presentNode.right);
                }
            }
        }
        System.out.println("The node does not exist in this Binary Tree");
    }

    // Delete Binary Tree
    void deleteBT() {
        root = null;
        System.out.println("BT has been successfully deleted !!");
    }
}
