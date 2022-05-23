import java.util.*;

//https://www.codechef.com/problems/MAKEZERO
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder result = new StringBuilder();

        while (testcase-- > 0) {
            int no = sc.nextInt();
            int[] arr = new int[no];
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < no; i++) {
                arr[i] = sc.nextInt();
            }
            int operations = 0;
            int zeros = 0;
            for (int power = 30; power >= 0 && zeros != no; power--) {
                int minus = (int) Math.pow(2, power);
                int count = 0;
                zeros = 0;
                for (int i = 0; i < no; i++) {
                    if (minus <= arr[i]) {
                        arr[i] -= minus;
                        count = 1;
                    }
                    if (arr[i] == 0) zeros++;
                }
                operations += count;
            }
            result.append(operations).append("\n");
        }
        System.out.println(result);
    }
}
/*
4
3
2 2 2
4
2 2 2 4
2
0 0
3
1 2 3

~
1
2
0
2

1
3
0 2 3

 */