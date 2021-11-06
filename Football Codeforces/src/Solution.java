import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String string = sc.readLine();
        boolean dangerous = false;
        Pattern pattern = Pattern.compile("0000000|1111111");
        Matcher match = pattern.matcher(string);
        while (match.find()) {
            dangerous = true;
            break;
        }
        if (dangerous)
            System.out.println("YES");
        else System.out.println("NO");
    }
}