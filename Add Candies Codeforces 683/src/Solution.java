
import java.util.Scanner;

/*                                        https://codeforces.com/contest/1447/problem/A */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
/*
            int max;
            int min;
            int count = 0;
            int[] arr = new int[n + 1];
            int[] result = new int[n + 3];
            for (int i = 1; i <= n; i++)
                arr[i] = i;
            max = n;
            min = 1;
            int k = 1;
            int max_index = n;
            int diff = n;
            int current_max_index = n;
            while (max != min && count <= n) {
                for (int i = 1; i <= n; i++) {
                    if (current_max_index != i)
                        arr[i] += diff;
                    if (arr[i] > max) {
                        max = arr[i];
                        max_index = i;
                    }
                }
                result[k] = current_max_index;
                k++;
                min = arr[current_max_index];
                current_max_index = max_index;
                diff = max - min;
                max = 0;
                count++;
            }
            System.out.println(count - 1);
            for (int i = 1; i < k - 1; i++)
                System.out.print(result[i] + " ");
            System.out.println();
            */
            System.out.println(n);
            for (int i = 1; i <= n; i++)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}