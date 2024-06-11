import java.util.function.Function;

public class no_of_spaces {
    public static void main(String... args) {
        String string = "Amit is working as project trainee";
        Function<String, Integer> function = s1 -> s1.length() - s1.replaceAll(" ", "").length();
        System.out.println(function.apply(string));
    }
}
