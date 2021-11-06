
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while (t-- > 0) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long a1[] = new long[(int) (n)];
            long a2[] = new long[(int) (m)];


            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }


            Compute obj = new Compute();
            System.out.println(obj.isSubset(a1, a2, n, m));

        }
    }
}
// } Driver Code Ends


class Compute {
    public String isSubset(long a1[], long a2[], long n, long m) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(a1[i]);
        for (int i = 0; i < m; i++) {
            if (set.contains(a2[i]))
                continue;
            else
                return "a2[] is not a subset of a1[]";
        }
        return "a2[] is a subset of a1[]";
    }
}
/*
6 4
11 1 13 21 3 7
11 3 7 1
 */