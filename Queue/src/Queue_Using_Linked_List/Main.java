package Queue_Using_Linked_List;

public class Main {

    public static void main(String[] args) {
        QueueLinkedList newQLL = new QueueLinkedList();

        boolean result = newQLL.isEmpty();
        System.out.println(result);

        newQLL.enQueue(10);
        newQLL.enQueue(20);
        newQLL.enQueue(30);

        boolean result1 = newQLL.isEmpty();
        System.out.println(result1);

        int result2 = newQLL.deQueue();
        System.out.println(result2);

        int result3 = newQLL.peek();
        System.out.println(result3);

        newQLL.deleteQueue();
    }

}
