import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        long product = 1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            product *= arr[i];
        }
        int count = 0;
        List<Integer> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(product); i++) {
            if (product % i == 0) {
                left.add(i);
                right.add(product / i);
            }
        }
//        //printing
//        for (int i = 0; i < left.size(); i++)
//            System.out.println(left.get(i) + " " + right.get(i));
//        //printing end
        count += left.size();
        for (int i = 1; i <= Math.sqrt(product); i++) {
            if (Math.pow(i, k) > product) {
                break;
            } else if (Math.pow(i, k) == product) {
                count++;
                break;
            }
        }
        int size = k - 2;
        if (size >= 1) {
            for (int i = 0; i < left.size(); i++) {
                if (left.get(i) <= 3 && left.get(i) % 2 != 0)
                    continue;
                int cnt = left.get(i) / 2 - 1;
                //System.out.println(left.get(i) + "->" + cnt + " size = " + size);
                if (size >= cnt)
                    count += cnt;
                else count += size;
                //System.out.println("count = " + count);
            }
        }

        System.out.println(count);

    }
}
/*
2 4
2 3
2 3
12 12
2 3
4 16
 */
