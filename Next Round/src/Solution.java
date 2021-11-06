import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int place = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        place = arr[place - 1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= place && arr[i] > 0)
                count++;
        }
        System.out.println(count);
    }
}
