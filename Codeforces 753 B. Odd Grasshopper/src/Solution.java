import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            long x = sc.nextLong();
            long jumps = sc.nextLong();
            long R = jumps % 4;
            long inc = (jumps / 4) * 4 + 1;
            if (R == 0) {

            } else if (R == 1) {
                if (x % 2 == 0)
                    x -= inc;
                else
                    x += inc;
            } else {
                for (int i = 0; i < R; i++, inc++) {
                    if (x % 2 == 0)
                        x -= inc;
                    else
                        x += inc;
                }
            }
            str.append(x + "\n");
        }
        System.out.println(str);
    }
}
/*
O(N^2):
            for (long i = 1; i <= jumps; i++) {
                if (x % 2 == 0) {
                    x = x - i;
                } else {
                    x = x + i;
                }
            }
 */

/*
9
0 1
0 2
10 10
10 99
177 13
10000000000 987654321
-433494437 87178291199
1 0
-1 1
 */