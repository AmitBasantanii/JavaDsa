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
}
