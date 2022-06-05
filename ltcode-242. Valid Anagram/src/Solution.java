import java.util.*;

class Solution {

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) > 0)
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (isAnagram(str1, str2)) System.out.println("true");
        else System.out.println("false");
    }

}
/*
"anagram"
"nagaram"

"rat"
"car"

"aacc"
"ccac"

"ab"
"ba"

 */