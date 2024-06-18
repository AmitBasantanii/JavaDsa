package Binary_Tree_Using_Array;

public class BinaryTree {
    String[] arr;
    int lastUsedIndex;

    public BinaryTree (int size) {
        arr = new String[size+1];
        this.lastUsedIndex = 0;
        System.out.println("Blank Tree of size " + size + " has been created !! ");
    }

    // isFull Method
    boolean isFull() {
        if(arr.length-1 == lastUsedIndex) {
            return true;
        }
        else {
            return false;
        }
    }

    // insert method
    void insert(String value) {
        if(!isFull()) {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println("The value of " + value + " has been inserted !!");
        }
        else {
            System.out.println("The Binary Tree is full !! ");
        }
    }

    // PreOrder Traversal
    public void preOrder(int index) {
        if(index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    // InOrder Traversal
    public void inOrder(int index) {
        if(index > lastUsedIndex) {
            return;
        }
        inOrder(index * 2);
        System.out.print(arr[index] + " ");
        inOrder(index * 2 + 1);
    }
}
