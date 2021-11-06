
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] m = new int[n];
        int n1 = 0;
        int n2 = 0;
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (arr[left] >= arr[right]) {
                m[i] = arr[left];
                left++;
            } else {
                m[i] = arr[right];
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                n1 += m[i];
            else n2 += m[i];
        }
        System.out.println(n1 + " " + n2);
    }
}
