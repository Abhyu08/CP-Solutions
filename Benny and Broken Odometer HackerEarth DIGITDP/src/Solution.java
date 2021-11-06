import java.util.Scanner;

public class Solution {
    public static int[][][] dp = new int[10][2][2];

    public static void memset() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;
    }

    public static int Odometer(int pos, int tight, int isThree, String no,String str) {

        if (pos == no.length()) {
            if (isThree == 1){
                System.out.println(str);
                return 1;
            }
            else return 0;
        } else if (dp[pos][tight][isThree] != -1)
            return dp[pos][tight][isThree];
        else if (tight == 1 || pos == 0) {
            int result = 0;

            for (int i = 0; i <= no.charAt(pos) - '0'; i++) {
                int flg = isThree;
                if (i == 3)
                    flg = 1;
                if (i != no.charAt(pos) - '0')
                    result += Odometer(pos + 1, 0, flg, no,str+i);
                else result += Odometer(pos + 1, 1, flg, no,str+i);
            }
            dp[pos][tight][isThree] = result;
            return result;
        } else {
            int result = 0;

            for (int i = 0; i <= 9; i++) {
                int flg = isThree;
                if (i == 3)
                    flg = 1;
                result += Odometer(pos + 1, 0, flg, no,str+i);
            }
            dp[pos][tight][isThree] = result;
            return result;
        }
    }

    //Driver Function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            String str = Integer.toString(n);
            memset();
            int fault = Odometer(0, 0, 0, str,"");
            System.out.println(n-fault);
        }
    }
}
