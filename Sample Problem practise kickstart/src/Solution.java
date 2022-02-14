import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        int f = 0;
        while (testcase-- > 0) {
            f++;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += sc.nextInt();
            }

            int result = total % m;
            str.append("Case #" + f + ": " + result + "\n");
        }
        System.out.println(str);
    }
}
