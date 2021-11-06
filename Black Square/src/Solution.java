import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        sc.nextLine();
        String seconds = sc.nextLine();
        int count = 0;
        for (int i = 0; i < seconds.length(); i++) {
            int temp = Integer.parseInt(String.valueOf(seconds.charAt(i)));
            count += arr[temp - 1];
        }
        System.out.println(count);
    }
}
