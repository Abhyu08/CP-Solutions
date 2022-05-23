import java.util.Scanner;
///ttps://www.codechef.com/MAY222C/problems/XOR_PAL
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder result = new StringBuilder();

        while (testcase-- > 0) {
            int no = sc.nextInt();
            int xor_one = 0;
            String palindrome = sc.next();
            for (int i = 0; i < no / 2; i++)
                if (palindrome.charAt(i) != palindrome.charAt(no - i - 1))
                    if (((palindrome.charAt(i) - 48) ^ (palindrome.charAt(no - i - 1) - 48)) == 1) xor_one++;

            int operations = xor_one % 2 == 0 ? xor_one / 2 : xor_one / 2 + 1;
            result.append(operations).append("\n");
        }
        System.out.println(result);
    }
}
/*
6
5
11011
7
0111010
1
0
5
11101
3
011
14
01110100111010




2
14
01110100111010
3
011


 */