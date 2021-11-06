import java.util.Scanner;

// Java program for above implementation
class Solution {

    // Function to find no. of elements
    // to be added from 1 to get n
    static int findS(long s) {
        long sum = 0;

        // Start adding numbers from 1
        long n = s * 2;
        long m = (long) Math.ceil(Math.sqrt(n));
        while (true) {
            if (m < 1)
                break;
            sum = (long) (m * (m + 1)) / 2;
            // If sum becomes equal to s
            // return n
            m--;
            if (sum == s)
                return 1;
        }

        return -1;
    }

    // Drivers code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long no = sc.nextLong();

        while (true) {

            long s = 0;
            if (sc.hasNextLong())
                s = sc.nextLong();
            long n = Solution.findS(s);
            if (n == -1)
                System.out.println("NO");
            else
                System.out.println("YES");
            no--;
            if (no < 1)
                break;
        }
    }
}

