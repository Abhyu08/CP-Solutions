import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            int[] diff = new int[n + 1];
            for (int i = 1; i <= n; i++)
                arr[i] = sc.nextInt();
            int available_max = arr[1];
            int minus_sum = 0;
            for (int i = 2; i <= n; i++) {
                diff[i] = arr[i] - arr[i - 1];
                if (diff[i] < 0)
                    minus_sum += diff[i];
            }
            if (available_max + minus_sum >= 0)
                    System.out.println("YES");
                else System.out.println("NO");
        }
    }
}
