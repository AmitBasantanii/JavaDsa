import java.util.ArrayList;
import java.util.function.Predicate;

public class remove_null_values {
    public static void main(String... args) {
        String[] names = {"Amit", " ", null, "Ravi", null, "Sonu", "", null };
        Predicate<String> predicate = s -> s!= null && s.length()!=0;
        ArrayList<String> arrayList = new ArrayList<String>();
        for(String s : names) {
            if(predicate.test(s)) {
                arrayList.add(s);
            }
        }
        System.out.println("The list for valid names : "+ arrayList);
    }
}
