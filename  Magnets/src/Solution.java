import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int prev = -1;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (prev == -1) {
                prev = temp;
            } else {
                if (prev == temp) {
                    continue;
                } else {
                    prev = temp;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
