#
# @lc app=leetcode.cn id=128 lang=python3
#
# [128] 最长连续序列
#
# type:ignore

# @lc code=start
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        ans = 0  # 记录最后的结果
        st = set(nums)  # 将数组转成set
        for x in st:
            # 只关注比x大的数
            if x - 1 in st:
                continue
            y = x + 1
            # set查找的时间复杂度为1
            while y in st:
                y = y + 1
            ans = max(ans, y - x)

        return ans
        
# @lc code=end

