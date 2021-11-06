import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {
            int no = sc.nextInt();
            int[] arr = new int[no];
            for (int i = 0; i < no; i++) {
                arr[i] = sc.nextInt();
            }
            nextPermutation(arr);
        }
    }

    public static void nextPermutation(int[] nums) {
        int temp = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
