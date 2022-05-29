import java.util.Scanner;

class Solution {

    //Brute Force Approach
    /*
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int index = len-1;
        if (len == 1 && gas[0] - cost[0] >= 0) return 0;
        else if(len == 1 && gas[0] - cost[0] < 0) return -1;
        for (int i = len-1; i >=0 ; i--, index = i) {
            if (gas[i] - cost[i] <= 0) continue;
            int curr_index = i, tank = 0, cnt = 0;
            while ((tank > 0 || cnt == 0) && cnt < len) {
                tank += gas[curr_index] - cost[curr_index];
                curr_index = (curr_index + 1) % len;
                cnt++;
            }
            if (cnt == len && tank >= 0) return index;
        }
        return -1;
    }
    */
    //Optimised Approach
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int tank = 0, index = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            int consume = gas[i] - cost[i];
            tank += consume;
            if (tank < 0) {
                tank = 0;
                index = i + 1;
            }
            sum += consume;
        }
        return sum < 0 ? -1 : index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] gas = new int[no];
        int[] cost = new int[no];

        for (int i = 0; i < no; i++)
            gas[i] = sc.nextInt();
        for (int i = 0; i < no; i++)
            cost[i] = sc.nextInt();

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
/*
5
1 2 3 4 5
3 4 5 1 2

3
2 3 4
3 4 3

1
2
2

5
4 5 3 1 4
5 4 3 4 2


 */