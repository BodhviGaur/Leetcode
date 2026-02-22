class Solution {
    public int[] rotateElements(int[] nums, int k) {
        /**
        1. In first run through nums, if nums[i] >=0 :
         1.1. store nums[i] in a list and replace nums[i] = Integer.MAX_INT
        2. Once done, go to the k+1th index (modulo wise) in list. 
        3. From there copy back all values to nums where nums[i] = Integer.MAX_INT.
        
        */

        List<Integer> nonNegNum = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] >= 0) {
                nonNegNum.add(nums[i]);
                nums[i] = Integer.MIN_VALUE;
            }
        }
        int nonNegLen = nonNegNum.size();
        //edge case - missed : when nonNeg length is 0
        if (nonNegLen == 0) {
            return nums;
        }
        int idx = k % nonNegLen;
        int j = 0;
        Collections.rotate (nonNegNum, -idx); //-ve for left rotation, O(n)
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                nums[i] = nonNegNum.get(j++);
            }
        }
        return nums;

    }
}