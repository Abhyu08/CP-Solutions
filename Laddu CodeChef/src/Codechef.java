import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


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

    //Driver Function
    public static void main(String[] args) throws Exception {
        StringBuilder str = new StringBuilder();
        Reader sc = new Reader();
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int result;
            int score = 0;
            int activities = sc.nextInt();
            String nationality = sc.readLine();
            for (int i = 0; i < activities; i++) {
                String string = sc.readLine();
                String[] temp = string.trim().split(" ");
                if (temp.length > 1) {
                    string = temp[0];
                    int s = Integer.parseInt(temp[1]);
                    if (string.length() < 10) {
                        score += s;
                    } else {
                        score += 300;
                        if (s <= 20)
                            score += 20 - s;
                    }
                } else {
                    if (string.equals("TOP_CONTRIBUTOR")) {
                        score += 300;
                    } else {
                        score += 50;
                    }
                }
            }
            if (nationality.equals("INDIAN")) {
                result = score / 200;
            } else {
                result = score / 400;
            }
            str.append(result + "\n");
        }
        System.out.println(str);
    }
}
