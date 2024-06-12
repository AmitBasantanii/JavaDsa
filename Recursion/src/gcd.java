public class gcd {
    public static void main(String[] args) {
        gcd greatest_common_divisor = new gcd();
        var result = greatest_common_divisor.gcd(8,12);
        System.out.println(result);
    }
    public int gcd(int a, int b) {
        if(a<0 || b<0) {
            return -1;
        }
        if (b==0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
