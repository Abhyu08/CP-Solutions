// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution {
    long sumOfDistinct(long arr[], int N) {
        //1.using sort //Time Taken 1.22ms
        /*
        Arrays.sort(arr);
        long sum = arr[0];
        for (int i = 1; i < N; i++)
            if (arr[i - 1] == arr[i]) continue;
            else sum += arr[i];
        return sum;
        */
        //2.using Hashmap//Time Taken 1.09ms
        /*
        int sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(arr[i])) continue;
            map.put(arr[i], 0);
            sum += arr[i];
        }
        return sum;
        */
        //3.using set //Time Taken : 1.03ms

//        int sum = 0;
//        Set<Long> set = new HashSet<>();
//        for (int i = 0; i < N; i++) {
//            if (set.contains(arr[i])) continue;
//            set.add(arr[i]);
//            sum += arr[i];
//        }
//        return sum;

        // Returns sum of distinct elements in arr[]
        // assuming that elements in a[] are in
        // range from 1 to n.
        int sum = 0;
        for (int i = 0; i < N; i++) { //Time Taken : 0.77ms

            // If element appears first time
            if (arr[(int) Math.abs(arr[i]) - 1] >= 0) {
                sum += Math.abs(arr[i]);
                arr[(int) Math.abs(arr[i]) - 1] *= -1;
            }
        }

        return sum;

    }

}


// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
//            String line = br.readLine();
//            String[] q = line.trim().split("\\s+");
//            int n =Integer.parseInt(q[0]);
//            int k =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            //        int k = Integer.parseInt(br.readLine());
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[n];
//            for (int i = 0; i < n; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
            //int k = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            long ans = ob.sumOfDistinct(a, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends