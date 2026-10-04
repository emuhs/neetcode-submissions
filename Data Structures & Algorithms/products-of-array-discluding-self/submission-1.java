// solution in O(n) time; O(1) aux space if we ignore the result array

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Pass 1: Store left (prefix) products in result
        // result[i] contains the product of all elements to the LEFT of i
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Pass 2: Multiply by right (suffix) products on the fly
        // postfix dynamically tracks the product of all elements to the RIGHT of i
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * postfix; // left_product * right_product
            postfix = postfix * nums[i];     // include current number for the next element to the left
        }

        return result;
    }
}
