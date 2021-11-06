
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int left = 0;
        int right = 0;
        int temp;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                temp = sc.nextInt();
                if (temp == 1) {
                    left = i+1;
                    right = j+1;
                }
            }
        System.out.println(Math.abs(3 - left) + Math.abs(3 - right));
    }
}