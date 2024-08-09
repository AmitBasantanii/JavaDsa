package AVL_Tree;

public class Main {
    public static void main(String[] args) {

        AVL newAVL = new AVL();

        newAVL.insert(5);
        newAVL.insert(10);
        newAVL.insert(15);
        newAVL.insert(20);

        newAVL.levelOrder(new BinaryNode());

        newAVL.delete(5);
        System.out.println();

        newAVL.levelOrder(new BinaryNode());
        System.out.println();

        newAVL.deleteAVL();
    }
}
