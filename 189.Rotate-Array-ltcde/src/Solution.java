import java.util.Scanner;

class Solution {
    public static void rotate(int[] nums, int k) {

        //1.Without switching | by printing from new index..

//        k = nums.length - k ;
//        for (int i = 0; i < nums.length; i++, k++)
//            System.out.print(nums[k % nums.length] + " ");

        //2.switching | by creating new array..  ==> 2ms

//        int[] arr = new int[nums.length];
//        k = nums.length - (k%nums.length);
//        for (int i = 0; i < nums.length; i++, k++)
//            arr[i] = nums[k % nums.length];
//        for (int i = 0; i < nums.length; i++, k++)
//            nums[i] = arr[i];

        //3.Using Optimised Solution with O(n) with O(1) space-complexity.. ==> 4ms
        //switch array elements with every i+k positions..
        int len = nums.length, index = 0, flag = 0;
        int prev_value = nums[index];
        nums[0] = -9797;
        for (int i = 0, curr_value; i < nums.length; i++) {
            index = (index + k) % len; //next i+k index
            if (nums[index] == -9797) flag = 1;
            curr_value = nums[index];
            nums[index] = prev_value;
            prev_value = curr_value;  //to store current i+k index value(to avoid loss of value)
            if (flag == 1 && i < len - 1) {
                flag = 0;
                index = (index + 1) % len;
                prev_value = nums[index % len];
                nums[index % len] = -9797;
            }
        }


        for (int var : nums)
            System.out.print(var + " ");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        rotate(arr, k);
    }
}
/*
6
1 2 3 4 5 6
2


7
1 2 3 4 5 6 7
3

7
1 2 3 4 5 6 7
2

7
1 2 3 4 5 6 7
1

6
1 2 3 4 5 6
3


4
-1 -100 3 99
2

4
-1 -100 3 99
0


 */