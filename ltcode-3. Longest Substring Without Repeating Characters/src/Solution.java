import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static int lengthOfLongestSubstring(String str) {
        int maxSubString = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, max = 0, startIndex = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int getIndex = map.get(str.charAt(i));
                map.put(str.charAt(i), i);
                if (startIndex > getIndex) max++;
                else {
                    max = Math.abs(i - getIndex);
                    startIndex = getIndex + 1;
                }
            } else {
                map.put(str.charAt(i), i);
                max++;
            }
            maxSubString = Math.max(max, maxSubString);
        }
        return maxSubString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(lengthOfLongestSubstring(str));
    }
}
/*
abcabcbb

bbbbb

pwwkew

abba


 */