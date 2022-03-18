import java.util.Scanner;

class Solution {
    public int singleNumber(int[] nums) {

        int x = nums[0];

        for (int i = 1; i < nums.length; i++) {
            x ^= nums[i];
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution sl = new Solution();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(sl.singleNumber(arr));
    }
}