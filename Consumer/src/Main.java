import java.util.function.Consumer;

// Consumer can be used to consume object and perform certain operation.
// Contains one abstract method that is "accept"
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Hello");
        consumer.accept("Amit");
    }
}