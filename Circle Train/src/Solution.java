import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;
        int fwd_cost = 0;
        for (int i = start; i != end; i = (i + 1) % n)
            fwd_cost += arr[i];
        System.out.println(Math.min(fwd_cost,total-fwd_cost));
    }
}
