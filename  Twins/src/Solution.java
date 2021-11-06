

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            arr2[i] = arr[i];
        }
        Arrays.sort(arr);
        Arrays.sort(arr2);
        int count = 0;
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                arr[i] += arr[i - 1];

            }

            for (int i = n - 2; i >= 0; i--) {
                arr2[i] += arr2[i + 1];
            }
            for (int i = n - 1; i > 0; i--) {
                count++;
                if (arr2[i] > arr[i - 1])
                    break;
                if (i == 1)
                    count++;
            }
            System.out.println(count);
        } else {
            System.out.println("1");
        }

    }
}
