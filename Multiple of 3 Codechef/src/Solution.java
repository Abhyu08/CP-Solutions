import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    private static final int mod = 10;

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

    //DRIVER FUNCTION
    public static void main(String[] args) throws Exception {
        StringBuilder str = new StringBuilder();
        Reader sc = new Reader();
        int testcases = sc.nextInt();
        while (testcases-- > 0) {

            int Sum = 0;
            int n = sc.nextInt();
            int[] arr = new int[4];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = ((arr[0] + arr[1]) % mod);
            arr[3] = (arr[0] + arr[1] + arr[2]) % mod;
            if (n <= 4) {
                for (int i = 0; i < n; i++)
                    Sum += arr[i];
            } else {
                n -= 4;
                for (int i = 0; i < 4; i++)
                    Sum += arr[i];
                int[] next = new int[5];
                for (int i = 1, prev = 0; i < 5 && n > 0; i++, n--) {
                    next[i] = Sum % 10 + next[i - 1];
                    Sum += Sum % 10;
                }

                if (n > 0) {
                    int modulo = n % 4; //cycle of 4 integers
                    int times = n / 4;  // cycle of 4 integers
                    int s = next[modulo] + times * next[4];
                    Sum += s;
                }
            }
            if (Sum % 3 == 0)
                str.append("YES\n");
            else str.append("NO\n");
        }
        System.out.println(str);
    }
}
