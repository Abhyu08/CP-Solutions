import java.util.Scanner;

public class Solution {

    public static boolean check(int n) {
        int temp = 180 - n;
        n = temp;
        while (temp <= 360) {
            temp += n;
            if (temp == 360)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (check(sc.nextInt()))
                str.append("YES\n");
            else str.append("NO\n");
        }
        System.out.println(str);
    }
}
