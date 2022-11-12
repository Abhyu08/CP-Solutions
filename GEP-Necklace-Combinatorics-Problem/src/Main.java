import java.util.Scanner;

public class Main {

    public static int countCombinations = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        int input3 = sc.nextInt();
        find_Sol(input1, input2, input3);
        System.out.println(countCombinations - 1);
    }

    public static int find_Sol(int input1, int input2, int input3) {
        return countCombinations(input1, 0, input2, input3,  "");
    }

    public static int countCombinations(int limit, int currentLength, int start, int end, String str) {
//        System.out.println(str);  //to see/check all possible scenario's
        countCombinations++;
        if (currentLength >= limit)
            return 0;
        else {
            for (int i = start; i <= end; i++)
                countCombinations(limit, currentLength + 1, i, end, str + i);
            return 0;
        }
    }
}
/*
TESTCASES :

1
4
5

~ 2

2
8
9

~5

3
6
9

~ 34
 */