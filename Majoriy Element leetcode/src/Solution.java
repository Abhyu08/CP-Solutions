class Solution {

    //Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0 ;
        int me = nums[0];
        for(int i=0;i<nums.length;i++){
            if(me!=nums[i]){
                count--;
                if(count == 0){
                    me = nums[i];
                    count++;
                }
            }else{
                count++;
            }
        }
        return me;
    }

    public int majorityElement2(int[] nums) {

        int need = nums.length/2 + 1;
        int value = 0 ;
        int count = 0 ;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == -123)
                continue;
            value = nums[i];
            count = 1;
            int pointer = i;
            while(pointer < nums.length - 1){
                pointer++;
                if(nums[pointer] == value){
                    count++;
                    nums[pointer] = -123;
                }
            }
            if(count >= need){
                return value;
            }
        }
        return 0 ;
    }
}