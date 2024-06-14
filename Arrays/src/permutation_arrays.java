public class permutation_arrays {
    public static void main(String[] args) {
        permutation_arrays main = new permutation_arrays();
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {5,4,3,2,9};
        boolean result = main.permutation(array1, array2);
        System.out.println(result);
    }

    // permutation method
    public boolean permutation(int[] array1, int[] array2) {
        if(array1.length != array2.length) {
            return false;
        }
        int sum1 = 0;
        int sum2 = 0;
        int multiplication1 = 1;
        int multiplication2 = 1;

        for(int i=0; i<array1.length; i++) {
            sum1 = sum1 + array1[i];
            sum2 = sum2 + array2[i];
            multiplication1 = multiplication1 * array1[i];
            multiplication2 = multiplication2 * array2[i];
        }

        if(sum1 == sum2 && multiplication1 == multiplication2) {
            return true;
        }
        return false;
    }
}
