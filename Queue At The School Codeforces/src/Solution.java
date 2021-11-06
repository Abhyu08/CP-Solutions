import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int k = 0;
        int time = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        for (int i = 0; i < time; i++)
            str = str.trim().replaceAll("BG", "GB");
        System.out.println(str);
    }
}