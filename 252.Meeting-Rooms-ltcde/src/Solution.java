import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {

    public static boolean getMeetingConflict(int[][] meetings) {
        boolean result = true;
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0])); //2d-array sorted based on 1st column
        for (int i = 1; i < meetings.length; i++)
            if (meetings[i][0] < meetings[i - 1][1]) return false;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[][] arr = new int[no][2];
        for (int i = 0; i < no; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(getMeetingConflict(arr));
    }

}
/*
3
0 30
5 10
15 20

3
7 10
2 4
10 20

 */
