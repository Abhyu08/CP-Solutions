import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1; //Inputting the testcases
        while (t-- > 0) {

            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            //calling trappingWater() function
            System.out.println(obj.trappingWater(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {

    static long trappingWater(int arr[], int n) {
        long min = arr[0], min_count = 0;
        long max = arr[0], max_count = 0;
        long water_tapped = 0;
        int[] values = new int[n + 1];
        for (int i = n - 1; i >= 0; i--)
            values[i] = Math.max(arr[i], values[i + 1]);

        for (int i = 0; i < n; i++) {
            if (max < arr[i] || i == n - 1) {
                water_tapped += max_count;
                max_count = 0;
                max = arr[i];
            } else {
                if (values[i] < max)
                    max = values[i];
                max_count += max - arr[i];
            }
        }
        return water_tapped;
    }
}
/*

7
8 8 2 4 5 5 1    ->4
4
7 4 0 9
6
3 0 0 2 0 4
3
6 9 9
3
2 0 2
5
3 0 2 0 4
12
0 1 0 2 1 0 1 3 2 1 2 1  -->6

 */