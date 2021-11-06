
public class Solution {
    public static void NQueens(int[][] board, int row, int col, int total_sum, int Knight_sum) {
        if (total_sum == Knight_sum) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
            System.exit(0);
        }
        //here calculate row and col where knight can go
        if (isSafeToPlace(board, row, col)) {
            //do
            board[row][col] = 1;
            //recur
            NQueens(board, //row and col , total_sum, Knight_sum + 1);
                    //undo
                    board[row][col] = 0;
        }
        NQueens(board, //rows and col , total_sum, Knight_sum); // if current [row,col] ! possible then try next (j++)
    }

    private static boolean isSafeToPlace(int[][] board, int row, int col) {
        int r = row - 1;
        //vertically check
        while (r >= 0) {
            if (board[r][col] == 1)
                return false;
            r--;
        }
        //horizontally
        int c = col - 1;
        while (c >= 0) {
            if (board[row][c] == 1)
                return false;
            c--;
        }
        //diagonally left
        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 1)
                return false;
            r--;
            c--;
        }
        //diagonally right
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board.length) {
            if (board[r][c] == 1)
                return false;
            r--;
            c++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[4][4];
        NQueens(board, 0, 0, 16, 0);
    }
}
