import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int lowerCase=0;
        int upperCase=0;
        for(int i=0;i<str.length();i++){
            if (Character.isLowerCase(str.charAt(i))) lowerCase++;
            if (Character.isUpperCase(str.charAt(i))) upperCase++;
        }



        System.out.print(upperCase+" ");
        System.out.println(lowerCase);
    }
}