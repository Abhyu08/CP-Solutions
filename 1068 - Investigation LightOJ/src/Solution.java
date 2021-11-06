import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
 // NOT ACCepted
//			//				//               Abhyu08   			//			//			//			//
class Solution {

    public static int[][][] dp = new int[12][120][2];//pos tight even odd


    static void memset_dp() {
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 120; j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;
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


    public static int Investigation(String str, int pos, int sum, int tight, String number, int dividend) {
        if (pos == str.length()) {
            if (sum % dividend == 0 && sum > 0) {
                if (Integer.parseInt(number) % dividend == 0) {
                   // System.out.println(Integer.parseInt(number));
                    return 1;
                } else return 0;
            } else return 0;
        } else if (tight == 1) {
            int res = 0;
            for (int i = 0; i <= str.charAt(pos) - '0'; i++) {
                if (i == str.charAt(pos) - '0')
                    res += Investigation(str, pos + 1, sum + i, 1, number + i, dividend);
                else res += Investigation(str, pos + 1, sum + i, 0, number + i, dividend);
            }
            dp[pos][sum][tight] = res;
            return res;
        } else {
            int res = 0;
            for (int i = 0; i <= 9; i++) {

                res += Investigation(str, pos + 1, sum + i, 0, number + i, dividend);
            }
            dp[pos][sum][tight] = res;
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        StringBuilder str = new StringBuilder();
        int testcases = sc.nextInt();
        for (int i = 1; i <= testcases; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt();
            int K = sc.nextInt();
            memset_dp();
            int ans1 = Investigation(String.valueOf(start), 0, 0, 1, "", K);
            memset_dp();
            int ans2 = Investigation(String.valueOf(end), 0, 0, 1, "", K);
            int result = ans2 - ans1;
            str.append("Case " + i + ": " + result + "\n");
        }
        System.out.println(str);
    }
}