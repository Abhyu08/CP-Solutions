import java.util.Scanner;

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int multiply = 1;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                multiply *= nums[i];
            } else cnt++;
        }
        if (cnt > 1) {
            return new int[nums.length];
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0 && cnt == 0) {
                    nums[i] = (int) multiply / nums[i];
                } else if (cnt == 1 && nums[i] != 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = multiply;
                }
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = new Solution().productExceptSelf(arr);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/*
4
1 2 3 4

~
[24,12,8,6]

5
-1 1 0 -3 3

~
[0,0,9,0,0]

 */