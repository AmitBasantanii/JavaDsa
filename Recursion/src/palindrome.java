public class palindrome {
    public static void main(String[] args) {
        palindrome isPalindrome = new palindrome();
        var result = isPalindrome.is_Palindrome("amma");
        System.out.println(result);
    }

    public boolean is_Palindrome(String str) {
        if(str.length() == 0 || str.length() == 1) {
            return true;
        }
        if(str.charAt(0) == str.charAt(str.length()-1)) {
            return is_Palindrome(str.substring(1, str.length()-1));
        }
        return false;
    }
}
