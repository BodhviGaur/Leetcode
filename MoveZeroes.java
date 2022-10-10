class Solution {
    public void moveZeroes(int[] nums) {
        int currIndex=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
               nums[currIndex++]=nums[i];
            }
        }
        for(int i=currIndex; i< nums.length; i++){
            nums[i]=0;
        }
    }
}