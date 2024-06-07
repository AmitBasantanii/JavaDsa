import java.util.function.Function;

public class length_of_string {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("Amit"));
        System.out.println(f.apply("Basantani"));
    }
}
