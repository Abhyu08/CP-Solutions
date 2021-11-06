import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int result = checkDivisibility(Long.parseLong(n), 0, -1);
        if (result == 1)
            System.out.println("beautiful");
        else
            System.out.println("-1");
    }

    public static int checkDivisibility(long n, long var, int result) {

        if (var != 0 && n % var == 0) {
            return 1;
        } else if (var > n) {
            return -1;
        } else {
            if (var == 0) {
                int eight, nine;
                eight = checkDivisibility(n, 8, result);
                nine = checkDivisibility(n, 9, result);
                result = Math.max(eight, nine);
            } else {
                int eight, nine;
                eight = checkDivisibility(n, var * 10 + 8, result);
                nine = checkDivisibility(n, var * 10 + 9, result);
                result = Math.max(eight, nine);
            }
        }
        return result;
    }
}
