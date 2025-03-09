#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# type:ignore
# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        # 双指针，从两边向中间移动，尝试所有可能的面积，找出最大值
        left = 0
        right = len(height) - 1
        max_area = 0
        while left < right:
            min_height = min(height[left], height[right])
            now_area = min_height * (right - left)
            max_area = max(max_area, now_area)
            # 接下来移动高度更小的指针，面积一定>=当前面积
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return max_area
        
# @lc code=end

