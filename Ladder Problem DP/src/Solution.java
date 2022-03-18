import java.util.Scanner;

public class Solution {

    //recursive solution
    //To calculate ways to climb n steps with k jumps..

    //Top-Down approach
    public int countways2(int stairs, int jumps, int[] dp) {

        if (stairs < 0)
            return 0;
        else if (stairs == 0) {
            return 1;
        } else if (dp[stairs] != 0)
            return dp[stairs];

        for (int i = 1; i <= jumps; i++)
            dp[stairs] += countways(stairs - i, jumps, dp);

        return dp[stairs];
    }

    //Bottom-up Approach
    public int countways(int stairs, int jumps, int[] dp) {
        dp[0] = 1;


        for (int i = 1; i <= stairs; i++) {
            for (int j = 1; j <= jumps; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[stairs];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stairs = sc.nextInt();
        int steps = sc.nextInt();
        int[] dp = new int[1000];
        Solution sl = new Solution();
        System.out.println(sl.countways(stairs, steps, dp));
    }
}
