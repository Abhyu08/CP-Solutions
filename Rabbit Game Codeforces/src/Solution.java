import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count1 = 0;
        int count2 = 0;
        int index = 0;
        int prev = Integer.MIN_VALUE;
        int[] carrots = new int[n + 1];
        for (int i = 1; i <= n; i++)
            carrots[i] = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (carrots[i] >= prev)
                count1++;
            else break;
            index = i;
            prev = carrots[i];
        }
        prev = Integer.MIN_VALUE;
        if (index < n) {
            for (int i = n; i > index; i--) {
                if (carrots[i] >= prev)
                    count2++;
                else break;
                prev = carrots[i];
            }
        } else count2 = 0;
        System.out.println(count1 + count2);
    }
}