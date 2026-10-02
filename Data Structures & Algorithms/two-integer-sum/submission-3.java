class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Will solve using a hashmap to compare each element in the nums array
        // to the target value and check if the difference exists as a value in
        // the hashmap.  This will allow for a solution with O(n) time complexity
        // vs O(n^2) as a nested loop solution or O(log n) by pre-sorting nums.

        // create the hashmap of seen values 
        // (Key : Integer of the value in nums, Value : Integer indicating the index)
        Map<Integer, Integer> seen = new HashMap<>();

        // one loop through each element of the nums array
        // will use i index and increment since we want to return
        // the index positions of the nums array that sum to the target
        // Time complexity = O(n) for the loop through the array
        // Space complexity = O(n) for 'seen' values from nums
        for (int i = 0; i < nums.length; i++) {

            // If target - nums[i] value is in 'seen' hashmap, we return the index 
            // of that value along with i as a 2-value integer array. Else, we will
            // add the value of i to seen.
            
            // set a variable check_val = difference of target and nums[i]
            int check_val = target - nums[i];

            // if statement to determine if check_val is in 'seen', if so, return indices
            // as a new array.
            if (seen.containsKey(check_val)) {
                int[] result = {seen.get(check_val), i};
                return result;
            }

            // else add i to 'seen'
            else seen.put(nums[i], i);

        }
    
    // exit condition if no matching pair found summing to target
    return new int[] {};
    }
}
