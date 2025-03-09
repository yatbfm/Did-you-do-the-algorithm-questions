#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#

# type:ignore
# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # # 先排序
        # nums.sort()
        # res = []
        # # 遍历
        # for k in range(len(nums) - 2):
        #     # 最小的数都大于0，无解
        #     if nums[k] > 0:
        #         break
        #     # 重复元素，跳过
        #     if k > 0 and nums[k] == nums[k - 1]:
        #         continue
        #     # 一般情况
        #     i = k + 1
        #     j = len(nums) - 1
        #     while i < j:  # 遍历所有的元素
        #         s = nums[k] + nums[i] + nums[j]
        #         if s < 0:
        #             i += 1
        #             # 处理重复元素
        #             while i < j and nums[i] == nums[i - 1]: i += 1
        #         elif s > 0:
        #             j -= 1
        #             while i < j and nums[j] == nums[j + 1]: j -= 1
        #         else:
        #             res.append([nums[k], nums[i], nums[j]])
        #             i += 1
        #             j -= 1
        #             while i < j and nums[i] == nums[i - 1]: i += 1
        #             while i < j and nums[j] == nums[j + 1]: j -= 1
            
        # return res

        # 重新写一遍
        # nums.sort()
        # res = []
        # for k in range(len(nums) - 2):
        #     if nums[k] > 0: break
        #     if k > 0 and nums[k] == nums[k - 1]: continue
        #     # 一般情况
        #     i = k + 1
        #     j = len(nums) - 1
        #     while i < j:
        #         s = nums[i] + nums[j] + nums[k]
        #         if s == 0: 
        #             res.append([nums[k], nums[i], nums[j]])
        #             i += 1
        #             j -= 1
        #             while i < j and nums[i] == nums[i - 1]: i += 1
        #             while i < j and nums[j] == nums[j + 1]: j -= 1
        #         elif s > 0:
        #             j -= 1
        #             while i < j and numsj[j] == nums[j + 1]: j -= 1
        #         else:
        #             i += 1
        #             while i < j and nums[i] == nums[i - 1]: i += 1

        # return res

        
        # 最后再写一遍，计时
        nums.sort()
        res = []
        for k in range(len(nums) - 2):
            if nums[k] > 0: break
            if k > 0 and nums[k] == nums[k - 1]: continue
            # 一般情况
            i = k + 1
            j = len(nums) - 1
            while i < j:
                s = nums[k] + nums[i] + nums[j]
                if s > 0:
                    j -= 1
                    while i < j and nums[j] == nums[j + 1]: j -= 1
                elif s < 0:
                    i += 1
                    while i < j and nums[i] == nums[i - 1]: i += 1
                else:
                    i += 1
                    j -= 1
                    while i < j and nums[i] == nums[i - 1]: i += 1
                    while i < j and nums[j] == nums[j + 1]: j -= 1

        return res
        


# @lc code=end

