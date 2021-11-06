import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fences = sc.nextInt();
        int height = sc.nextInt();
        int count = 0;
        for (int i = 0; i < fences; i++) {
            int temp = sc.nextInt();
            if (temp > height) {
                count += 2;
            } else count++;
        }
        System.out.println(count);
    }
}
