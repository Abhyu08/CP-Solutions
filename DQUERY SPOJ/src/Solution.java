import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1000009];
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int temp = sc.nextInt();
            if (arr[temp] != 1)
                array[i] += array[i - 1] + 1;
            else array[i] = array[i - 1];
            arr[temp] = 1;
        }

    }
}
