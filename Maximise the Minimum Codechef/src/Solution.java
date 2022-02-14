import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();
            for (int i = 0; i < n; i++) {
                setA.add(sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                setB.add(sc.nextInt());
            }
            int[] A = new int[setA.size()];
            int[] B = new int[setB.size()];
            int p = 0, q = 0;
            for (int val : setA) {
                A[p++] = val;
            }
            for (int val : setB) {
                B[q++] = val;
            }
            int countA = 0;
            int countB = 0;
            for (int i=n-1; i >= 0 && k > 0; i--, k--) {
                countA += A[--p];
                countB += B[--q];
            }
            str.append(Math.min(countA, countB) + "\n");
        }
        System.out.println(str);
    }
}
/*
1
5 3
4 2 3 1 4
3 2 5 5 1

 */