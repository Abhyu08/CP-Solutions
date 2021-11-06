import java.io.*;
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String string = sc.readLine();
        string = string.trim().replaceAll("[AEIOUYaeiouy]","");
        string = string.toLowerCase();
        for(int i=0;i<string.length();i++)
            System.out.print("."+string.charAt(i));
    }
}