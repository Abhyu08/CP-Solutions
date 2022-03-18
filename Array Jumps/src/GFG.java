import java.io.*;
import java.util.*;

// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S1[] = read.readLine().split(" ");

            int[] A = new int[N];

            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A, N));
        }
    }
}// } Driver Code Ends


class Solution {
    public int canReach(int[] A, int N) {
        // code here
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int result = calc_min_steps(A, N, 0, 0, dp, new Stack<Integer>());
        return result == Integer.MAX_VALUE ? 0 : result;
        //return dp[N] == Integer.MAX_VALUE ? 0 : dp[N];
    }

    public int calc_min_steps(int[] arr, int n, int index, int steps, int[] dp, Stack<Integer> stk) {
        if (index > n - 1) {
            //System.out.println(steps);
           // System.out.println("Contains - > " + stk);
            return steps;
        } else if (dp[index] != Integer.MAX_VALUE) {
           // System.out.println("Dp return --> " + stk);
            return dp[index];
    } else {
            int result = Integer.MAX_VALUE;
            for (int i = arr[index]; i >= 1; i--) {
                if (arr[i - 1] == 0 && index + i < n - 1)
                    continue;
                stk.push(i);
                result = Math.min(result, calc_min_steps(arr, n, index + i, steps + 1, dp, stk));
                stk.pop();
            }
            dp[index] = Math.min(result, dp[index]);
            return dp[index];
        }
    }
}
/*
1
6
1 2 0 3 0 0

~3
1
3
1 0 2

~0
1
11
1 3 5 8 9 2 6 7 6 8 9

~3
1
10
1 1 1 1 1 1 1 1 1 1 1

~10
1
12
5 9 3 2 1 0 2 3 3 1 0 0

~3
2
5
2 3 1 1 4
5
2 3 0 1 4

~2
 */