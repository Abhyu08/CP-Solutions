import java.util.Scanner;

class Solution {
    public static int[] sortColors(int[] nums) {
        int one = 0;
        int zero = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 1) one++;
            else if (nums[i] == 0) zero++;
        for (int i = 0; i < nums.length; i++) {
            if (zero > 0) {
                nums[i] = 0;
                zero--;
            } else if (one > 0) {
                nums[i] = 1;
                one--;
            } else {
                nums[i] = 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();
        int[] result = sortColors(arr);
        for (int var : result)
            System.out.print(var + " ");
    }
}