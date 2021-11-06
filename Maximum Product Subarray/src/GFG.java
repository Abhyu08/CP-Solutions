import java.io.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        int k = 0;
        long[] stk = new long[n + 1];
        long max = Integer.MIN_VALUE;
        long curr = 1;
        stk[k++] = arr[0];
        for (int i = 0; i < n; i++) {
            if(curr==0)
                curr=1;
            curr *= arr[i];
            stk[k++] = curr;
        }
        for (long var : stk) {
            long temp = var;
            if (max <= temp)
                max = temp;
        }
        stk[n]=0;
        k=0;
        curr=1;
        for (int i = n-1; i >=0; i--) {
            if(curr==0)
                curr=1;
            curr *= arr[i];
            stk[k++] = curr;
        }
        for (long var : stk) {
            long temp = var;
            if (max <= temp)
                max = temp;
        }
        if (n == 1)
            return arr[0];
        else
            return max;
    }
}
/*
10
8 -2 -2 0 8 0 -6 -8 -6 -1
5
-8 5 3 1 6
*/