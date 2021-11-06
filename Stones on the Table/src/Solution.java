import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int count = 0;
        if (n >= 2) {
            for (int i = 1; i < n; i++) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    while (i < n && str.charAt(i) == str.charAt(i - 1)) {
                        i++;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
