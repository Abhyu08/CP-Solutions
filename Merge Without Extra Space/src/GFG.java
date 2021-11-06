// { Driver Code Starts

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}// } Driver Code Ends


class Solution {

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int[] arr_m = new int[n + m ];

        for (int i = 0, j = 0, k = 0; (i + j) <= (n + m - 1); ) {
            if (i < n)
                arr_m[k++] = arr1[i++];
            if (j < m)
                arr_m[k++] = arr2[j++];
        }
        Arrays.sort(arr_m);
        for(int i=0,k=0;i<n;i++){
            arr1[k++] = arr_m[i];
        }
        for(int i=n,k=0;i<m+n;i++){
            arr2[k++] = arr_m[i];
        }
    }
}
/*
4 5
1 3 5 7
0 2 6 8 9
-------------
2 3
10 12
5 18 20

 */
