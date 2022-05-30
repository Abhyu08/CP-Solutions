import java.util.Scanner;

class Solution {

    //1.Using Normal Approach
    public static int divide(int dividend, int divisor) {
        long quotient = 0;
        int max = (int) (Math.pow(2, 31));
        int min = (int) (-1 * Math.pow(2, 31));
        quotient = (long) dividend / divisor;
        quotient = quotient >= max ? max : Math.max(quotient, min);

        return Integer.parseInt(String.valueOf(quotient));
    }

    //2.Using Bit-wise Manipulation

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();
        System.out.println(divide(dividend, divisor));
    }
}
/*
2147483647
1

-2147483648
-1

-1
-1

 */