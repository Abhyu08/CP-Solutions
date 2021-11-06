
import java.math.*;
import java.util.*;
import java.io.*;

class Driverclass {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = new Solution().findLongestConseqSubseq(arr, n);
        System.out.println(result);
    }
}


class Solution {


    //Function to return length of longest subsequence of consecutive integers.
    static int findLongestConseqSubseq(int arr[], int N) {
        int max_length = 1;
        int count = 0;
        int prev = -111;
        Set<Integer> set = new TreeSet<>();
        for (int var : arr)
            set.add(var);
        for (int var : set) {
            if (prev == -111) {
                count++;
            } else if (var >= prev && var - prev == 1) {
                count++;
                if (max_length <= count)
                    max_length = count;
            } else {
                count = 1;
            }
            prev = var;
        }

        return max_length;
    }
}
/*
7
1 9 3 10 4 20 2
7
2 6 1 9 4 5 3
2
61 130
 */