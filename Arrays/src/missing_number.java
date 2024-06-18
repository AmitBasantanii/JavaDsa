public class missing_number {
    public static void main(String[] args) {
        missing_number main = new missing_number();
        int intArray[] = {1,2,3,4,5,6,7,9,10};

        main.missingNumber(intArray);
    }

    // missingNumber method
    public void missingNumber( int[] intArray) {
        int sum1= 0;
        int sum2 = 0;

        for (int i: intArray) {
            sum1 = sum1 + i;
        }
        sum2 = 10 * (10+1)/2;

        int difference = sum2 - sum1;
        System.out.println("Missing number is : " + difference);
    }
}
