import java.util.Scanner;

class Solution {
    public static int missingNumber(int[] nums) {
        /*
        //1.Using Set(O(n))
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
                set.add(nums[i]);
        for(int i=0;i<=nums.length;i++)
            if(!set.contains(i)) return i;
            
            return 0;
        */

        //2.using sort(O(nlogn))
        /*
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
            if(nums[i] != i) return i;
        return nums.length;
        */
        //3.Using sum - remaining : formula
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        return ((n * (n + 1)) / 2) - sum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();
        System.out.println(missingNumber(arr));
    }
}