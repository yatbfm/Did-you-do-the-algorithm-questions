package leetcode.editor.cn.HashTables;

import java.util.HashMap;
import java.util.Map;

;

/**
 * 四数相加 II
 *
 * @author solisamicus
 * @date 2024-12-11 10:50:11
 */
public class P454_FourSumIi {

    public static void main(String[] args) {
        Solution solution = new P454_FourSumIi().new Solution();

        System.out.println(solution.fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2})
        );

        System.out.println(solution.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
    }

    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int result = 0;
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int num1 : nums1)
                for (int num2 : nums2) {
                    int sum = num1 + num2;
                    hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
                }
            for (int num3 : nums3)
                for (int num4 : nums4)
                    result += hashMap.getOrDefault(-num3 - num4, 0);
            return result;
        }
    }

}