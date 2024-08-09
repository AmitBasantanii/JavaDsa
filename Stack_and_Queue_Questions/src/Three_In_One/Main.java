package Three_In_One;

public class Main {
    public static void main(String... args) {
        ThreeInOne newStacks = new ThreeInOne(3);

        boolean result = newStacks.isFull(2);
        System.out.println(result);

        boolean result1 = newStacks.isEmpty(0);
        System.out.println(result1);

        newStacks.push(0,1);
        newStacks.push(0,2);
        newStacks.push(1, 4);
        newStacks.push(1, 5);
        newStacks.push(2, 8);

        int result2 = newStacks.pop(0);
        System.out.println(result2);

        int result3 = newStacks.peek(0);
        System.out.println(result3);

        int result4 = newStacks.pop(1);
        System.out.println(result4);

        int result5 = newStacks.peek(1);
        System.out.println(result5);

        int result6 = newStacks.pop(2);
        System.out.println(result6);

        int result7 = newStacks.peek(2);
        System.out.println(result7);
    }
}
