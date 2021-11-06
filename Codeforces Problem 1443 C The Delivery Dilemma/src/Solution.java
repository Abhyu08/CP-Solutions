import java.util.*;

public class Solution {

    /* duplicate  keys are  being deleted in hmap */
    /* use another class and use array of objects and then use comparator.. */
    //use online delivery after n value

    static Map<Integer, Integer> hmap = new HashMap<>();

    // Function to sort map by Key
    public static void sortbykey() {
        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(hmap.keySet());

        Collections.sort(sortedKeys);
        for (int i : sortedKeys) {
            System.out.println("KEY = " + i + "\tValue = " + hmap.get(i));
        }
        int max = 0, temp;
        int min = Integer.MAX_VALUE;
        int[] sum = new int[sortedKeys.size() + 1];
        for (int x = sortedKeys.size() - 1; x >= 0; x--) {
            sum[x] = sum[x + 1] + hmap.get(sortedKeys.get(x));

            if (x != 0)
                temp = sortedKeys.get(x - 1);
            else temp = Integer.MIN_VALUE;
            max = Math.max(sum[x], temp);
            min = Math.min(min, max);
        }
        temp = sortedKeys.get(sortedKeys.size() - 1);
        hmap.clear();
        System.out.println(Math.min(min, temp));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            int[] order = new int[n];
            int[] self_time = new int[n];
            for (int i = 0; i < n; i++)
                order[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                self_time[i] = sc.nextInt();

            for (int i = 0; i < n; i++)
                hmap.put(order[i], self_time[i]);
            sortbykey();
        }
    }
}