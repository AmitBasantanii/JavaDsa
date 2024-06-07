import java.util.function.Predicate;

public class display_name_starts_with_a {
    public static void main(String[] args) {
        String[] names = {"Amit", "Alice", "Ajay", "Aakansha", "Kajal", "Sunny", "Kareena"};
        Predicate<String> startsWithA = s ->s.charAt(0)== 'A';
        System.out.println("The names starts with A are : ");
        for(String s: names) {
            if(startsWithA.test(s)) {
                System.out.println(s);
            }
        }

    }
}
