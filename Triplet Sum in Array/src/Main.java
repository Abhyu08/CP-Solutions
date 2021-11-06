
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1; //Inputting the testcases
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int X = Integer.parseInt(inputLine[1]);
            int A[] = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.find3Numbers(A, n, X);
            System.out.println(ans ? 1 : 0);
        }
    }
}// } Driver Code Ends


class Solution {
    public static boolean find3Numbers(int arr[], int n, int X) {
        if (n >= 3) {
            int sum = 0, var = 0;
            int[] temp = new int[1000000];
            Arrays.sort(arr);
            for (int var1 : arr)
                ++temp[var1];

            for (int i = 0; i < n; i++) {
                sum = Math.max(arr[i], 0);
                temp[sum]--;
                for (int j = i + 1; j < n; j++) {
                    --temp[arr[j]];
                    var = Math.max(X - arr[j] - sum, 0);
                    if (temp[var] >= 1)
                        return true;
                    ++temp[arr[j]];
                }
            }
        }
        return false;
    }
}
/*
6 13
1 4 45 6 10 8
5 10
1 2 4 3 6
6 24
12 3 4 1 6 9
50 182
589 343 609 61 222 759 955 889 147 691 950 844 431 621 749 68 537 784 36 227 186 39 854 630 225 749 924 360 258 767 945 956 319 727 412 26 356 2 550 497 585 516 965 343 76 914 143 197 949 73

 */