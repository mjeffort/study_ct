"""
    https://leetcode.com/problems/two-sum/

    > easy
"""

class Solution:
     def twoSum(self, nums, target):
        for i, num in enumerate(nums):
            nums_ = nums[:]
            n = target - num
            nums_.remove(num)
            if n in nums_:
                return [i,nums[i+1:].index(n)+(i+1)]
   

# sol = Solution()
# print(sol.twoSum([2,7,11,15], 9))