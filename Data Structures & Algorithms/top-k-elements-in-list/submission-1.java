class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count frequencies of num in nums using HMap; O(n) time & space
        // (Key : element, Value: frequency count)
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // initialize PriorityQueue as a Min-Heap
        // Lambda comparator
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // iterate through counts, bounding heap size to k: O(N log k) time
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            // add an array pair {frequency, element}
            minHeap.add(new int[]{count, element});

            // if heap size exceeds k, remove the element with the lowest frequency
            if (minHeap.size() > k) {
                minHeap.poll(); // removes root = smallest element since minheap
            }
        }

        // extract results into an array: O(n) time
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[1]; // extract 1 index value
        }

        return result;
    }
}

// Time = O(n log k)
// Space = O(n) -> O(k) aux space for heap == O(n) 
