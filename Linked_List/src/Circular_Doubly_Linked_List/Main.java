package Circular_Doubly_Linked_List;

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();

        circularDoublyLinkedList.createCDLL(1);
        System.out.println(circularDoublyLinkedList.head.value); // 1

        circularDoublyLinkedList.insertNode(2, 0);
        System.out.println(circularDoublyLinkedList.head.value); // 2

        circularDoublyLinkedList.insertNode(3, 2);
        circularDoublyLinkedList.insertNode(4, 5);

        circularDoublyLinkedList.traverseCDLL(); // 2 -> 1 -> 3 -> 4

        circularDoublyLinkedList.reverseTraversalCDLL();

        circularDoublyLinkedList.searchNodeCDLL(3); // The node is found at location 2

        circularDoublyLinkedList.searchNodeCDLL(9); // The node is not found

        circularDoublyLinkedList.deleteNode(0);
        circularDoublyLinkedList.traverseCDLL(); // 1 -> 3 -> 4

        circularDoublyLinkedList.deleteCDLL(); // The CDLL has been deleted
        circularDoublyLinkedList.traverseCDLL(); // The CDLL does not exists
    }
}
