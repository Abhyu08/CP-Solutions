import java.io.BufferedReader;
import java.io.InputStreamReader;
/* https://www.hackerearth.com/problem/algorithm/benny-and-the-broken-odometer/ */

public class Solution {
    public static int[][][] dp = new int[11][2][2];

    static void memset_dp() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;
    }

    static int Benny(String str, int pos, int tight, int flag) {
        if (pos == str.length()) {
            if (flag == 1)
                return 1;
            else return 0;
        } else if (dp[pos][tight][flag] != -1)
            return dp[pos][tight][flag];
        else if (tight == 1) {
            int res = 0;
            for (int i = 0; i <= str.charAt(pos) - '0'; i++) {
                int flg = flag;
                if (i == 3)
                    flg = 1;
                if (i == str.charAt(pos) - '0')
                    res += Benny(str, pos + 1, 1, flg);
                else res += Benny(str, pos + 1, 0, flg);
            }
            return dp[pos][tight][flag] = res;
        } else {
            int res = 0;
            for (int i = 0; i <= 9; i++) {
                int flg = flag;
                if (i == 3)
                    flg = 1;
                res += Benny(str, pos + 1, 0, flg);
            }
            return dp[pos][tight][flag] = res;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testcases = Integer.parseInt(br.readLine());
            while (testcases-- > 0) {
                String str = br.readLine();
                memset_dp();  //initialize to -1
                int ans = Benny(str, 0, 1, 0);
                System.out.println(Integer.parseInt(str) - ans);
            }
        } catch (Exception e) {
            System.out.println("Exception occurs at line : " + e.getStackTrace()[0].getLineNumber());
        }

    }
}
