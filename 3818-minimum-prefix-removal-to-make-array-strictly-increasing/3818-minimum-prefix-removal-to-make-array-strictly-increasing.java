class Solution {
    public int minimumPrefixLength(int[] nums) {

        /**
        1. Move through nums from index 0 to length-2 and check 
        -> if nums[i] < nums [i+1], 
        2. yes -> i++. , no -> update result minLen to i+1.
        3. Edge case, when length of array < 2, then we can manually check.
        */

        int minLen = 0, len = nums.length;
        if (len <= 1) {
            return minLen;
        } else if (len == 2) {
            return nums[0] < nums[1] ? minLen : 1;
        }

        for (int i=0 ; i <= len-2 ; i++) {
            if (nums[i] >= nums[i+1]) {
                minLen = i+1;
            }
        }

        return minLen;
        
    }
}