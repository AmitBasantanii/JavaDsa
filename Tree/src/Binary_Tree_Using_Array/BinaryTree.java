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

    // Post Order
    public void postOrder(int index) {
        if(index>lastUsedIndex) {
            return;
        }
        postOrder(2*index); // left subtree
        postOrder(2*index+1); // right subtree
        System.out.print(arr[index] + " "); // root subtree
    }

    // LevelOrder Traversal
    public void levelOrder() {
        for(int i=1; i<= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Search method
    public int search(String value) {
        for(int i=1; i<=lastUsedIndex; i++) {
            if(arr[i] == value) {
                System.out.println(value + " exists at the location : " + i);
                return i;
            }
        }
        System.out.println("The value does not exists in the Binary Tree");
        return -1;
    }

    // Delete Method
    public void delete(String value) {
        int location = search(value);
        if(location == -1) {
            return;
        }
        else {
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println(" The node successfully deleted !! ");
        }
    }

    // Delete BT
    public void deleteBT() {
        try {
            arr = null;
            System.out.println("The BT has been sucessfully deleted !!");
        }
        catch(Exception exception) {
            System.out.println("There was an error deleting the tree !!");
        }
    }
}
