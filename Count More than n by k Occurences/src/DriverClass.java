
import javax.swing.*;
import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        }
    }
}

class Solution {

    public int countOccurence(int[] arr, int n, int k) {
        int count = 0;
        k = n / k;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        for (int var : arr) {
            list.add(var);
            set.add(var);
        }
        for (int var : set) {
            int c = Collections.frequency(list, var);
            if (c > k)
                count++;
        }
        return count;
    }
}
