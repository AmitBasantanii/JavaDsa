package Queue_Via_Stacks;

public class Main {
    public static void main(String[] args) {
        QueueViaStack newQueue = new QueueViaStack();

        newQueue.enQueue(1);
        newQueue.enQueue(2);
        newQueue.enQueue(3);

        System.out.println(newQueue.deQueue()); // 1

        newQueue.enQueue(4); // 2 -> 3 -> 4

        System.out.println(newQueue.deQueue()); // 2
    }
}
