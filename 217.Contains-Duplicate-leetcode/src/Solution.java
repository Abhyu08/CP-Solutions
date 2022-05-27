import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static boolean containsDuplicate(int[] nums) {

        //1.By Sorting...
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i - 1]) return true;
        //2.Using Hashing/Counting Sort...
        int[] hash = new int[1000000002];
        for (int i = 0; i < nums.length; i++)
            if (++hash[nums[i]] > 1) return true;
        //3.Using Set
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (set.size() != nums.length) return true;
        //4.Using HashMap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], 0);
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();

        System.out.println(containsDuplicate(arr));
    }
}
/*
4
1 2 3 1

4
1 2 3 4

10
1 1 1 3 3 4 3 2 4 2

6
1 5 4 2 2 1


 */