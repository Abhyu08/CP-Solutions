
import java.util.Scanner;

public class Solution {

    private static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};


    //DRIVER FUNCTION
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            String no = "";
            for (int i = 8; i >= 0 && n > 0; i--) {
                if (numbers[i] <= n) {
                    n -= numbers[i];
                    no += numbers[i];
                }
            }
            if (n == 0) {
                for (int i = no.length() - 1; i >= 0; i--) {
                    str.append(no.charAt(i));
                }
                str.append("\n");
            } else str.append("-1\n");
        }
        System.out.println(str);
    }
}