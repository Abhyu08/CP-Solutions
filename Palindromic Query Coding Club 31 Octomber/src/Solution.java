import java.util.*;
/* https://www.hackerrank.com/contests/all-india-contest-by-mission-helix-a-31-october/challenges/palindromic-query/problem
*   TLE*/
public class Solution {

    public static boolean Check(String str, int left, int right) {
        char[] arr = new char[right - left + 1];
        for (int i = left - 1, j = 0; i <= right - 1; i++, j++)
            arr[j] = str.charAt(i);

        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            if (arr[i] != arr[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.nextInt(); //scan length of string
        int queries = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        for (int i = 0; i < queries; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            sc.nextLine();
            if (l - r == 0 || Check(str, l, r))
                System.out.println("yes");
            else System.out.println("no");
        }
        sc.close();
    }
}