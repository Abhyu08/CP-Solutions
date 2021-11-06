
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = 1;

        while (t-- > 0) {
            long n = sc.nextLong();
            ArrayList<Long> arr = new ArrayList<Long>();
            for (int i = 0; i < n; i++) {
                long x = sc.nextInt();
                arr.add(x);
            }
            long m = sc.nextLong();

            Solution ob = new Solution();

            System.out.println(ob.findMinDiff(arr, n, m));
        }

    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public long findMinDiff(ArrayList<Long> list, long n, long mm) {
        // your code here
        int m = (int) mm;
        long min = Long.MAX_VALUE;
        Collections.sort(list);
        int l = list.size();
        int k = 0;
        int i = m - 1;
        while (i < l) {
            min = Math.min(min, list.get(i++) - list.get(k++));
        }
        return min;
    }
}
/*
8
3 4 1 9 56 7 9 12
5
7
7 3 2 4 9 12 56
3
17
12 4 7 9 2 23 25 41 30 40 28 42 30 44 48 43 50
7
 */