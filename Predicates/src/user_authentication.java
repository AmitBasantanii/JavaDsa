import java.util.Scanner;
import java.util.function.Predicate;

class User {
    String username;
    String password;
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
public class user_authentication {
    public static void main(String... args) {
        Predicate<User> predicate = u -> u.username.equals("Amit")&& u.password.equals("Amit");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User name");
        String username = sc.next();
        System.out.println("Enter passowrd : ");
        String password = sc.next();
        User user = new User(username, password);
        if(predicate.test(user)) {
            System.out.println("Valid user !!");
        }
        else {
            System.out.println("Invalid user");
        }
    }
}
