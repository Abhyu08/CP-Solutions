import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            int amount = sc.nextInt();
            String s = sc.next();

            int carson = 0;
            int chef = 0;
            int tie = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'C')
                    carson++;
                else if (s.charAt(i) == 'N')
                    chef++;
                else
                    tie++;
            }
            carson = carson * 2 + tie;
            chef = chef * 2 + tie;

            if (carson > chef) {
                str.append(60 * amount + "\n");
            } else if (chef > carson) {
                str.append(40 * amount + "\n");
            } else {
                str.append(55 * amount + "\n");
            }
        }
        System.out.println(str);
    }
}
