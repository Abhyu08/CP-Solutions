import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;


public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int f = 0;

        StringBuilder str = new StringBuilder();
        int testcase = sc.nextInt();
        while (testcase-- > 0) {
            f++;
            //Write your code here:
            int cnt = 0, cnt2 = 0;
            int k = 0;
            Set<Character> set = new HashSet<>();

            int letter = Integer.MAX_VALUE;
            String initial_str = sc.nextLine();
            String letters_str = sc.nextLine();
            char[] initial = initial_str.toCharArray();
            char[] letters = letters_str.toCharArray();

            Arrays.sort(initial);
            Arrays.sort(letters);

            for (int i = 0; i < letters_str.length(); i++)
                set.add(letters_str.charAt(i));
            //int[] count = new int[initial.length];
            int length = letters_str.length();

            for (int i = 0; i < initial.length; i++) {
                //curr_letter-a --> z-letter
                //curr_letter-z --> a-letter
                int count = 0;

                int a_z = Math.abs(122 - initial[i]) + Math.abs(letters[k] - 97) + 1;
                int z_a = Math.abs(initial[i] - 97) + Math.abs(122 - letters[k]) + 1;
                count = Math.min(a_z, z_a);
                int to_letter = Math.abs(letters[k] - initial[i]);
                count = Math.min(count, to_letter);

                if (k + 1 < length) {
                    int count2 = 0;
                    int a_z2 = Math.abs(122 - initial[i]) + Math.abs(letters[k + 1] - 97);
                    int z_a2 = Math.abs(initial[i] - 97) + Math.abs(122 - letters[k + 1]);
                    count2 = Math.min(a_z2, z_a2);
                    int to_letter2 = Math.abs(letters[k + 1] - initial[i]);
                    count2 = Math.min(count2, to_letter2);
                    if (count2 <= count) {
                        k++;
                        count = count2;
                    }
                }

                cnt += count;
            }


            k = letters_str.length() - 1;
            for (int i = 0; i < initial.length; i++) {
                //curr_letter-a --> z-letter
                //curr_letter-z --> a-letter
                int count = 0;

                int a_z = Math.abs(122 - initial[i]) + Math.abs(letters[k] - 97) + 1;
                int z_a = Math.abs(initial[i] - 97) + Math.abs(122 - letters[k]) + 1;
                count = Math.min(a_z, z_a);
                int to_letter = Math.abs(letters[k] - initial[i]);
                count = Math.min(count, to_letter);

                if (k - 1 >= 0) {
                    int count2 = 0;
                    int a_z2 = Math.abs(122 - initial[i]) + Math.abs(letters[k - 1] - 97);
                    int z_a2 = Math.abs(initial[i] - 97) + Math.abs(122 - letters[k - 1]);
                    count2 = Math.min(a_z2, z_a2);
                    int to_letter2 = Math.abs(letters[k - 1] - initial[i]);
                    count2 = Math.min(count2, to_letter2);
                    if (count2 <= count) {
                        k--;
                        count = count2;
                    }
                }

                cnt2 += count;
            }

            str.append("Case #" + f + ": " + Math.min(cnt, cnt2) + "\n");
        }
        System.out.println(str);
    }
}
/*
8
abcd
a
pppp
p
pqrst
ou
abd
abd
aaaaaaaaaaaaaaab
aceg
abcd
z
wxyz
b
pqrst
oooou

 */