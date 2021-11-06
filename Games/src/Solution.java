import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] host = new int[n];
        int[] op = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            host[i] = sc.nextInt();
            op[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (host[i] == op[j])
                    count++;
            }
        }
        System.out.println(count);
    }
}
