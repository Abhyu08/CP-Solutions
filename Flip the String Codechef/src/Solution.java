import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testcases = Integer.parseInt(br.readLine());
            while (testcases-- > 0) {
                String a = br.readLine();
                String b = br.readLine();
                char[] arr1 = a.toCharArray();
                char[] arr2 = b.toCharArray();
                int count = 0;
                for (int i = 0, j; i < a.length(); i++) {
                    if (arr1[i] != arr2[i]) {
                        arr1[i] = arr2[i];
                        j = i + 2;
                        count++;
                        while (j < a.length()) {
                            if (arr1[j] != arr2[j])
                                arr1[j] = arr2[j];
                            else break;
                            j += 2;
                        }
                    }
                }
                System.out.println(count);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
