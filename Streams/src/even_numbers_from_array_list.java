import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class even_numbers_from_array_list {

    // without using streams
//    public static void main(String... args) {
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        for (int i=0; i<=10; i++) {
//            arrayList.add(i);
//        }
//        System.out.println(arrayList);
//
//        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
//        for(Integer i:arrayList) {
//            if (i % 2 == 0) {
//                arrayList1.add(i);
//            }
//        }
//        System.out.println(arrayList1);
//    }

    public static void main(String... args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i=0; i<=10; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        List<Integer> list = arrayList.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.println(list);
    }
}
