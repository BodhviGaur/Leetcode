class Solution {
    public int singleNumber(int[] nums) {
        // 0 XOR number = number itself eg: 000 XOR 001 = 001 (since only last bit was different -> 1           //on diff bits)
        int res = 0;
        for(int num: nums){
            res = num^res;
        }
        return res;
    }
}