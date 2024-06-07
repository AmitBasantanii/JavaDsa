// Predicate is a function with a single argument and returns boolean value

import java.util.function.Predicate;
public class Main {
    public static void main(String[] args) {
        Predicate<String> p = s -> (s.length()>3);
        System.out.println(p.test("rvkb"));
        System.out.println(p.test("ab"));
        System.out.println("Hello world!");
    }
}