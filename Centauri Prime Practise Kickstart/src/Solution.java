import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        //Scanner sc = new Scanner(System.in);
        int f = 0;

        StringBuilder str = new StringBuilder();
        int testcase = sc.nextInt();
        Set<Character> s = new HashSet<>();
        s.add('A');
        s.add('E');
        s.add('I');
        s.add('O');
        s.add('U');
        s.add('a');
        s.add('e');
        s.add('i');
        s.add('o');
        s.add('u');
        while (testcase-- > 0) {
            f++;
            boolean result = true;
            //Write your code here:
            String ss = sc.next();
            int len = ss.length() - 1;
            if (s.contains(ss.charAt(len))) {
                str.append("Case #" + f + ": " + ss + " is ruled by " + "Alice." + "\n");
            } else if (ss.charAt(len) != 'y' && ss.charAt(len) != 'Y') {
                str.append("Case #" + f + ": " + ss + " is ruled by " + "Bob." + "\n");
            } else {
                str.append("Case #" + f + ": " + ss + " is ruled by " + "nobody." + "\n");
            }

        }
        System.out.println(str);
    }
}
/*
3
Mollaristan
Auritania
Zizily

 */