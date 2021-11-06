/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int[] removeDup(int[] arr) {
        int[] array = new int[arr.length];
        int k = 0;
        int prev = -111;
        for (int i = 0; i < arr.length; i++) {
            if (prev != arr[i])
                array[k++] = arr[i];
            prev = arr[i];
        }
        int[] ar = new int[k];
        for (int i = 0; i < k; i++)
            ar[i] = array[i];
        return ar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcases-- > 0) {
            int count = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N];
            int[] arr2 = new int[M];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();
            for (int i = 0; i < M; i++)
                arr2[i] = sc.nextInt();
            Arrays.sort(arr);
            Arrays.sort(arr2);
            arr = removeDup(arr);
            arr2 = removeDup(arr2);
            N = arr.length;
            M = arr2.length;
            if (N >= M) {
                for (int i = 0; i < M; i++) {
                    int isThere = Arrays.binarySearch(arr, arr2[i]);
                    if (isThere < 0)
                        count++;
                }
                count += N;
            } else {
                for (int i = 0; i < N; i++) {
                    int isThere = Arrays.binarySearch(arr2, arr[i]);
                    if (isThere < 0)
                        count++;
                }
                count += M;
            }
            str.append(count + "\n");
        }
        System.out.println(str);
    }
}