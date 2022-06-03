// class Solution {
//     public void moveZeroes1(int[] nums) {
//         int pointer1 = nums.length-1;
//         int pointer2 = nums.length-1;

//         for(int i=0;i<nums.length;i++){

//             if(pointer1 != pointer2 && nums[pointer1] == 0){
//                 //interchage
//                 int pointer = pointer1;
//                 while(pointer1 != pointer2){
//                     nums[pointer1] = nums[pointer1+1];
//                     nums[pointer1+1] = 0;
//                     pointer1++;
//                 }
//                 pointer2--;
//                 pointer1 = pointer-1;
//             }else if(pointer1 > 0 ) {
//                     pointer1--;
//           }
//         }
//     }
//         public void moveZeroes(int[] nums) {
//         int lastfoundAtindex = 0;

//         for(int i=0;i<nums.length;i++){
//             if(nums[i] != 0){
//                 nums[lastfoundAtindex++] = nums[i];
//             }
//         }
//         for(int i=lastfoundAtindex ; i<nums.length;i++)
//             nums[lastfoundAtindex++] = 0;
//     }


// }






class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0 ;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) count++;
            else if(count > 0){
                int index = i;
                int c = count;
                //to go to last index where 0's occurred
                while( index > 0 && c > 0){
                    index--;
                    if(nums[index] == 0 )c--;
                }//end while
                nums[index] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
