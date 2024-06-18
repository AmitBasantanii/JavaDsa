package Three_In_One;

// describe how you could use a single array to implement 3 stacks

public class ThreeInOne {

    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    // isFull method
    public boolean isFull(int stackNum) {
        if (sizes[stackNum] == stackCapacity) {
            return true;
        }
        else {
            return false;
        }
    }

    // isEmpty Method
    public boolean isEmpty(int stackNum) {
        if(sizes[stackNum] == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // indexOfTop
    private int indexOfTop (int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size -1;
    }

    // Push
    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            System.out.println("The stack is full !! ");
        }
        else {
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }
    }

    // Pop method
    public int pop(int stackNum) {
        if(isEmpty(stackNum)) {
            System.out.println("The stack is empty !! ");
            return -1;
        }
        else {
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return value;
        }
    }

    // Peek method
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("The stack is empty");
            return -1;
        }
        else {
            return values[indexOfTop(stackNum)];
        }
    }
}
