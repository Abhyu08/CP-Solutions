
import java.util.Scanner;

public class Solution {
    public static int Fact_zero_trail(int n) {
        int zeros = 0;
        for (int i = 5; n / i > 0; ) {
            zeros += n / i;
            n = n / i;
        }
        return zeros;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            int zeroes = Fact_zero_trail(n);
            System.out.println(zeroes);
        }
    }
}
