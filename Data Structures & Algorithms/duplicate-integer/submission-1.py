class Solution:
    def hasDuplicate(self, nums: List[int], index = 0) -> bool:
        nums.sort()
        for i in range(1,len(nums)):
            if nums[i] == nums[i - 1]:
                return True
            i += 1
        return False
