import java.util.Arrays;
import java.util.Collections;

public class first_and_second_best_scores {
    public static String firstSecond (Integer[] myArray) {
        Integer[] arr = myArray;
        Arrays.sort(arr, Collections.reverseOrder());
        int first = arr[0];
        Integer second = null;

        for(int i=0; i<arr.length; i++) {
            if(!arr[i].equals(first)) {
                second = arr[i];
                break;
            }
        }
        return first + " " + (second != null ? second : "None");
    }

    public static void main(String[] args) {
        first_and_second_best_scores main = new first_and_second_best_scores();
        Integer[] myArray = {90, 12, 1, 55, 77, 99};
        String result = main.firstSecond(myArray);
        System.out.println(result);
    }
}
