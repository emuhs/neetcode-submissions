class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int longest_count = 0; // store longest consecutive count
        int compare_count = 0; // store comparison count reference
        
        // loop through each number in nums, if nums[i] = 1, increment compare_count
        // once reaching a 0 or the end of the array, compare compare_count to longest_count
        // and select the longest up to that point
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                compare_count += 1;
            }
            if (i == nums.length - 1 || nums[i] == 0) {
                if (compare_count > longest_count) {
                    longest_count = compare_count;    
                }
                compare_count = 0;
            }
        }
        return longest_count;
    }
}