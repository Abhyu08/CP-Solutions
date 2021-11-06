
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] max_diff = new Solution().getMinDiff(arr, n, k);
            for (int i = 0; i < n; i++) {
                System.out.print(max_diff[i] + " ");
            }
        }
    }
}

class Solution {
    int[] getMinDiff(int[] arr, int n, int k) {
        int max = -1, min = 100000001, minus = 0, plus = 0, var = 0, diff = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        arr[0] += k;
        var = arr[0];
        for (int i = 1; i < n; i++) {
            minus = arr[i] - k;
            plus = arr[i] + k;

            diff = Math.abs(arr[i] - var);
            if (diff <= Math.min(minus, plus)) {
                continue;
            } else {
                if (minus < 0) {
                    arr[i] = arr[i] + k;
                }else{
                    minus = Math.abs(Math.abs(minus) - Math.abs(var));
                    plus = Math.abs(Math.abs(plus) - Math.abs(var));

                    if (minus <= plus) {
                        arr[i] = arr[i] - k;
                    } else {
                        arr[i] = arr[i] + k;
                    }
                }
            }
        }
        //Arrays.sort(arr);
        return arr;
    }
}
