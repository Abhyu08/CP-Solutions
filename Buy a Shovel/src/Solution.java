import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int digit = sc.nextInt();
        int flag = 1;
        int temp = price;
        int count = 1;
        while (true) {
            if (temp % 10 == digit) {
                break;
            } else if (temp % 10 == 0) {
                break;
            } else {
                temp += price;
                count++;
            }
        }
        System.out.println(count);
    }
}
