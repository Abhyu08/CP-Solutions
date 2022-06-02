import java.util.*;

class Solution {

//    1.O(n) Approach

//    public static int subarraySum(int[] arr, int k) {
//        // HashMap to store number of subArrays
//        // starting from index zero having
//        // particular value of sum.
//        HashMap<Integer, Integer> prevSum = new HashMap<>();
//        prevSum.put(0,1);
//        int result = 0;
//        int n = arr.length;
//
//        // Sum of elements so far.
//        int currPrefixSum = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            // Add current element to sum so far.
//            currPrefixSum += arr[i];
//
//            //calculate the sum that have to be removed
//            //so that we can get the desired sum
//            int removeSum=currPrefixSum-k;
//
//            //get count of occurrences of that sum that
//            //have to removed and add it to res value
//            if (prevSum.containsKey(removeSum))
//                result += prevSum.get(removeSum);
//
//            // Add currsum value to count of
//            // different values of sum.
//            prevSum.put(currPrefixSum,prevSum.getOrDefault(currPrefixSum,0)+1);
//        }
//
//        return result;
//    }

    public static int subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int totalSubArrays = 0, currPrefixSum = 0;

//        Gives wrong result if pre-calculated the prefix sum with occurrences beforehand
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] += nums[i - 1];
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }

//      Add Required-Sum Occurrences while traversing left->right
//      Will get correct result if we add countOf Occurrences at the present moment...
        for (int num : nums) {
            currPrefixSum += num;
            int reqSum = currPrefixSum - target;
            if (map.containsKey(reqSum)) totalSubArrays += map.get(reqSum);
            map.put(currPrefixSum, map.getOrDefault(currPrefixSum, 0) + 1);
        }

        return totalSubArrays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];

        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        System.out.println(subarraySum(arr, k));
    }
}
/*
3
1 1 1
2

~2

3
1 2 3
3

~2


5
10 2 -2 -20 10
-10

~3
{10,2,-3,-20} , {2,-2,-20,10} , {-20 ,10 }

6
9 4 20 3 10 5
33

~2
 */