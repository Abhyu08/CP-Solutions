import java.util.Scanner;

public class Solution {


    int result = Integer.MIN_VALUE;

    //1.recursive bottoms-up (not optimised)
    public int maxProfit(int[] prices, int sum, int n, int max_profit) {
        if (sum == n) {
            result = Math.max(max_profit, result);
            return result;
        } else if (sum > n) {
            return 0;
        } else {
            int curr_max_profit = 0;
            for (int i = 1; i <= n; i++) {
                if (sum + i > n)
                    continue;
                curr_max_profit = maxProfit(prices, sum + i, n, max_profit + prices[i - 1]);
            }
            return Math.max(result, curr_max_profit);
        }
    }

    //2.recursive top-down Approach ~ Memoization
    public int maxProfit2(int[] prices, int n, int[] dp) {
        if (n <= 0)
            return 0;
        else if (dp[n] != 0)
            return dp[n];
        else {
            int curr_maxProfit = 0, result = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                curr_maxProfit = prices[i - 1] + maxProfit2(prices, n - i, dp);
                dp[n] = Math.max(dp[n], curr_maxProfit);
            }
            return dp[n];
        }
    }

    //3.Bottoms-Up Approach ~ Iterative ~ Optimized
    public int maxProfit3(int[] prices, int n, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], prices[j] + dp[i - j - 1]);
                //System.out.println(i + "-->" + dp[i]);
            }
            //System.out.println();
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] prices = new int[N];
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++)
            prices[i] = sc.nextInt();
        Solution sl = new Solution();
        /*
        sl.maxProfit(prices, 0, N, 0);
        System.out.println(sl.maxProfit2(prices, N, dp));
        */
        System.out.println(sl.maxProfit3(prices, N, dp));
    }
}
/*
8
1 5 8 9 10 17 17 20

~22

8
3 5 8 9 10 17 17 20

~24

120
3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20 3 5 8 9 10 17 17 20

 */