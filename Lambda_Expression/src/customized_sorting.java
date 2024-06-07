import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class customized_sorting {

    public static void main(String... args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(10);
        arrayList.add(0);
        arrayList.add(15);
        arrayList.add(5);
        arrayList.add(20);
        System.out.println("Before sorting" + arrayList);

        Collections.sort(arrayList,(l1, l2)->(l1<l2)?1:(l1>l2)?-1:0);
        System.out.println("After sorting : " + arrayList);
    }
}
