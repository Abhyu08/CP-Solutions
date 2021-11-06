import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class Solution {
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
        StringBuilder str = new StringBuilder();
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int total_inversions = 0;
            int n = sc.nextInt();
            String[] matrix = new String[n];
            for (int i = 0; i < n; i++)
                matrix[i] = sc.readLine();

            if (matrix[0].charAt(1) == matrix[1].charAt(0)) { //Start is same
                char temp = matrix[0].charAt(1);
                String strr = "";
                if (matrix[n - 2].charAt(n - 1) == temp) {
                    int a = n - 2;
                    int b = n - 1;
                    strr += a + " " + b + "\n";
                    total_inversions++;
                }
                if (matrix[n - 1].charAt(n - 2) == temp) {
                    int a = n - 1;
                    int b = n - 2;
                    strr += a + " " + b + "\n";
                    total_inversions++;
                }
                str.append(total_inversions + "\n");
                str.append(strr);

            } else if (matrix[n - 1].charAt(n - 2) == matrix[n - 2].charAt(n - 1)) { //Finish is same
                int temp = matrix[n - 1].charAt(n - 2);
                String strr = "";
                if (matrix[0].charAt(1) == temp) {
                    strr += '1' + " " + '2' + "\n";
                    total_inversions++;
                }
                if (matrix[1].charAt(0) == temp) {
                    int a = n;
                    int b = n - 1;
                    strr += '2' + " " + '1' + "\n";
                    total_inversions++;
                }
                str.append(total_inversions + "\n");
                str.append(strr);
            } else {  //both S and F are different
                String strr = "";
                if (matrix[0].charAt(1) == '1')
                    strr += '1' + " " + '2' + "\n";
                else strr += '2' + " " + '1' + "\n";

                int a = n;
                int b = n - 1;
                if (matrix[n - 1].charAt(n - 2) == 0) {
                    a = n - 1;
                    b = n;
                }
                strr += a + " " + b + "\n";
                str.append("2\n");
                str.append(strr);
            }
        }
        System.out.println(str);
    }
}