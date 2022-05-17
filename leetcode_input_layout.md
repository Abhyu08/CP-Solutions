```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        return intervals;
    }

    /*Driver Code  leetcode input to a generalized input */
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] newinterval = br.readLine().split(",");
        int[] newInterval = new int[2];
        newInterval[0] = Integer.parseInt(newinterval[0].replace("[", ""));
        newInterval[1] = Integer.parseInt(newinterval[1].replace("]", ""));
        input = input.substring(1, input.length() - 1);
        String[] input1 = input.split(",");
        int[][] final_input = new int[input1.length/2][2];
        for (int i = 0, index = 0; i < input1.length; i+=2) {
            final_input[index][0] = Integer.parseInt(input1[i].replace("[", "").replace("]", ""));
            final_input[index++][1] = Integer.parseInt(input1[i + 1].replace("[", "").replace("]", ""));

        }
      
        //passing arguments in required manner to function..
        int[][] result = Solution.insert(final_input, newInterval);
        System.out.println("Solution : ");
        for (int[] ints : result) {
            System.out.println(ints[0] + " " + ints[1]);
        }
        br.close();
    }
}
```
```
/*
[[1,3],[6,9]]
[2,5]

~
1 3
6 9
2 5

[[1,2],[3,5],[6,7],[8,10],[12,16]]
[4,8]

~
1 2
3 5
6 7
8 10
12 16
4 8

 */
 ```
