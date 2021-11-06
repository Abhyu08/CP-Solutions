import java.util.*;

public class Main {
    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            Scanner sc = new Scanner(System.in);
            //No of Groups
            int no = Integer.parseInt(sc.nextLine());
            int[][] arr = new int[no][2];
            //Input
            for (int i = 0; i < no; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            int[][] result = merge(arr);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i][0] + " , " + result[i][1]);
            }
        }

    }
    //2 Functions 1.Forwards 2.Backwards || Return Math.min(Forwards , Backwards );

    public static int[][] merge(int[][] intervals) {
        //Reverse an array
        int[][] intervals_bk = get_arr_backwards(intervals);
        int[][] intervals_sorted = intervals;
        //Sorting intervals_sorted array
        Arrays.sort(intervals_sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        //Sorting ends
        int[][] result1 = merge_intervals(intervals);
        int[][] result2 = merge_intervals(intervals_bk);
        int[][] result3 = merge_intervals(intervals_sorted);
        int[][] result;
        if (result1.length > result2.length)
            if (result3.length >= result2.length)
                result = result2;
            else
                result = result3;
        else if (result3.length >= result1.length)
            result = result1;
        else
            result = result3;

        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        return result;
    }

    public static int[][] merge_intervals(int[][] intervals) {

        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0, index = 0, k = -1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end && start <= intervals[i][1]) {
                if (intervals[i][0] < start)
                    start = intervals[i][0];
                count++;
                if (intervals[i][1] >= end)
                    end = intervals[i][1];
                intervals[i][0] = -1;
                intervals[i][1] = end;
            }
            if ((intervals[i][0] > end || start > intervals[i][1]) || (i + 1 >= intervals.length && intervals[i][0] == -1)) {
                intervals[index][0] = start;
                intervals[index][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
                index = i;
            }
        }
        int[][] merge_arr = new int[intervals.length - count][2];
        //Return Updated merge array
        //ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == -1)
                continue;
            //x.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
            merge_arr[++k][0] = intervals[i][0];
            merge_arr[k][1] = intervals[i][1];
        }
        return merge_arr;
    }

    public static int[][] get_arr_backwards(int[][] intervals) {
        int[][] intervals_bk = new int[intervals.length][2];
        for (int i = intervals.length - 1, j = 0; i >= 0; i--, j++) {
            intervals_bk[j][0] = intervals[i][0];
            intervals_bk[j][1] = intervals[i][1];
        }
        return intervals_bk;
    }

}

/*
-----
4
1 3
2 6
8 10
15 18

2
1 4
4 5

2
1 4
2 3

2
1 4
0 4

2
1 4
2 3

2
1 4
0 0

5
2 3
4 5
6 7
8 9
1 10

5
2 5
1 10
3 4
2 4
8 11

5
2 3
5 5
2 2
3 4
3 4
 */
/*
    public static int[][] merge(int[][] intervals) {
        int current = intervals[0][1];
        int strt = intervals[0][0];
        int k = 0, count = 0, index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if ((current >= intervals[i][0] && current <= intervals[i][1]) || (strt >= intervals[i][0] && strt <= intervals[i][1])) {
                if (intervals[index][0] > intervals[i][0])
                    intervals[index][0] = intervals[i][0];

                if (intervals[i][1] < intervals[i - 1][1])
                    intervals[i][1] = intervals[i - 1][1];

                intervals[i][0] = -1;
                count++;
            } else {
                current = intervals[i][1];
                strt = intervals[i][0];
                index = i;
            }
        }
        int[][] merge_int = new int[intervals.length - count][2];
        merge_int[0][0] = intervals[0][0];
        merge_int[0][1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] != -1) {
                merge_int[++k][0] = intervals[i][0];
                merge_int[k][1] = intervals[i][1];
            } else
                merge_int[k][1] = intervals[i][1];
        }
        return intervals;
    }
 */
