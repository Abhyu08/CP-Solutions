
import java.util.Scanner;

public class Solution {

    public static String swap(String str, int current, int to_this) {
        char t;
        char[] arr = str.toCharArray();
        t = arr[current];
        arr[current] = arr[to_this];
        arr[to_this] = t;
        return String.valueOf(arr);
    }

    public static void find_Permutations(String str, int left, int right) {
        if (left == right)
            System.out.println(str);
        else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i); //do swap
                find_Permutations(str, left + 1, right);
                str = swap(str, left, i); //undo swap
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        find_Permutations(str, 0, str.length() - 1);
    }
}
