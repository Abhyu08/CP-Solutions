import java.util.Scanner;

class Solution {

    //IMP: Formula 
    public int uniquePaths_u(int n, int m) {
        double res = 1;
        int N = n + m - 2;
        int r = m-1;
        for (int i = 1; i <= r;i++){
            res = res * ( N - r + i) / i;
        }
        return (int)res;

    }

    //1.With Memoization
    public long unique_paths_m(int m, int n, long[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (m == 1 && n == 1) {
            return 1;
        } else if (dp[m][n] != 0) {
            return dp[m][n];
        } else {
            dp[m][n] = unique_paths_m(m - 1, n, dp) + unique_paths_m(m, n - 1, dp);
            return dp[m][n];
        }
    }

    //2.Without Memoization
    public long unique_paths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (m == 1 && n == 1) {
            return 1;
        } else {
            return unique_paths(m - 1, n) + unique_paths(m, n - 1);
        }
    }

    public long uniquePaths(int m, int n) {
        long[][] dp = new long[m+1][n+1];
            return unique_paths_m(m, n, dp); //1.With Memoization
        //  return unique_paths(m, n); // 2.Without Memoization
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Solution sl = new Solution();
        long result = sl.uniquePaths(m, n);
        System.out.println(result);

    }
}