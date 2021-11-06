import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;     //trie Data Structure ;

/* https://www.hackerrank.com/contests/all-india-contest-by-mission-helix-a-7-november/challenges/string-matcher
 * Editorial : https://www.hackerrank.com/contests/all-india-contest-by-mission-helix-a-7-november/challenges/string-matcher/editorial */
public class Solution {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    //Driver Function
    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int l1 = sc.nextInt();
        sc.nextInt();
        StringBuilder result = new StringBuilder();
        String[] str = new String[l1];
        for (int i = 0; i < l1; i++)
            str[i] = sc.readLine();

        int l2 = sc.nextInt();
        for (int i = 0; i < l2; i++) {
            int count = 0;
            String regex = sc.readLine();
            Pattern pattern = Pattern.compile(regex);
            for (int j = 0; j < l1; j++) {
                Matcher match = pattern.matcher(str[j]);
                while (match.find())
                    count++;
            }
            result.append(count + "\n");
        }
        System.out.println(result);
        sc.close();
    }
}