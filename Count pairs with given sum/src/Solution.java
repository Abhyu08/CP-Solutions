// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        while (tc-- > 0) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            int m = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = new Main().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Main {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        int[] temp = new int[10000000];
        int j = 0;
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] >= k) {
                temp[arr[i]] += 1;
                continue;
            } else {
                temp[arr[i]] += 1;
                elements[j++] = arr[i];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (elements[i] == 0)
                continue;

            int sum = k - elements[i];

            if (temp[elements[i]] > 0)
                temp[elements[i]]--;

            if (temp[sum] > 0) {
                count += temp[sum];
            }
        }

        return count;
    }
}

/*
42 43
9 7 53 41 4 97 75 30 54 61 9 8 14 50 95 38 12 38 44 2 78 71 97 67 10 4 68 43 47 56 35 7 62 39 47 17 36 21 46 41 34 7
*/