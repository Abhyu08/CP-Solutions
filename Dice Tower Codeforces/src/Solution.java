import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int flag = 1;
        int n = sc.nextInt();
        int face = sc.nextInt();
        int bottom = 7 - face;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == face || b == face) {
                flag = 0;
                break;
            } else if (a == bottom || b == bottom) {
                flag = 0;
                break;
            }
        }
        if (flag == 1)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
