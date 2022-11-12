import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);

        int count = 0;
        int[][] matrix = new int[10][10];
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
                matrix[i][j] = sc.nextInt();

        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++){
                if(i == j)
                    count+=matrix[i][j];
            }

        System.out.println(count);
    }
}

/*
1 2 3 4 5 6 7 8 9 10
1 1 3 4 5 6 7 8 9 10
1 2 1 4 5 6 7 8 9 10
1 2 3 1 5 6 7 8 9 10
1 2 3 4 1 6 7 8 9 10
1 2 3 4 5 1 7 8 9 10
1 2 3 4 5 6 1 8 9 10
1 2 3 4 5 6 7 1 9 10
1 2 3 4 5 6 7 8 1 10
1 2 3 4 5 6 7 8 9 1

 */