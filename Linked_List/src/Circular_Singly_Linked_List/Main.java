package Circular_Singly_Linked_List;

public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        csll.createCSLL(5);

        System.out.println(csll.head.value); // 5
        System.out.println(csll.head.next.value); // 5

        csll.insertCSLL(4, 0);
        System.out.println(csll.head.value); // 4

        csll.insertCSLL(6, 1);
        csll.insertCSLL(7, 8);
        csll.traverseCSLL(); // 4 -> 6 -> 5 -> 7

        csll.searchNode(5); // Node found at location 2

        csll.deleteNode(0);

        csll.traverseCSLL(); // 6 -> 5 -> 7
    }
}
