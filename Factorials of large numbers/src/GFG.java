
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans)
                System.out.print(val);
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N) {
        //code here
        ArrayList<Integer> result = new ArrayList<>();
        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        String str = factorial.toString();
        for (int i = 0; i < str.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        return result;
    }
}