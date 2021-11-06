import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        //code
        //code

        //taking input using class Scanner
        Scanner scan = new Scanner(System.in);

        //taking total number of testcases
        int t = 1;
        while (t > 0) {
            //taking total count of elements
            int n = scan.nextInt();

            //Declaring and Initializing an array of size n
            int arr[] = new int[n];

            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            t--;

            //calling the method findSum
            //and print "YES" or "NO" based on the result
            System.out.println(new Solution().findsum(arr, n) == true ? "Yes" : "No");
        }
    }


}// } Driver Code Ends


class Solution {


    static boolean findsum(int arr[], int n) {
        Set<Integer> list = new HashSet<>();
        int sum = 0;
        for (int var : arr) {
            sum += var;
            if (var == 0 || list.contains(sum) || sum == 0)
                return true;
            else
                list.add(sum);
        }
        return false;
    }


//    static boolean findsum(int arr[], int n) {
//        //Your code here
//        int sum = 0;
//        int min = 0;
//        for (int i = 0; i < n; i++) {
//            if (arr[i] < 0)
//                min += arr[i];
//            if (arr[i] == 0)
//                return true;
//        }
//        System.out.println("Min : " + min);
//        if (min < 0)
//            min = Math.abs(min);
//        else
//            return false;
//        for (int i = 0; i < n; i++) {
//            sum += arr[i];
//
//            if (sum > min)
//                sum = arr[i];
//
//            if (sum == 0)
//                return true;
//
//        }
//        return false;
//    }
}
/*
5
4 5 -4 -2 1
Yes
// [5 -4 -2 1] = 0

6
9 4 -7 2 3 7
No

34
36 27 -35 43 -15 36 42 -1 -29 12 -23 40 9 13 -24 -10 -24 22 -14 -39 18 17 -21 32 -20 12 -27 17 -15 -21 -48 -28 8 19
Yes
 */