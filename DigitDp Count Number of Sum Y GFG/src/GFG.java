import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class GFG {
    private static int dp[][][] = new int[20][180][2];//pos sum tight

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

    static void memset_dp() {
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 180; j++)
                for (int k = 0; k < 2; k++)
                    dp[i][j][k] = -1;

    }

    public static int Sum_Count(String str, int pos, int sum, int tight, int number) {
        if (pos == str.length()) {
            if (sum == number) {
                return 1;
            } else return 0;
        } else if (dp[pos][sum][tight] != -1) {
            return dp[pos][sum][tight];
        } else if (tight == 1) {
            int res = 0;
            for (int i = 0; i <= str.charAt(pos) - '0'; i++) {
                int sm = sum + i;
                if (i == str.charAt(pos) - '0')
                    res += Sum_Count(str, pos + 1, sm, 1, number);
                else res += Sum_Count(str, pos + 1, sm, 0, number);
            }
            dp[pos][sum][tight] = res;
            return res;
        } else {
            int res = 0;
            for (int i = 0; i <= 9; i++) {
                int sm = sum + i;

                res += Sum_Count(str, pos + 1, sm, 0, number);
            }
            dp[pos][sum][tight] = res;
            return res;
        }
    }


    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        StringBuilder str = new StringBuilder();
        int l = sc.nextInt() - 1;
        int r = sc.nextInt();
        int Y = sc.nextInt();
        memset_dp();
        int ansL = Sum_Count(String.valueOf(l), 0, 0, 1, Y);
        memset_dp();
        int ansR = Sum_Count(String.valueOf(r), 0, 0, 1, Y);
        str.append(ansR - ansL + "\n");
        System.out.println(str);
    }

}
