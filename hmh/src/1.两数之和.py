#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#
# type:ignore
# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 直接两层循环遍历
        for i in range(len(nums)):
            for j in range(len(nums)):
                if i != j and nums[i] + nums[j] == target:
                    return [i, j]
        
# @lc code=end

