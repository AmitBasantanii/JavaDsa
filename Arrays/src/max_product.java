public class max_product {
    public static void main(String[] args) {
        max_product main = new max_product();
        int[] intArray = {10,60,30,20,40,50};
        String pairs = main.maxProduct(intArray);
        System.out.println(pairs);
    }

    // Max Product Method
    public String maxProduct(int[] intArray) {
        int maxProduct = 0;
        String pairs = " ";
        for(int i=0; i<intArray.length; i++) {
            for(int j=i+1; j<intArray.length; j++) {

                if(intArray[i] * intArray[j] > maxProduct) {
                    maxProduct = intArray[i] * intArray[j];
                    pairs = Integer.toString(intArray[i]) + "," + Integer.toString(intArray[j]);
                }
            }
        }
        return pairs;
    }
}
