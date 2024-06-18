package Circular_Singly_Linked_List;

public class CircularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    // creation of circular singly linked list
    public Node createCSLL (int nodeValue ) {
        head = new Node();
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // insertion method
    public void insertCSLL(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if(head == null) {
            createCSLL(nodeValue);
            return;
        }
        // insertion at the begining of the linked list
        if (location ==0 ) {
            node.next = head;
            head = node;
            tail.next= head;
        }
        // insertion at the end of the linked list
        else if(location >= size) {
            tail.next = node;
            tail = node;
            tail.next =head;
        }
        // insertion at the specified location
        else {
            Node tempNode = head;
            int index = 0;
            while (index < location-1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    // traversal method
    public void traverseCSLL() {
        if(head != null) {
            Node tempNode = head;
            for(int i=0; i<size; i++) {
                System.out.print(tempNode.value);
                if(i != size-1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.print("\n");
        }
        else {
            System.out.println("\n Circular singly linked list does not exist!");
        }
    }

    // Search Method
    public boolean searchNode (int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for(int i=0; i<size; i++) {
                if(tempNode.value == nodeValue) {
                    System.out.print(" Found node at location : " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found!");
        return false;
    }

    // Delete method
    public void deleteNode(int location) {
        if(head == null) {
            System.out.println("The CSLL does not exist!");
            return;
        }
        // deleting from the begining of the linked list
        else if( location == 0) {
            // if there are more than one element in the linked list
            head = head.next;
            tail.next = head;
            size--;

            // case 2: if there is only one element in the linked list
            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        }

        // deleting the node from the end of the linked list
        else if(location >= size ) {
            Node tempNode = head;
            for(int i=0; i<size-1; i++) {
                tempNode = tempNode.next;
            }
            // case 1 : if there is only one element in the linked list
            if (tempNode == head) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            // for more than one element in the linked list
            tempNode.next = head;
            tail = tempNode;
            size--;
        }

        // deleting a node from the given location
        else {
            Node tempNode = head;
            for(int i=0; i<location-1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    // deleting entire CSLL
    public void deleteCSLL () {
        if(head == null) {
            System.out.println("The CSLL does not exists!");
        }
        else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("The CSLL has been deleted!!");
        }
    }
}
