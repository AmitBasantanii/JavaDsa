public class Main {
    public static void main(String[] args) {
        System.out.println("Stack using linked list implementation");

        StackLinkedList newStack = new StackLinkedList();
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);

        boolean result = newStack.isEmpty();
        System.out.println(result);

        int result1 = newStack.pop();
        System.out.println(result1);

        int result2 = newStack.peek();
        System.out.println(result2);

        newStack.deleteStack();
    }
}