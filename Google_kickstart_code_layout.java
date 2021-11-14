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
			//Write your code here:
			
			
            if (result)
                str.append("Case #" + f + ": YES" + "\n");
            else
                str.append("Case #" + f + ": NO" + "\n");
        }
        System.out.println(str);
    }
}
/*

 */