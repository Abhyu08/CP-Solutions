
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            int n = sc.nextInt();
            int temp = sc.nextInt();
            int count = 1;
            for (int i = 1; i < n; i++) {
                int var = sc.nextInt();
                if (var <= temp)
                    count++;
                else
                    var = temp;
                temp = var;
            }
            System.out.println(count);
        }

    }
}
