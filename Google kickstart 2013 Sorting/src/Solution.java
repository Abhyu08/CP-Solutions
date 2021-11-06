import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        for (int t = 1; t <= testcase; t++) {
            int temp;
            int n = sc.nextInt();
            List<Integer> even = new ArrayList();
            List<Integer> odd = new ArrayList();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                temp = arr[i] = sc.nextInt();
                if (temp % 2 == 0)
                    even.add(temp);
                else
                    odd.add(temp);
            }
            Collections.sort(even);
            Collections.sort(odd);
            int e_size = even.size() - 1;
            int o_size = 0;
            str.append("Case #" + t + ": ");
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 0) {
                    str.append(even.get(e_size) + " ");
                    e_size--;
                } else {
                    str.append(odd.get(o_size) + " ");
                    o_size++;
                }
            }
            str.append("\n");
        }
        System.out.println(str);
    }
}
