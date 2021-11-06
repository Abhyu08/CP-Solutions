import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int r = 0;
        int l = 0;
        int start = 0;
        int end = n - 1;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') r++;
            if (str.charAt(i) == 'L') l++;
        }
        if (l == 0) { //all R
            for (int i = 0; i < n; i++) {
                if (start == 0 && str.charAt(i) == 'R') {
                    start = i;
                }
                if (str.charAt(i) == 'R') {
                    end = i + 2;
                }
            }
            System.out.println(start + 1 + " " + end);

        } else if (r == 0) { //all L

            for (int i = 0; i < n; i++) {
                if (start == 0 && str.charAt(i) == 'L') {
                    start = i;
                }
                if (str.charAt(i) == 'L') {
                    end = i;
                }
            }
            System.out.println(end + 1 + " " + start);

        } else { //R followed by L

            for (int i = 0; i < n; i++) {
                if (start == 0 && str.charAt(i) == 'R') {
                    start = i + 1;
                }
                if (end == n - 1 && str.charAt(i) == 'L') {
                    end = i;
                }
            }
            System.out.println(start + " " + end);
        }
    }
}
