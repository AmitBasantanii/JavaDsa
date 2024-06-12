package TwoDimensionalArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray(3, 3);
        twoDimensionalArray.insertValueInTheArray(0,0,10);

        System.out.println(Arrays.deepToString(twoDimensionalArray.arr));

        twoDimensionalArray.insertValueInTheArray(0,1,20);
        twoDimensionalArray.accessCell(0,1);

        twoDimensionalArray.insertValueInTheArray(1,0,30);
        twoDimensionalArray.insertValueInTheArray(2,0,40);

        twoDimensionalArray.traverse2DArray();

        twoDimensionalArray.searchingValues(20);

        System.out.println(Arrays.deepToString(twoDimensionalArray.arr));

        twoDimensionalArray.deleteValueFromArray(0,0);
//        System.out.println(Arrays.deepToString());
    }
}
