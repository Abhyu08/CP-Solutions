
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int testcase = sc.nextInt();
        while (testcase-- > 0) {
            int n = sc.nextInt();
            int K = sc.nextInt();
            String s = sc.next();
            char[] arr = s.toCharArray();
            int k = 0;
            for (int i = 0; i <= n / 2; i++) {
                if (arr[i] != arr[n - i - 1]) {
                    k++;
                    arr[i] = arr[n - i - 1];
                }
            }
            // System.out.println(arr);
            int left = K - k;
            if ((left > 0 && left % 2 == 0) || left == 0) {
                str.append("YES\n");
            } else if ((left > 0 && left % 2 != 0) && (n % 2 != 0)) {
                str.append("YES\n");
            } else {
                str.append("NO\n");
            }
        }
        System.out.println(str);
    }

}
/*
2
3 0
110
6 1
101100

 */