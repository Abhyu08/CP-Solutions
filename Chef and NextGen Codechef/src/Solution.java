import java.util.Scanner;

 class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();

            A = A * B;
            X = X * Y;
            if (X >= A) {
                str.append("YES\n");
            } else
                str.append("NO\n");
        }
        System.out.println(str);
    }
}
