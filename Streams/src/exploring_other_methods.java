import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class exploring_other_methods {

    public static void main(String... args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0);
        arrayList.add(15);
        arrayList.add(10);
        arrayList.add(5);
        arrayList.add(30);
        arrayList.add(25);
        arrayList.add(20);
        System.out.println(arrayList);

        ArrayList<Integer> arrayList1 = (ArrayList<Integer>) arrayList.stream().map(i -> i+10).collect(Collectors.toList());
        System.out.println(arrayList1);

        long count = arrayList.stream().filter(i -> i%2==0).count();
        System.out.println(count);

        List<Integer> integerList = arrayList.stream().sorted().collect(Collectors.toList());
        System.out.println(integerList);

        Comparator<Integer> comparator = (i1, i2) -> i1.compareTo(i2);
        List<Integer> integerList1 = arrayList.stream().sorted(comparator).collect(Collectors.toList());
        System.out.println(integerList1);

        Integer min = arrayList.stream().min(comparator).get();
        System.out.println(min);

        Integer max = arrayList.stream().max(comparator).get();
        System.out.println(max);

        integerList.stream().forEach(i -> System.out.print(i ));
        integerList.stream().forEach(System.out::println);

        Integer[] integers= arrayList.stream().toArray(Integer[] :: new);
        for(Integer i : integers) {
            System.out.println(i);
        }
    }
}
