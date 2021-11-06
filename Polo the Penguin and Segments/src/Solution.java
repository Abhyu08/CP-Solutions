import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int n = testcase;
        int k = sc.nextInt();
        int sum = 0;
        while (testcase-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            sum += r - l + 1;
        }
        int d = k;
        while (sum > d) {
            d += k;
        }
        System.out.println(d - sum);
    }
}
