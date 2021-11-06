
import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while (t-- > 0) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int arr[], int n, int x) {
        // Your code goes here
        int min = Integer.MAX_VALUE;
        int[] sum = new int[n];
        for (int i = 0, prev = 0; i < n; i++) {
            sum[i] = arr[i] + prev;
            prev = sum[i];
            if (arr[i] > x)
                return 1;
        }
        int left = 0, right = 0;
        while (right < n) {
            int s = sum[right];
            if (s > x) {
                min = Math.min(min, right - left  + 1);
                while (left < right) {
                    s -= arr[left];
                    if (s <= x)
                        break;
                    min = Math.min(min, right - left);
                    left++;
                }
            }
            right++;
        }
        return min;
    }
}
/*

6 51
1 4 45 6 0 19
5 9
1 10 5 2 7
10 280
1 11 100 1 0 200 3 2 1 250
8 10
1 3 4 7 10 10 8 10
8 16
6 3 4 5 4 3 7 9

 */