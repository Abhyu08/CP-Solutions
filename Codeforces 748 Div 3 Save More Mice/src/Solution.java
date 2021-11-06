import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            int cat = 0;
            int mouse = 0;
            int hole = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            if (cat <= hole - arr[n - 1]) {
                mouse++;
                cat += hole - arr[n - 1];
            }
            for (int i = n - 2; i >= 0; i--) {
                if (cat < arr[i]) {
                    mouse++;
                } else break;
                cat += (hole - arr[i]);
            }
            str.append(mouse + "\n");
        }
        System.out.println(str);
    }
}
