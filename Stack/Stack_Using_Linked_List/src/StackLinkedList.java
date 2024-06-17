public class StackLinkedList {

    LinkedList linkedList;

    public void Stack() {
        linkedList = new LinkedList();
    }

    // Push method
    public void push(int value) {
        linkedList.insertInLL(value);
        System.out.println("Inserted value " + value + "in stack");
    }

    // isEmpty method
    public boolean isEmpty() {
        if (linkedList.head == null) {
            return true;
        }
        return false;
    }

    // Pop method
    public int pop() {
        int result = -1;
        if(isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            result = linkedList.head.value;
            linkedList.deletionOfNode(0);
        }
        return result;
    }

    // Peek method
    public int peek() {
        if(isEmpty()) {
            System.out.println("The stack is empty");
            return -1;
        }
        else {
            return linkedList.head.value;
        }
    }

    // Deletion method
    public void deleteStack() {
        linkedList.head = null;
        System.out.println("The stack is deleted !! ");
    }
}
