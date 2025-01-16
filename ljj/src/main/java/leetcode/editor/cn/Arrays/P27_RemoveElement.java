package leetcode.editor.cn.Arrays;

/**
 * 移除元素
 *
 * @author solisamicus
 * @date 2024-12-09 09:25:41
 */
public class P27_RemoveElement {

    public static void main(String[] args) {
        Solution solution = new P27_RemoveElement().new Solution();

        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = solution.removeElement(nums1, val1);
        System.out.println("Output k: " + k1);
        System.out.print("Updated nums: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = solution.removeElement(nums2, val2);
        System.out.println("\nOutput k: " + k2);
        System.out.print("Updated nums: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
    }

    class Solution {
        public int removeElement(int[] nums, int val) {
            int slowIndex = 0;
            for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
                if (nums[fastIndex] != val) {
                    nums[slowIndex] = nums[fastIndex];
                    slowIndex++;
                }
            }
            return slowIndex;
        }
    }

}