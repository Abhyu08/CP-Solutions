/*
```
Q. Closest Numbers Hackerank:

        To determine which pair or pairs of elements have the smallest absolute difference between them.
        arr = [5,4,3,2,1]
        Sorted arr = [1,2,3,4,5]
        The minimum difference is 1 here.
        pairs : [(1,2), (2,3) , (3,4) , (4,5) ]

        O/P : 1 2 2 3 3 4 4 5

        I/P:
        4
        5 4 3 2
        O/P:
        2 3 3 4 4 5

        Explanation :
        Here, the minimum difference is 1. Valid pairs are (2, 3), (3, 4), and (4, 5).
```
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



class Solution {

    public static int getMinValue(List<Integer> nums) {
        int minimum_value = Integer.MAX_VALUE;

        for (int i = 1; i < nums.size(); i++)
            minimum_value = Math.min(minimum_value, nums.get(i) - nums.get(i - 1));


        return minimum_value;
    }

    public static void closestNumbers(List<Integer> nums) {

        Collections.sort(nums);
        int minimum_value = getMinValue(nums);
        int no_of_pairs = 0, index = 0;
        int[][] pairs = new int[nums.size()][2];


        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) - nums.get(i - 1) == minimum_value) {
                pairs[index][0] = nums.get(i - 1);
                pairs[index++][1] = nums.get(i);
            }
        }

        System.out.println("No of Pairs : " + index);
        for (int i = 0; i < index; i++)
            System.out.println(pairs[i][0] + " " + pairs[i][1]);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int no = Integer.parseInt(br.readLine().trim());
        String[] input = (br.readLine().split(" "));
        List<Integer> list = new ArrayList<>();

        for (String var : input)
            list.add(Integer.parseInt(var));

        Solution.closestNumbers(list);

    }
}
/*
Sample Testcases :
10
-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854

O/P : -20 30

12
-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470

O/P : -520 -470 -20 30


4
5 4 3 2

O/P : 2 3 3 4 4 5
 */