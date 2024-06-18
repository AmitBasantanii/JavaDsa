package Circular_Queue_Using_Array;

public class Main {
    public static void main(String[] args) {
        CircularQueue newCQ = new CircularQueue(3);

        boolean result = newCQ.isEmpty();
        System.out.println(result);

        boolean result1 = newCQ.isFull();
        System.out.println(result1);

        newCQ.enQueue(10);
        newCQ.enQueue(20);
        newCQ.enQueue(30);
        newCQ.enQueue(40);
        newCQ.enQueue(50);

        int result2 = newCQ.deQueue();
        System.out.println(result2);

        int result3 = newCQ.peek();
        System.out.println(result3);

        newCQ.deleteQueue();
    }
}
