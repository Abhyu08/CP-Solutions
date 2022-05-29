import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static int maxProduct(String[] words) {
        int maxValue = 0;
        //Brute Force Approach
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (compareWords(words[i], words[j])) {
                    maxValue = Math.max(maxValue, words[i].length() * words[j].length());
                }
            }
        }
        return maxValue;
    }

    public static boolean compareWords(String word1, String word2) {
        boolean result = true;
        int l1 = word1.length();
        int l2 = word2.length();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int w1 = 0, w2 = 0, i = 0; i < Math.max(l1, l2); i++) {
            if (w1 < l1) {
                char ch = word1.charAt(w1);
                if (set2.contains(ch)) return false;
                else set1.add(ch);
                w1++;
            }
            if (w2 < l2) {
                char ch = word2.charAt(w2);
                if (set1.contains(ch)) return false;
                else set2.add(ch);
                w2++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        String[] arr = new String[no];

        for (int i = 0; i < no; i++)
            arr[i] = sc.next();
        System.out.println(maxProduct(arr));
    }
}
/*
6
abcw baz foo bar xtfn abcdef

7
a ab abc d cd bcd abcd

4
a aa aaa aaaa

10
eae ea aaf bda fcf dc ac ce cefde dabae

 */