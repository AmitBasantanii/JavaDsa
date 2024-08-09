package Question_1;

//Problem definition
//        An arithmetic expression (char array) is the input to your function.
//        Find out if the set of opening i.e. "(","[","{" and closing i.e  ")","]","}" brackets are matching or not.
//        You must follow the hierarchy of brackets as per BODMAS rule i.e. "[" bracket cannot come inside "(", or "{" bracket.
//        e.g. "4 + ( 5 - 6 * [6+5] - 10 )" is NOT a valid expression.
//        If all the bracket pairs match as per the rule, then return 0 from the function otherwise -1.
//        Instructions
//        You can use any Java Collection in your solution
//        The solution will be evaluated on the time complexity, readability and simplicity of the logic.
//// Function Name    : validateMatchingBrackets
//// Parameter                             : char array (Not a String)
////Return values                        : -1 => when input expression has INVALID matching brackets
////                                                    :  0   => when expression has VALID matching brackets

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    // // APPROACH 1 :
//    public static int validateMatchingBrackets(char[] chars) {
//        Stack<Character> stack = new Stack<>();
//        Map<Character, Character> map = new HashMap<>();
//        map.put(')', '(');
//        map.put('}', '{');
//        map.put(']', '[');
//
//        for (char c : chars) {
//            if (map.containsValue(c)) {
//                stack.push(c);
//            } else if (map.containsKey(c)) {
//                if (stack.isEmpty() || map.get(c) != stack.pop()) {
//                    return -1;
//                }
//            }
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your expression : ");
//        char[] expression= sc.nextLine().toCharArray();
//        validateMatchingBrackets(expression);
//    }

//    // APPROACH 2 :
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char cur = s.charAt(i);
//            if (!stack.isEmpty()) {
//                char last = stack.peek();
//                if (isPair(last, cur)) {
//                    stack.pop();
//                    continue;
//                }
//            }
//            stack.push(cur);
//        }
//
//        return stack.isEmpty();
//    }
//
//    private boolean isPair(char last, char cur) {
//        return (last == '(' && cur == ')') ||
//                (last == '{' && cur == '}') ||
//                (last == '[' && cur == ']');
//    }
//
//    public static void main(String... args) {
//        char[] expression1 = "4 + (5 - 6* [6+5] - 10 )".toCharArray();
//        System.out.println();
//    }

//    // APPROACH 3 :
//    public static boolean matchingPair(char open, char close) {
//        return (open == '(' && close == ')') || ( open == '{' && close == '}') || (open == '[' && close == ']');
//    }
//
//    public static boolean BODMAS(char open, char close) {
//        return (open == '(' && close != '[') || ( open == '{' && close != '(' && close != '[') || ( open == '[' && close == ']');
//    }
//
//    public static int validateMatchingBrackets(char[] expression) {
//        Stack<Character> stack = new Stack<>();
//
//        for(char c: expression) {
//            switch (c) {
//                case '(':
//                case '{':
//                case '[':
//                    if(!stack.isEmpty() && !BODMAS(stack.peek(), c)) {
//                        return -1;
//                    }
//                    stack.push(c);
//                    break;
//
//                case ')':
//                case ']':
//                case '}':
//                    if (stack.isEmpty() || !matchingPair(stack.pop(), c)) {
//                        return -1;
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }
//        return stack.isEmpty() ? 0 : -1;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        char[] expression1 = "4 + (5 - 6* [6+5] - 10 )".toCharArray();
//        char[] expression2 = "4 + (5 - 6* {6+5} - 10 )".toCharArray();
//        char[] expression3 = "4 + {5 - (6* [6+5]) - 10 }".toCharArray();
//
//        System.out.println(validateMatchingBrackets(expression1));
//        System.out.println(validateMatchingBrackets(expression2));
//        System.out.println(validateMatchingBrackets(expression3));
//    }

    // APPROACH 4:
    public static int validateMatchingBrackets(char[] expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return -1;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return -1;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return -1;
                    }
                    break;
                default:
                    break;
            }
        }

        if (!stack.isEmpty()) {
            return -1;
        }

        String expr = new String(expression);
        if (expr.contains("[") && (expr.contains("(") || expr.contains("{"))) {
            int Square = expr.indexOf('[');
            int Round = expr.indexOf('(');
            int Curly = expr.indexOf('{');

            // BODMAS
            if ((Round != -1 && Round < Square) ||
                    (Curly != -1 && Curly < Square)) {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the arithmetic expression:");
        String input = sc.nextLine();

        char[] expression = input.toCharArray();

        int result = validateMatchingBrackets(expression);
        if (result == 0) {
            System.out.println("Valid matching brackets.");
        } else {
            System.out.println("Invalid matching brackets.");
        }
    }
}
