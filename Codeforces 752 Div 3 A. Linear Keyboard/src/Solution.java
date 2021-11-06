import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            int result = 0;
            String keyboard = sc.nextLine();
            String word = sc.nextLine();
            int[] arr = new int[130];
            for (int i = 0; i < 26; i++) {
                int temp = keyboard.charAt(i);
                arr[temp] = i;
            }
            for (int i = 1; i < word.length(); i++) {
                result += Math.abs(arr[word.charAt(i)] - arr[word.charAt(i-1)]);
            }
            str.append(result + "\n");
        }
        System.out.println(str);
    }
}
/*
1
abcdefghijklmnopqrstuvwxyz
hello

5
abcdefghijklmnopqrstuvwxyz
hello
abcdefghijklmnopqrstuvwxyz
i
abcdefghijklmnopqrstuvwxyz
codeforces
qwertyuiopasdfghjklzxcvbnm
qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
qwertyuiopasdfghjklzxcvbnm
abacaba

 */