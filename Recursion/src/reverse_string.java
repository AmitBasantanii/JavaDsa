public class reverse_string {
    public static void main(String[] args) {
        reverse_string reverse = new reverse_string();
        var result = reverse.reverseString("amit");
        System.out.println(result);
    }
    public String reverseString(String str) {
        if(str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
