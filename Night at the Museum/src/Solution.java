import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        int word = 97;
        for (int i = 0; i < str.length(); i++) {
            int ch = (int) str.charAt(i);
            if (Math.abs(word - ch) <= 26 - (Math.abs(word - ch))) {
                count += Math.abs(word - ch);
                word = ch;

            } else {
                count += 26 - (Math.abs(word - ch));
                word = ch;

            }
        }
        System.out.println(count);
    }
}
