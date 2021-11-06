// { Driver Code Starts

import java.lang.*;
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String) br.readLine()).split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println("\nJumps ->  " + new Solution().minJumps(arr));
        }
    }

}
// } Driver Code Ends


// 1) O(N) Solution
class Solution {
    static int minJumps(int[] arr) {
        int step = arr[0];
        System.out.print(arr[0] + " ");
        int max_reached = 0;
        int jumps = 1;
        int index = 0;
        int next_index = 1;
        int l = arr.length;
        if (l == 1)
            return 0;
        else if (arr[0] == 0)
            return -1;
        else if (arr[0] >= l - 1) {
            return 1;
        } else {
            for (int i = 1; i < l; i++) {
                step--;
                if (i+ arr[i] >= max_reached) {
                    max_reached = i+ arr[i];
                    next_index = i;
                }
                if (step == 0 && max_reached == index) {
                    return -2;
                } else if (step == 0) {
                    jumps++;
                    if (max_reached >= l - 1) {
                        System.out.print(arr[next_index] + " ");
                        return jumps;
                    }
                    step = arr[next_index];
                    index = next_index;
                    i = index;
                    max_reached = index;
                    System.out.print(arr[next_index] + " ");
                }

            }

        }
        return -1;
    }
}


/*
N = 11
arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3
----------------------
15
9 10 1 2 3 4 8 0 0 0 0 0 0 0
----------------------
4
2 1 0 3
----------------------
11
1 3 5 8 9 2 6 7 6 8 9
----------------------
10
2 3 1 1 2 4 2 0 1 1
----------------------
6
1 4 3 2 6 7
 */

// 2) O(N^2) Solution

/*
class Solution {
    static int minJumps(int[] arr) {
        // your code here
        int index = 0;
        int count = 1;
        int len = arr.length;
        int[] dp = init(len);
        for (int i = 0; i < len; i++) {
            count = dp[i];
            for (int j = arr[i], c = count + 1; j > 0; j--) {
                index = i + j;
                if (index >= len) {
                    dp[len - 1] = Math.min(dp[len - 1], c);
                } else {
                    dp[index] = Math.min(dp[index], c);
                }

            }
        }
        if (Math.abs(dp[len - 1]) == Integer.MAX_VALUE || dp[len - 1] < 0) {
            dp[len - 1] = -1;
        }
        return (arr[0] > 0 ? dp[len - 1] : -1);
    }

    static int[] init(int length) {
        int[] dp = new int[length];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        return dp;
    }
}
*/