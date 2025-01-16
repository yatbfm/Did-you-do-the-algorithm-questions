package leetcode.editor.cn.HashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author solisamicus
 * @date 2024-12-11 10:50:43
 */
public class P18_FourSum {

    public static void main(String[] args) {
        Solution solution = new P18_FourSum().new Solution();

        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));

        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            // a = nums[i], b = nums[j], c = nums[left], d = nums[right]
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // remove items with duplicate value num[i]
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue; // remove items with duplicate value num[j]
                    int left = j + 1, right = nums.length - 1;
                    while (left < right) {
                        long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum > target) right--;
                        else if (sum < target) left++;
                        else {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) left++;
                            while (left < right && nums[right] == nums[right - 1]) right--;
                            left++;
                            right--;
                        }
                    }
                }
            }
            return result;
        }
    }

}