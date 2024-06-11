import java.util.function.Function;

public class remove_space_from_string {
    public static void main(String... args) {
        String string = "Amit is working as project trainee";
        Function<String, String> function = s1 -> s1.replaceAll(" ", "");
        System.out.println(function.apply(string));
    }
}
