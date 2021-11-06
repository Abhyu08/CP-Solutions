import javax.swing.event.InternalFrameEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (testcase-- > 0) {
            String str = br.readLine();
            int min_steps = str.length();
            int n = str.length();
            for (int i = 0; i < n; i++) {
                int no_1 = str.charAt(i) - '0';
                for (int j = i + 1; j < n; j++) {
                    int no_2 = str.charAt(j) - '0';
                    int temp = no_1 * 10 + no_2;
                    if (temp % 25 == 0) {
                        min_steps = Math.min(min_steps, j - i - 1 + n - j - 1);
                    }
                }
            }

            result.append(min_steps + "\n");
        }
        System.out.println(result);
    }
}
/*
5`
100
71345
3259
50555
2050047
 */