class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int longest_count = 0; // store longest consecutive count
        int compare_count = 0; // store comparison count reference
        
        for (int num : nums) {
            if (num == 0) {
                compare_count = 0;
            } else {
                compare_count += 1;

                longest_count = Math.max(compare_count, longest_count);
            }
        }
        return longest_count;
    }
}