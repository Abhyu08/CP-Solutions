import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st1 = sc.nextLine();
        String st2 = sc.nextLine();
        int l1 = st1.length();
        int l2 = st2.length();
        int path = 0;
        for (int i = 0; i < l2; i++) {
            if (st2.charAt(i) == st1.charAt(path)) {
                path++;
            }
        }
        System.out.println(path + 1);
    }
}
