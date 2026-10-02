class Solution {
    public boolean hasDuplicate(int[] nums) {
        // 1. Sort the array that NeetCode passed to you
        Arrays.sort(nums);
        
        // 2. Walk through the array to look for duplicates next to each other
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true; // Found a duplicate!
            }
        }
        
        // 3. If the loop finishes without finding any matches, return false
        return false; 
    }
}