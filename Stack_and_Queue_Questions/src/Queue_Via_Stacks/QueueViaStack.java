package Queue_Via_Stacks;

import java.util.Stack;

public class QueueViaStack {
    Stack<Integer> stackNewest, stackOldest;

    public QueueViaStack() {
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void enQueue(int value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if(stackOldest.isEmpty()) {
            while (! stackNewest.isEmpty()) {
                int poppedOut = stackNewest.pop();
                stackOldest.push(poppedOut);
            }
        }
    }

    public int deQueue() {
        shiftStacks();
        return stackOldest.pop();
    }

    public int peek() {
        shiftStacks();
        return stackOldest.peek();
    }
}
