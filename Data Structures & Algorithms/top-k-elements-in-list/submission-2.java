// bucket sort = O(n) time & space complexity - optimized solution

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // hashmap to capture frequencies in nums
        // (Key : Num; Value : Count)
        // O(n) time & space
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // construct another result array and group num values into
        // sub-arrays where result[index] = counts[num] = O(n) space
        List<Integer>[] buckets = new List[nums.length + 1];

        // add mapped keys to the buckets array at buckets[counts[value]]
        // O(n) time
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }

            buckets[value].add(key);
        }

        // construct and return the result list, checking buckets
        // values in decreasing order until result lenght = k
        int[] result = new int[k];
        int rIndex = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
             
            // nested loop will only loop through each bucket's values
            // once, so this does not extend time complexity beyond O(n)
            for (int num : buckets[i]) {
                result[rIndex] = num;
                rIndex++;
            }

            if (rIndex == k) {
                return result;
            }
        }

        return result;
    }
}

