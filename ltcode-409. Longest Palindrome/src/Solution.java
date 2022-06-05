import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static int longestPalindrome(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry mapElement : map.entrySet()) {
            int value = ((int) mapElement.getValue());
            value -= value % 2;
            maxLength += value;
        }
        if (s.length() % 2 != 0 || maxLength < s.length()) maxLength++;

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(longestPalindrome(str));
    }
}
/*
abccccdd

a

bb

 */