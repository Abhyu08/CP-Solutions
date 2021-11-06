import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.nextLine();
        String l2 = sc.nextLine();
        String l3 = sc.nextLine();
        String l4 = sc.nextLine();
        int flag = 0;
        //for second line :
        for (int i = 1; i < 4; i++) {
            int count = 0;
            int count1 = 0;

            if (l1.charAt(i - 1) == '#')
                count++;
            if (l1.charAt(i) == '#')
                count++;
            if (l2.charAt(i - 1) == '#')
                count++;
            if (l2.charAt(i) == '#')
                count++;
            if (count >= 3 || count < 2) {
                flag = 1;
                break;
            }

        }

        if (flag == 0) {
            //for last line :

            for (int i = 1; i < 4; i++) {
                int count = 0;

                if (l3.charAt(i - 1) == '#')
                    count++;
                if (l3.charAt(i) == '#')
                    count++;
                if (l4.charAt(i - 1) == '#')
                    count++;
                if (l4.charAt(i) == '#')
                    count++;
                if (count >= 3 || count < 2) {
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 0) {
            //for last line :

            for (int i = 1; i < 4; i++) {
                int count = 0;

                if (l2.charAt(i - 1) == '#')
                    count++;
                if (l2.charAt(i) == '#')
                    count++;
                if (l3.charAt(i - 1) == '#')
                    count++;
                if (l3.charAt(i) == '#')
                    count++;
                if (count >= 3 || count < 2) {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 1)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
