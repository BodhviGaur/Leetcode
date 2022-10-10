class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        if(nums.length==1){
            return 1;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                uniqueIndex=uniqueIndex+1;
                nums[uniqueIndex]=nums[i+1];
            }
        }
        return uniqueIndex+1;
    }
}