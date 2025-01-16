package leetcode.editor.cn.HashTables;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 *
 * @author solisamicus
 * @date 2024-12-11 10:49:22
 */
public class P202_HappyNumber {

    public static void main(String[] args) {
        Solution solution = new P202_HappyNumber().new Solution();

        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(2));
    }

    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> record = new HashSet<>();
            while (n != 1 && !record.contains(n)) {
                record.add(n);
                n = getNextNumber(n);
            }
            return n == 1;
        }

        private int getNextNumber(int n) {
            int result = 0;
            while (n > 0) {
                int temp = n % 10;
                result += temp * temp;
                n = n / 10;
            }
            return result;
        }
    }

}