import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        long min = 0;
        long median = arr[n/2+1];
        for (int i = 1; i <= n; i++)
                min += Math.abs(arr[i] - median);
        System.out.println(min);
    }
}
