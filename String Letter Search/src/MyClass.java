
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int result = new UserMainCode().SearchLetter(str1, str2);
        System.out.println(result);
    }
}

class UserMainCode {


    public int SearchLetter(String input1, String input2) {
        Set<Character> s = new HashSet<>();
        int first = input1.indexOf(input2);
        int last = input1.lastIndexOf(input2);
        if (first < 0 || last < 0)
            return -1;
        int count = 0;
        String substr = input1.substring(first, last);
        int n = substr.length();
        int[] arr = new int[300];
        for (int i = 0; i < n; i++) {
            int t = substr.charAt(i);
            arr[t]++;
        }
        char ch = input2.charAt(0);
        arr[(int) ch] = 5;
        ch = ' ';
        arr[(int) ch] = 5;
        for (int i = 0; i < n; i++) {
            int t = substr.charAt(i);
            if (arr[t] == 1)
                count++;
        }
        return count;
    }

}
