import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();
        int[][] arr1 = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        int row2 = sc.nextInt();
        int col2 = sc.nextInt();
        int[][] arr2 = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        int[][] result = matrix_multiplication(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[1].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

//            1) can u find a substring in a string without using readymade functions?

    public static String getSubstring(int start_index, int end_index, String str) {
        String substr = new String();
        for (int i = start_index; i < end_index; i++)
            substr += str.charAt(i);
        return substr;
    }


    //            2)Matrix multiplication?
    public static int[][] matrix_multiplication(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[1].length];
        if (arr1[1].length != arr2.length){
            System.out.println("NOT POSSIBLE");
            return result;
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[1].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
//                    System.out.print(arr1[i][k] + "  ");
//                    System.out.println(arr2[k][j]);
                }
                result[i][j] = sum;
            }
        }

        return result;

    }

//            3) how many ways u can swap a number?


}
/*
2 2
3 4
2 1
2 2
1 5
3 7

3 2
1 2
3 4
5 6
2 4
7 8 9 10
11 12 13 14


 */