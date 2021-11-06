
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 2 * n - 1; i > 0 && k > 0; i--) {
            int temp = arr[i] - 1;
            if (arr[i - 1] < temp && temp > arr[i + 1]) {
                arr[i]--;
                k--;
            }
        }
        for (int i = 0; i < 2 * n + 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
