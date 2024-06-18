public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    // Method to create Linked List
    public void createLL (int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size=1;
    }

    // Method to insert elements in linked list
    public void insertInLL(int nodeValue) {
        if (head == null) {
            createLL(nodeValue);
            return;
        }
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // traverse method
    public void traverseLL() {
        Node tempNode = head;
        for(int i =0; i<size; i++) {
            System.out.print(tempNode.value);
            if( i != size -1) {
                System.out.print("->");
            }
            tempNode = tempNode.next;
        }
        System.out.println("\n");
    }

    // deleting a node
    public void deletionOfNode(int location) {
        if(head == null) {
            System.out.println("The SLL doesn't exists");
            return;
        }
        // deleting from starting of the linked list
        else if (location == 0) {
            head = head.next;
            size--;
            if(size == 0) {
                tail = null;
            }
        }
        // deleting from the end of the linked list
        else if( location >= size) {
            Node tempNode = head;
            for (int i =0; i<size-1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        }
        // deleting from the particular position
        else {
            Node tempNode = head;
            for(int i=0; i<location-1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
        }
    }

    // deleting entire SinglyLinkedList
    public void deleteSLL() {
        head = null;
        tail = null;
        System.out.println("The SLL deleted successfully ");
    }
}
