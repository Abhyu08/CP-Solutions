import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static boolean bool = false;

    public static boolean isKaprekarNumber(long no) {
        if (no == 1)
            return true;
        long count_digits = 0;
        long temp = no;
        while (temp > 0) {
            count_digits++;
            temp /= 10;
        }
        long sqrt = no * no;
        long equal_parts = (long) Math.pow(10, count_digits);
        long sum = sqrt % equal_parts + sqrt / equal_parts ;
        if (sum == no) {
            bool = true;
            return true;
        } else return false;
    }

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(long p, long q) {
        for (long no = p; no <= q; no++) {
            if (isKaprekarNumber(no))
                System.out.print(no + " ");
        }
        if (!bool)
            System.out.println("INVALID RANGE");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long p = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
