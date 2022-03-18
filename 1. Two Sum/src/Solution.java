import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] result = Solution.twoSum(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];
            if (set.containsKey(diff) && set.get(diff) != i) {
                result[0] = i;
                result[1] = set.get(diff);
                break;
            }

        }
        if (result[0] > result[1]) {
            int temp = result[0];
            result[0] = result[1];
            result[1] = result[0];
        }
        return result;
    }
}
/*
4
2 7 11 15
9

3
3 2 4
6

2
3 3
6

5
-1 -2 -3 -4 -5
-8

5
3 2 95 4 -3
92

 */