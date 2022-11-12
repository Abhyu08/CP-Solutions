import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(new Main().noOfWays(n));

    }

    public int noOfWays(int  input1){
        return (int)(countWays(input1) % 1000000007);
    }

    public long countWays(int input1){

            if (input1<0)
                return 0;
            if (input1==0)
                return 1;

            return countWays(input1-1) +
                    countWays(input1-2);
    }


}
/*
3
~3

4
~5
 */