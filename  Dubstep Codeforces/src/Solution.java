import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String str = temp.replaceAll("WUB", " ").trim();
        System.out.println(str);
    }
}
