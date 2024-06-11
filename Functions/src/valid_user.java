import java.util.Scanner;
import java.util.function.Function;

public class valid_user {
    public static void main(String[] args) {
        Function<String, String> function1 = s -> s.toLowerCase();
        Function<String, String> function2 = s -> s.substring(0,4);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username : ");
        String username = sc.next();

        System.out.println("Enter password : ");
        String password = sc.next();

        if (function1.andThen(function2).apply(username).equals("amit")&&password.equals("java")) {
            System.out.println("Valid User");
        } else {
            System.out.println("Invalid User");
        }
    }
}
