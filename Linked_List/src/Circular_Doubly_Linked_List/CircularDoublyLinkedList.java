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
    public void reverseTraversalCDLL() {
        if (head != null) {
            DoublyNode tempNode = tail;
            // in reverse loop - tail to head
            for(int i =0; i<size; i++) {
                System.out.print(tempNode.value);
                if(i != size-1) {
                    System.out.print("<-");
                }
                tempNode = tempNode.previous;
            }
        }
        else {
            System.out.println("The CDLL does not exists !! ");
        }
    }

    // Search for a Node
    public boolean searchNodeCDLL(int nodeValue) {
        if (head != null) {
            DoublyNode tempNode = head;
            for(int i=0; i<size; i++) {
                if(tempNode.value == nodeValue) {
                    System.out.println("The node is found at location : " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found !! ");
        return false;
    }

    // Deletion Method
    public void deleteNode(int location) {
        if(head == null) {
            System.out.println("The CDLL does not exists !! ");
            return;
        }

        // deleting a node from the begining of the linked list
        else if(location == 0) {
            // case 1: if there is only one node present in the linked list
            if(size == 1) {
                head.previous = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            }

            // case 2 : more than one element in the CDLL
            else {
                head = head.next;
                head.previous = tail;
                tail.next = head;
                size--;
            }
        }

        // deleting from the end of CDLL
        else if(location >= size) {

            // case 1: if 1 node is present in the linked list
            if (size == 1) {
                head.previous = null;
                head.next = null;
                head = tail = null;
                size--;
            }

            // case 2 : more than 1 node is present in the CDLL
            else {
                tail = tail.previous;
                tail.next = head;
                head.previous = tail;
                size--;
            }
        }

        // deleting any given node from CDLL
        else {
            DoublyNode tempNode = head;
            for(int i=0; i<location-1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.previous = tempNode;
            size--;
        }
    }

    // Delete Entire CDLL
    public void deleteCDLL() {
        DoublyNode tempNode = head;
        for(int i=0; i<size; i++) {
            tempNode.previous = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("The CDLL has been deleted !! ");
    }
}
