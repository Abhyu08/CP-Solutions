import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list =  new ArrayList<>();

        for(int i=0;i< nums.length ; i++){
            list.add(Math.abs(nums[i] ) - 1) ;
            nums[list.get(0)] = -1 * Math.abs(nums[list.get(0)]);
            list.remove(0);
        }
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1] >= 0 )
                list.add(i);
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        List<Integer> list =  new ArrayList<>();
        for(int i=0;i< nums.length ; i++)
            set.add(nums[i]);

        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i))
                list.add(i);
        }
        return list;
    }
}