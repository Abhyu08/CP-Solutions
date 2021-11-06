import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            int max_distance = 1;
            int[] arr = new int[n];
            int[] arr_asc = new int[n];
            int[] arr_des = new int[n];
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                arr_asc[i] = arr[i];
            }
            Arrays.sort(arr_asc);
            for (int i = 0, j = n - 1; i < n; i++, j--) {
                arr_des[i] = arr_asc[j];
            }

            if (n > 1) {
                for (int i = 1; i < n; i++) {
                    if (arr[i - 1] != arr[i])
                        max_distance++;
                }
            }

//n^2 complexity for hamming/-- 
            for (int i = 0; i < n; i++) {
                int temp = arr_asc[i];
                for (int j = 0; j < n; j++) {
                    if (temp == arr[j]) {
                        result[j] = arr_des[i];
                        arr[j] = -1;
                        break;
                    }
                }
            }
            //missing maximum hamming O/P single integer
            System.out.println(max_distance);
            for (int i : result)
                System.out.print(i + " ");
            System.out.println();
        }//while
    }
}