import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Q.What are the Minimum Initial Points to Reach Destination ?
--

We can move across a cell only if we have positive points ( > 0 ). Whenever we pass through a cell, points in that cell are added to our overall points.
We need to find minimum initial points to reach cell (m, n) from (1, 1) by following these certain set of rules :
From a cell (i, j) we can move to (i+j, j) or (i, j+i).
We have to reach at (m, n) with minimum positive points i.e., > 0.

input: 3 2
Output : 2
Explanation :
(1,1) -> (1,2) -> (3, 2)
From a cell (i, j) we can move to (i+j, j) or (i, j+i).

input: 2 2
Output : -1
Explanation :
If we cannot reach at position with the rules mentioned then return -1
 */
class UserMainCode {
    static List<Integer> list = new ArrayList<>();

    public int minSteps(int input1, int input2) {

        int x = 1, y = 1;
        int result = Integer.MAX_VALUE;

        countSteps(x,y,input1,input2,0);

        for (int i = 0; i < list.size(); i++) {
            if(result > list.get(i)){
                result = list.get(i);
            }
        }

        return  (result == Integer.MAX_VALUE ? -1 : result);
    }

    public static int countSteps(int x, int y, int input1, int input2, int count) {
        if (x == input1 && y == input2) {
            list.add(count);
            return count;
        } else if (x > input1 || y > input2) {
            return Integer.MAX_VALUE;
        } else {
            if (x != input1 && y != input2) {
                count = Math.min(countSteps(x + y, y, input1, input2, count + 1), count);
                count = Math.min(countSteps(x, y + x, input1, input2, count + 1), count);
            } else if (x == input1 && y != input2) {
                count = Math.min(countSteps(x, y + x, input1, input2, count + 1), count);
            } else {
                count = Math.min(countSteps(x + y, y, input1, input2, count + 1), count);
            }
            return count;
        }
    }
}

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        UserMainCode ob = new UserMainCode();
        System.out.println(ob.minSteps(m, n));
    }
}
