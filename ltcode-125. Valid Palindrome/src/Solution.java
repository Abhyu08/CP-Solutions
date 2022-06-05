import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static boolean isPalindrome(String str) {

        StringBuilder final_str = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || ((ch >= 48 && ch <= 57) )) final_str.append(ch);
        }
        if (final_str.toString().equalsIgnoreCase(final_str.reverse().toString()))
            return true;
        else return false;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            if (isPalindrome(str)) System.out.println("true");
            else System.out.println("false");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
"race a car"

"A man, a plan, a canal: Panama"

" "

"0P"


 */