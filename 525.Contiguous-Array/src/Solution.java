import java.util.HashMap;
import java.util.Scanner;

class Solution {

//  1. Brute-Force Approach
//    public int findMaxLength(int[] nums) {
//        int maxlen = 0;
//        for (int start = 0; start < nums.length; start++) {
//            int zeroes = 0, ones = 0;
//            for (int end = start; end < nums.length; end++) {
//                if (nums[end] == 0) {
//                    zeroes++;
//                } else {
//                    ones++;
//                }
//                if (zeroes == ones) {
//                    maxlen = Math.max(maxlen, end - start + 1);
//                }
//            }
//        }
//        return maxlen;
//    }

//  2. Optimised Approach
    public static int findMaxLength(int[] nums) {
        int maxLength = 0, len = nums.length, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) count -= 1;
            else count++;

            if (map.containsKey(count)) maxLength = Math.max(maxLength, i - map.get(count));
            else map.put(count, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();
        System.out.println(findMaxLength(arr));
    }
}
/*

3
0 1 0

2
0 1

8
1 0 1 0 0 0 0 0

~4

8
1 1 1 1 0 0 0 0

~8

7
1 0 1 1 0 0 1

~6

7
0 0 0 0 0 0 0

~0

7
1 1 1 1 1 1 1

~0

0 0 0 0 0 1 1

11
0 1 0 1 1 0 1 0 1 0 1

~10

8
0 1 1 0 1 1 1 0

~4

-------

13
1 1 0 1 0 1 1 0 1 0 1 0 1

~10

13
1 1 0 1 0 1 1 0 1 0 1 0 0

~12

18
1 1 1 1 1 1 1 0 1 0 1 1 0 1 0 1 0 0

~12

12
1 0 1 0 1 1 0 1 0 1 0 1

~10

 */