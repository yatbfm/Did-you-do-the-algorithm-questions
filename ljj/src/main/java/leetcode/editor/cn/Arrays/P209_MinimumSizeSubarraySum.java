package leetcode.editor.cn.Arrays;

;

/**
 * 长度最小的子数组
 *
 * @author solisamicus
 * @date 2024-12-09 10:56:35
 */
public class P209_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        Solution solution = new P209_MinimumSizeSubarraySum().new Solution();

        int[] nums1 = {2, 3, 1, 2, 4, 3};
        // 2, 3, 1, 2, 4, 3
        // i(0), j(0) => 2
        // i(0), j(1) => 2, 3
        // i(0), j(2) => 2, 3, 1
        // i(0), j(3) => 2, 3, 1, 2 => result(4) => i(1), j(3) => 3, 1, 2
        // i(1), j(4) => 3, 1, 2, 4 => result(4) => i(2), j(4) => 1, 2, 4 => result(3) => i(3), j(4) => 1, 2
        // i(3), j(5) => 1, 2, 4 => result(3) => i(4), j(5) => 4, 3 => result(2) => i(5), j(5) => 3
        System.out.println(solution.minSubArrayLen(7, nums1));

        int[] nums2 = {1, 4, 4};
        System.out.println(solution.minSubArrayLen(4, nums2));

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution.minSubArrayLen(11, nums3));
    }

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0;
            int result = Integer.MAX_VALUE;
            for (int i = 0, j = 0; j < nums.length; j++) {
                sum += nums[j];
                while (sum >= target) {
                    result = Math.min(result, j - i + 1);
                    sum -= nums[i++];
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }

}