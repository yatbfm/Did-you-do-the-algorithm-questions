package leetcode.editor.cn.Arrays;

import java.util.Arrays;

/**
 * 有序数组的平方
 *
 * @author solisamicus
 * @date 2024-12-09 10:34:17
 */
public class P977_SquaresOfASortedArray {

    public static void main(String[] args) {
        Solution solution = new P977_SquaresOfASortedArray().new Solution();
        Solution2 solution2 = new P977_SquaresOfASortedArray().new Solution2();

        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(solution.sortedSquares(nums1)));
        System.out.println(Arrays.toString(solution2.sortedSquares(nums1)));

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(solution.sortedSquares(nums2)));
        System.out.println(Arrays.toString(solution2.sortedSquares(nums2)));
    }

    class Solution {
        public int[] sortedSquares(int[] nums) {
            int i = 0, j = nums.length - 1;
            int k = nums.length - 1;
            int[] ans = new int[nums.length];
            while (k >= 0) { // or i <= j
                if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                    ans[k--] = nums[j] * nums[j];
                    j--;
                } else {
                    ans[k--] = nums[i] * nums[i];
                    i++;
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }
    }

}