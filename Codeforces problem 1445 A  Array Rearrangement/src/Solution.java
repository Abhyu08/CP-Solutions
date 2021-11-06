import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            boolean bool = true;
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++)
                arr1[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr2[i] = sc.nextInt();

            for (int i = 0; i < n; i++){
                int temp = arr1[i]+arr2[n-i-1];
                bool = bool && (temp<=x);
            }
            if (bool)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
