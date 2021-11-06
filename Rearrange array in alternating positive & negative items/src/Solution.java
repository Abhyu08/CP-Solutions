

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.util.*;
import java.io.*;

 class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Main().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Main {
    void rearrange(int arr[], int n) {
        // code here
        int i = 0;
        int j = n - 1;
        int[] temp = new int[n];
        while (i < j) {
            if (arr[i] >= 0)
                temp[i++] = arr[i];
            else
                temp[j--] = arr[i];
        }
        int l = 0, m = n - 1;
        int k = 0;
        while (l < i || m >= j && k<n) {
            if (m >= j)
                arr[k++] = temp[m--];
            if (l < i)
                arr[k++] = temp[l++];
        }
    }
}
/*
9
9 4 -2 -1 5 0 -5 -3 2
 */