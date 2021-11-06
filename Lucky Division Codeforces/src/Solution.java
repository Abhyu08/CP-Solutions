import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final int[] luckies = {4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777};

    static boolean Check(String str) {
        Pattern pattern = Pattern.compile("^[47]+$");
        Matcher match = pattern.matcher(str);
        while (match.find()) {
            return true;
        }
        int temp = Integer.parseInt(str);
        if (temp % 4 == 0 || temp % 7 == 0)
            return true;
        else {
            for (int i = 0; i < luckies.length; i++) {
                if (temp % luckies[i] == 0)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean lucky = false;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int temp = Integer.parseInt(str);
        lucky = Check(Integer.toString(temp));
        if (lucky)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
