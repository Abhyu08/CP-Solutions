import java.util.*;

public class leet {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = new Solution().lengthOfLIS(arr);
        System.out.println(result);
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.size() == 0)
                list.add(nums[i]);
            else if (list.contains(nums[i]))
                continue;
            else {
                int index = Collections.binarySearch(list, nums[i]) * -1;
                if (index >= list.size())
                    list.add(nums[i]);
                else if (index > 0) {
                    list.set(index - 1, nums[i]);
                }
                System.out.println(index + " var : " + nums[i]);
            }
        }
//        if (list.size() >= 2) {
//            if (list.get(list.size() - 1) < list.get(list.size() - 2))
//                list.remove(list.size() - 2);
//        }

        for (int var : list)
            System.out.println(var);
        return -1;
    }

}
/*
8
10 9 2 5 3 7 101 18 ->4
6
0 1 0 3 2 3     ->4 //
7
7 7 7 7 7 7 7   ->1
1
0               ->1
6
4 10 4 3 8 9    ->3
9
1 3 6 7 9 4 10 5 6 -> 6
 */
































/* O(N^2) Solution:
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] counts = new int[l];
        int max = 1, count = 1;
        counts[0] = 1;
        for (int i = 1; i < l; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] < nums[i]) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
                --j;
            }
            counts[i] = Math.max(counts[i], 1);
            max = Math.max(max, counts[i]);
        }
        return max;
    }
 */