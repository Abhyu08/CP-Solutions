import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int A = Math.max(Math.max(b, c) - a + 1 , 0);
            int B = Math.max(Math.max(a, c) - b + 1 , 0);
            int C = Math.max(Math.max(b, a) - c + 1 , 0);
            str.append(A + " " + B + " " + C + "\n");
        }
        System.out.println(str);
    }
}
/*

5
0 0 0
10 75 15
13 13 17
1000 0 0
0 1000000000 0
 */