import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean accident = true;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) > 90) {
                accident = false;
                break;
            }
        }
        if (accident) {
            char temp = str.charAt(0);
            char[] arr = str.toLowerCase().toCharArray();
            if (temp > 90)
                arr[0] = (char) (temp - 32);
            else arr[0] = (char) (temp + 32);
            System.out.println(arr);
        } else System.out.println(str);
    }
}
