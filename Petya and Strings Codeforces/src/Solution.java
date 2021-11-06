import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String str1 = sc.readLine();
        String str2 = sc.readLine();
        int compare = str1.compareToIgnoreCase(str2);
        if (compare < 0)
            System.out.println("-1");
        else if(compare  == 0)System.out.println("0");
        else  System.out.println("1");
    }
}