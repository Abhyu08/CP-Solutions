import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            int max = 0;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt() + 1;
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (c < a)
                    continue;
                int divisor = ( c / a);
                int p = divisor * b;
                if (max < p)
                    max = p;
            }
            str.append(max + "\n");
        }
        System.out.println(str);
    }
}
