import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            boolean exist = false;
            if (n == 1)
                exist = true;
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i - 1]) {
                    exist = true;
                    break;
                }
            }
            if (exist)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
