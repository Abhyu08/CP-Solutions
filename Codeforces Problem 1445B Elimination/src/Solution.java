import java.util.Scanner;
import java.util.regex.Matcher;

public class Solution {
    static int Calculate(int a, int b) {
        if (a > b)
            return a - b;
        else if (b > a)
            return b - a;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(Math.max(a+b,c+d));
        }
    }
}
