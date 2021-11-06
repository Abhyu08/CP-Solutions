import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
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
        while (testcase-- > 0) {
            f++;
            boolean result = true;
            long N = sc.nextLong();
            long D = sc.nextLong();
            long C = sc.nextLong();
            long M = sc.nextLong();
            //sc.nextLine();
            String s = sc.nextLine();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'D') {
                    if (D <= 0) {
                        result = false;
                        break;
                    } else {
                        D--;
                        C += M;
                    }
                } else if (C <= 0) {
                    while (i < s.length()) {
                        if (s.charAt(i) == 'D') {
                            result = false;
                            break;
                        }
                        i++;
                    }
                    break;
                } else
                    C--;
            }
            if (result)
                str.append("Case #" + f + ": YES" + "\n");
            else
                str.append("Case #" + f + ": NO" + "\n");
        }
        System.out.println(str);
    }
}
/*
5
6 10 4 0
CCDCDD
4 1 2 0
CCCC
4 2 1 0
DCCD
12 4 2 2
CDCCCDCCDCDC
8 2 1 3
DCCCCCDC
 */