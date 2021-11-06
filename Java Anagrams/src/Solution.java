import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        char[] a_arr = a.toCharArray();
        char[] b_arr = b.toCharArray();
        Arrays.sort(a_arr);
        Arrays.sort(b_arr);
        a = Arrays.toString(a_arr);
        b = Arrays.toString(b_arr);
        return (a.equals(b) ? true : false);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}