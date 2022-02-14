import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int testcase = sc.nextInt();
        while (testcase-- > 0) {
            int n = sc.nextInt();
            double result = 0.143 * n;
            result = Math.round(Math.pow(result, n));
            str.append((int)result + "\n");
        }
        System.out.println(str);
    }
}
