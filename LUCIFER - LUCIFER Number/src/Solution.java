import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//			//				//               Abhyu08   			//			//			//			//
class Solution {

    public static int[][][][] dp = new int[12][2][60][60];//pos tight even odd
    public static int[] prime_no = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61};

    static void memset_dp() {
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 60; k++)
                    for (int r = 0; r < 60; r++)
                        dp[i][j][k][r] = -1;
    }


    private static boolean check(int even, int odd, int length) {
        int diff;
        if (length % 2 == 0) {
            diff = odd - even;
        } else {
            diff = even - odd;
        }
        if (diff >= 2) {
            for (int i = 0; i < prime_no.length; i++) {
                if (prime_no[i] == diff)
                    return true;
            }
        }
        return false;
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


    public static int Lucifer(String str, int pos, int tight, int even, int odd) {
        if (pos == str.length()) {
            if (check(even, odd, str.length())) {
                return 1;
            } else return 0;
        } else if (dp[pos][tight][even][odd] != -1) {
            return dp[pos][tight][even][odd];
        } else if (tight == 1) {
            int res = 0;
            for (int i = 0; i <= str.charAt(pos) - '0'; i++) {
                int od = odd;
                int ev = even;
                if (pos % 2 == 0)
                    od += i;
                else ev += i;
                if (i == str.charAt(pos) - '0')
                    res += Lucifer(str, pos + 1, 1, ev, od);
                else res += Lucifer(str, pos + 1, 0, ev, od);
            }
            dp[pos][tight][even][odd] = res;
            return res;
        } else {
            int res = 0;
            for (int i = 0; i <= 9; i++) {
                int od = odd;
                int ev = even;
                if (pos % 2 == 0)
                    od += i;
                else ev += i;
                res += Lucifer(str, pos + 1, 0, ev, od);
            }
            dp[pos][tight][even][odd] = res;
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        StringBuilder str = new StringBuilder();
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt();
            memset_dp();
            int ans1 = Lucifer(String.valueOf(start), 0, 1, 0, 0);
            memset_dp();
            int ans2 = Lucifer(String.valueOf(end), 0, 1, 0, 0);
            str.append(ans2 - ans1 + "\n");
        }
        System.out.println(str);
    }
}