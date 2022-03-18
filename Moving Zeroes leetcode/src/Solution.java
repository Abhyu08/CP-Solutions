class Solution {
    public void moveZeroes(int[] nums) {
        int pointer1 = nums.length-1;
        int pointer2 = nums.length-1;

        for(int i=0;i<nums.length;i++){

            if(pointer1 != pointer2 && nums[pointer1] == 0){
                //interchage
                int pointer = pointer1;
                while(pointer1 != pointer2){
                    nums[pointer1] = nums[pointer1+1];
                    nums[pointer1+1] = 0;
                    pointer1++;
                }
                pointer2--;
                pointer1 = pointer-1;
            }else if(pointer1 > 0 ) {
                pointer1--;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int lastfoundAtindex = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[lastfoundAtindex++] = nums[i];
            }
        }
        for(int i=lastfoundAtindex ; i<nums.length;i++)
            nums[lastfoundAtindex++] = 0;
    }
}