import java.util.function.BiPredicate;

public class bi_predicate {
    // sum of 2 numbers is even or not
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> biPredicate = (a,b) -> (a+b) % 2 ==0;
        System.out.println(biPredicate.test(10,20));
        System.out.println(biPredicate.test(15, 20));
    }
}
