package leetcode.editor.cn.HashTables;

import java.util.*;

/**
 * 三数之和
 *
 * @author solisamicus
 * @date 2024-12-11 10:50:39
 */
public class P15_ThreeSum {

    public static void main(String[] args) {
        Solution solution = new P15_ThreeSum().new Solution();

        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            // a = nums[i], b = nums[left], c = nums[right]
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum > 0) right--;
                    else if (sum < 0) left++;
                    else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
            return result;
        }
    }

}