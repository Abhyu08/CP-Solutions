import java.util.Scanner;

class Solution {

    public static long[][] dp = new long[12][12];

    static void memset_dp() {
        for (long i = 0; i < 12; i++)
            for (long j = 0; j < 12; j++) {
                dp[(int) i][(int) j] = -1;
            }
    }

    static long Digit_Count(long no_length, long[] vector, long pos, long prev) {
        long res = 0;
        if (dp[(int) pos][(int) prev] != -1)
            return dp[(int) pos][(int) prev];
        if (pos == no_length) {
            return 1;
        }
        for (int i = 0; i < vector.length; i++) {
            if (prev == 0 || Math.abs(prev - vector[i]) <= 2)
                res += Digit_Count(no_length, vector, pos + 1, (int) vector[i]);
        }
        return dp[(int) pos][(int) prev] = res;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int testcases = sc.nextInt();
        for (int i = 1; i <= testcases; i++) {
            long n = sc.nextLong();
            long no_length = sc.nextLong();
            long[] vector = new long[(int)n];
            for (long k = 0; k < n; k++)
                vector[(int)k] = sc.nextInt();
            memset_dp();
            long ans = Digit_Count(no_length, vector, 0, 0);
            str.append("Case " + i + ": " + ans + "\n");
        }
        System.out.println(str);
    }
}
