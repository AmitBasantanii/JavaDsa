package Circular_Doubly_Linked_List;

public class CircularDoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    // Creation method for Circular Doubly Linked List
    DoublyNode createCDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        newNode.next = newNode;
        newNode.previous = newNode;
        size = 1;
        return head;
    }

    // Insertion Method
    public void insertNode(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;

        // if linked list does not exist then create linked list
        if (head == null) {
            createCDLL(nodeValue);
            return;
        }
        // insertion of the new node at the begining
        else if (location == 0) {
            newNode.next = head;
            newNode.previous = tail; // to make it circular
            head.previous = newNode;
            tail.next = newNode;
            head = newNode;
        }

        // insertion at the end of CDLL
        else if (location >= size) {
            newNode.next = head;
            newNode.previous = tail;
            head.previous = newNode;
            tail.next=newNode;
            tail = newNode;
        }

        // insertion of node at a specific location
        else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location-1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.previous = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.previous = newNode;
        }
        size++;
    }

    // Traverse CDLL
    public void traverseCDLL() {
        if( head != null) {
            DoublyNode tempNode = head;
            for(int i=0; i<size; i++) {
                System.out.print(tempNode.value);
                if( i != size -1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        else {
            System.out.println("The CDLL does not exists !!");
        }
        System.out.println();
    }

    // Reverse Traversal
}
