#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] 移动零
#

# type:ignore
# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 解法1：快慢指针（快指针复杂遍历，慢指针负责保持非0空位）
        # slow = 0  # i是快指针
        # for i in range(len(nums)):
        #     if nums[i] != 0:
        #         nums[slow], nums[i] = nums[i], nums[slow]
        #         slow += 1
        # return nums

        # 解法2：直接暴力解法
        # 注意，for遍历，i只能往前走，回不了头
        i = 0
        lastNotZero = len(nums)  # 记录最后一个非0元素的位置，后面的元素都是0不用管
        while i < lastNotZero:
            # 发现0，把后面的元素前移
            if nums[i] == 0:
                # 只移动lastNotZero之前的元素
                for j in range(i + 1, lastNotZero):
                    nums[j - 1] = nums[j]
                nums[lastNotZero - 1] = 0
                lastNotZero -= 1
            else:
                i += 1  # 只有再i这个位置非0了，才往后走
        
        return nums



        
        
# @lc code=end

