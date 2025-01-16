package leetcode.editor.cn.Arrays;

/**
 * 二分查找
 *
 * @author solisamicus
 * @date 2024-12-06 16:43:23
 */
public class P704_BinarySearch {

    public static void main(String[] args) {
        P704_BinarySearch p704BinarySearch = new P704_BinarySearch();

        Solution solution1 = p704BinarySearch.new Solution();
        Solution2 solution2 = p704BinarySearch.new Solution2();

        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int result1 = solution1.search(nums1, target1);
        System.out.println("Test case 1 result with Solution1: " + result1);
        result1 = solution2.search(nums1, target1);
        System.out.println("Test case 1 result with Solution2: " + result1);

        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        int result2 = solution1.search(nums2, target2);
        System.out.println("Test case 2 result with Solution1: " + result2);
        result2 = solution2.search(nums2, target2);
        System.out.println("Test case 2 result with Solution2: " + result2);
    }

    // [left, right]
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) left = mid + 1;
                else if (nums[mid] > target) right = mid - 1;
                else return mid;
            }
            return -1;
        }
    }

    // [left, right)
    class Solution2 {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) left = mid + 1;
                else if (nums[mid] > target) right = mid;
                else return mid;
            }
            return -1;
        }
    }

}