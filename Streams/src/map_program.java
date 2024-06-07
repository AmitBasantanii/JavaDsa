import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class map_program {
    public static void main(String[] args) {
        // map() and collect() method
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("amit");
        stringArrayList.add("is");
        stringArrayList.add("working");
        stringArrayList.add("as");
        stringArrayList.add("project");
        stringArrayList.add("trainee");
        System.out.println(stringArrayList);
        List<String> stringList = stringArrayList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(stringList);

        List<String> stringList1 = stringArrayList.stream().sorted().collect(Collectors.toList());
        System.out.println("According to default natural sorting : " + stringList1);

        List<String> stringList2 = stringArrayList.stream().sorted((s1, s2) -> -s1.compareTo(s2)).collect(Collectors.toList());
        System.out.println("According to customized sorting order : " + stringList2);

        String min = stringArrayList.stream().min((s1,s2) -> s1.compareTo(s2)).get();
        System.out.println(min);

        String max = stringArrayList.stream().max((s1,s2) -> s1.compareTo(s2)).get();
        System.out.println(max);
    }
}

//  Comparator - compare(obj1, obj2)
// 1. returns negative iff obj1 has to come before obj2
// 2. returns positive iff obj1 has to come after obj2
// 3. returns 0 iff obj1 and obj2 are equal