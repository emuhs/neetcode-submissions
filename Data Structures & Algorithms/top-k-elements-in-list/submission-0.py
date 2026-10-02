# naive solution using min_heap priority queue; O(n log k) TC suitable, but
# we can achieve O(n) TC with a Bucket Sort approach

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # count frequencies of each element in nums 
        
        # count of objects using Counter() function to create a dictionary of
        # counts of each num in nums. counts = {(key : element, value : count),...} 
        # = O(n) time; O(n) space
        counts = Counter(nums)
    
        # initialize min_heap object as an array
        min_heap = []

        # iterate through each element in counts, pushing and poping to
        # min_heap such that its length remains <= k; O(log k) time to
        # loop through each heap element and push/pop; O(k) space
        for element, count in counts.items():
            heapq.heappush(min_heap, (count, element))

            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        # return the elements for each value in min heap as a new array
        return [element for count, element in min_heap]

        # Time = O(n log k)
        # Space = O(n + k) == O(n) 


