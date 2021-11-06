import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int list = sc.nextInt();
        sc.nextLine();
        int count = 0;
        int temp = 0;
        int[] players = new int[1001];
        for (int i = 1; i <= list; i++)
            players[i] = i;
        for (int i = 1; i <= list; i++) {
            temp = sc.nextInt();
            if (players[temp] != -1) {
                count++;
                players[temp] = -1;
            } else continue;
        }
        if (n - count == 1) System.out.println("YES");
        else System.out.println("NO");
    }
}
