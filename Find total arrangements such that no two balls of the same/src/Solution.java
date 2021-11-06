import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int n = 0, count = 0;
            int length = N + M;
            int d = length / 2;
            int result = 0;
            while (count < length && count <= K) {
                if (count == 0)
                    result += 2;
                else {
                    n = length - count;
                    if (N >= count)
                        result += n;
                    if (M >= count)
                        result += n;
                }
                count++;
            }
            System.out.println(count);
        }
    }
}
