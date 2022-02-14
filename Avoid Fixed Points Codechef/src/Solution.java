import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            LinkedList<Integer> ll = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();
            int n = sc.nextInt();
            int cnt = 0, first = -1, fwd = 0;
            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                ll.add(temp);
                if (temp == i + 1) {
                    cnt++;
                    if (first == -1)
                        first = i;
                }
            }
            first = Math.max(first, 0);
            int p = -1, cost = 0;
            for (int var : ll) {

                p++;
                if (p < first) {
                    list.add(var);
                } else if (var == p + 1) {
                    list.add(n + 1);
                    n++;
                    p++;
                    cost++;
                }
                list.add(var);
            }
//            for (int var : list)
//                System.out.print(var + " ");
//            System.out.println("cnt:" + cnt);
            str.append(cost + "\n");
        }
        System.out.println(str);
    }
}
