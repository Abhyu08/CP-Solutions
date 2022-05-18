import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// Q. https://leetcode.com/problems/insert-interval/

// cases. https://discord.com/channels/476793160471674900/694950332719038544/976344842806394962

public class Solution {

//Original Approach Lengthy Approach
/*
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int index = 0;
        boolean flag = true;
        int x = 0, y = 0;
        int len = intervals.length;
        if (newInterval.length == 0) {
            return intervals;
        } else {
            x = newInterval[0];
            y = newInterval[1];
        }
        int[][] newSet = new int[intervals.length + 1][2];

        if (intervals.length == 0) {
            int[][] newintervals = new int[1][2];
            newintervals[0][0] = newInterval[0];
            newintervals[0][1] = newInterval[1];
            return newintervals;
        }
        if (x < intervals[0][0] && y < intervals[0][0]) {
            newSet[index][0] = x;
            newSet[index++][1] = y;
            flag = false;

        } else if (x < intervals[0][0] && y <= intervals[0][1]) {
            intervals[0][0] = x;
            y = intervals[0][1];
        } else if (x < intervals[0][0] && y > intervals[0][1]) {
            intervals[0][0] = x;
        }

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][0] <= x && intervals[i][1] >= x && flag) {
                if (intervals[i][0] <= x) {
                    newSet[index][0] = intervals[i][0];
                }

                while (y >= intervals[i][0] && y >= intervals[i][1]) {
                    i++;
                    if (i >= intervals.length) {
                        break;
                    }
                }
                if (i == intervals.length) {
                    newSet[index++][1] = y;

                } else if (intervals[i][0] > y) {
                    newSet[index++][1] = y;
                    i--;
                } else {
                    newSet[index++][1] = intervals[i][1];
                }
                flag = false;

            } else if (x < intervals[i][0] && y < intervals[i][0] && flag) {
                newSet[index][0] = x;
                newSet[index++][1] = y;
                flag = false;
                i--;
            } else if (x <= intervals[i][0] && y <= intervals[i][1] && flag) {
                newSet[index][0] = x;
                newSet[index++][1] = intervals[i][1];
                flag = false;
            } else if (x < intervals[i][0] && y > intervals[i][1] && flag) {
                intervals[i][0] = x;
                i--;
            } else {
                newSet[index][0] = intervals[i][0];
                newSet[index++][1] = intervals[i][1];
            }
        }

        if (y > newSet[index - 1][1]) {

            newSet[index][0] = x;
            newSet[index++][1] = y;
        }


        return newArr(newSet, index);
    }

    public static int[][] newArr(int[][] old_arr, int len) {

        int newarr[][] = new int[len][2];
        for (int i = 0; i < len; i++) {
            newarr[i][0] = old_arr[i][0];
            newarr[i][1] = old_arr[i][1];
        }
        return newarr;
    }
*/

//Optimistic Approach.
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();

        int index = 0, n = intervals.length;

        //1.To add all non-overlapping intervals..
        while (index < n && intervals[index][1] < newInterval[0]) {
            list.add(intervals[index++]);
        }
        //2.To insert new overlapping interval in the present sequence
        while (index < n && intervals[index][1] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        list.add(newInterval); //here condition satisfy where newInterval is to be added at last.
        //3.To add remaining non-overlapping intervals...
        while (index < n) {
            list.add(intervals[index++]);
        }

        return list.toArray(new int[list.size()][2]);
    }

    //Driver Code // leetcode input to generalized input
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //Inputted from file..
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\user_name\\Desktop\\input_file.txt"));
        String input = new String();
        while ((input = br.readLine()) != null) {

            //        String input = br.readLine();
            String[] newinterval = br.readLine().split(",");


            int[] newInterval = new int[2];
            input = input.substring(1, input.length() - 1);
            String[] input1 = input.split(",");
            newInterval[0] = Integer.parseInt(newinterval[0].replace("[", ""));
            newInterval[1] = Integer.parseInt(newinterval[1].replace("]", ""));
            int[][] final_input = new int[input1.length / 2][2];

            for (int i = 0, index = 0; i < input1.length; i += 2) {
                final_input[index][0] = Integer.parseInt(input1[i].replace("[", "").replace("]", ""));
                final_input[index++][1] = Integer.parseInt(input1[i + 1].replace("[", "").replace("]", ""));

            }
            int[][] result = Solution.insert(final_input, newInterval);
            for (int[] ints : result) {
                System.out.println(ints[0] + " " + ints[1]);
            }
            System.out.println("-----------------------------------------");
        }

        br.close();
    }
}
/*
[[1,3],[6,9]]
[2,5]

~
1 5
6 9

[[1,2],[3,5],[6,7],[8,10],[12,16]]
[4,8]

~
1 2
3 10
12 16


[[2,2],[3,5],[6,7],[8,10],[12,16]]
[1,2]

~
1 2
3 5
6 7
8 10
12 16

[[2,2],[3,5],[6,7],[8,10],[12,16]]
[1,1]

~
1 1
2 2
3 5
6 7
8 10
12 16

[[2,2],[3,5],[6,7],[8,10],[12,16]]
[17,19]

~
2 2
3 5
6 7
8 10
12 16
17 19

[[2,2],[3,5],[6,7],[8,10],[12,16]]
[16,19]

~
2 2
3 5
6 7
8 10
12 19


[[1,5]]
[2,7]

~
1 7

[[1,5]]
[0,3]

~
0 5

[[1,5]]
[0,1]

~
0 5

[[1,5]]
[0,6]

~
0 6

[[0,5],[9,12]]
[7,16]

~
0 5
7 16

[[0,5],[9,12]]
[7,11]

~
0 5
7 12

[[0,5],[9,12]]
[9,13]

~
0 5
9 13

[[3,5],[12,15]]
[6,6]

~
3 5
6 6
12 15

 */


/* Testcases console :
[[1,3],[6,9]]
[2,5]
[[1,2],[3,5],[6,7],[8,10],[12,16]]
[4,8]
[[2,2],[3,5],[6,7],[8,10],[12,16]]
[1,2]
[[2,2],[3,5],[6,7],[8,10],[12,16]]
[1,1]
[[2,2],[3,5],[6,7],[8,10],[12,16]]
[17,19]
[[2,2],[3,5],[6,7],[8,10],[12,16]]
[16,19]
[[1,5]]
[2,7]
[[1,5]]
[0,3]
[[1,5]]
[0,1]
[[1,5]]
[0,6]
[[0,5],[9,12]]
[7,16]
[[0,5],[9,12]]
[9,13]
[[0,5],[9,12]]
[7,11]
[[3,5],[12,15]]
[6,6]
 */


















