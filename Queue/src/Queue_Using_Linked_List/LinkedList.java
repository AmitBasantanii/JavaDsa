package Queue_Using_Linked_List;

public class LinkedList {

    public Node head;
    public Node tail;
    public int size;

    // creation of linked list
    public Node createSinglyLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insertion in Singly Linked List
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if(head == null) {
            createSinglyLinkedList(nodeValue);
            return;
        }
        // insertion at the begining of the linked list
        else if (location == 0) {
            node.next = head;
            head = node;
        }
        // insertion at the end of the linked list
        else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        }
        // insertion at a particular position
        else {
            Node tempNode = head;
            int index = 0;
            while(index < location -1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // Linked list traversal
    public void traverseSinglyLinkedList() {
        if(head == null) {
            System.out.println(" SLL doesn't exist ! ");
        }
        else {
            Node tempNode = head;
            for (int i=0; i<size; i++) {
                System.out.print(tempNode.value);
                if(i != size -1 ) {
                    System.out.print( " -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    // searching for the node in the linked list
    boolean searchNode(int nodeValue) {
        if( head != null) {
            Node tempNode = head;
            for(int i=0; i<size; i++) {
                if(tempNode.value == nodeValue) {
                    System.out.println("Found the node at location : " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found!");
        return false;
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
