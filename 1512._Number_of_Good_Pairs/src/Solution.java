import java.util.Arrays;
import java.util.Scanner;
// src : https://leetcode.com/problems/number-of-good-pairs/
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();
        int result = Solution.numIdenticalPairs(arr);
        System.out.println(result);

    }

    public static int numIdenticalPairs(int[] nums) {
        int result = 0, count = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (i == nums.length - 1) {
                    result += ((count * count) - count) / 2;
                }
            } else {
                result += ((count * count) - count) / 2;
                count = 1;
            }
        }
        return result;
    }
}
/*
Testcases :
6
1 2 3 1 1 3

4
1 1 1 1

3
1 2 3

 */