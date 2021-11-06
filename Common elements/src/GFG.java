import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();

            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];

            for (int i = 0; i < n1; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < n2; i++) {
                B[i] = sc.nextInt();
            }
            for (int i = 0; i < n3; i++) {
                C[i] = sc.nextInt();
            }

            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0) {
                System.out.print(-1);
            } else {
                for (int i = 0; i < res.size(); i++) {
                    System.out.print(res.get(i) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
Negative Value in Index.....
 */
class Solution {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        // code here
        int[] positive = new int[10000001];
        int[] minus = new int[10000001];

        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            if (A[i] >= 0)
                positive[A[i]] = 1;
            else {
//                A[i] *= -1;
                minus[A[i] * -1] = 1;
            }
        }

        for (int i = 0; i < n2; i++) {
            if (B[i] >= 0) {
                if (positive[B[i]] == 1)
                    positive[B[i]] = 2;
            } else {
//                B[i] *= -1;
                if (minus[B[i] * -1] == 1)
                    minus[B[i] * -1] = 2;
            }
        }

        for (int i = 0; i < n3; i++) {
            if (C[i] >= 0) {
                if (positive[C[i]] + 1 == 3) {
                    positive[C[i]] = -1;
                    sol.add(C[i]);
                }
            } else {
//                C[i] *= -1;
                if (minus[C[i] * -1] + 1 == 3) {
                    minus[C[i] * -1] = -1;
                    sol.add(C[i]);
                }
            }
        }
        return sol;
    }
}
/*
6 5 8
1 5 10 20 40 -80
6 7 20 -80 100
3 4 15 20 30 70 -80 120

3 3 3
3 3 3
3 3 3
3 3 3
 */