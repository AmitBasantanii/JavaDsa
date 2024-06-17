package Linear_Queue_Using_Array;

public class QueueArray {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("The queue is created with the size of : " + size);
    }

    // isFull Method
    public boolean isFull() {
        if (topOfQueue == arr.length-1) {
            return true;
        }
        else {
            return false;
        }
    }

    // isEmpty method
    public boolean isEmpty() {
        if ((beginningOfQueue == -1) || (beginningOfQueue == arr.length)) {
            return true;
        }
        else {
            return false;
        }
    }

    // EnQueue method
    public void enQueue(int value) {
        if(isFull()) {
            System.out.println("The Queue is already full !!");
        }
        else if (isEmpty()) {
            beginningOfQueue = 0; // initializing
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + "in the Queue");
        }
        else {
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + "in the Queue");
        }
    }

    // deQueue method
    public int deQueue() {
        if(isEmpty()) {
            System.out.println("The Queue is empty !! ");
            return -1;
        }
        else {
            int result = arr[beginningOfQueue];
            beginningOfQueue++;

            if (beginningOfQueue > topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            }
            return result;
        }
    }

    // Peek Method
    public int peek() {
        if(!isEmpty()) {
            return arr[beginningOfQueue];
        }
        else {
            System.out.println("The Queue is empty !!");
            return -1;
        }
    }

    // delete Queue
    public void deleteQueue() {
        arr = null;
        System.out.println("The Queue is successfully deleted");
    }
}
