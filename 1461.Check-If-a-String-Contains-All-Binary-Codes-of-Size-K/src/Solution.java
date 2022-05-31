import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> got = new HashSet<String>();

        for (int i = k; i <= s.length(); i++) {
            String a = s.substring(i - k, i);
            if (!got.contains(a)) {
                got.add(a);
                need--;
                // return true when found all occurrences
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        System.out.println(hasAllCodes(str, k));
    }
}
/*
00110110
2

0110
1

0110
2


 */