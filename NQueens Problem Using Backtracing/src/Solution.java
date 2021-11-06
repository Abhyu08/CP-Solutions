
public class Solution {
    public static void NQueens(int[][] matrix, int row, int col, int total_q, int Q_placed, String str) {
        if (total_q == Q_placed) {
            System.out.println(str);
            return;
        }

        if (col == matrix.length || row == matrix.length)
            return;

        if (isSafeToPlace(matrix, row, col)) {
            //do
            matrix[row][col] = 1;
            //recur
            NQueens(matrix, row + 1, 0, total_q, Q_placed + 1, str + "[" + row + " , " + col + "] ");
            //undo
            matrix[row][col] = 0;
        }
        NQueens(matrix, row, col + 1, total_q, Q_placed, str); // if current [row,col] ! possible then try next (j++)
    }

    private static boolean isSafeToPlace(int[][] matrix, int row, int col) {
        int r = row - 1;
        //vertically check
        while (r >= 0) {
            if (matrix[r][col] == 1)
                return false;
            r--;
        }
        //horizontally
        int c = col - 1;
        while (c >= 0) {
            if (matrix[row][c] == 1)
                return false;
            c--;
        }
        //diagonally left
        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (matrix[r][c] == 1)
                return false;
            r--;
            c--;
        }
        //diagonally right
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < matrix.length) {
            if (matrix[r][c] == 1)
                return false;
            r--;
            c++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        NQueens(matrix, 0, 0, 4, 0, "");
    }
}
