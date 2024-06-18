package Binary_Tree_Using_Linked_List;

public class Main {
    public static void main(String... args) {
        BinaryTreeLL binaryTreeLL = new BinaryTreeLL();

        BinaryNode N1 = new BinaryNode();
        N1.value = "N1";

        BinaryNode N2 = new BinaryNode();
        N1.value = "N2";

        BinaryNode N3 = new BinaryNode();
        N3.value = "N3";

        BinaryNode N4 = new BinaryNode();
        N4.value = "N4";

        BinaryNode N5 = new BinaryNode();
        N5.value = "N5";

        BinaryNode N6 = new BinaryNode();
        N6.value = "N6";

        BinaryNode N7 = new BinaryNode();
        N7.value = "N7";

        BinaryNode N8 = new BinaryNode();
        N8.value = "N8";

        BinaryNode N9 = new BinaryNode();
        N9.value = "N9";

        N1.left = N2;
        N1.right = N3;
        N2.left = N4;
        N2.right = N5;
        N3.left = N6;
        N3.right = N7;
        N4.left = N8;
        N4.right = N9;
        binaryTreeLL.root = N1;

        binaryTreeLL.preOrder(binaryTreeLL.root); // Root - left - right
        System.out.println();

        binaryTreeLL.inOrder(binaryTreeLL.root); // Left - Root - Right
        System.out.println();

        binaryTreeLL.postOrder(binaryTreeLL.root); // Left - Right - Root
        System.out.println();

        binaryTreeLL.levelOrder();
        System.out.println();

        binaryTreeLL.search("N5");

        binaryTreeLL.insert("N10");

        binaryTreeLL.levelOrder();

        System.out.println(binaryTreeLL.getDeepestNode().value);

        binaryTreeLL.deleteDeepestNode();
        System.out.println();

        binaryTreeLL.levelOrder();
        System.out.println();

        binaryTreeLL.deleteNode("N3");
        System.out.println();

        binaryTreeLL.levelOrder();

        binaryTreeLL.deleteBT();
    }
}
