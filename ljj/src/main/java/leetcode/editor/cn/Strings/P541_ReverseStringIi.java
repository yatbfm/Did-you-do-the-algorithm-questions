package leetcode.editor.cn.Strings;

/**
 * 反转字符串 II
 *
 * @author solisamicus
 * @date 2024-12-12 11:33:56
 */
public class P541_ReverseStringIi {

    public static void main(String[] args) {
        Solution solution = new P541_ReverseStringIi().new Solution();

        System.out.println(solution.reverseStr("abcdefg", 2));

        System.out.println(solution.reverseStr("abcd", 2));
    }

    class Solution {
        public String reverseStr(String s, int k) {
            char[] cc = s.toCharArray();
            for (int i = 0; i < cc.length; i += 2 * k) {
                if (i + k - 1 <= cc.length - 1) {
                    reverseChars(cc, i, i + k - 1);
                    continue;
                }
                reverseChars(cc, i, cc.length - 1);
            }
            return new String(cc);
        }

        // [left, right]
        public void reverseChars(char[] s, int left, int right) {
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }

}