import java.util.Scanner;

class Solution {

    //1.Recursive
    public int binarySearch(int[] nums, int target, int left, int right, int mid) {
        if (left > right) {
            return 0;
        } else if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            mid = binarySearch(nums, target, mid + 1, right, (left + right) / 2);
        } else {
            mid = binarySearch(nums, target, left, mid - 1, (left + right) / 2);
        }
        return nums[mid] >= target ? mid : mid + 1;
    }


    //2/Iterative
    public int binarySearch2(int[] nums, int target) {
        int mid = nums.length / 2;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[mid] != target) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                mid = (left + right) / 2;
            } else {
                return mid;
            }
        }
        if (nums[mid] > target)
            return mid;
        else return mid + 1;
    }


    public int searchInsert(int[] nums, int target) {
        int mid = binarySearch(nums, target, 0, nums.length - 1, (0 + nums.length) / 2);
        //return mid;
        return nums[mid] >= target ? mid : mid + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Solution sl = new Solution();
        System.out.println(sl.searchInsert(arr, target));
    }
}
/*
4
1 3 5 6
2

4
1 3 5 7
8

4
1 3 5 7
6

4
1 3 5 7
0

4
1 3 5 7
4

--
4
1 3 5 7
1

4
1 3 5 7
3

4
1 3 5 7
5

4
1 3 5 7
7

 */