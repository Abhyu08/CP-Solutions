import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                min = Math.min(min, arr[i]);
            }
            for (int i = 0; i < n; i++) {
                arr[i] = arr[i] - min;
            }
            int result = GCD.findGCD(arr, n);
            result = result < 1 ? -1 : result;
            str.append(result + "\n");
        }
        System.out.println(str);
    }
}

class GCD {
    // Function to return gcd of a and b
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    static int findGCD(int arr[], int n) {
        int result = 0;
        for (int element : arr) {
            result = gcd(result, element);

            if (result == 1) {
                return 1;
            }
        }

        return result;
    }
}
/*
1
40
2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904 2904

 */