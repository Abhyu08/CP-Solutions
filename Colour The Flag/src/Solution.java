import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.io.*;

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

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testcases = sc.nextInt();
        StringBuilder stb = new StringBuilder();
        while (testcases-- > 0) {
            int flag = 0;
            int m = sc.nextInt();
            int n = sc.nextInt();
            char[][] arr = new char[m][n];
            String[] str = new String[m];
            for (int i = 0; i < m; i++) {
                str[i] = sc.readLine();
            }
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < m; j++) {
                    if (flag == 0 && str[i].charAt(j) == '.') {
                        continue;
                    } else if (flag == 0) {
                        if (str[i].charAt(j) == 'R') {
                            arr[i][j] = 'R';
                            flag = -1;
                        } else {
                            arr[i][j] = 'W';
                            flag = 1;
                        }
                    } else {
                        if (str[i].charAt(j) == 'R' && flag == -1) {

                        } else if (str[i].charAt(j) == 'W' && flag == 1) {

                        }else{
                            stb.append("NO\n");
                            break;
                    }
                }
            }
        }
    }
        System.out.println(stb);
}
}
