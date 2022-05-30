import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static int longestConsecutive(int[] nums) {
        int maxCount = 1, len = nums.length;
        if (len == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++)
            set.add(nums[i]);

        for (int i = 0, curr_max = 0; i < len; i++, curr_max = 0) {
            if (set.contains(nums[i] - 1)) continue;
            for (int j = nums[i]; j <= nums[i] + len; j++) {
                if (!set.contains(j)) break;
                curr_max++;
            }
            maxCount = Math.max(maxCount, curr_max);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();

        System.out.println(longestConsecutive(arr));

    }
}
/*
6
100 4 200 1 3 2


10
0 3 7 2 5 8 4 6 0 1

 */