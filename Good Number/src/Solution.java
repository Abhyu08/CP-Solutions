import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int limit = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            int t = temp;
            int l = limit + 1;
            int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            while (temp > 0) {
                int k = temp % 10;
                temp /= 10;
                if (arr[k] == 1 && k <= limit) {
                    l--;
                    arr[k] = -1;
                } else if (l == 0)
                    break;
            }
            if (l <= 0) {
                count++;
            }

        }
          System.out.println(count);
    }
}
