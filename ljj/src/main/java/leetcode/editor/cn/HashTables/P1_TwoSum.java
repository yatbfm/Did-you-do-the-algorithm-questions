package leetcode.editor.cn.HashTables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author solisamicus
 * @date 2024-12-11 10:49:49
 */
public class P1_TwoSum {

    public static void main(String[] args) {
        Solution solution = new P1_TwoSum().new Solution();

        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));

        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));

        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) return new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }

}