import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder result = new StringBuilder();

        while (testcase-- > 0) {
            int n = sc.nextInt();
            int degree = 0;
            for (int i = 0; i < n; i++) {
                if ((sc.nextInt()) != 0 && i != 0)
                    degree = i;
            }
            result.append(degree).append("\n");
        }
        System.out.println(result);
    }
}
