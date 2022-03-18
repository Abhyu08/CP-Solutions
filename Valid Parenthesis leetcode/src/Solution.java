import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(Solution.isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int len = s.length();
        boolean result = true;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stk.push(s.charAt(i));
            } else if (s.charAt(i) == ']' && stk.empty() != true) {
                if (stk.pop() != '[') {
                    result = false;
                    break;
                }
                //stk.pop();
            } else if (s.charAt(i) == '}' && stk.empty() != true) {
                if (stk.pop() != '{') {
                    result = false;
                    break;
                }
                // stk.pop();
            } else if (s.charAt(i) == ')' && stk.empty() != true) {
                if (stk.pop() != '(') {
                    result = false;
                    break;
                }
                // stk.pop();
            } else {
                result = false;
                break;
            }
        }
        if (stk.empty() != true)
            result = false;

        return result;
    }
}
/*

([)] --false

()          true
()[]{}      true
(]          false


 if (s.charAt(i) == '{') {
                stk1.push('{');
            } else if (s.charAt(i) == '[') {
                stk2.push('[');
            } else if (s.charAt(i) == '(') {
                stk3.push('(');
            } else if (s.charAt(i) == '}') {
                if (stk1.empty() == true) {
                    result = false;
                    break;
                }
                stk1.pop();
            } else if (s.charAt(i) == ']') {
                if (stk2.empty() == true) {
                    result = false;
                    break;
                }
                stk2.pop();
            } else {
                if (stk3.empty() == true) {
                    result = false;
                    break;
                }
                stk3.pop();
            }
 */