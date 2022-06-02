import java.util.Scanner;

class Solution {
    public static int[][] transpose(int[][] matrix) {
        int temp = 0;
        int[][] arr = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                arr[j][i] = matrix[i][j];
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = sc.nextInt();
        arr = transpose(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }

    }
}
/*
3 3
1 2 3
4 5 6
7 8 9


1 2
1 1


2 1
1
1


1 1
1


2 2
1 2
3 4

 */