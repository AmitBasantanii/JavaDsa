package Doubly_Linked_List;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // creation of DLL
        dll.createDLL(1);
        System.out.println(dll.head.value);

        dll.insertDLL(2, 0);
        dll.insertDLL(3, 1);
        dll.insertDLL(4, 7);

        System.out.println(dll.head.value);
        System.out.println(dll.head.next.value);

        dll.traverseDLL();
        dll.reverseTraverseDLL();

        dll.searchNode(4);
        dll.searchNode(7);

        dll.deleteNodeDLL(0);
        dll.traverseDLL();

        dll.deleteDLL();
        dll.traverseDLL();
    }
}
