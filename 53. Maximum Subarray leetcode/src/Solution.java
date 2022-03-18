import java.util.Scanner;
import java.util.Stack;

/*
1 . Using kadane algo
2 . Using brute force
3 . Using divide and conquer -->
 */

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Solution.maxSubArray(arr)); //Using (3)
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        return Divide_and_Conquer(nums, 0, len - 1, 0);
    }

    public static int Divide_and_Conquer(int[] nums, int left, int right, int max_arr) {
        if ((right - left) == 1) {
            max_arr = Math.max(nums[right], 0);
            return max_arr;
        } else if ((right - left) == 2) {
            max_arr = Math.max(nums[right] + nums[left], 0);
            max_arr = Math.max(max_arr, Math.max(nums[right], nums[left]));
            return max_arr;
        } else {
            int mid = (left + right) / 2;
            int left1 = Divide_and_Conquer();
            int right2 = Divide_and_Conquer();

        }
    }
}
