import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex1 = "KICK";
        String regex2 = "START";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        int testcases = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= testcases; i++) {
            String str = sc.nextLine();
            Matcher match1 = pattern1.matcher(str);
            Matcher match2 = pattern2.matcher(str);
            int Kick_index = -1;
            int Start_index = -1;
            int lucky_fragments = 0;

            while (match2.find()) {
                lucky_fragments++;
                Start_index = match2.start(); //gives last interval of START
            }
            while (match1.find()) {
                lucky_fragments++;

                if (Kick_index == -1) {
                    Kick_index = match1.start(); // Stores first interval of KICK

                    if (Start_index <= match1.start())
                        lucky_fragments--;
                }
            }

            if (Start_index > 3) {
                int n = Start_index - 4;
                String ss = str.charAt(n) + "" + str.charAt(n + 1) + str.charAt(n + 2) + str.charAt(n + 3);
                if (ss.equals("KICK"))
                    lucky_fragments--;
            }
            //-----------OUTPUT----------------------------
            if (Kick_index > Start_index)
                System.out.println("Case #" + i + ": 0");
            else System.out.println("Case #" + i + ": " + lucky_fragments);
        }
    }
}
//This Solution Require me 2hrs of time.....//WA