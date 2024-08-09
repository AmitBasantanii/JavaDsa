package Question_2;

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
////

import java.util.Scanner;
import java.util.Stack;

public class Main {

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

// The Time Complexity of above code is O(N)