public class factorial {
    public static void main(String[] args) {
        factorial recursion = new factorial();
        var rec = recursion.factorial(4);
        System.out.println("The factorial of the given number is: "+ rec);
    }
    public int factorial(int n) {
        if(n<1) {
            return -1;
        }
        if (n==0 || n==1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
