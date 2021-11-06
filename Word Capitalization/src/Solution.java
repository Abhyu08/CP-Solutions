
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(str.toUpperCase().charAt(0));
        for (int i = 1; i < str.length(); i++)
            System.out.print(str.charAt(i));
    }
}
