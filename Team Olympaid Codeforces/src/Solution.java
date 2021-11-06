import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ones = new int[n];
        int[] twos = new int[n];
        int[] three = new int[n];
        int k = 0, l = 0, m = 0;
        for (int i = 0, temp; i < n; i++) {
            temp = sc.nextInt();
            if (temp == 1)
                ones[k++] = i + 1;
            else if (temp == 2)
                twos[l++] = i + 1;
            else three[m++] = i + 1;
        }
        int min = Math.min(Math.min(k, l), Math.min(l, m));
        System.out.println(min);
        for (int i = 0; i < min; i++)
            System.out.println(ones[i] + " " + twos[i] + " " + three[i]);
    }
}