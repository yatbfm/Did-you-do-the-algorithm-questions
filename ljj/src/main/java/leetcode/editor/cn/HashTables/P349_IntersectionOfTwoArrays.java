package leetcode.editor.cn.HashTables;

import java.util.*;

;

/**
 * 两个数组的交集
 *
 * @author solisamicus
 * @date 2024-12-11 10:28:54
 */
public class P349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        Solution solution = new P349_IntersectionOfTwoArrays().new Solution();
        Solution2 solution2 = new P349_IntersectionOfTwoArrays().new Solution2();

        System.out.println(Arrays.toString(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));

        System.out.println(Arrays.toString(solution2.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(solution2.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int i : nums1) set1.add(i);
            for (int j : nums2) if (set1.contains(j)) set2.add(j);
            int n = set2.size();
            int[] result = new int[n];
            Iterator<Integer> it = set2.iterator();
            for (int i = 0; i < n; i++)
                result[i] = it.next();
            return result;
        }
    }

    class Solution2 {
        public int[] intersection(int[] nums1, int[] nums2) {
            int n = 1001;
            int[] hash1 = new int[n];
            int[] hash2 = new int[n];
            for (int i : nums1) hash1[i]++;
            for (int j : nums2) hash2[j]++;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++)
                if (hash1[i] > 0 && hash2[i] > 0)
                    res.add(i);
            int[] result = new int[res.size()];
            for (int i = 0; i < res.size(); i++)
                result[i] = res.get(i);
            return result;
        }
    }

}