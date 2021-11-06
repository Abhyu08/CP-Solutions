
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 97) {
                upper++;
            } else lower++;
        }
        if (upper > lower)
            System.out.println(str.toUpperCase());
        else System.out.println(str.toLowerCase());
    }
}
