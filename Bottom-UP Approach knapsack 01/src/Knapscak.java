public class Knapscak {


    public static int Knapsack(int[] val, int[] wt, int W, int n) {
        int matrix[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                if (W >= wt[i - 1]) 
                    matrix[i][j] = Math.max(
                            val[i - 1] + matrix[i - 1][W - wt[i - 1]], matrix[i - 1][W]
                    );
                else matrix[i][j] = matrix[i - 1][W];

            }
        return matrix[n][W];
    }

    public static void main(String[] args) {
        int[] val = new int[]{};
        int[] wt = new int[]{};
        int W = 0;
        int n = val.length;
        int result = Knapsack(val, wt, W, n);
        System.out.println(result);
    }
}
