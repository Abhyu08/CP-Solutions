import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Scanner;
/*
VM Options : -Xms512M -Xmx4096M
 */
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = 1;
        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (long i = 0; i < n; i++)
                arr[(int) i] = sc.nextLong();

            System.out.println( new Main().inversionCount(arr, n));

        }
    }
}
// } Driver Code Ends

class Main {
    public static long mergesort(long[] arr, long temp[], int left, int mid, int right) {
        long inversions = 0;
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
                inversions += (mid - i + 1); //look detail
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int m = left; m <= right; m++)
            arr[m] = temp[m];
        return inversions;
    }

    public static long merge(long arr[], long temp[], int left, int right) {
        long inversions = 0;
        if (left >= right)
            return 0;
        else {
            int mid = (left + right) / 2;
            inversions += merge(arr, temp, left, mid);
            inversions += merge(arr, temp, mid + 1, right);
            inversions += mergesort(arr, temp, left, mid, right);
        }
        return inversions;
    }

    static long inversionCount(long arr[], long N) {
        // Your Code Here
        long[] temp = new long[arr.length];
        long result = merge(arr, temp, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println();
        return result;
    }
}
/*
5
2 4 1 3 5

6
12 11 13 5 6 7


 */