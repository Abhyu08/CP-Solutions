
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[temp] = i + 1;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
