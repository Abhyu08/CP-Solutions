import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] arrStr = ((String) br.readLine()).split("\\s+");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int duplicate = findDuplicate(arr);
        System.out.println(duplicate);
    }

    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else
                set.add(num);
        }
        return -1;
    }
//        int[] bucket = new int[1000000];
//        for (int i = 0; i < nums.length; i++) {
//            if (bucket[nums[i]] != 0)
//                return nums[i];
//            else
//                bucket[nums[i]] = 1;
//        }

}