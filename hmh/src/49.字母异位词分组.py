#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#
# type:ignore

# @lc code=start
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = defaultdict(list)  # 创建一个空列表字典
        for s in strs:
            # 将s添加到对应的字母异位词key
            d[''.join(sorted(s))].append(s)
        return list(d.values())
        
# @lc code=end

