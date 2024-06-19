package Binary_Tree_Using_Array;

public class Main {
    public static void main(String[] args) {
        BinaryTree newBinaryTree = new BinaryTree(5);

        newBinaryTree.insert("N1");
        newBinaryTree.insert("N2");
        newBinaryTree.insert("N3");
        newBinaryTree.insert("N4");
        newBinaryTree.insert("N5");
        newBinaryTree.insert("N6");

        System.out.println();

        newBinaryTree.preOrder(1);
        System.out.println();

        newBinaryTree.postOrder(1);
        System.out.println();

        newBinaryTree.inOrder(1);
        System.out.println();

        newBinaryTree.levelOrder();
        System.out.println();

        newBinaryTree.search("N5");
        System.out.println();

        newBinaryTree.delete("N5");
        System.out.println();

        newBinaryTree.levelOrder();
        System.out.println();

        newBinaryTree.deleteBT();

    }
}
