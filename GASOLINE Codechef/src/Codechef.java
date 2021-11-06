import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class Codechef {
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
        Reader sc = new Reader();
        StringBuilder str = new StringBuilder();
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++)
                arr[i][0] = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr[i][1] = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr[i][2] = arr[i][0] * arr[i][1];
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] s1, int[] s2) {
                    if (s1[2] > s2[2])
                        return 1;
                    else if (s1[2] == s2[2])
                        return 0;
                    else return -1;
                }
            });
            int distance = n;
            long cost = 0;
            for (int i = 0; i < n && distance != 0; i++) {
                if (arr[i][0] >= distance) {
                    cost += distance * arr[i][1];
                    break;
                } else {
                    cost += arr[i][2];
                    distance -= arr[i][0];
                }
            }
            str.append(cost + "\n");
        }
        System.out.println(str);
    }
}
