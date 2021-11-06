import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int String_length = sc.nextInt();
        sc.nextLine();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] chararr1 = str1.toCharArray();
        char[] chararr2 = str2.toCharArray();
        Arrays.sort(chararr1);
        Arrays.sort(chararr2);
        str1 = String.valueOf(chararr1);
        str2 = String.valueOf(chararr2);
        boolean bool = Arrays.equals(chararr1,chararr2);
        if(bool)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
