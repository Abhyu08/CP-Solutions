/* Digit Dp Problem - https://www.spoj.com/problems/GONE/   */

import java.util.Scanner;

public class Solution {

    static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109};
    public static int[][][] dp = new int[10][80][2];

    static void memset_dp() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 80; j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;
    }

    static boolean check(int sum) {
        for (int i : prime) {
            if (sum == i)
                return true;
        }
        return false;
    }

    static int Gone(String str, int pos, int sum, int tight, String no) {
        if (pos == str.length()) {
            System.out.println(no);
            if (check(sum))
                return 1;
            else return 0;
        } else if (dp[pos][sum][tight] != -1) {
            return dp[pos][sum][tight];
        } else if (tight == 1) {
            int res = 0;
            for (int i = 0; i <= str.charAt(pos) - '0'; i++) {
                if (i == str.charAt(pos) - '0')
                    res += Gone(str, pos + 1, sum + i, 1, no + i);
                else res += Gone(str, pos + 1, sum + i, 0, no + i);
            }
            dp[pos][sum][tight] = res;
            return res;
        } else {
            int res = 0;
            for (int i = 0; i <= 9; i++) {
                res += Gone(str, pos + 1, sum + i, 0, no + i);
            }
            dp[pos][sum][tight] = res;
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a = a - 1;
            String l = String.valueOf(a);
            String r = String.valueOf(b);
            memset_dp();
            int ans1 = Gone(r, 0, 0, 1, "");
            memset_dp();
            int ans2 = Gone(l, 0, 0, 1, "");
            System.out.println(ans1 - ans2);
        }
    }
}
