import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
1. Can be solved using digit_dp technique  ~ Time exceeded
2. Can be solved using fibonacci iterative
3. Can be solved using fibonacci recursive ~ Time exceeded
4. Can be solved using fibonacci recursive with Memoization
 */

class Solution {
    int[] dp = new int[46];
    int count = 0;

    //1. digit_dp technique
    public void calc_stairs(int sum, int length, int n) {
        if (sum == n) {
            count++;
        } else if (sum < n) {
            calc_stairs(sum + 1, length + 1, n);
            calc_stairs(sum + 2, length + 1, n);
        }
    }

    //2. Iterative  O(n)
    public int fibonacci_series(int n) {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //3.fibonacci recursive
    public int fibonacci_series_r(int n) throws InterruptedException {
        if (n <= 1)
            return 1;
        else {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("1 sec ...");
            return fibonacci_series_r(n - 1) + fibonacci_series_r(n - 2);
        }

    }

    //4.fibonacci recursive with Memoization
    public int fibonacci_series_rm(int n) throws InterruptedException {
        if (n <= 1)
            return 1;
        else if (dp[n] != 0)
            return dp[n];
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1 sec ...");
        dp[n] = fibonacci_series_rm(n - 1) + fibonacci_series_rm(n - 2);
        return dp[n];
    }

    public int climbStairs(int n) {
        //calc_stairs(0, 0, n);
        count = fibonacci_series(n);
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Solution sl = new Solution();
        int n = sc.nextInt();
        int result = sl.fibonacci_series(n); //iterative
        //int result = sl.fibonacci_series_r(n); //without Memoization
        //int result = sl.fibonacci_series_rm(n); //with Memoization
        System.out.println(result);
    }
}