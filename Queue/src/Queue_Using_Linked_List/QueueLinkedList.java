package Queue_Using_Linked_List;

public class QueueLinkedList {

    LinkedList linkedList;

    // Queue Creation
    public QueueLinkedList() {
        linkedList = new LinkedList();
        System.out.println("The Queue is successfully created !!");
    }

    // isEmpty Method
    public boolean isEmpty() {
        if(linkedList.head == null) {
            return true;
        }
        else {
            return false;
        }
    }

    // enQueue method
    public void enQueue(int value) {
        linkedList.insertInLinkedList(value, linkedList.size);
        System.out.println("Successfully inserted " + value + " in the Queue");
    }

    // deQueue Method
    public int deQueue() {
        int value = -1;
        if(isEmpty()) {
            System.out.println("The Queue is Empty !!");
        }
        else {
            value = linkedList.head.value;
            linkedList.deletionOfNode(0);
        }
        return value;
    }

    // Peek method
    public int peek() {
        if(isEmpty()) {
            System.out.println("The Queue is Empty !!");
            return -1;
        }
        else {
            return linkedList.head.value;
        }
    }

    // delete Method
    public void deleteQueue() {
        linkedList.head = null;
        linkedList.tail = null;
        System.out.println("The Queue is successfully deleted !! ");
    }
}
