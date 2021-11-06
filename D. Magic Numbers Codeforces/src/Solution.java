import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//			//				//               Abhyu08   			//			//			//			//
public class Solution {
    private static final int mod = 1000000007;
    public static int[][][] dp = new int[12][60][2];//pos sum tight
    private static int parity;

    static void memset_dp() {
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 60; j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;
        parity = 0;
    }


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


    public static long Magic_Numbers(String str, int pos, int sum, int tight, int multiple, int digit, String number, long limit) {
        if (pos == str.length()) {
            int temp = Integer.parseInt(number);
            if (temp % multiple == 0 && temp > limit) {
                parity = 1;
                return 1;
            } else return 0;
        } else if (tight == 1) {
            long res = 0;
            if (pos % 2 != 0) {
                if (digit > str.charAt(pos) - '0')
                    return 0;
                else if (digit < str.charAt(pos) - '0')
                    res += Magic_Numbers(str, pos + 1, sum + digit, 0, multiple, digit, number + digit, limit);
                else res += Magic_Numbers(str, pos + 1, sum + digit, 1, multiple, digit, number + digit, limit);

            } else {
                for (int i = 0; i <= str.charAt(pos) - '0'; i++) {
                    if (i == digit)
                        continue;
                    int sm = sum + i;
                    if (i == str.charAt(pos) - '0')
                        res += Magic_Numbers(str, pos + 1, sm, 1, multiple, digit, number + i, limit);
                    else res += Magic_Numbers(str, pos + 1, sm, 0, multiple, digit, number + i, limit);
                }
            }

            return res;

        } else {
            long res = 0;
            if (pos % 2 != 0) {
                res += Magic_Numbers(str, pos + 1, sum + digit, 0, multiple, digit, number + digit, limit);
            } else {
                for (int i = 0; i <= 9; i++) {
                    if (i == digit)
                        continue;
                    int sm = sum + i;
                    res += Magic_Numbers(str, pos + 1, sm, 0, multiple, digit, number + i, limit);
                }
            }

            return res;
        }

    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        StringBuilder str = new StringBuilder();

        int multiple = sc.nextInt();
        int digit = sc.nextInt();
        long start = sc.nextLong() - 1;
        long end = sc.nextLong();
        memset_dp();
        long ans2 = Magic_Numbers(String.valueOf(end), 0, 0, 1, multiple, digit, "", start);
        str.append(ans2 %mod + "\n");
        System.out.println(str);
    }
}