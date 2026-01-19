class Solution {
    public int centeredSubarrays(int[] nums) {
        /**
        Approach 1 :
        1.Maintain a hashmap of all numbers being considered.
        2. Maintain 2 pointers, one at the start of the subarray, one at the end.
        3. From 0th index, take the start pointer (ith index) to end, 
        while shifting end pointer from i+1 th index till end.
        4. for each combination, check if we sum exists in the list, if yes, increment count.
        5. Edge case : 0 elements/null string : return 0.
        */


        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length, count = 0, sum = 0;
        HashSet<Integer> hs = new HashSet<>();

        if (len == 1) {
            return 1;
        }

        for (int str = 0; str<len; str++) {
            sum = 0;
            for (int end = str; end <len; end++) {
                hs.add(nums[end]);
                sum = sum + nums[end];
                if (hs.contains(sum)) {
                    count++;
                }
            }
            hs.clear();
        }
        return count;

    }
}